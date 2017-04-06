package exempleslayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ExempleMenu extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuImatge, menuColor;
    private JMenuItem menuItemCanviarImatge, menuItemCanviarColor;

    private JLabel labelImatge, labelColor;
    private JColorChooser cc;

    public ExempleMenu() throws HeadlessException {
        configuracio();
        this.pack();
        this.setVisible(true);
    }

    private void configuracio() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 70);
        this.setPreferredSize(new Dimension(1000, 700));

        menuItemCanviarImatge = new JMenuItem("Canviar imatge");
        menuItemCanviarImatge.addActionListener(this);
        menuItemCanviarColor = new JMenuItem("Canviar color");
        menuItemCanviarColor.addActionListener(this);

        menuImatge = new JMenu("Imatge");
        menuImatge.add(menuItemCanviarImatge);
        menuColor = new JMenu("Color");
        menuColor.add(menuItemCanviarColor);

        menuBar = new JMenuBar();
        menuBar.add(menuColor);
        menuBar.add(menuImatge);

        this.setJMenuBar(menuBar);
        this.labelImatge = new JLabel();
        this.labelColor = new JLabel();

        this.getContentPane().add(this.labelImatge);
        this.getContentPane().add(this.labelColor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case "Canviar imatge":
                carregarImatge();
                break;
            case "Canviar color":
                break;
        }
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new GridLayoutExemple();
                new ExempleMenu();
            }
        });
    }

    public void carregarImatge() {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            ImageIcon imagen;
            try {
                imagen = new ImageIcon(fc.getSelectedFile().getCanonicalPath());
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(-1, -1, Image.SCALE_AREA_AVERAGING));
                labelImatge.setIcon(imagen);
            } catch (IOException ex) {
                Logger.getLogger(ExempleMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}

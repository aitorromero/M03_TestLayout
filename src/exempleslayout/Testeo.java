package exempleslayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Testeo extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuConfiguracio, subMenuJugadors;
    private JMenuItem menuItemEstablirDosJugador, menuItemEstablirTresJugadors,
            menuItemEstablirQuatreJugadors, menuItemCanviarColor;
    private JLabel labelJugador1, labelJugador2, labelJugador3, labelJugador4, labelAux;
    private JLabel x1, x2, x3, x4, x5, x6, x7, x8, x9;
    private JPanel panelTablero, panelFichasJ1, panelFichasJ2, panelFichasJ3, panelFichasJ4;

    public Testeo() throws HeadlessException {
        configuracio();
        this.pack();
        this.setVisible(true);
    }

    public void configuracio() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 70);
        this.setPreferredSize(new Dimension(1000, 700));
        //Usar boxLayout para las fichas

        menuItemEstablirDosJugador = new JMenuItem("2 Jugadors");
        menuItemEstablirDosJugador.addActionListener(this);

        menuItemEstablirTresJugadors = new JMenuItem("3 Jugadors");
        menuItemEstablirTresJugadors.addActionListener(this);

        menuItemEstablirQuatreJugadors = new JMenuItem("4 Jugadors");
        menuItemEstablirQuatreJugadors.addActionListener(this);

        menuConfiguracio = new JMenu("Configuracio");
        subMenuJugadors = new JMenu("Nombre de jugadors");

        menuConfiguracio.add(subMenuJugadors);
        subMenuJugadors.add(menuItemEstablirDosJugador);
        subMenuJugadors.add(menuItemEstablirTresJugadors);
        subMenuJugadors.add(menuItemEstablirQuatreJugadors);

        menuBar = new JMenuBar();
        menuBar.add(menuConfiguracio);

        //Panels donde iran la fichas con sus respectivos BoxLayout
        panelFichasJ1 = new JPanel();
        panelFichasJ1.setLayout(new BoxLayout(panelFichasJ1, BoxLayout.X_AXIS));
        add(panelFichasJ1, BorderLayout.NORTH);
        
        panelFichasJ2 = new JPanel();
        panelFichasJ2.setLayout(new BoxLayout(panelFichasJ2, BoxLayout.Y_AXIS));
        add(panelFichasJ2, BorderLayout.NORTH);
        
        panelFichasJ3 = new JPanel();
        panelFichasJ3.setLayout(new BoxLayout(panelFichasJ3, BoxLayout.X_AXIS));
        add(panelFichasJ3, BorderLayout.NORTH);
        
        panelFichasJ4 = new JPanel();
        panelFichasJ4.setLayout(new BoxLayout(panelFichasJ4, BoxLayout.Y_AXIS));
        add(panelFichasJ4, BorderLayout.NORTH);

        //Labels con el nombre de los jugadores
        labelJugador1 = new JLabel("Jugador1", JLabel.CENTER);
        add(labelJugador1, BorderLayout.NORTH);
        labelJugador2 = new JLabel("Jugador2");
        add(labelJugador2, BorderLayout.EAST);
        labelJugador3 = new JLabel("Jugador3", JLabel.CENTER);
        add(labelJugador3, BorderLayout.SOUTH);
        labelJugador4 = new JLabel("Jugador4");
        add(labelJugador4, BorderLayout.WEST);
        /*
        labelAux=new JLabel("CENTRO?");
        labelAux.setHorizontalAlignment(JLabel.CENTER);
        add(labelAux, BorderLayout.CENTER);
         */

        this.setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        /*
        switch (action) {
            case "Canviar imatge":
                carregarImatge();
                break;
            case "Canviar color":
                break;
        }*/
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new GridLayoutExemple();
                new Testeo();
            }
        });
    }
    /*
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

    }*/
}

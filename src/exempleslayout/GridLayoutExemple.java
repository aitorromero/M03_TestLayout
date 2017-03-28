package exempleslayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutExemple extends JFrame implements ActionListener {

    public GridLayoutExemple(String title) {
        super(title);
    }

    public GridLayoutExemple() {
        super("Exemple de GridLayout");
        this.configurarGraella();
        this.pack();
        this.setVisible(true);
    }

    private void configurarGraella() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(500, 300);
        this.setPreferredSize(new Dimension(300,300));
        this.setLayout(new GridLayout(4, 4));
        this.setFont(new Font("SansSerif", Font.BOLD, 24));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton boto = new JButton("" + (i * 4 + j));
                this.add(boto);
                boto.addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int posicio = Integer.parseInt(e.getActionCommand());
        if (posicio % 2 == 0) {
            ((JButton) e.getSource()).setBackground(Color.red);
        } else {
            ((JButton) e.getSource()).setBackground(Color.GREEN);
        }
        ((JButton) e.getSource()).setText("(" + posicio / 4 + "," + posicio % 4 + ")");
    }

    
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new GridLayoutExemple();
                new CardLayoutJFrame();
            }
        });
    }
}
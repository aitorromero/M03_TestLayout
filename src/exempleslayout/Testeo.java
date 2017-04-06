package exempleslayout;

import java.awt.BorderLayout;
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

public class Testeo extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuConfiguracio, subMenuJugadors;
    private JMenuItem menuItemEstablirDosJugador, menuItemEstablirTresJugadors, 
            menuItemEstablirQuatreJugadors, menuItemCanviarColor;
    private JLabel labelJugador1, labelJugador2, labelJugador3, labelJugador4;
    private JPanel panelTablero;
    
    public Testeo() throws HeadlessException{
        configuracio();
        this.pack();
        this.setVisible(true);
    }
    
    public void configuracio(){
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
        
        labelJugador1=new JLabel("Jugador1");
        add(labelJugador1, BorderLayout.SOUTH);
        labelJugador2=new JLabel("Jugador2");
        add(labelJugador2, BorderLayout.WEST);
        labelJugador3=new JLabel("Jugador3");
        add(labelJugador3, BorderLayout.EAST);
        labelJugador4=new JLabel("Jugador4");
        add(labelJugador4, BorderLayout.NORTH);

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

package exempleslayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class CardLayoutJFrame extends JFrame implements ActionListener{

    
   private JPanel pCard,pNord,pEst,pOest, pBlau, pVermell,pVerde, pRosa , pTaulell;
   
   private JButton botoVermell, botoBlau,botoRosa, botoVerde;
   
   private String vermell ="vermell", blau = "blau", rosa = "rosa" , verde = "verde" ;

    public CardLayoutJFrame() {
        
        configuracio();
        this.pack();
        this.setVisible(true);
        
    }
   
   private void configuracio(){
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //lo que hace por defecto cuando le das al boton de cerrar
       this.setPreferredSize(new Dimension(600, 300));
       //Establecemos unas dimensiones
       
       this.setLocationRelativeTo(null);//Donde quieres la ventana, null es en medio
       //si la quieres en un sitio especifico
       //hay que hacer
       //this.Location(x,y);
       
       this.setLayout(new BorderLayout());
       
       pNord = new JPanel();
       pEst = new JPanel();
       pOest = new JPanel();
       
       
       
       botoBlau = new JButton(blau);
       botoVermell = new JButton(vermell);
       
       botoRosa = new JButton(rosa);
       botoVerde = new JButton(verde);
       
       
       
       botoBlau.addActionListener(this);
       botoVermell.addActionListener(this);
       
       
       botoVerde.addActionListener(this);
       botoRosa.addActionListener(this);
       
       
       pNord.add(botoBlau);
       pNord.add(botoVermell);
       
       pEst.add(botoRosa);
       pOest.add(botoVerde);
       
       this.add(pNord, BorderLayout.NORTH);
       this.add(pEst, BorderLayout.EAST);
       this.add(pOest, BorderLayout.WEST);
    
       pCard = new JPanel(new CardLayout());
       
       pBlau = new JPanel();
       pVermell = new JPanel();
       
       pRosa = new JPanel();
       pVerde = new JPanel();
       
       
       pBlau.setBackground(Color.ORANGE);
       pVermell.setBackground(Color.YELLOW);
       
       
       pVerde.setBackground(Color.MAGENTA);
       pRosa.setBackground(Color.CYAN);
       
       pCard.add(pBlau, blau);
       pCard.add(pVermell, vermell);
       pCard.add(pRosa, rosa);
       //pCard.add(pVerde, verde);
       this.add(pCard, BorderLayout.CENTER);
       
   }

   
   private void crearTaulell(){
       
       pTaulell = new JPanel();
       
       for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton boto = new JButton("" + (i * 8 + j));
                this.add(boto);
                boto.addActionListener(this);
            }
        }
       
       
   }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(!e.getActionCommand().equals(verde)){
            ((CardLayout)pCard.getLayout()).show(pCard, e.getActionCommand());
        
        }else{
            
                crearTaulell();
                //((CardLayout)pCard.getLayout()).show(pCard, e.getActionCommand());
                ((CardLayout)pCard.getLayout()).show(pCard, e.getActionCommand());
        
        }
        
        
    }
   
   
}

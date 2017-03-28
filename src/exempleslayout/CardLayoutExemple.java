package exempleslayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CardLayoutExemple extends JApplet implements ActionListener {

    private JPanel card;
    private String PanelBoto = "Panell amb botons";
    private String PanelText = "Panell amb camp de text";
    private JPanel p1, p2;

    @Override
    public void init() {
        this.setLayout(new BorderLayout());
        JPanel ac = new JPanel();
        Choice c = new Choice();

        c.addItem(PanelBoto);
        c.addItem(PanelText);
        ac.add(c);
        this.add("North", ac);

        card = new JPanel();
        card.setLayout(new CardLayout());

        p1 = new JPanel();
        JButton boto1 = new JButton("Botó 1");
        boto1.addActionListener(this);
        p1.add(boto1);
        p1.add(new JButton("Botó 2"));
        p1.add(new JButton("Botó 3"));

        p2 = new JPanel();
        p2.add(new JTextField("Text", 20));

        card.add(PanelBoto, p1);
        card.add(PanelText, p2);
        this.add("Center", card);
    }

    @Override
    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Choice) {
            ((CardLayout) card.getLayout()).show(card, (String) arg);
            return true;
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p1.setBackground(Color.cyan);
    }
}

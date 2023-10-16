package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JButton MOMLB = new JButton("inputMOML");
    private JTextArea MOML = new JTextArea(15,10);

    private JButton selectQB = new JButton("selectQ (4 or 5)");
    private JTextField selectQ = new JTextField(10);

    private JButton ok = new JButton("OK");

    private String ans = "";
    private JLabel Anslb = new JLabel("ANS");
    private  JTextArea ANSta = new  JTextArea(ans);


    public View(){
        JPanel calcPanel = new JPanel();

        this.setSize(800, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); 
        MOMLB.setPreferredSize(new Dimension(300, 20));
        calcPanel.add(MOMLB);
        MOML.setPreferredSize(new Dimension(450, 200));
        calcPanel.add(MOML);

        selectQB.setPreferredSize(new Dimension(300, 20));
        calcPanel.add(selectQB);
        selectQ.setPreferredSize(new Dimension(400, 20));
        calcPanel.add(selectQ);

        ok.setPreferredSize(new Dimension(450, 20));
        calcPanel.add(ok);

        calcPanel.add(Anslb);
        Anslb.setPreferredSize(new Dimension(450, 20));
        calcPanel.add(Anslb);
        ANSta.setPreferredSize(new Dimension(450, 200));
        calcPanel.add(ANSta);

        this.add(calcPanel);
        this.setVisible(true);

    }

    public String getMOML() {
        return MOML.getText();
    }

    public String getq(){
        return selectQ.getText();
    }

    public JButton getOK() {
        return ok;
    }

    public void setAns(String ans){
        ANSta.setText(ans);
    }

    public void addCalculationListener(ActionListener listenerForCalcButton){
        ok.addActionListener(listenerForCalcButton);
    }

    public void displayErrorMessage(String e){
        JOptionPane.showMessageDialog(this, e);
    }
    


    



}
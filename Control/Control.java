package Control;

import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {
    private View view;
    private Model model;

    public Control(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addCalculationListener(new Listener());
    }
 
    class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getq().equals("4")){
                String q4 = model.CalculateQ4(view.getMOML());
                view.setAns(q4);
            }else if(view.getq().equals("5")){
                String q5 = model.CalculateQ5(view.getMOML());
                view.setAns(q5);
            }else{
                view.displayErrorMessage("Try agin with 4 or 5");
            }
        }
    }

}

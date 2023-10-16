// No : 65050446
// Name : Narakorn Deeyen
// choice 2 


import Model.*;
import View.*;
import Control.*;

public class MVCmain {
    public static void main(String[] args) {
        View view = new View();
        Model Model = new Model();
        Control control = new Control(view, Model);
    }
}

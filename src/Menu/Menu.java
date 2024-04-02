package Menu;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import arrayLogic.*; 

public class Menu {

    public void menu() {
      
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, "-----Menu de Arrays-----\n"
                + "1.Array 1\n"
                + "2.Array 2\n"
                + "3.Array 3\n"
                + "4.Array 4\n"
                + "5.Array 5\n"
                + "0.Salir\n"));
        switch (op) {
            case 1:
            menuArray1();
                break;
            case 2:

                break;

            case 3:

                break;

            case 4:

                break;
            case 5:

                break;
            case 6:

                break;

            default:
                break;
        }

    }

    private void menuArray1(){
        ArrayList<Array_1> x = new ArrayList<>();
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, "-----Menu de Array 1-----\n"
                + "1.Crear el Array.\n"
                + "2.Mostrar.\n"
                + "3.Promedio de los valores\n"
                + "0.Salir\n"));
        switch (op) {
            case 1:
                 Array_1.llenarArray_1();
                 JOptionPane.showMessageDialog(null, "El Array ha sido llenado");
                break;
            case 2:
                Array_1.mostrar();
                break;

            case 3:

                break;

            case 4:

                break;
            case 5:

                break;
            case 6:

                break;

            default:
                break;
        }

    }

}

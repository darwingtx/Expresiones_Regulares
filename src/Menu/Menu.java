package Menu;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import arrayLogic.*;

public class Menu {

    public void menu() {
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "-----Menu de Arrays-----\n"
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
                    menuArray3();
                    break;

                case 4:

                    break;
                case 5:

                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Hasta luego");
                    break;

                default:
                    break;
            }

        } while (op != 0);

    }

    private void menuArray1() {
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "-----Menu de Array 1-----\n"
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
                    if (!Array_1.getArray_1().isEmpty()) {
                        Array_1.mostrar();
                    } else
                        JOptionPane.showMessageDialog(null, "El Array esta vacio");
                    break;

                case 3:
                    if (!Array_1.getArray_1().isEmpty()) {
                        Array_1.promedio();
                    } else
                        JOptionPane.showMessageDialog(null, "El Array esta vacio");
                    break;

                case 0:
                JOptionPane.showMessageDialog(null, "Volviendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                    break;
            }
        } while (op != 0);
    }

    private void menuArray3() {
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "-----Menu de Array 3-----\n"
                    + "1.Cargar datos en el Array.\n"
                    + "2.Agregar Docente.\n"
                    + "3.Mostrar.\n"
                    + "4.Buscar e imprimir el porcentaje de cierto docente dado.\n"
                    + "5.Cantidad de veces que se equivoco el usuario ingresando el numero de cedula.\n"
                    + "6.Buscar y almacenar en otro ArrayList los docentes de catedra que almacenaron la fecha con mes.\n"
                    + "0.Salir\n"));
            switch (op) {
                case 1:
                    Array_3.CargarDatos(
                            "D:\\Users\\Usuario\\Documents\\NetBeansProjects\\AP4\\Expresiones_Regulares\\src\\Utilidades\\cargabasica.txt");
                    JOptionPane.showMessageDialog(null, "El Array ha sido llenado");
                    break;
                case 2:
                    Array_3.agregarObj();
                    break;

                case 3:
                 Array_3.mostrar(Array_3.Array_3);
                    break;
                case 4:
                    Array_3.buscarTd();
                    break;
                case 5:
                    Array_3.errores();
                    break;

                case 6:
                Array_3.docenteMes();
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Volviendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                    break;
            }
        } while (op != 0);
    }
}

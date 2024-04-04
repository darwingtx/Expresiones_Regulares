package Menu;

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
                    menuArray2();
                    break;

                case 3:
                    menuArray3();
                    break;

                case 4:
                    menuArray4();
                    break;
                case 5:
                    menuArray5();
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

    private void menuArray2() {
        Array2 x = new Array2();
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "-----Menu de Array 2-----\n"
                    + "1.Llenar ArrayList.\n"
                    + "2.Mostrar ArrayList.\n"
                    + "3.Numero mayor\n"
                    + "0.Salir\n"));
            switch (op) {
                case 1:
                    if (x.getArray2().isEmpty()) {
                        x.LlenarArray2();
                        JOptionPane.showMessageDialog(null, "El Array ha sido llenado");
                    } else {
                        JOptionPane.showMessageDialog(null, "El Array ha sido llenado anteriormente");
                    }
                    break;
                case 2:
                    if (!x.getArray2().isEmpty()) {
                        x.Listar();
                    } else
                        JOptionPane.showMessageDialog(null, "El Array esta vacio");
                    break;

                case 3:
                    if (!x.getArray2().isEmpty()) {
                        x.Mayor();
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

    private void menuArray4() {
        LArray4 x = new LArray4();
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "-----Menu de Array 4-----\n"
                    + "1.Cargar ArrayList.\n"
                    + "2.Ingresar datos.\n"
                    + "3.Mostrar ArrayList.\n"
                    + "4.Numeros seguidos(Codigo)\n"
                    + "0.Salir\n"));
            switch (op) {
                case 1:
                    x.CargarDatos();;
                    JOptionPane.showMessageDialog(null, "El Array ha sido cargado");
                    break;
                case 2:
                    x.Llenado();
                    JOptionPane.showMessageDialog(null, "El Array ha sido llenado");
                    break;
                case 3:
                    if (!x.getArray4().isEmpty()) {
                        x.Listar();
                    } else
                        JOptionPane.showMessageDialog(null, "El Array esta vacio");
                    break;

                case 4:
                    if (!x.getArray4().isEmpty()) {
                        x.Seguidos();
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

    private void menuArray5() {
        LTarjetas x = new LTarjetas();
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "-----Menu de Array 5-----\n"
                    + "1.Cargar Tarjetas de Credito.\n"
                    + "2.Ingresar Tarjetas de credito.\n"
                    + "3.Motrar Tarjetas\n"
                    + "4.Mostrar tarjetas por Visa y MasterCard\n"
                    + "5.Buscar tarjetas por año\n"
                    + "0.Salir\n"));
            switch (op) {
                case 1:

                    JOptionPane.showMessageDialog(null, "El Array ha sido llenado");
                    break;
                case 2:

                    x.Ingreso();

                case 3:
                    if (!x.getTarjetas().isEmpty()) {
                        x.Listar();
                    } else
                        JOptionPane.showMessageDialog(null, "El Array esta vacio");
                    break;
                case 4:
                    if (!x.getTarjetas().isEmpty()) {

                    } else
                        JOptionPane.showMessageDialog(null, "El Array esta vacio");
                    break;
                case 5:
                    if (!x.getTarjetas().isEmpty()) {
                        x.fecha();
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

}

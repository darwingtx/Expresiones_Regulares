package arrayLogic;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Array_3 {

    public static ArrayList<Array_3> Array_3 = new ArrayList<>();
    public static int error = 0;
    private String cc;
    private String nombre;
    private String tD;
    private String fecha;

    public Array_3() {

    }

    public Array_3(String cc, String tD, String fecha, String nombre) {
        this.cc = cc;
        this.tD = tD;
        this.fecha = fecha;
        this.nombre = nombre;
    }

    public static void CargarDatos(String sfichero) {
        File fichero = new File(sfichero);
        Scanner s = null;
        try {
            s = new Scanner(fichero);
            int op = 0;

            while (s.hasNextLine()) {
                String linea = s.nextLine();
                String[] cortarString = linea.split(";");
                Array_3 x = new Array_3();
                x.setCc(cortarString[0]);
                x.setNombre(cortarString[1]);
                x.settD(cortarString[2]);
                x.setFecha(cortarString[3]);
                Array_3.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null)
                    s.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public static void agregarObj() {
        String cc = "", nombre = "", tD = "", fecha = "";
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, "1.Agregar\n0.Salir\n"));
        do {
            cc = ingresoCc();
            nombre = JOptionPane.showInputDialog(null, "Digite el nombre del docente.");
            tD = ingresotD();
            fecha = ingresofech();
            Array_3.add(new Array_3(cc, tD, fecha, nombre));
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "1.Agregar\n0.Salir\n"));
        } while (op == 1);

    }

    public static String ingresoCc() {
        String regex = "^\\d+$";
        String cc = JOptionPane.showInputDialog(null, "Ingrese una cedula sin comas o puntos y solo con digitos.");

        while (!cc.matches(regex)) {
            cc = JOptionPane.showInputDialog(null, "Ingrese una cedula sin comas o puntos y solo con digitos.");
            error++;
        }
        return cc;
    }

    public static String ingresotD() {
        int opcion;
        boolean salir = false;
        while (!salir) {
            String[] options = { "Docente de Planta", "Docente Ocasional", "Docente de Catedra" };
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Tipos de docentes",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch (opcion) {
                case 0:
                    return "Docente de Planta";

                case 1:
                    return "Docente Ocasional";

                case 2:
                    return "Docente de Catedra";
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        }

        return null;
    }

    public static String ingresofech() {
        Scanner scanner = new Scanner(System.in);
        String fecha;
        boolean fechaValida = false;
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        do {
            fecha = JOptionPane.showInputDialog(null, "Ingrese una fecha en formato dd/mm/aaaa: ");
            Matcher matcher = pattern.matcher(fecha);
            if (matcher.matches()) {
                fechaValida = true;
            } else {
                System.out.println("Formato de fecha incorrecto. Por favor, vuelva a intentarlo.");
            }
        } while (!fechaValida);

        return fecha;

    }

    public static void errores() {
        JOptionPane.showMessageDialog(null,  "La cantidad de errores al ingresar la cedula es: " + error);
    }

    public static void buscarTd() {

        Iterator<Array_3> x = Array_3.iterator();
        JOptionPane.showMessageDialog(null, "A continuacion seleccione el tipo de docente");
        String td = ingresotD();
        float cont = 0;
        float porc = 0;
        while (x.hasNext()) {
            Array_3 r = x.next();
            if (r.gettD().equals(td)) {
                cont++;
            }
        }
        porc = (cont * 100) / Array_3.size();
        JOptionPane.showMessageDialog(null, "El porcentaje de " + td + " es de: " + porc);
    }

    public static void docenteMes() {
        Iterator<Array_3> x = Array_3.iterator();
        ArrayList<Array_3> aMeses = new ArrayList<>();
        int opcion;
        String[] options = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
        opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Mes",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        String[] optionD = { "Docente de Planta", "Docente Ocasional", "Docente de Catedra" };
        int opcionD = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Tipos de docentes",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionD, optionD[0]);
        String mes = "" + (opcion + 1);
        String regex;
        if (Integer.parseInt(mes) < 10) {
            mes = "0" + mes;
        }
        regex = "\\d{2}/" + mes + "/\\d{4}";
                while (x.hasNext()) {
                    Array_3 r = x.next();
                    if (r.gettD().equals(optionD[opcionD])) {
                        if (r.getFecha().matches(regex)) {
                            aMeses.add(r);
                        }
                    }
                }
            if(!aMeses.isEmpty()){
                mostrar(aMeses);
            }else{
                JOptionPane.showMessageDialog(null, "No hubo coincidencia");
            }

    }

    public static void mostrar(ArrayList<Array_3> T) {

        String s = "";
        for (int i = 0; i < T.size(); i++) {
                s += "Docente: "+T.get(i).getNombre()+" Cedula: "+T.get(i).getCc()+" "
                +T.get(i).gettD()+" Fecha: "+T.get(i).getFecha()+"\n";
            
            
        }
     JTextArea textArea = new JTextArea(s);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        JOptionPane.showMessageDialog(null, scrollPane, "Array 3", 1);
    }
    
    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String gettD() {
        return tD;
    }

    public void settD(String tD) {
        this.tD = tD;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
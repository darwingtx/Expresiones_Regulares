package arrayLogic;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LTarjetas {

    private ArrayList<TarjetaCredito> tarjetas = new ArrayList<>();

    public LTarjetas() {
        CargarDatos("D:\\Users\\Usuario\\Documents\\NetBeansProjects\\AP4\\Expresiones_Regulares\\src\\Utilidades\\tarjetas.txts");
       }

    public void Ingreso() {
        String visa = "^5[0-9]{15}$";
        String master = "^4[0-9]{15}$";
        String nomb = "^[A-Z]{1,100}$";
        String cvv = "^[0-9]{3}$";
        TarjetaCredito x = new TarjetaCredito();

        String num = JOptionPane.showInputDialog(null, "Ingresa el numero de la tarjeta");

        while (!num.matches(visa) && !num.matches(master)) {
            num = JOptionPane.showInputDialog(null,
                    "(Error intente de nuevo)\nIngresa el numero de la tarjeta");
        }

        x.setNumTarj(Long.parseLong(num));
        if (num.matches(visa)) {
            x.setTipo("Visa");
        } else if (num.matches(master)) {
            x.setTipo("MasterCard");
        }

        String nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre que esta en la tarjeta");

        while (!nombre.matches(nomb)) {
            nombre = JOptionPane.showInputDialog(null,
                    "(Error intente de nuevo)\nIngresa el nombre que esta en la tarjeta");
        }

        x.setNombre(nombre);

        String apellido = JOptionPane.showInputDialog(null, "Ingresa el apellido que esta en la tarjeta");

        while (!apellido.matches(nomb)) {
            apellido = JOptionPane.showInputDialog(null,
                    "(Error intente de nuevo)\nIngresa el apellido que esta en la tarjeta");
        }

        x.setApellido(apellido);

        x.setFecha(this.ingresofech());

        String codigo = JOptionPane.showInputDialog(null, "Ingresa el codigo de verificacion que esta en la tarjeta");

        while (!codigo.matches(cvv)) {
            codigo = JOptionPane.showInputDialog(null,
                    "(Error intente de nuevo)\nIngresa el codigo de verificacion que esta en la tarjeta");
        }

        x.setCvv(Short.parseShort(codigo));

        tarjetas.add(x);
    }

    public String ingresofech() {
        String fecha;
        boolean fechaValida = false;
        String regex = "^(0[1-9]|1[0-2])/\\d{2}$";
        Pattern pattern = Pattern.compile(regex);

        do {
            fecha = JOptionPane.showInputDialog(null, "Ingrese una fecha en formato MM/YY: ");
            Matcher matcher = pattern.matcher(fecha);
            if (matcher.matches()) {
                fechaValida = true;
            } else {
                System.out.println("Formato de fecha incorrecto. Por favor, vuelva a intentarlo.");
            }
        } while (!fechaValida);

        return fecha;

    }

    public void Listar() {
        int p = 500, t = 300;
        String s = "";
        int i = 1;
        for (TarjetaCredito tarjetaCredito : tarjetas) {
            s += "Tarjeta #" + i + "\n";
            s += tarjetaCredito.getNumTarj() + "\n";
            s += tarjetaCredito.getTipo() + "\n";
            s += tarjetaCredito.getNombre() + " " + tarjetaCredito.getApellido() + "\n";
            s += tarjetaCredito.getFecha() + "\n";
            s += tarjetaCredito.getCvv();

            i++;
        }
        JTextArea textArea = new JTextArea(s);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new Dimension(p, t));
        JOptionPane.showMessageDialog(null, scrollPane, "Tarjetas de Credito", 1);
    }

    public void tipoT() {
        ArrayList<TarjetaCredito> tarjetasVisa = new ArrayList<>();
        ArrayList<TarjetaCredito> tarjetasMasT = new ArrayList<>();
        String visa = "^5[0-9]{15}$";
        String master = "^4[0-9]{15}$";
        for (int index = 0; index < tarjetas.size(); index++) {
            TarjetaCredito x = tarjetas.get(index);
            String numT = "" + x.getNumTarj();
            if (numT.matches(visa)) {
                tarjetasVisa.add(x);
            } else if (numT.matches(master)) {
                tarjetasMasT.add(x);
            }

        }
        int op = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione una opcion\n" +
                    "1.Mostrar Array Visa.\n" +
                    "2.Mostrar Array Mastercard.\n" +
                    "0.salir.\n"));
            switch (op) {
                case 1:
                Listar(tarjetasVisa);
                    break;
                case 2:
                Listar(tarjetasMasT);
                    break;

                case 0:
                JOptionPane.showMessageDialog(null, "Volviendo...");
                    break;

                default:
                JOptionPane.showMessageDialog(null, "Opcion invalida.");
                    break;
            }

        } while (op != 0);

    }
      
    public void CargarDatos(String sfichero) {
        File fichero = new File(sfichero);
        Scanner s = null;
        try {
            s = new Scanner(fichero);
            int op = 0;

            while (s.hasNextLine()) {
                String linea = s.nextLine();
                String[] cortarString = linea.split(";");
                TarjetaCredito x = new TarjetaCredito();
                    x.setTipo(cortarString[0]);
                    x.setNumTarj(Long.parseLong(cortarString[1]));
                    x.setNombre(cortarString[2]);
                    x.setApellido(cortarString[3]);
                    x.setFecha(cortarString[4]);
                    x.setCvv(Short.parseShort(cortarString[5]));
                    tarjetas.add(x);
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
    public void Listar(ArrayList<TarjetaCredito> tarjetas) {
        int p = 500, t = 300;
        String s = "";
        int i = 1;
        for (TarjetaCredito tarjetaCredito : tarjetas) {
            s += "Tarjeta #" + i + "\n";
            s += tarjetaCredito.getNumTarj() + "\n";
            s += tarjetaCredito.getTipo() + "\n";
            s += tarjetaCredito.getNombre() + " " + tarjetaCredito.getApellido() + "\n";
            s += tarjetaCredito.getFecha() + "\n";
            s += tarjetaCredito.getCvv();

            i++;
        }
        JTextArea textArea = new JTextArea(s);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new Dimension(p, t));
        JOptionPane.showMessageDialog(null, scrollPane, "Tarjetas de Credito", 1);
    }
}

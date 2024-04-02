package arrayLogic;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LTarjetas {

    private ArrayList<TarjetaCredito> tarjetas = new ArrayList<>();

    public LTarjetas() {

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
        }else if(num.matches(master)){
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

    public void Listar(){
        int p = 500, t = 300;
        String s = "";
        int i=1;
        for (TarjetaCredito tarjetaCredito : tarjetas) {
            s+="Tarjeta #"+i+"\n";
            s+=tarjetaCredito.getNumTarj()+"\n";
            s+=tarjetaCredito.getTipo()+"\n";
            s+=tarjetaCredito.getNombre() +" "+ tarjetaCredito.getApellido()+"\n";
            s+=tarjetaCredito.getFecha()+"\n";
            s+=tarjetaCredito.getCvv();

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

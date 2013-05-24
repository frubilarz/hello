package cl.codo.fernando.gui;

import cl.codo.fernando.modelo.Usuario;
import cl.codo.fernando.servicio.ServicioDB;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando
 */
public class Codo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServicioDB servicio = new ServicioDB();
        Usuario usuario = servicio.getUsuario();
        if(usuario==null)
        {
            Claves panel =new Claves();
            panel.setVisible(true);
            panel.setLocationRelativeTo(null);
        }
        else{
        Autentificacion panel = new Autentificacion();
        panel.setVisible(true);
        panel.setLocationRelativeTo(null);
        }

    }
}

package Utils;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import Models.Persona;

public class UIUtils {

    public static boolean validarCamposObligatorios(JTextField tfNombre, JTextField tfApellidos,
            JTextField tfCorreo, JTextField tfPais, JTextField tfProfesion,
            JDateChooser dcFechaNacimiento) {

        if (tfNombre.getText().trim().isEmpty()
                || tfApellidos.getText().trim().isEmpty()
                || tfCorreo.getText().trim().isEmpty()
                || tfPais.getText().trim().isEmpty()
                || tfProfesion.getText().trim().isEmpty()
                || dcFechaNacimiento.getDate() == null) {

            mostrarMensaje("Por favor, complete todos los campos obligatorios",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean validarId(JTextField tfBuscarPersona) {
        String idPersona = tfBuscarPersona.getText().trim();

        if (idPersona.isEmpty() || idPersona.equals("0")) {
            mostrarMensaje("Error al tratar de capturar un ID",
                    "Debes ingresar un ID válido",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static void mostrarPersonaEncontrada(Persona persona, JTextField tfNombre,
            JTextField tfApellidos, JTextField tfCorreo, JTextField tfPais,
            JTextField tfProfesion, JDateChooser dcFechaNacimiento,
            JComboBox<String> cbRol) {

        tfNombre.setText(persona.getNombre());
        tfApellidos.setText(persona.getApellidos());
        tfCorreo.setText(persona.getCorreo());
        tfPais.setText(persona.getPais());
        tfProfesion.setText(persona.getProfesion());

        Calendar cal = Calendar.getInstance();
        cal.setTime(persona.getFechaNacimiento());
        dcFechaNacimiento.setCalendar(cal);

        cbRol.setSelectedIndex(persona.getRol().intValue() - 1);
    }

    public static void limpiarCampos(JTextField tfNombre, JTextField tfApellidos,
            JTextField tfCorreo, JTextField tfPais, JTextField tfProfesion,
            JDateChooser dcFechaNacimiento, JComboBox<String> cbRol,
            JTextField tfBuscarPersona) {

        tfNombre.setText("");
        tfApellidos.setText("");
        tfCorreo.setText("");
        tfPais.setText("");
        tfProfesion.setText("");
        dcFechaNacimiento.setCalendar(null);
        cbRol.setSelectedIndex(0);
        tfBuscarPersona.setEditable(true);
        tfBuscarPersona.setText("");
    }

    public static void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }
}
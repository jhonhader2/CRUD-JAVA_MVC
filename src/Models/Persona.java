/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigInteger;
import java.util.Date;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.Calendar;

/**
 *
 * @author Hader
 */
public class Persona {

    private BigInteger id;
    private BigInteger rol;

    private String nombre;
    private String apellidos;
    private String correo;
    private String pais;
    private String profesion;

    private Date fechaNacimiento;

    public Persona() {
    }

    public Persona(BigInteger id, String nombre, String apellidos, String correo, String pais, String profesion,
            BigInteger rol, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.pais = pais;
        this.profesion = profesion;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public BigInteger getRol() {
        return rol;
    }

    public void setRol(BigInteger rol) {
        this.rol = rol;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    public static boolean validarCamposObligatorios(JTextField tfNombre, JTextField tfApellidos,
            JTextField tfCorreo, JTextField tfPais, JTextField tfProfesion,
            JDateChooser dcFechaNacimiento) {

        if (tfNombre.getText().trim().isEmpty()
                || tfApellidos.getText().trim().isEmpty()
                || tfCorreo.getText().trim().isEmpty()
                || tfPais.getText().trim().isEmpty()
                || tfProfesion.getText().trim().isEmpty()
                || dcFechaNacimiento.getDate() == null) {

            JOptionPane.showMessageDialog(null,
                    "Por favor, complete todos los campos obligatorios",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean validarId(JTextField tfBuscarPersona) {
        String idPersona = tfBuscarPersona.getText().trim();

        if (idPersona.isEmpty() || idPersona.equals("0")) {
            JOptionPane.showMessageDialog(null,
                    "Error al tratar de capturar un ID",
                    "Debes ingresar un ID válido",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static Persona obtenerDatosPersona(JTextField tfNombre, JTextField tfApellidos,
            JTextField tfCorreo, JTextField tfPais, JTextField tfProfesion,
            JDateChooser dcFechaNacimiento, JComboBox<String> cbRol) {

        Persona persona = new Persona();
        persona.setNombre(tfNombre.getText().trim());
        persona.setApellidos(tfApellidos.getText().trim());
        persona.setCorreo(tfCorreo.getText().trim());
        persona.setPais(tfPais.getText().trim());
        persona.setProfesion(tfProfesion.getText().trim());
        persona.setFechaNacimiento(dcFechaNacimiento.getDate());
        persona.setRol(new BigInteger(String.valueOf(cbRol.getSelectedIndex() + 1)));

        return persona;
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

        // Convertir Date a Calendar
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

    public boolean validarDatos() {
        return nombre != null && !nombre.trim().isEmpty() &&
                apellidos != null && !apellidos.trim().isEmpty() &&
                correo != null && !correo.trim().isEmpty() &&
                pais != null && !pais.trim().isEmpty() &&
                profesion != null && !profesion.trim().isEmpty() &&
                fechaNacimiento != null &&
                rol != null;
    }
}

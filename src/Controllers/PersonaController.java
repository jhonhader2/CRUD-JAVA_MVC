/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Config.ConexionLocal;

import Interface.IGestorDatos;
import Models.Persona;

import java.math.BigInteger;
import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Calendar;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;

/**
 *
 * @author Hader
 */
public class PersonaController implements IGestorDatos<Persona> {

    private final ConexionLocal conNewAdmin = new ConexionLocal();

    @Override
    public boolean creacion(Persona objeto) {
        try {
            conNewAdmin.conectar();
            String sql = "INSERT INTO personas (nombre,apellidos,correo,fecha_nacimiento,pais,profesion,id_rol)"
                    + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st = conNewAdmin.getConexion().prepareStatement(sql);
            st.setString(1, objeto.getNombre());
            st.setString(2, objeto.getApellidos());
            st.setString(3, objeto.getCorreo());
            java.sql.Date fechaNacimiento = new java.sql.Date(objeto.getFechaNacimiento().getTime());
            st.setDate(4, fechaNacimiento);
            st.setString(5, objeto.getPais());
            st.setString(6, objeto.getProfesion());
            st.setLong(7, objeto.getRol().longValue());

            st.executeUpdate();
            mostrarMensaje("Se ha realizado un nuevo registro.", "Datos Guardados",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;

        } catch (Exception e) {
            mostrarMensaje("Error al crear una nueva persona", "Error al crear",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;

        } finally {
            conNewAdmin.desconectar();
        }
    }

    @Override
    public Persona lectura(BigInteger id) {
        Persona persona = new Persona();

        try {
            conNewAdmin.conectar();

            String sql = "SELECT nombre, apellidos, correo, fecha_nacimiento, pais, profesion, id_rol FROM personas WHERE id = ?";
            PreparedStatement st = conNewAdmin.getConexion().prepareStatement(sql);
            st.setLong(1, id.longValue());
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                persona.setNombre(rs.getString("nombre"));
                persona.setApellidos(rs.getString("apellidos"));
                persona.setCorreo(rs.getString("correo"));
                persona.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                persona.setPais(rs.getString("pais"));
                persona.setProfesion(rs.getString("profesion"));
                persona.setRol(BigInteger.valueOf(rs.getInt("id_rol")));
            } else {
                persona = new Persona();
                mostrarMensaje("No se encontró ninguna persona con el ID: " + id,
                        "Error al buscar", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            mostrarMensaje("Error al leer una persona", "Error al leer",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        } finally {
            conNewAdmin.desconectar();
        }

        return persona;
    }

    @Override
    public void actualizar(Persona objeto, BigInteger id) {
        // TODO: Implementar actualización
    }

    @Override
    public void eliminar(BigInteger id) {
        // TODO: Implementar eliminación
    }

    public boolean validarCamposObligatorios(JTextField tfNombre, JTextField tfApellidos,
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

    public Persona obtenerDatosPersona(JTextField tfNombre, JTextField tfApellidos,
            JTextField tfCorreo, JTextField tfPais, JTextField tfProfesion,
            JDateChooser dcFechaNacimiento, JComboBox<String> cbRol) {

        Persona persona = new Persona();
        persona.setNombre(tfNombre.getText());
        persona.setApellidos(tfApellidos.getText());
        persona.setCorreo(tfCorreo.getText());
        persona.setPais(tfPais.getText());
        persona.setProfesion(tfProfesion.getText());
        persona.setFechaNacimiento(dcFechaNacimiento.getDate());

        // Asignar rol según la selección
        switch (cbRol.getSelectedIndex()) {
            case 0 ->
                persona.setRol(new BigInteger("1"));
            case 1 ->
                persona.setRol(new BigInteger("2"));
            case 2 ->
                persona.setRol(new BigInteger("3"));
            case 3 ->
                persona.setRol(new BigInteger("4"));
            case 4 ->
                persona.setRol(new BigInteger("5"));
            default ->
                persona.setRol(new BigInteger("2"));
        }

        return persona;
    }

    public void mostrarPersonaEncontrada(Persona persona, JTextField tfNombre,
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

    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }

    public boolean validarIngresado(JTextField tfBuscarPersona) {
        String idPersona = tfBuscarPersona.getText().trim();

        if (idPersona.equals("") || idPersona.equals(0)) {
            mostrarMensaje(
                    "Error al tratar de capturar un ID",
                    "Debes ingresar un ID válido",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void limpiarDatos(JTextField tfNombre, JTextField tfApellidos,
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

}

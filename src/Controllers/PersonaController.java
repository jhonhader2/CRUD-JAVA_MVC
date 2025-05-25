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
            // Formatear fecha
            java.sql.Date fechaNacimiento = new java.sql.Date(objeto.getFechaNacimiento().getTime());
            // pasar fecha
            st.setDate(4, fechaNacimiento);
            st.setString(5, objeto.getPais());
            st.setString(6, objeto.getProfesion());
            st.setLong(7, objeto.getRol().longValue());

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha realizado un nuevo registro.", "Datos Guardados",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear una nueva persona", "Error al crear",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;

        } finally {
            conNewAdmin.desconectar();
        }
    }

    @Override
    public Persona lectura(BigInteger id) {

        return null;

    }

    @Override
    public void actualizar(Persona Objeto, BigInteger id) {

    }

    @Override
    public void eliminar(BigInteger id) {

    }

}

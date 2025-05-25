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
                JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con el ID: " + id,
                        "Error al buscar", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer una persona", "Error al leer",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        } finally {
            conNewAdmin.desconectar();
        }

        return persona;
    }

    @Override
    public void actualizar(Persona Objeto, BigInteger id) {

    }

    @Override
    public void eliminar(BigInteger id) {

    }

}

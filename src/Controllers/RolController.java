/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Config.ConexionLocal;
import Models.Rol;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigInteger;
import java.util.Collections;

/**
 *
 * @author Hader
 */
public class RolController {

    
    private ConexionLocal conConsultar = new ConexionLocal();
    private Rol mostrarRol = new Rol();

    public List<Rol> traerRoles() {
        List<Rol> roles = new ArrayList();

        String sql = "SELECT id, nombre FROM roles ORDER BY id";

        try {
            conConsultar.conectar();
            PreparedStatement stmt = conConsultar.getConexion().prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Rol rol = new Rol();
                rol.setId(BigInteger.valueOf(rs.getLong("id")));
                rol.setNombre(rs.getString("nombre"));
                roles.add(rol);
            }

            return roles;
        } catch (SQLException e) {
            System.out.println("Error al traer los roles: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al traer los roles: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Rol> obtenerRoles() {
        return traerRoles();
    }
}

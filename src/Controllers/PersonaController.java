/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Config.ConexionLocal;
import Interface.IGestorDatos;
import Models.Persona;
import com.mysql.cj.jdbc.ConnectionGroup;

import java.math.BigInteger;

/**
 *
 * @author Hader
 */
public class PersonaController implements IGestorDatos<Persona> {

    private ConnectionGroup conexion;
    private final ConexionLocal conNewAdmin = new ConexionLocal();

    @Override
    public void creacion(Persona Objeto) {
        try {
            conNewAdmin.conectar();
        } catch (Exception e) {
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

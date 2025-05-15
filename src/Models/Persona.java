/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigInteger;
import java.util.Date;

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

    public Persona(BigInteger id, String nombre, String apellidos, String correo, String pais, String profesion, BigInteger rol, Date fechaNacimiento) {
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

}

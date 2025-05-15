package Config;

import Interface.IGestorConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

// CRUD Desarrollado por Deyson
/**
 * La clase ConexionLocal representa una conexión local a una base de datos
 * MySQL.
 * Implementa la interfaz IGestorConexion.
 */
public class ConexionLocal implements IGestorConexion {

    private String url = "jdbc:mysql://localhost/crud_java_mvc?useSSL=false&serverTimezone=UTC";
    private String usuario = "root";
    private String clave = "";

    // Instancia de la clase Connection del sistema
    private Connection conexion;

    /**
     * Constructor por defecto de la clase ConexionLocal.
     */
    public ConexionLocal() {
    }

    /**
     * Obtiene la URL de la conexión a la base de datos.
     *
     * @return La URL de la conexión a la base de datos.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Establece la URL de la conexión a la base de datos.
     *
     * @param url La URL de la conexión a la base de datos.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Obtiene el usuario de la conexión a la base de datos.
     *
     * @return El usuario de la conexión a la base de datos.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario de la conexión a la base de datos.
     *
     * @param usuario El usuario de la conexión a la base de datos.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la clave de la conexión a la base de datos.
     *
     * @return La clave de la conexión a la base de datos.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Establece la clave de la conexión a la base de datos.
     *
     * @param clave La clave de la conexión a la base de datos.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Obtiene la conexión a la base de datos.
     *
     * @return La conexión a la base de datos.
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Establece la conexión a la base de datos.
     *
     * @param conexion La conexión a la base de datos.
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Conecta a la base de datos local.
     */
    @Override
    public void conectar() {
        try {
            conexion = DriverManager.getConnection(this.url, this.usuario, this.clave);
            System.out.println("Conectado a la base de datos local");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede conectar al servidor, por revisa el servidor",
                    "Problemas al conectar", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    /**
     * Desconecta de la base de datos local.
     */
    @Override
    public void desconectar() {
        conectar();
        try {
            conexion.close();
            System.out.println("Desconectado de la base de datos local");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Prueba si la conexión a la base de datos está abierta.
     *
     * @return true si la conexión está abierta, false si está cerrada.
     */

    @Override
    public boolean testearConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                System.out.println("Conexion abierta");
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
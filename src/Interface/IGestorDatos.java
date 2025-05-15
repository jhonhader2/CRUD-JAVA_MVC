/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.math.BigInteger;

/**
 *
 * @author Hader
 * @param <T>
 */
public interface IGestorDatos<T> {

    void creacion(T Objeto);

    T lectura(BigInteger id);

    void actualizar(T Objeto, BigInteger id);

    void eliminar(BigInteger id);
}

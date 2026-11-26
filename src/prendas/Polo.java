/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prendas;

import inventario.Tela;

/**
 *
 * @author Lenovo
 */
public class Polo extends Prenda {

    public Polo(String codigo, String nombre, Tela telaPrincipal, double consumoS, double consumoM, double consumoL, double consumoXL, int tiempoConfeccion, double costoCostura, double precioVenta) {
        super(codigo, nombre, telaPrincipal, consumoS, consumoM, consumoL, consumoXL, tiempoConfeccion, costoCostura, precioVenta);
    }

    @Override
    public double calcularCostoProduccion(String talla) {
        return calcularCostoBase(talla);
    }

    @Override
    public String getTipo() {
        return "Polo";
    }
    
}

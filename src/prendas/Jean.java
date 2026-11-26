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
public class Jean extends Prenda {
    private double costoLavado;

    public Jean(double costoLavado, String codigo, String nombre, Tela telaPrincipal, double consumoS, double consumoM, double consumoL, double consumoXL, int tiempoConfeccion, double costoCostura, double precioVenta) {
        super(codigo, nombre, telaPrincipal, consumoS, consumoM, consumoL, consumoXL, tiempoConfeccion, costoCostura, precioVenta);
        this.costoLavado = costoLavado;
    }

    @Override
    public double calcularCostoProduccion(String talla) {
        return calcularCostoBase(talla)+ costoLavado;
    }

    @Override
    public String getTipo() {
        return "Jean";
    }

    public double getCostoLavado() {
        return costoLavado;
    }

    public void setCostoLavado(double costoLavado) {
        this.costoLavado = costoLavado;
    }
    
}

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
public class Casaca extends Prenda {
    private double costoForro;
    private double costoAvios;

    public Casaca(double costoForro, double costoAvios, String codigo, String nombre, Tela telaPrincipal, double consumoS, double consumoM, double consumoL, double consumoXL, int tiempoConfeccion, double costoCostura, double precioVenta) {
        super(codigo, nombre, telaPrincipal, consumoS, consumoM, consumoL, consumoXL, tiempoConfeccion, costoCostura, precioVenta);
        this.costoForro = costoForro;
        this.costoAvios = costoAvios;
    }



    @Override
    public double calcularCostoProduccion(String talla) {
        return calcularCostoBase(talla) + costoForro + costoAvios;
    }

    @Override
    public String getTipo() {
        return "Casaca";
    }

    public double getCostoForro() {
        return costoForro;
    }

    public void setCostoForro(double costoForro) {
        this.costoForro = costoForro;
    }

    public double getCostoAvios() {
        return costoAvios;
    }

    public void setCostoAvios(double costoAvios) {
        this.costoAvios = costoAvios;
    }
}

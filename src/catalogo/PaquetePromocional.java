/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package catalogo;

import prendas.Prenda;

/**
 *
 * @author Lenovo
 */
public class PaquetePromocional implements ItemVendible {
    private String codigo;
    private String nombre;
    private double precioPromocional;
    private Prenda[] prendas;
    private int contadorPrendas;
    private ServicioAcabado[] servicios;
    private int contadorServicios;

    public PaquetePromocional(String codigo, String nombre, double precioPromocional) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioPromocional = precioPromocional;
        this.prendas = new Prenda[10];
        this.contadorPrendas = 0;
        this.servicios = new ServicioAcabado[10];
        this.contadorServicios = 0;
    }

    public String agregarPrenda(Prenda p) {
        if (p == null) {
            return "La prenda no existe.";
        }
        if (!p.isActiva()) {
            return "La prenda " + p.getCodigo() + " está descontinuada.";
        }
        if (contadorPrendas >= prendas.length) {
            return "El paquete ya no admite más prendas.";
        }
        prendas[contadorPrendas] = p;
        contadorPrendas++;
        return "OK";
    }    
    
    public String agregarServicio(ServicioAcabado s) {
        if (s == null) {
            return "El servicio no existe.";
        }
        if (contadorServicios >= servicios.length) {
            return "El paquete ya no admite más servicios.";
        }
        servicios[contadorServicios] = s;
        contadorServicios++;
        return "OK";
    }
    
    public double calcularPrecioSinPromocion() {
        double total = 0;
        for (int i = 0; i < contadorPrendas; i++) {
            total = total + prendas[i].getPrecioVenta();
        }
        for (int i = 0; i < contadorServicios; i++) {
            total = total + servicios[i].getPrecioPorPrenda();
        }
        return total;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecioUnitario() {
        return precioPromocional;
    }
    
    public int getCantidadPrendas() { 
        return contadorPrendas; 
    }
    public Prenda getPrenda(int i) { 
        return prendas[i]; 
    }
    public int getCantidadServicios() { 
        return contadorServicios; 
    }
    public ServicioAcabado getServicio(int i) { 
        return servicios[i]; 
    }

    public double getPrecioPromocional() {
        return precioPromocional;
    }

    public void setPrecioPromocional(double precioPromocional) {
        this.precioPromocional = precioPromocional;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getInformacion() {
    return "Paquete " + codigo + ": " + nombre
           + ", precio promocional: S/. " + precioPromocional
           + ", " + contadorPrendas + " prendas y " + contadorServicios + " servicios";
    }
}

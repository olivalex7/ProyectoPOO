/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prendas;

import catalogo.ItemVendible;
import inventario.ConsumoInsumo;
import inventario.Tela;

/**
 *
 * @author Lenovo
 */
public abstract class Prenda implements ItemVendible {
    protected String codigo;
    protected String nombre;
    protected Tela telaPrincipal;
    protected double consumoS;
    protected double consumoM;
    protected double consumoL;
    protected double consumoXL;
    protected ConsumoInsumo[] insumos;
    protected int contadorInsumos;
    protected int tiempoConfeccion;
    protected double costoCostura;
    protected double precioVenta;
    protected String estado;

    public Prenda(String codigo, String nombre, Tela telaPrincipal, double consumoS, double consumoM,
              double consumoL, double consumoXL, int tiempoConfeccion,
              double costoCostura, double precioVenta) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.telaPrincipal = telaPrincipal;
    this.consumoS = consumoS;
    this.consumoM = consumoM;
    this.consumoL = consumoL;
    this.consumoXL = consumoXL;
    this.tiempoConfeccion = tiempoConfeccion;
    this.costoCostura = costoCostura;
    this.precioVenta = precioVenta;
    this.estado = "Activo";
    this.insumos = new ConsumoInsumo[10];
    this.contadorInsumos = 0;
    }
    
    public abstract double calcularCostoProduccion(String talla);
    public abstract String getTipo();
    
    public double getConsumoPorTalla(String talla) {
        switch (talla.toUpperCase()) {
            case "S":  return consumoS;
            case "M":  return consumoM;
            case "L":  return consumoL;
            case "XL": return consumoXL;
            default:   return 0.0;
        }
    }    
    
    protected double calcularCostoBase(String talla) {
        return getConsumoPorTalla(talla) * telaPrincipal.getCostoPorMetro() + costoCostura;
    }
    
    public String agregarInsumo(ConsumoInsumo ci) {
        if (contadorInsumos >= insumos.length) {
            return "No se pueden agregar más insumos.";
        }
        insumos[contadorInsumos] = ci;
        contadorInsumos++;
        return "OK";
    }
    
    public boolean isActiva() {
        return estado.equalsIgnoreCase("Activo");
    }
    
    public String getInformacion() {
        return "[" + getTipo() + "] " + codigo + " - " + nombre
               + ", tela: " + telaPrincipal.getDescripcion()
               + ", precio: S/. " + precioVenta + ", estado: " + estado;
    }
    
    
    @Override
    public String getCodigo() { return codigo; }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public double getPrecioUnitario() { return precioVenta; }    

    public int getCantidadInsumos() {
    return contadorInsumos;
    }

    public ConsumoInsumo getInsumo(int i) {
    return insumos[i];
    }
    
    
    
    public Tela getTelaPrincipal() {
        return telaPrincipal;
    }

    public void setTelaPrincipal(Tela telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    public double getConsumoS() {
        return consumoS;
    }

    public void setConsumoS(double consumoS) {
        this.consumoS = consumoS;
    }

    public double getConsumoM() {
        return consumoM;
    }

    public void setConsumoM(double consumoM) {
        this.consumoM = consumoM;
    }

    public double getConsumoL() {
        return consumoL;
    }

    public void setConsumoL(double consumoL) {
        this.consumoL = consumoL;
    }

    public double getConsumoXL() {
        return consumoXL;
    }

    public void setConsumoXL(double consumoXL) {
        this.consumoXL = consumoXL;
    }

    public int getTiempoConfeccion() {
        return tiempoConfeccion;
    }

    public void setTiempoConfeccion(int tiempoConfeccion) {
        this.tiempoConfeccion = tiempoConfeccion;
    }

    public double getCostoCostura() {
        return costoCostura;
    }

    public void setCostoCostura(double costoCostura) {
        this.costoCostura = costoCostura;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

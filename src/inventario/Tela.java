/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

/**
 *
 * @author Lenovo
 */
public class Tela {
    private String codigo;
    private String tipo;
    private String color;
    private double metrosStock;
    private double costoPorMetro;

    public Tela(String codigo, String tipo, String color, double metrosStock, double costoPorMetro) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.color = color;
        this.metrosStock = metrosStock;
        this.costoPorMetro = costoPorMetro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMetrosStock() {
        return metrosStock;
    }

    public void setMetrosStock(double metrosStock) {
        this.metrosStock = metrosStock;
    }

    public double getCostoPorMetro() {
        return costoPorMetro;
    }

    public void setCostoPorMetro(double costoPorMetro) {
        this.costoPorMetro = costoPorMetro;
    }
    
    public boolean descontar(double metros){
        if (metros > metrosStock) {
            return false;
        }
        metrosStock = metrosStock - metros;
        return true;
    }
    public String getDescripcion(){
        return tipo + " color " + color;
    }
    
    public String getInformacion(){
        return "Tela " + codigo + ":" + getDescripcion() + ", stock: " + metrosStock 
               + "m, costo/m: S/. " + costoPorMetro;
    }
    
    
}

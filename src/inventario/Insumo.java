/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

/**
 *
 * @author Lenovo
 */
public class Insumo {
    private String codigo;
    private String nombre;
    private int stock;
    private int stockMinimo;

    public Insumo(String codigo, String nombre, int stock, int stockMinimo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    
    
    public boolean estaBajoMinimo(){
        return stock < stockMinimo;
    }
    
    public boolean descontar(int cantidad){
        if (cantidad > stock){
            return false;   
        }
        stock = stock - cantidad;
        return true;
    }
    
    public String getInformacion() {
        return "Insumo " + codigo + ": " + nombre + ", stock: " + stock
               + " (mínimo " + stockMinimo + ")";
    }    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

/**
 *
 * @author Lenovo
 */
public class ConsumoInsumo {
    private Insumo insumo;
    private int cantidadPorPrenda;

    public ConsumoInsumo(Insumo insumo, int cantidadPorPrenda) {
        this.insumo = insumo;
        this.cantidadPorPrenda = cantidadPorPrenda;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public int getCantidadPorPrenda() {
        return cantidadPorPrenda;
    }

    public void setCantidadPorPrenda(int cantidadPorPrenda) {
        this.cantidadPorPrenda = cantidadPorPrenda;
    }
    
    public int calcularNecesario(int cantidadPrendas){
        return cantidadPorPrenda * cantidadPrendas;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package catalogo;

/**
 *
 * @author Lenovo
 */
public class ServicioAcabado implements ItemVendible {
    private String codigo;
    private String nombre;
    private double precioPorPrenda;
    private boolean incluyeLogo;

    public ServicioAcabado(String codigo, String nombre, double precioPorPrenda, boolean incluyeLogo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioPorPrenda = precioPorPrenda;
        this.incluyeLogo = incluyeLogo;
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
        return precioPorPrenda;
    }
    
    public String getInformacion(){
        return "Servicio " +codigo+ ": " +nombre+ ", S/. " + precioPorPrenda + " por prenda" + (incluyeLogo ? " (con logo)" : "");
    }

    public double getPrecioPorPrenda() {
        return precioPorPrenda;
    }

    public void setPrecioPorPrenda(double precioPorPrenda) {
        this.precioPorPrenda = precioPorPrenda;
    }

    public boolean isIncluyeLogo() {
        return incluyeLogo;
    }

    public void setIncluyeLogo(boolean incluyeLogo) {
        this.incluyeLogo = incluyeLogo;
    }
    
    public void setCodigo(String codigo) {
    this.codigo = codigo;
    }

    public void setNombre(String nombre) {
    this.nombre = nombre;
    }    
    
    
}

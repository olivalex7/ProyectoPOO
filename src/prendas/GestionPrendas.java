/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prendas;

/**
 *
 * @author Lenovo
 */
public class GestionPrendas {
    private Prenda[] prendas;
    private int contador;
    
    public GestionPrendas(){
        prendas = new Prenda[100];
        contador = 0;
    }
    
    public String agregar(Prenda p){
        if (contador >= prendas.length){
            return "No hay espacio para más modelos.";
        }
        if (p.getCodigo().trim().isEmpty()){
            return "El codigo es obligatorio.";
        }
        if (p.getNombre().trim().isEmpty()){
            return "El nombre es obligatorio.";
        }
        if (p.getTelaPrincipal() == null){
            return "Debe elegir una tela principal registrada.";
        }
        if (p.getPrecioVenta() <= 0){
            return "El precio de venta debe ser mayor a 0.";
        }
        if (buscar(p.getCodigo()) != null){
            return "Ya existe un modelo con el codigo "  + p.getCodigo() + ".";
        }
        prendas[contador] = p;
        contador = contador + 1;
        return "OK";
    }
    
    public String modificar(String codigo, String nombre, int tiempoConfeccion,
                            double costoCostura, double precioVenta, String estado) {
        Prenda p = buscar(codigo);
        if (p == null) {
            return "No existe un modelo con el código " + codigo + ".";
        }
        if (nombre.trim().isEmpty()) {
            return "El nombre es obligatorio.";
        }
        if (precioVenta <= 0) {
            return "El precio de venta debe ser mayor a 0.";
        }
        if (!estado.equalsIgnoreCase("Activo") && !estado.equalsIgnoreCase("Descontinuado")) {
            return "El estado debe ser Activo o Descontinuado.";
        }
        p.setNombre(nombre);
        p.setTiempoConfeccion(tiempoConfeccion);
        p.setCostoCostura(costoCostura);
        p.setPrecioVenta(precioVenta);
        p.setEstado(estado);
        return "OK";
    }
    
    public String eliminar(String codigo) {
        int pos = buscarPosicion(codigo);
        if (pos == -1) {
            return "No existe un modelo con el código " + codigo + ".";
        }
        for (int i = pos; i < contador - 1; i++) {
            prendas[i] = prendas[i + 1];      // corre cada una a la izquierda
        }
        prendas[contador - 1] = null;
        contador--;
        return "OK";
    }    
    
    public Prenda buscar(String codigo) {
        int pos = buscarPosicion(codigo);
        if (pos == -1) {
            return null;
        }
        return prendas[pos];
    }    
    
    public Prenda buscarActiva(String codigo) {
        Prenda p = buscar(codigo);
        if (p != null && p.isActiva()) {
            return p;
        }
        return null;
    }
    
    private int buscarPosicion(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (prendas[i].getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }
    
    public int getCantidad() { 
        return contador; 
    }
    public Prenda getPrenda(int i) { 
        return prendas[i]; 
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

/**
 *
 * @author Lenovo
 */
public class GestionTelas {
    private Tela[] telas;
    private int contador;
    
    public GestionTelas(){
        telas = new Tela[100];
        contador = 0;
    }
    
    public String agregar(Tela t){
        if (contador >= telas.length){
            return "No hay espacio para más telas.";
        }
        if (t.getCodigo().trim().isEmpty()){
            return "El codigo es obligatorio";
        }
        if (t.getCostoPorMetro() <= 0){
            return "El costo por metro debe ser mayor a 0.";
        }
        if (buscar(t.getCodigo()) != null){
            return "Ya existe una tela con el codigo " + t.getCodigo() + ".";
        }
        telas[contador] = t;
        contador = contador + 1;
        return "OK";
    }
    
    public String modificar(String codigo, String tipo, String color, double metrosStock, double costoPorMetro) {
        Tela t = buscar(codigo);
        if (t == null) {
            return "No existe una tela con el código " + codigo + ".";
        }
        if (costoPorMetro <= 0) {
            return "El costo por metro debe ser mayor a 0.";
        }
        t.setTipo(tipo);
        t.setColor(color);
        t.setMetrosStock(metrosStock);
        t.setCostoPorMetro(costoPorMetro);
        return "OK";
    }
    
    
    public String eliminar(String codigo) {
        int pos = buscarPosicion(codigo);
        if (pos == -1) {
            return "No existe una tela con el código " + codigo + ".";
        }
        for (int i = pos; i < contador - 1; i++) {
            telas[i] = telas[i + 1];      // corre cada una a la izquierda
        }
        telas[contador - 1] = null;
        contador--;
        return "OK";
    }

    public Tela buscar(String codigo) {
        int pos = buscarPosicion(codigo);
        if (pos == -1) {
            return null;
        }
        return telas[pos];
    }

    public Tela buscarPorTipoYColor(String tipo, String color) {
        for (int i = 0; i < contador; i++) {
            if (telas[i].getTipo().equalsIgnoreCase(tipo) && telas[i].getColor().equalsIgnoreCase(color)) {
                return telas[i];
            }
        }
        return null;
    }
    
    private int buscarPosicion(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (telas[i].getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }
    
    public int getCantidad() { return contador; }
    public Tela getTela(int i) { return telas[i]; }
    
}

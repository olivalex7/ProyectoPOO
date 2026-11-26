/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package catalogo;

/**
 *
 * @author Lenovo
 */
public class GestionPaquetes {
    private PaquetePromocional[] paquetes;
    private int contador;

    public GestionPaquetes() {
        paquetes = new PaquetePromocional[50];
        contador = 0;
    }

    public String agregar(PaquetePromocional p) {
        if (contador >= paquetes.length) {
            return "No hay espacio para más paquetes.";
        }
        if (p.getCodigo().trim().isEmpty() || p.getNombre().trim().isEmpty()) {
            return "Código y nombre son obligatorios.";
        }
        if (p.getPrecioPromocional() <= 0) {
            return "El precio promocional debe ser mayor a 0.";
        }
        if (p.getCantidadPrendas() == 0) {
            return "El paquete debe incluir al menos una prenda.";
        }
        if (buscar(p.getCodigo()) != null) {
            return "Ya existe un paquete con el código " + p.getCodigo() + ".";
        }
        paquetes[contador] = p;
        contador = contador + 1;
        return "OK";
    }

    public String modificar(String codigo, String nombre, double precioPromocional) {
        PaquetePromocional p = buscar(codigo);
        if (p == null) {
            return "No existe un paquete con el código " + codigo + ".";
        }
        if (nombre.trim().isEmpty()) {
            return "El nombre es obligatorio.";
        }
        if (precioPromocional <= 0) {
            return "El precio promocional debe ser mayor a 0.";
        }
        p.setNombre(nombre);
        p.setPrecioPromocional(precioPromocional);
        return "OK";
    }

    public String eliminar(String codigo) {
        int pos = buscarPosicion(codigo);
        if (pos == -1) {
            return "No existe un paquete con el código " + codigo + ".";
        }
        for (int i = pos; i < contador - 1; i++) {
            paquetes[i] = paquetes[i + 1];
        }
        paquetes[contador - 1] = null;
        contador--;
        return "OK";
    }

    public PaquetePromocional buscar(String codigo) {
        int pos = buscarPosicion(codigo);
        if (pos == -1) {
            return null;
        }
        return paquetes[pos];
    }

    private int buscarPosicion(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (paquetes[i].getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }

    public int getCantidad() { return contador; }
    public PaquetePromocional getPaquete(int i) { return paquetes[i]; }
}

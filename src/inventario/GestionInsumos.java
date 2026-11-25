/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

/**
 *
 * @author Lenovo
 */
public class GestionInsumos {
    private Insumo[] insumos;
    private int contador;

    public GestionInsumos() {
        insumos = new Insumo[100];
        contador = 0;
    }

    public String agregar(Insumo in) {
        if (contador >= insumos.length) {
            return "No hay espacio para más insumos.";
        }
        if (in.getCodigo().trim().isEmpty()) {
            return "El código es obligatorio.";
        }
        if (in.getNombre().trim().isEmpty()) {
            return "El nombre es obligatorio.";
        }
        if (in.getStock() < 0 || in.getStockMinimo() < 0) {
            return "El stock y el stock mínimo no pueden ser negativos.";
        }
        if (buscar(in.getCodigo()) != null) {
            return "Ya existe un insumo con el código " + in.getCodigo() + ".";
        }
        insumos[contador] = in;
        contador = contador + 1;
        return "OK";
    }

    public String modificar(String codigo, String nombre, int stock, int stockMinimo) {
        Insumo in = buscar(codigo);
        if (in == null) {
            return "No existe un insumo con el código " + codigo + ".";
        }
        if (nombre.trim().isEmpty()) {
            return "El nombre es obligatorio.";
        }
        if (stock < 0 || stockMinimo < 0) {
            return "El stock y el stock mínimo no pueden ser negativos.";
        }
        in.setNombre(nombre);
        in.setStock(stock);
        in.setStockMinimo(stockMinimo);
        return "OK";
    }

    public String eliminar(String codigo) {
        int pos = buscarPosicion(codigo);
        if (pos == -1) {
            return "No existe un insumo con el código " + codigo + ".";
        }
        for (int i = pos; i < contador - 1; i++) {
            insumos[i] = insumos[i + 1];      
        }
        insumos[contador - 1] = null;
        contador--;
        return "OK";
    }

    public Insumo buscar(String codigo) {
        int pos = buscarPosicion(codigo);
        if (pos == -1) {
            return null;
        }
        return insumos[pos];
    }

    public int contarBajoMinimo() {
        int c = 0;
        for (int i = 0; i < contador; i++) {
            if (insumos[i].estaBajoMinimo()) {
                c++;
            }
        }
        return c;
    }

    private int buscarPosicion(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (insumos[i].getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }

    public int getCantidad() { return contador; }
    public Insumo getInsumo(int i) { return insumos[i]; }
}

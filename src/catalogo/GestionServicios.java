/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package catalogo;

/**
 *
 * @author Lenovo
 */
public class GestionServicios {
    private ServicioAcabado[] servicios;
    private int contador;

    public GestionServicios() {
        servicios = new ServicioAcabado[50];
        contador = 0;
    }

    public String agregar(ServicioAcabado s) {
        if (contador >= servicios.length) {
            return "No hay espacio para más servicios.";
        }
        if (s.getCodigo().trim().isEmpty() || s.getNombre().trim().isEmpty()) {
            return "Código y nombre son obligatorios.";
        }
        if (s.getPrecioPorPrenda() <= 0) {
            return "El precio por prenda debe ser mayor a 0.";
        }
        if (buscar(s.getCodigo()) != null) {
            return "Ya existe un servicio con el código " + s.getCodigo() + ".";
        }
        servicios[contador] = s;
        contador = contador + 1;
        return "OK";
    }

    public String modificar(String codigo, String nombre, double precioPorPrenda, boolean incluyeLogo) {
        ServicioAcabado s = buscar(codigo);
        if (s == null) {
            return "No existe un servicio con el código " + codigo + ".";
        }
        if (nombre.trim().isEmpty()) {
            return "El nombre es obligatorio.";
        }
        if (precioPorPrenda <= 0) {
            return "El precio por prenda debe ser mayor a 0.";
        }
        s.setNombre(nombre);
        s.setPrecioPorPrenda(precioPorPrenda);
        s.setIncluyeLogo(incluyeLogo);
        return "OK";
    }

    public String eliminar(String codigo) {
        int pos = buscarPosicion(codigo);
        if (pos == -1) {
            return "No existe un servicio con el código " + codigo + ".";
        }
        for (int i = pos; i < contador - 1; i++) {
            servicios[i] = servicios[i + 1];
        }
        servicios[contador - 1] = null;
        contador--;
        return "OK";
    }

    public ServicioAcabado buscar(String codigo) {
        int pos = buscarPosicion(codigo);
        if (pos == -1) {
            return null;
        }
        return servicios[pos];
    }

    private int buscarPosicion(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (servicios[i].getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }

    public int getCantidad() { 
        return contador; 
    }
    public ServicioAcabado getServicio(int i) { 
        return servicios[i]; 
    }   
    
}

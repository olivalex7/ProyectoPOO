/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRUEBAQUEBORRARE;

import catalogo.GestionPaquetes;
import catalogo.GestionServicios;
import catalogo.ItemVendible;
import catalogo.PaquetePromocional;
import catalogo.ServicioAcabado;
import inventario.ConsumoInsumo;
import inventario.GestionInsumos;
import inventario.GestionTelas;
import inventario.Insumo;
import inventario.Tela;
import prendas.Casaca;
import prendas.GestionPrendas;
import prendas.Jean;
import prendas.Polo;
import prendas.Prenda;

/**
 *
 * @author Lenovo
 */
public class PruebaVerde {
    public static void main(String[] args) {

        imprimir("========== INVENTARIO: TELAS ==========");
        GestionTelas gt = new GestionTelas();
        imprimir("Agregar T01: " + gt.agregar(new Tela("T01", "Jersey Algodon Pima", "negro", 500, 12.00)));   // OK
        imprimir("Agregar T02: " + gt.agregar(new Tela("T02", "Denim", "azul", 300, 18.50)));                  // OK
        imprimir("Agregar T03: " + gt.agregar(new Tela("T03", "Drill", "gris", 200, 15.00)));                  // OK
        imprimir("Codigo repetido: " + gt.agregar(new Tela("T01", "Otra", "rojo", 10, 5)));                    // Ya existe...
        imprimir("Costo en 0: " + gt.agregar(new Tela("T04", "Lino", "blanco", 10, 0)));                       // debe ser mayor a 0
        for (int i = 0; i < gt.getCantidad(); i++) {
            imprimir("  " + gt.getTela(i).getInformacion());
        }
        Tela denim = gt.buscarPorTipoYColor("denim", "AZUL");
        imprimir("Buscar Denim azul: " + (denim != null ? denim.getMetrosStock() + " m" : "no existe"));   // 300.0 m
        imprimir("Descontar 50 m de T02: " + gt.buscar("T02").descontar(50) + " -> quedan "
                 + gt.buscar("T02").getMetrosStock());                                                     // true -> 250.0
        imprimir("Descontar 999 m de T02: " + gt.buscar("T02").descontar(999));                           // false

        imprimir("\n========== INVENTARIO: INSUMOS ==========");
        GestionInsumos gi = new GestionInsumos();
        imprimir("Agregar I01: " + gi.agregar(new Insumo("I01", "Botones", 2000, 500)));
        imprimir("Agregar I02: " + gi.agregar(new Insumo("I02", "Cierres", 80, 100)));
        imprimir("Agregar I03: " + gi.agregar(new Insumo("I03", "Etiquetas", 1000, 200)));
        imprimir("Stock negativo: " + gi.agregar(new Insumo("I04", "Hilos", -5, 10)));                    // no pueden ser negativos
        for (int i = 0; i < gi.getCantidad(); i++) {
            imprimir("  " + gi.getInsumo(i).getInformacion());
        }
        imprimir("Insumos bajo el minimo: " + gi.contarBajoMinimo());                                      // 1 (cierres)

        imprimir("\n========== PRENDAS (POLIMORFISMO) ==========");
        GestionPrendas gp = new GestionPrendas();
        imprimir("Polo: " + gp.agregar(new Polo("P01", "Polo Basico", gt.buscar("T01"),
                0.9, 1.0, 1.1, 1.2, 20, 4.50, 35.00)));
        imprimir("Jean: " + gp.agregar(new Jean(6.00, "J01", "Jean Clasico", gt.buscar("T02"),
                1.3, 1.5, 1.6, 1.8, 45, 9.00, 89.90)));
        imprimir("Casaca: " + gp.agregar(new Casaca(10.00, 7.50, "C01", "Casaca Drill", gt.buscar("T03"),
                1.8, 2.0, 2.2, 2.4, 90, 12.00, 129.90)));
        imprimir("Tela inexistente: " + gp.agregar(new Polo("P02", "Polo X", gt.buscar("T99"),
                1, 1, 1, 1, 20, 4, 30)));                                                                  // Debe elegir una tela...

        for (int i = 0; i < gp.getCantidad(); i++) {
            Prenda p = gp.getPrenda(i);
            imprimir("  " + p.getInformacion());
            imprimir("     costo talla M: S/. " + String.format("%.2f", p.calcularCostoProduccion("M")));
        }
        // Esperado talla M: Polo 16.50 | Jean 42.75 | Casaca 59.50
        imprimir("Costo Jean talla XL: S/. "
                 + String.format("%.2f", gp.buscar("J01").calcularCostoProduccion("XL")));                 // 48.30

        Prenda jean = gp.buscar("J01");
        jean.agregarInsumo(new ConsumoInsumo(gi.buscar("I02"), 1));   // 1 cierre por jean
        jean.agregarInsumo(new ConsumoInsumo(gi.buscar("I01"), 1));   // 1 boton por jean
        imprimir("Insumos del jean para un pedido de 250:");
        for (int i = 0; i < jean.getCantidadInsumos(); i++) {
            ConsumoInsumo ci = jean.getInsumo(i);
            int necesario = ci.calcularNecesario(250);
            imprimir("  " + ci.getInsumo().getNombre() + ": necesita " + necesario
                     + ", hay " + ci.getInsumo().getStock()
                     + (necesario > ci.getInsumo().getStock() ? "  -> NO ALCANZA" : "  -> alcanza"));
        }   // Cierres: necesita 250, hay 80 -> NO ALCANZA | Botones: necesita 250, hay 2000 -> alcanza

        imprimir("Estado invalido: " + gp.modificar("P01", "Polo Basico", 20, 4.50, 35.00, "Agotado"));
        imprimir("Descontinuar P01: " + gp.modificar("P01", "Polo Basico", 20, 4.50, 35.00, "Descontinuado"));
        imprimir("buscarActiva(P01): " + (gp.buscarActiva("P01") != null ? "activa" : "null, esta descontinuada"));

        imprimir("\n========== CATALOGO ==========");
        GestionServicios gs = new GestionServicios();
        imprimir("Servicio S01: " + gs.agregar(new ServicioAcabado("S01", "Bordado de logo", 3.50, true)));
        imprimir("Servicio S02: " + gs.agregar(new ServicioAcabado("S02", "Empaque personalizado", 1.20, false)));
        for (int i = 0; i < gs.getCantidad(); i++) {
            imprimir("  " + gs.getServicio(i).getInformacion());
        }

        PaquetePromocional uniforme = new PaquetePromocional("K01", "Uniforme Escolar Completo", 110.00);
        imprimir("Agregar polo descontinuado: " + uniforme.agregarPrenda(gp.buscar("P01")));             // esta descontinuada
        gp.modificar("P01", "Polo Basico", 20, 4.50, 35.00, "Activo");
        imprimir("Agregar polo activo: " + uniforme.agregarPrenda(gp.buscar("P01")));                    // OK
        imprimir("Agregar jean: " + uniforme.agregarPrenda(gp.buscar("J01")));                           // OK
        imprimir("Agregar bordado: " + uniforme.agregarServicio(gs.buscar("S01")));                     // OK

        GestionPaquetes gpaq = new GestionPaquetes();
        imprimir("Paquete vacio: " + gpaq.agregar(new PaquetePromocional("K02", "Vacio", 50)));          // al menos una prenda
        imprimir("Paquete K01: " + gpaq.agregar(uniforme));                                             // OK
        imprimir("  " + uniforme.getNombre() + ": " + uniforme.getCantidadPrendas() + " prendas, "
                 + uniforme.getCantidadServicios() + " servicio(s)");
        imprimir("  Por separado: S/. " + String.format("%.2f", uniforme.calcularPrecioSinPromocion())   // 128.40
                 + " | Promocion: S/. " + String.format("%.2f", uniforme.getPrecioUnitario()));          // 110.00

        imprimir("\n========== INTERFAZ ItemVendible (POLIMORFISMO) ==========");
        ItemVendible[] items = { gp.buscar("C01"), gs.buscar("S02"), gpaq.buscar("K01") };
        for (ItemVendible item : items) {
            imprimir("  " + item.getCodigo() + " - " + item.getNombre() + ": S/. "
                     + String.format("%.2f", item.getPrecioUnitario()));
        }   // C01 129.90 | S02 1.20 | K01 110.00

        imprimir("\n========== ELIMINAR ==========");
        imprimir("Eliminar T02: " + gt.eliminar("T02") + " -> quedan " + gt.getCantidad() + " telas");    // OK -> 2
        imprimir("Eliminar T99: " + gt.eliminar("T99"));                                                 // No existe...
        for (int i = 0; i < gt.getCantidad(); i++) {
            imprimir("  " + gt.getTela(i).getCodigo());                                                   // T01, T03
        }
    }

    public static void imprimir(String cadena) {
        System.out.println(cadena);
    }
}    


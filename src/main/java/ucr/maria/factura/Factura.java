/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ucr.maria.factura;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author maria
 */

public class Factura {

    
    private ArrayList<String> facturasIngresos = new ArrayList<>();
    private ArrayList<String> facturasGastos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    public void mostrarMenu() {
        int opcion;
        
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Ingresar las facturas por servicios profesionales.");
            System.out.println("2. Ingresar gastos.");
            System.out.println("3. Listado de ingresos.");
            System.out.println("4. Listado de gastos.");
            System.out.println("5. Cálculo del impuesto de renta.");
            System.out.println("6. Salir.");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    ingresarFacturaIngreso();
                    break;
                case 2:
                    ingresarFacturaGasto();
                    break;
                case 3:
                    listarIngresos();
                    break;
                case 4:
                    listarGastos();
                    break;
                case 5:
                    calcularImpuesto();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 6);
    }
    
    public void ingresarFacturaIngreso() {
        System.out.print("Ingrese número de factura: ");
        String numero = scanner.nextLine();
        System.out.print("Ingrese fecha de factura: ");
        String fecha = scanner.nextLine();
        System.out.print("Ingrese monto cobrado: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();  // Limpiar buffer
        
        String factura = "Factura Nº: " + numero + ", Fecha: " + fecha + ", Monto: " + monto;
        facturasIngresos.add(factura);
        System.out.println("Factura de ingreso registrada.");
    }
    
    public void ingresarFacturaGasto() {
        System.out.print("Ingrese número de factura: ");
        String numero = scanner.nextLine();
        System.out.print("Ingrese fecha de factura: ");
        String fecha = scanner.nextLine();
        System.out.print("Ingrese monto pagado: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();  // Limpiar buffer
        
        String factura = "Factura Nº: " + numero + ", Fecha: " + fecha + ", Monto: " + monto;
        facturasGastos.add(factura);
        System.out.println("Factura de gasto registrada.");
    }
    
    public void listarIngresos() {
        System.out.println("\nListado de Ingresos:");
        if (facturasIngresos.isEmpty()) {
            System.out.println("No hay ingresos registrados.");
        } else {
            for (String ingreso : facturasIngresos) {
                System.out.println(ingreso);
            }
        }
    }
    
    public void listarGastos() {
        System.out.println("\nListado de Gastos:");
        if (facturasGastos.isEmpty()) {
            System.out.println("No hay gastos registrados.");
        } else {
            for (String gasto : facturasGastos) {
                System.out.println(gasto);
            }
        }
    }
    
    public void calcularImpuesto() {
        double totalIngresos = 0;
        double totalGastos = 0;
        
        for (String ingreso : facturasIngresos) {
            String[] partes = ingreso.split(", ");
            String montoTexto = partes[2].split(": ")[1];
            totalIngresos += Double.parseDouble(montoTexto);
        }
        
        for (String gasto : facturasGastos) {
            String[] partes = gasto.split(", ");
            String montoTexto = partes[2].split(": ")[1];
            totalGastos += Double.parseDouble(montoTexto);
        }
        
        double utilidades = totalIngresos - totalGastos;
        double impuesto = calcularImpuestoPorUtilidades(utilidades);
        
        System.out.println("\nTotal de Ingresos: " + totalIngresos);
        System.out.println("Total de Gastos: " + totalGastos);
        System.out.println("Utilidades: " + utilidades);
        System.out.println("Impuesto sobre la renta: " + impuesto);
    }
    
    private double calcularImpuestoPorUtilidades(double utilidades) {
        if (utilidades <= 0) {
            return 0;
        }
        return utilidades * 0.15;  // 15% sobre las utilidades
    }

    public static void main(String[] args) {
        Factura sistema = new Factura();
        sistema.mostrarMenu();
    }
}


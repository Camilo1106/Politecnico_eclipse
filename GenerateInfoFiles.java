package proyecto_vendedor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {

    private static final String[] nombres = { "Juan", "María", "Pedro", "Ana", "Luisa", "Carlos", "Laura", "Andrés", "Sofía", "Javier", "Elena", "Marta", "Diego", "Claudia", "Alejandro", "Patricia" };
    private static final String[] apellidos = { "Gómez", "López", "Martínez", "González", "Rodríguez", "Fernández", "Pérez", "Sánchez", "Ramírez", "Torres", "Flores", "Vargas", "Jiménez", "Díaz", "Moreno", "Ruiz" };

    public static void main(String[] args) {
        createSalesMenFile(10);
        createProductsFile(10);
    }

    public static void createSalesMenFile(int count) {
        String filePath = "salesmen.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                String tipoDocumento = "CC";
                long numeroDocumento = 1000000000 + random.nextInt(900000000);
                String nombresVendedor = nombres[random.nextInt(nombres.length)];
                String apellidosVendedor = apellidos[random.nextInt(apellidos.length)];
                writer.write(tipoDocumento + ";" + numeroDocumento + ";" + nombresVendedor + ";" + apellidosVendedor);
                writer.newLine();
                System.out.println("Vendedor creado: " + tipoDocumento + ";" + numeroDocumento + ";" + nombresVendedor + ";" + apellidosVendedor);
            }
            System.out.println("Archivo de vendedores creado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de vendedores: " + e.getMessage());
        }
    }

    public static void createProductsFile(int count) {
        String filePath = "products.txt";
        String[] nombresProductos = { "Arroz", "Papa", "Cebolla", "Zanahoria", "Lechuga", "Tomate", "Plátano", "Manzana", "Banano", "Aguacate" };
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int id = i + 1;
                String nombre = nombresProductos[random.nextInt(nombresProductos.length)];
                int precio = random.nextInt(91);
                writer.write(id + ";" + nombre + ";" + precio + " USD");
                writer.newLine();
                System.out.println("Producto creado: " + id + ";" + nombre + ";" + precio + " USD");
            }
            System.out.println("Archivo de productos creado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de productos: " + e.getMessage());
        }
    }

    public static void createSalesManInfoFile(int salesmanCount) {
        String filePath = "salesman_info.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();
            for (int i = 0; i < salesmanCount; i++) {
                String tipoDocumento = "CC";
                long numeroDocumento = 1000000000 + random.nextInt(900000000);
                String nombresVendedor = nombres[random.nextInt(nombres.length)];
                String apellidosVendedor = apellidos[random.nextInt(apellidos.length)];
                writer.write(tipoDocumento + ";" + numeroDocumento + ";" + nombresVendedor + ";" + apellidosVendedor);
                writer.newLine();
                System.out.println("Información de vendedor creada: " + tipoDocumento + ";" + numeroDocumento + ";" + nombresVendedor + ";" + apellidosVendedor);
            }
            System.out.println("Archivo de información de vendedores creado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de información de vendedores: " + e.getMessage());
        }
    }

    public static void createSalesFiles(int salesmanCount, int salesCount) {
        for (int i = 1; i <= salesmanCount; i++) {
            String fileName = "sales_" + i + ".txt";
            createSalesFile(fileName, salesCount);
        }
    }

    public static void createSalesFile(String fileName, int salesCount) {
        String filePath = fileName;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();
            for (int i = 0; i < salesCount; i++) {
                int idProducto = random.nextInt(10) + 1;
                int cantidadProducto = random.nextInt(10) + 1;
                writer.write(idProducto + ";" + cantidadProducto);
                writer.newLine();
                System.out.println("Venta creada: " + idProducto + ";" + cantidadProducto);
            }
            System.out.println("Archivo de ventas " + fileName + " creado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de ventas " + fileName + ": " + e.getMessage());
        }
    }

    public static void createTestFiles() {
        createSalesMenFile(5, "Juan", 123456789);
        createSalesMenFile(5, "María", 987654321);
        createSalesMenFile(5, "Pedro", 135792468);
        createProductsFile(5);
        createSalesManInfoFile(5);
        createSalesFiles(5, 5);
    }

}


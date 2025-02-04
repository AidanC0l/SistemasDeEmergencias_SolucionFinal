import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Emergencia;
import Model.Factory.EmergenciaFactory;
import Model.Singleton.GestionRecursos;


public class Main {
    private static List<Emergencia> emergencias = new ArrayList<>(); // Lista de emergencias
    private static GestionRecursos gestionRecursos = GestionRecursos.getInstancia(); // El jefe de recursos

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Para leer lo que el usuario escribe
        int opcion;

        do {
            // Menú de opciones
            System.out.println("\n--- Sistema de Gestión de Emergencias Urbanas ---");
            System.out.println("1. Registrar Emergencia");
            System.out.println("2. Ver Recursos Disponibles");
            System.out.println("3. Atender Emergencia");
            System.out.println("4. Mostrar Estadísticas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarEmergencia(scanner); // Registrar una emergencia
                    break;
                case 2:
                    gestionRecursos.mostrarRecursos(); // Ver recursos disponibles
                    break;
                case 3:
                    atenderEmergencia(scanner); // Atender una emergencia
                    break;
                case 4:
                    mostrarEstadisticas(); // Mostrar estadísticas
                    break;
                case 5:
                    System.out.println("Saliendo del sistema..."); // Salir del programa
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    // Método para registrar una emergencia
    private static void registrarEmergencia(Scanner scanner) {
        System.out.print("Ingrese el tipo de emergencia (Incendio, Accidente, Robo): ");
        String tipo = scanner.next();
        System.out.print("Ingrese la ubicación: ");
        String ubicacion = scanner.next();
        System.out.print("Ingrese el nivel de gravedad (1: Bajo, 2: Medio, 3: Alto): ");
        int gravedad = scanner.nextInt();

        // Creamos una emergencia usando la fábrica
        Emergencia emergencia = EmergenciaFactory.crearEmergencia(tipo, ubicacion, gravedad);
        emergencias.add(emergencia); // La agregamos a la lista de emergencias
        System.out.println("Emergencia registrada: " + emergencia);
    }

    // Método para atender una emergencia
    private static void atenderEmergencia(Scanner scanner) {
        if (emergencias.isEmpty()) {
            System.out.println("No hay emergencias registradas.");
            return;
        }

        // Mostramos las emergencias registradas
        System.out.println("Emergencias registradas:");
        for (int i = 0; i < emergencias.size(); i++) {
            System.out.println((i + 1) + ". " + emergencias.get(i));
        }

        System.out.print("Seleccione una emergencia para atender: ");
        int seleccion = scanner.nextInt() - 1;

        if (seleccion >= 0 && seleccion < emergencias.size()) {
            Emergencia emergencia = emergencias.get(seleccion);
            System.out.println("Atendiendo emergencia: " + emergencia);

            // Asignamos recursos según el tipo de emergencia
            switch (emergencia.getTipo()) {
                case "Incendio":
                    gestionRecursos.asignarBomberos(2); // Enviamos 2 bomberos
                    gestionRecursos.asignarAmbulancias(1); // Enviamos 1 ambulancia
                    break;
                case "Accidente":
                    gestionRecursos.asignarAmbulancias(2); // Enviamos 2 ambulancias
                    gestionRecursos.asignarPolicias(1); // Enviamos 1 policía
                    break;
                case "Robo":
                    gestionRecursos.asignarPolicias(3); // Enviamos 3 policías
                    break;
                default:
                    System.out.println("Tipo de emergencia no reconocido.");
            }

            emergencia.setTiempoRespuesta(30); // Simulamos que tardaron 30 minutos en llegar
            System.out.println("Emergencia atendida con éxito.");
        } else {
            System.out.println("Selección no válida.");
        }
    }

    // Método para mostrar estadísticas del día
    private static void mostrarEstadisticas() {
        System.out.println("Estadísticas del día:");
        System.out.println("Emergencias registradas: " + emergencias.size());
        int tiempoTotal = 0;
        for (Emergencia emergencia : emergencias) {
            tiempoTotal += emergencia.getTiempoRespuesta(); // Sumamos los tiempos de respuesta
        }
        double tiempoPromedio = emergencias.isEmpty() ? 0 : (double) tiempoTotal / emergencias.size();
        System.out.println("Tiempo promedio de respuesta: " + tiempoPromedio + " minutos");
    }

}


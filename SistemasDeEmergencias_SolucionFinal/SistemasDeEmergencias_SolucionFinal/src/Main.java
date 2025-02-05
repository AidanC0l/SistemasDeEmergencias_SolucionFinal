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
                    limpiar();
                    break;
                case 2:
                    gestionRecursos.mostrarRecursos(); // Ver recursos disponibles
                    limpiar();
                    break;
                case 3:
                    atenderEmergencia(scanner); // Atender una emergencia
                    limpiar();
                    break;
                case 4:
                    mostrarEstadisticas(); // Mostrar estadísticas
                    limpiar();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema..."); // Salir del programa
                    limpiar();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    // Método para registrar una emergencia
    private static void registrarEmergencia(Scanner scanner) {
        System.out.print("Ingrese el tipo de emergencia (Incendio, Accidente, Robo): ");
        String tipo = scanner.next().toLowerCase();
        scanner.nextLine();
        System.out.print("Ingrese la ubicación: ");
        String ubicacion = scanner.nextLine();
        System.out.print("Ingrese el nivel de gravedad (1: Bajo, 2: Medio, 3: Alto): ");
        int gravedad = scanner.nextInt();

        // Creamos una emergencia
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
        System.out.println("Emergencias registradas: ");
        for (int i = 0; i < emergencias.size(); i++) {
            System.out.println((i + 1) + ". " + emergencias.get(i));
        }

        System.out.print("Seleccione una emergencia para atender (número o nombre): ");
        String seleccion = scanner.next();

        Emergencia emergencia = null;

        // Verificamos si la selección es número
        if (seleccion.matches("\\d+")) { // Verifica si es un número
            int index = Integer.parseInt(seleccion) - 1; // Convertimos a número
            if (index >= 0 && index < emergencias.size()) {
                emergencia = emergencias.get(index);
            }
    
            // Si se seleccionó por número, usamos un switch
            if (emergencia != null) {
                System.out.println("Atendiendo emergencia: " + emergencia.getTipo());
    
                switch (index + 1) { // Usamos index + 1 para que coincida con la selección del usuario
                    case 1: // Para incendio
                        gestionRecursos.asignarBomberos(2); // Enviamos 2 bomberos
                        gestionRecursos.asignarAmbulancias(1); // Enviamos 1 ambulancia
                        break;
                    case 2: // Para accidente
                        gestionRecursos.asignarAmbulancias(2); // Enviamos 2 ambulancias
                        gestionRecursos.asignarPolicias(1); // Enviamos 1 policía
                        break;
                    case 3: // Para robo
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
        } else {
            // Si no es un número, buscamos por nombre
            for (Emergencia em : emergencias) {
                if (em.getTipo().equalsIgnoreCase(seleccion)) {
                    emergencia = em;
                    break;
                }
            }
    
            if (emergencia != null) {
                System.out.println("Atendiendo emergencia: " + emergencia.getTipo());
    
                // Usamos un switch para el tipo de emergencia
                switch (emergencia.getTipo().toLowerCase()) {
                    case "incendio":
                        gestionRecursos.asignarBomberos(2); // Enviamos 2 bomberos
                        gestionRecursos.asignarAmbulancias(1); // Enviamos 1 ambulancia
                        break;
                    case "accidente":
                        gestionRecursos.asignarAmbulancias(2); // Enviamos 2 ambulancias
                        gestionRecursos.asignarPolicias(1); // Enviamos 1 policía
                        break;
                    case "robo":
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

        /*if (seleccion >= 0 && seleccion < emergencias.size()) {
            Emergencia emergencia = emergencias.get(seleccion);
            System.out.println("Atendiendo emergencia: " + emergencia);

            // Asignamos recursos según el tipo de emergencia
            switch (emergencia.getTipo()) {
                case "incendio":
                    gestionRecursos.asignarBomberos(2); // Enviamos 2 bomberos
                    gestionRecursos.asignarAmbulancias(1); // Enviamos 1 ambulancia
                    break;
                case "accidente":
                    gestionRecursos.asignarAmbulancias(2); // Enviamos 2 ambulancias
                    gestionRecursos.asignarPolicias(1); // Enviamos 1 policía
                    break;
                case "robo":
                    gestionRecursos.asignarPolicias(3); // Enviamos 3 policías
                    break;
                default:
                    System.out.println("Tipo de emergencia no reconocido.");
            }

            emergencia.setTiempoRespuesta(30); // Simulamos que tardaron 30 minutos en llegar
            System.out.println("Emergencia atendida con éxito.");
        } else {
            System.out.println("Selección no válida.");
        }*/
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


    // Método para limpiar la pantalla
    public static void limpiar(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}


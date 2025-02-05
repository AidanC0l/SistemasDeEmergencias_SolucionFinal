package Model.Singleton;

// Patrón Singleton
public class GestionRecursos {
    private static GestionRecursos instancia; // La instancia unica
    private int bomberosDisponibles; // Cuántos bomberos hay disponibles
    private int ambulanciasDisponibles; // Cuántas ambulancias hay disponibles
    private int policiasDisponibles; // Cuántos policías hay disponibles

    // Constructor privado
    private GestionRecursos() {
        bomberosDisponibles = 10; // Empezamos con 10 bomberos
        ambulanciasDisponibles = 5; // Empezamos con 5 ambulancias
        policiasDisponibles = 20; // Empezamos con 20 policías
    }

    // Método para obtener ala instancia única
    public static GestionRecursos getInstancia() {
        if (instancia == null) {
            instancia = new GestionRecursos(); // creamos una
        }
        return instancia; // Devolvemos la instancia
    }

    // Método para asignar bomberos a una emergencia
    public void asignarBomberos(int cantidad) {
        if (cantidad <= bomberosDisponibles) {
            bomberosDisponibles -= cantidad; // Restamos los bomberos que se usaron
            System.out.println(cantidad + " bomberos asignados. Quedan " + bomberosDisponibles + " disponibles.");
        } else {
            System.out.println("No hay suficientes bomberos disponibles.");
        }
    }

    // Método para asignar ambulancias a una emergencia
    public void asignarAmbulancias(int cantidad) {
        if (cantidad <= ambulanciasDisponibles) {
            ambulanciasDisponibles -= cantidad; // Restamos las ambulancias que se usaron
            System.out.println(cantidad + " ambulancias asignadas. Quedan " + ambulanciasDisponibles + " disponibles.");
        } else {
            System.out.println("No hay suficientes ambulancias disponibles.");
        }
    }

    // Método para asignar policías a una emergencia
    public void asignarPolicias(int cantidad) {
        if (cantidad <= policiasDisponibles) {
            policiasDisponibles -= cantidad; // Restamos los policías que se usaron
            System.out.println(cantidad + " policías asignados. Quedan " + policiasDisponibles + " disponibles.");
        } else {
            System.out.println("No hay suficientes policías disponibles.");
        }
    }

    // Método para mostrar cuántos recursos hay disponibles
    public void mostrarRecursos() {
        System.out.println("Recursos disponibles:");
        System.out.println("Bomberos: " + bomberosDisponibles);
        System.out.println("Ambulancias: " + ambulanciasDisponibles);
        System.out.println("Policías: " + policiasDisponibles);
    }
}

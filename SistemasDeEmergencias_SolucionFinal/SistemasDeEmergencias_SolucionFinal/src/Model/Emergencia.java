package Model;

public class Emergencia {
    
    private String tipo; // Tipo de emergencia (por ejemplo, "Incendio" o "Accidente")
    private String ubicacion; // Lugar donde ocurre la emergencia (por ejemplo, "Calle Principal")
    private int gravedad; // Qué tan grave es la emergencia (1: poco grave, 3: muy grave)
    private int tiempoRespuesta; // Cuánto tiempo tardan en llegar los servicios de emergencia

    // Constructor: es como una receta para crear una emergencia
    public Emergencia(String tipo, String ubicacion, int gravedad) {
        this.tipo = tipo; // Guardamos el tipo de emergencia
        this.ubicacion = ubicacion; // Guardamos la ubicación
        this.gravedad = gravedad; // Guardamos la gravedad
        this.tiempoRespuesta = 0; // Al principio, el tiempo de respuesta es 0 (nadie ha llegado todavía)
    }

    // Métodos para obtener información de la emergencia
    public String getTipo() {
        return tipo; // Nos dice qué tipo de emergencia es
    }

    public String getUbicacion() {
        return ubicacion; // Nos dice dónde ocurrió la emergencia
    }

    public int getGravedad() {
        return gravedad; // Nos dice qué tan grave es
    }

    public int getTiempoRespuesta() {
        return tiempoRespuesta; // Nos dice cuánto tiempo tardaron en llegar
    }

    // Método para cambiar el tiempo de respuesta
    public void setTiempoRespuesta(int tiempoRespuesta) {
        this.tiempoRespuesta = tiempoRespuesta; // Actualizamos el tiempo de respuesta
    }

    // Método para mostrar la emergencia de manera bonita
    @Override
    public String toString() {
        return "Emergencia{" +
                "tipo='" + tipo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", gravedad=" + gravedad +
                ", tiempoRespuesta=" + tiempoRespuesta +
                '}';
    }
}



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

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    public int getTiempoRespuesta() {
        return tiempoRespuesta; // Nos dice cuánto tiempo tardaron en llegar
    }

    // Método para cambiar el tiempo de respuesta
    public void setTiempoRespuesta(int tiempoRespuesta) {
        this.tiempoRespuesta = tiempoRespuesta; // Actualizamos el tiempo de respuesta
    }
    
     // metodo para hacer en consola no se imprima el numero ingresado por la persona sino el nivel de gravedad en texto
    public String gravedadTexto(int gravedad) {

        if (this.gravedad == 1) {
            return "Bajo";
        } else if (this.gravedad == 2) {
            return "Medio ";
        } else if (this.gravedad == 3) {
            return "Alto";
        } else {
            return "Desconocido el nivel de gravedad"; // Si el nivel de gravedad no es conocido
        }

    }

    // Método para mostrar la emergencia de manera bonita
    @Override
    public String toString() {
        String nivelGravedad = gravedadTexto(gravedad); // Guardamos el nivel de gravedad en texto, teniendo en cuenta el texto que retornari el metodo gravedadTexto
        return "Emergencia{" +
                "tipo: '" + tipo + '\'' +
                ", ubicacion: '" + ubicacion + '\'' +
                ", gravedad: " + nivelGravedad +
                ", tiempoRespuesta: " + tiempoRespuesta +
                '}';
    }
}

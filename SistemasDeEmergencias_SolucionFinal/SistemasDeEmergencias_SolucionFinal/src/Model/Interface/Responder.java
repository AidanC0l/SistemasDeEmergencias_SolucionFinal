package Model.Interface;
import Model.Emergencia;
public interface Responder {
    void atenderEmergencia(Emergencia emergencia); // Método para atender una emergencia
    void evaluarEstado(); // Método para ver cómo están los servicios
}

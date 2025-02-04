package Model.Services;

import Model.Emergencia;
import Model.Interface.Responder;

public class Ambulancia implements Responder{
    @Override
    public void atenderEmergencia(Emergencia emergencia) {
        System.out.println("Ambulancia atendiendo emergencia: " + emergencia.getTipo() + " en " + emergencia.getUbicacion());
    }

    @Override
    public void evaluarEstado() {
        System.out.println("Evaluando estado de las ambulancias...");
    }
}

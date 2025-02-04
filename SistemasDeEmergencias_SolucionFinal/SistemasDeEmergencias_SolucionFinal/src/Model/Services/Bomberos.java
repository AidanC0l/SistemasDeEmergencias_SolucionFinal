package Model.Services;

import Model.Emergencia;
import Model.Interface.Responder;

public class Bomberos implements Responder    {

    @Override
    public void atenderEmergencia(Emergencia emergencia) {
        System.out.println("Bomberos atendiendo emergencia: " + emergencia.getTipo() + " en " + emergencia.getUbicacion());
    }

    @Override
    public void evaluarEstado() {
        System.out.println("Evaluando estado de los bomberos...");
    }

}

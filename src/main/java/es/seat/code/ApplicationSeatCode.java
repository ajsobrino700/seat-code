package es.seat.code;

import es.seat.code.infraestructure.model.PlateauMaintenance;

import es.seat.code.infraestructure.utility.ProcessInput;


public class ApplicationSeatCode {


    public static void main(String args[]) {
        PlateauMaintenance plateauMaintenance = ProcessInput.getPlateuMaintenance();

        plateauMaintenance.executeMaintenance();
    }
}

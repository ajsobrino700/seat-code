package es.seat.code.infraestructure.services;

import es.seat.code.infraestructure.model.Grid;
import es.seat.code.infraestructure.model.MowerTask;

public interface ExecuteTask {

    public void execute(MowerTask mowerTask, Grid grid) throws RuntimeException;

}

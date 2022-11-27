package es.seat.code.infraestructure.model;

import es.seat.code.infraestructure.actions.Action;
import es.seat.code.infraestructure.services.ExecuteTask;
import es.seat.code.infraestructure.services.impl.ExecuteTaskImpl;

import lombok.Data;


import java.util.*;

@Data
public class PlateauMaintenance {

    private Map<String,Action> actions;

    private Grid grid;

    Queue<MowerTask> mowerTasks = new LinkedList<>();

    public void executeMaintenance(){
        ExecuteTask executeTask = new ExecuteTaskImpl();
        Iterator<MowerTask> iterator = this.getMowerTasks().iterator();
        iterator.forEachRemaining(m -> executeTask.execute(m,this.grid));
    }

}

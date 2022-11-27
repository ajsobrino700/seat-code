package es.seat.code.infraestructure.model;

import es.seat.code.infraestructure.actions.Action;
import es.seat.code.infraestructure.model.Grid;
import es.seat.code.infraestructure.model.Mower;
import es.seat.code.infraestructure.model.MowerTask;
import es.seat.code.infraestructure.services.ExecuteTask;
import es.seat.code.infraestructure.services.impl.ExecuteTaskImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
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

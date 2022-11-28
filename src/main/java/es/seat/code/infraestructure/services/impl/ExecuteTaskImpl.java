package es.seat.code.infraestructure.services.impl;

import es.seat.code.infraestructure.actions.FactoryAction;
import es.seat.code.infraestructure.enumeration.ActionEnumeration;
import es.seat.code.infraestructure.model.Grid;
import es.seat.code.infraestructure.model.GridPoint;
import es.seat.code.infraestructure.model.MowerTask;
import es.seat.code.infraestructure.services.ExecuteTask;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Iterator;


@Data
@NoArgsConstructor

public class ExecuteTaskImpl implements ExecuteTask {

    FactoryAction factoryAction = new FactoryAction() ;

    public void execute(MowerTask mowerTask, Grid grid){
        Iterator<ActionEnumeration> actions = mowerTask.getActions().iterator();
        actions.forEachRemaining(a -> {
            this.factoryAction.get(a).execute(mowerTask.getMower());
            this.checkPosition(mowerTask.getMower().getPosition(),grid);
        });
        System.out.println(mowerTask.getMower().getPosition().getXAxis()+" "+mowerTask.getMower().getPosition().getYAxis()+ " "+mowerTask.getMower().getOrientation().name());
    }

    private void checkPosition(GridPoint point, Grid grid) throws RuntimeException{
        if( point.getXAxis()<0 || point.getXAxis() > grid.getWidth()){
            throw new RuntimeException("Out grid in x axis");
        }

        if( point.getYAxis()<0 || point.getYAxis() > grid.getHeight()){
            throw new RuntimeException("Out grid in y axis");
        }
    }
}

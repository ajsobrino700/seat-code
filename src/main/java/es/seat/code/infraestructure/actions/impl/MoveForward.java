package es.seat.code.infraestructure.actions.impl;

import es.seat.code.infraestructure.model.Mower;
import es.seat.code.infraestructure.actions.Action;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MoveForward implements Action {

    @Override
    public void execute(Mower mower) {
        switch (mower.getOrientation()){
            case N:
                mower.getPosition().setYAxis(mower.getPosition().getYAxis()+1);
                break;
            case E:
                mower.getPosition().setXAxis(mower.getPosition().getXAxis()+1);
                break;
            case S:
                mower.getPosition().setYAxis(mower.getPosition().getYAxis()-1);
                break;
            case W:
                mower.getPosition().setXAxis(mower.getPosition().getXAxis()-1);
                break;
        }
    }
}

package es.seat.code.infraestructure.actions.impl;

import es.seat.code.infraestructure.enumeration.OrientationEnum;
import es.seat.code.infraestructure.model.Mower;
import es.seat.code.infraestructure.actions.Action;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TurnRight implements Action {

    public void execute(Mower mower) {
        OrientationEnum currentOrientation =mower.getOrientation();
        Integer value =currentOrientation.getValue()+1;
        if( value>3){
            value= value%4;
        }

        mower.setOrientation(OrientationEnum.getByVale(value));
    }
}

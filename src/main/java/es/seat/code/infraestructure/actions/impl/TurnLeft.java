package es.seat.code.infraestructure.actions.impl;

import es.seat.code.infraestructure.enumeration.OrientationEnum;
import es.seat.code.infraestructure.model.Mower;
import es.seat.code.infraestructure.actions.Action;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TurnLeft implements Action {


    @Override
    public void execute(Mower mower) {
        OrientationEnum currentOrientation =mower.getOrientation();
        Integer value =currentOrientation.getValue()-1;
        if( value<0){
            value+=4;
        }

        mower.setOrientation(OrientationEnum.getByVale(value));
    }
}

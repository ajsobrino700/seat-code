package es.seat.code.dummy;

import es.seat.code.infraestructure.enumeration.OrientationEnum;
import es.seat.code.infraestructure.model.GridPoint;
import es.seat.code.infraestructure.model.Mower;

public class DummyMowerFactory {

    public static Mower build(){
        return build(OrientationEnum.S);
    }

    public static Mower build(OrientationEnum orientation){
        return Mower.builder().orientation(orientation).position(GridPoint.builder().xAxis(1).yAxis(1).build()).build();
    }
}

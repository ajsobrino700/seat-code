package es.seat.code.dummy;

import es.seat.code.infraestructure.enumeration.ActionEnumeration;
import es.seat.code.infraestructure.enumeration.OrientationEnum;
import es.seat.code.infraestructure.model.MowerTask;

import java.util.LinkedList;

public class DummyMowerTaskFactory {

    public static MowerTask build(LinkedList<ActionEnumeration> actions, OrientationEnum orientationEnum){
        return MowerTask.builder().mower(DummyMowerFactory.build(orientationEnum)).actions(actions).build();
    }

}

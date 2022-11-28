package es.seat.code.infraestructure.services.impl;

import es.seat.code.dummy.DummyGridFactory;
import es.seat.code.dummy.DummyMowerTaskFactory;
import es.seat.code.infraestructure.enumeration.ActionEnumeration;
import es.seat.code.infraestructure.enumeration.OrientationEnum;
import es.seat.code.infraestructure.model.MowerTask;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

public class ExecuteTaskImplTest {

    private ExecuteTaskImpl executeTask = new ExecuteTaskImpl();

    @Test
    public void testExecuteTaskOutRangeX(){

        LinkedList<ActionEnumeration> actions = new LinkedList<>(Arrays.asList(ActionEnumeration.M,ActionEnumeration.M,ActionEnumeration.M,ActionEnumeration.M,ActionEnumeration.M));

        assertThrows(RuntimeException.class,()->executeTask.execute(DummyMowerTaskFactory.build(actions, OrientationEnum.E),DummyGridFactory.build()));
    }

    @Test
    public void testExecuteTaskOutRangeY(){

        LinkedList<ActionEnumeration> actions = new LinkedList<>(Arrays.asList(ActionEnumeration.M,ActionEnumeration.M,ActionEnumeration.M,ActionEnumeration.M,ActionEnumeration.M));

        assertThrows(RuntimeException.class,()->executeTask.execute(DummyMowerTaskFactory.build(actions, OrientationEnum.S),DummyGridFactory.build()));
    }

    @Test
    public void testExecuteTask(){

        LinkedList<ActionEnumeration> actions = new LinkedList<>(Arrays.asList(ActionEnumeration.L,ActionEnumeration.M,ActionEnumeration.R,ActionEnumeration.M,ActionEnumeration.M));
        MowerTask mowerTask = DummyMowerTaskFactory.build(actions, OrientationEnum.N);

        executeTask.execute(mowerTask,DummyGridFactory.build());

        assertThat(mowerTask.getMower().getOrientation()).isEqualTo(OrientationEnum.N);
        assertThat(mowerTask.getMower().getPosition().getXAxis()).isEqualTo(0);
        assertThat(mowerTask.getMower().getPosition().getYAxis()).isEqualTo(3);
    }

}
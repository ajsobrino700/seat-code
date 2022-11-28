package es.seat.code.infraestructure.actions.impl;

import es.seat.code.dummy.DummyMowerFactory;
import es.seat.code.infraestructure.model.Mower;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import es.seat.code.infraestructure.enumeration.OrientationEnum;


public class TurnRightTest {

    private TurnRight turnRight = new TurnRight();

    @Test
    public void testTurnRight(){
        Mower mower = DummyMowerFactory.build();

        this.turnRight.execute(mower);

        assertThat(mower.getOrientation().getValue()).isEqualTo(OrientationEnum.W.getValue());
    }

    @Test
    public void testTurnRightOutRange(){

        Mower mower = DummyMowerFactory.build(OrientationEnum.W);

        this.turnRight.execute(mower);

        assertThat(mower.getOrientation().getValue()).isEqualTo(OrientationEnum.N.getValue());

    }
}
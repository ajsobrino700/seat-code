package es.seat.code.infraestructure.actions.impl;

import es.seat.code.dummy.DummyMowerFactory;
import es.seat.code.infraestructure.model.Mower;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import es.seat.code.infraestructure.enumeration.OrientationEnum;


class TurnRightTest {

    private TurnRight turnRight = new TurnRight();

    @Test
    public void turnRightTest(){
        Mower mower = DummyMowerFactory.build();

        this.turnRight.execute(mower);

        assertThat(mower.getOrientation().getValue()).isEqualTo(OrientationEnum.W.getValue());
    }

    @Test
    public void turnRightOutRangeTest(){

        Mower mower = DummyMowerFactory.build(OrientationEnum.W);

        this.turnRight.execute(mower);

        assertThat(mower.getOrientation().getValue()).isEqualTo(OrientationEnum.N.getValue());

    }
}
package es.seat.code.infraestructure.actions.impl;

import org.junit.jupiter.api.Test;

import es.seat.code.dummy.DummyMowerFactory;
import es.seat.code.infraestructure.model.Mower;
import static org.assertj.core.api.Assertions.assertThat;

import es.seat.code.infraestructure.enumeration.OrientationEnum;


class TurnLeftTest {

    private TurnLeft turnLeft = new TurnLeft();

    @Test
    public void turnLeftTest(){
        Mower mower = DummyMowerFactory.build();

        this.turnLeft.execute(mower);

        assertThat(mower.getOrientation().getValue()).isEqualTo(OrientationEnum.E.getValue());
    }

    @Test
    public void turnLeftOutRangeTest(){

        Mower mower = DummyMowerFactory.build(OrientationEnum.N);

        this.turnLeft.execute(mower);

        assertThat(mower.getOrientation().getValue()).isEqualTo(OrientationEnum.W.getValue());

    }

}
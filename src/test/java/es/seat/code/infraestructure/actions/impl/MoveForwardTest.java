package es.seat.code.infraestructure.actions.impl;

import org.junit.jupiter.api.Test;
import es.seat.code.dummy.DummyMowerFactory;
import es.seat.code.infraestructure.model.Mower;
import es.seat.code.infraestructure.model.GridPoint;

import static org.junit.jupiter.api.Assertions.*;
import es.seat.code.infraestructure.enumeration.OrientationEnum;
import static org.assertj.core.api.Assertions.assertThat;


class MoveForwardTest {

    private MoveForward moveForward = new MoveForward();

    @Test
    public void turnMoveEastTest(){
        Mower mower = DummyMowerFactory.build(OrientationEnum.E);
        GridPoint point = currenPoint(mower);

        this.moveForward.execute(mower);

        assertThat(mower.getPosition().getXAxis()).isEqualTo(point.getXAxis()+1);
        assertThat(mower.getPosition().getYAxis()).isEqualTo(point.getYAxis());
    }


    @Test
    public void turnMoveWestTest(){
        Mower mower = DummyMowerFactory.build(OrientationEnum.W);
        GridPoint point = currenPoint(mower);;

        this.moveForward.execute(mower);

        assertThat(mower.getPosition().getXAxis()).isEqualTo(point.getXAxis()-1);
        assertThat(mower.getPosition().getYAxis()).isEqualTo(point.getYAxis());
    }

    @Test
    public void turnMoveNorthTest(){
        Mower mower = DummyMowerFactory.build(OrientationEnum.N);
        GridPoint point = currenPoint(mower);

        this.moveForward.execute(mower);

        assertThat(mower.getPosition().getXAxis()).isEqualTo(point.getXAxis());
        assertThat(mower.getPosition().getYAxis()).isEqualTo(point.getYAxis()+1);
    }

    @Test
    public void turnMoveSouthTest(){
        Mower mower = DummyMowerFactory.build(OrientationEnum.S);
        GridPoint point = currenPoint(mower);

        this.moveForward.execute(mower);

        assertThat(mower.getPosition().getXAxis()).isEqualTo(point.getXAxis());
        assertThat(mower.getPosition().getYAxis()).isEqualTo(point.getYAxis()-1);
    }

    private static GridPoint currenPoint(Mower mower) {
        return GridPoint.builder()
                .xAxis(mower.getPosition().getXAxis())
                .yAxis(mower.getPosition().getYAxis())
                .build();
    }

}
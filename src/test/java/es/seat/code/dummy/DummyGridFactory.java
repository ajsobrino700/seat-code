package es.seat.code.dummy;

import es.seat.code.infraestructure.model.Grid;

public class DummyGridFactory {

    public static Grid build(Integer width, Integer height){
        return Grid.builder().width(width).height(height).build();
    }

    public static Grid build(){
        return build(5,5);
    }

}

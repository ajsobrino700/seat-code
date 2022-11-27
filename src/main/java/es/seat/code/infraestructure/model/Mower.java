package es.seat.code.infraestructure.model;

import es.seat.code.infraestructure.enumeration.OrientationEnum;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Mower {

    private GridPoint position;

    private OrientationEnum orientation;

}

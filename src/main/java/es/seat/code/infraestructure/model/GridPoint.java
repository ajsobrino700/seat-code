package es.seat.code.infraestructure.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GridPoint {

    private Integer xAxis;

    private Integer yAxis;

}

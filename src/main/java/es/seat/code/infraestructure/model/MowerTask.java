package es.seat.code.infraestructure.model;

import es.seat.code.infraestructure.enumeration.ActionEnumeration;
import lombok.Builder;
import lombok.Data;

import java.util.Queue;

@Builder
@Data
public class MowerTask {

    private Mower mower;

    private Queue<ActionEnumeration> actions;

}

package es.seat.code.infraestructure.actions;

import es.seat.code.infraestructure.actions.impl.MoveForward;
import es.seat.code.infraestructure.actions.impl.TurnLeft;
import es.seat.code.infraestructure.actions.impl.TurnRight;
import es.seat.code.infraestructure.enumeration.ActionEnumeration;

import java.util.HashMap;
import java.util.Map;

public class FactoryAction {

    private Map<String,Action> actions = new HashMap<>();

    public FactoryAction() {
        actions.put(ActionEnumeration.L.getValue(),new TurnLeft());
        actions.put(ActionEnumeration.M.getValue(),new MoveForward());
        actions.put(ActionEnumeration.R.getValue(),new TurnRight());
    }

    public Action get(ActionEnumeration nameAction){
        return actions.get(nameAction.getValue());
    }

}

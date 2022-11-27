package es.seat.code.infraestructure.enumeration;

import lombok.Getter;

@Getter
public enum ActionEnumeration {

    L("turnLeft"),
    R("turnRight"),
    M("moveForward");

    private final String value;

    ActionEnumeration(String value) {
        this.value = value;
    }



}

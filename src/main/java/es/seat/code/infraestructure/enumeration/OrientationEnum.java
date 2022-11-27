package es.seat.code.infraestructure.enumeration;

import lombok.Getter;
import java.util.Arrays;

@Getter
public enum OrientationEnum {

    N(0),
    E(1),
    S(2),
    W(3);


    private final Integer value;

    OrientationEnum(Integer value){
        this.value = value;
    }

    public static OrientationEnum getByVale(final Integer value){
        return Arrays.stream(OrientationEnum.values()).filter(p-> p.getValue().equals(value)).findFirst().orElseThrow();
    }

}

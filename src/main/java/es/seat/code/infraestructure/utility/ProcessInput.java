package es.seat.code.infraestructure.utility;

import es.seat.code.infraestructure.model.PlateauMaintenance;
import es.seat.code.infraestructure.enumeration.ActionEnumeration;
import es.seat.code.infraestructure.enumeration.OrientationEnum;
import es.seat.code.infraestructure.model.Grid;
import es.seat.code.infraestructure.model.GridPoint;
import es.seat.code.infraestructure.model.Mower;
import es.seat.code.infraestructure.model.MowerTask;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProcessInput {

    public static PlateauMaintenance getPlateuMaintenance() {
        Scanner sc = new Scanner(System.in);
        String gridData = sc.nextLine();
        PlateauMaintenance plateauMaintenance = new PlateauMaintenance();
        plateauMaintenance.setGrid(buildGrid(gridData));

        while(sc.hasNextLine()){
            String mowerData = sc.nextLine();
            String actionData = sc.nextLine();
            plateauMaintenance.getMowerTasks().add(MowerTask.builder()
                    .mower(getInitStateMower(mowerData))
                    .actions(getActionList(actionData))
                    .build()
            );
        }

        sc.close();
        return plateauMaintenance;
    }

    private static Queue<ActionEnumeration> getActionList(String data){
        return (Queue<ActionEnumeration>) Arrays.stream(data.split("")).map(action -> ActionEnumeration.valueOf(action)).collect(Collectors.toCollection(LinkedList::new));
    }

    private static Mower getInitStateMower(String inputLine){
        String[] data = inputLine.split(" ");
        return Mower.builder()
                .orientation(OrientationEnum.valueOf(data[2]))
                .position(GridPoint.builder()
                        .xAxis(Integer.valueOf(data[0]))
                        .yAxis(Integer.valueOf(data[1]))
                        .build())
                .build();
    }

    private static Grid buildGrid(String gridData) {
        String[] data = gridData.split(" ");
        return Grid.builder()
                .height(Integer.valueOf(data[0]))
                .width(Integer.valueOf(data[1]))
                .build();
    }



}

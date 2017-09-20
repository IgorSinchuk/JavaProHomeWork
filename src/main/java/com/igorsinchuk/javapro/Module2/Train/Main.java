package com.igorsinchuk.javapro.Module2.Train;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Trains trains = new Trains();
        trains.add(new Train(4, "Kiev", "Lvov", "23/07/2017 17:00"))
                .add(new Train(22, "Odessa", "Dnepr", "13/08/2017 17:00"))
                .add(new Train(45, "Harkov", "Lvov", "30/07/2017 17:00"))
                .add(new Train(56, "Rovno", "Ivano-Frankovsk", new Date()));

        WriteToXml.run(trains, "/Users/igorsinchuk/IdeaProjects/JavaProHomeWork/src/main/java/com/igorsinchuk/javapro/Module2/Train/savedFile/output.xml");


        trains = ReadFromXml.run("/Users/igorsinchuk/IdeaProjects/JavaProHomeWork/src/main/java/com/igorsinchuk/javapro/Module2/Train/output.xml");
        Train train = new Train(123, "Dnepr", "Harkov", new Date());
    }

}
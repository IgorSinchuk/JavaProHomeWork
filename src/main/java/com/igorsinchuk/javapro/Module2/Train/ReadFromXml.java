package com.igorsinchuk.javapro.Module2.Train;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReadFromXml {

    private ReadFromXml() {}

    public static Trains run(String path) {
        Trains trains = new Trains();
        File file = new File(path);
        try {
            JAXBContext context = JAXBContext.newInstance(Trains.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            trains = (Trains) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return trains;
    }
}
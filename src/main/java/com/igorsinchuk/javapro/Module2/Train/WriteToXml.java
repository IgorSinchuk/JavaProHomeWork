package com.igorsinchuk.javapro.Module2.Train;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class WriteToXml {
    private WriteToXml() {

    }

    public static void run(Trains trains, String path) {
        File file = new File(path);
        try {
            JAXBContext context = JAXBContext.newInstance(Trains.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(trains, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

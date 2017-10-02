package com.igorsinchuk.javapro.Module2.Yahoo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        String xmlFile = "/Users/igorsinchuk/IdeaProjects/JavaProHomeWork/src/main/java/" +
                "com/igorsinchuk/javapro/Module2/Yahoo/xml.xml";

        String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

        writeRequestToFile(request,xmlFile);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Query query = (Query) unmarshaller.unmarshal(new File(xmlFile));

            System.out.println(query);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    private static void writeRequestToFile(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);

        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        try (BufferedWriter printWriter = new BufferedWriter(new FileWriter(file));
             BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()))){
            char[] buf = new char[1000000];
            int r;
            do {
                if ((r = br.read(buf)) > 0)
                    printWriter.write(new String(buf, 0, r));
                printWriter.flush();
            } while (r > 0);
        } finally {
            http.disconnect();
        }
    }
}

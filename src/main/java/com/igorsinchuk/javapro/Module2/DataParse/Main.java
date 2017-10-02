package com.igorsinchuk.javapro.Module2.DataParse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    private static String path = "/Users/igorsinchuk/IdeaProjects/JavaProHomeWork/src/main/java/com/" +
            "igorsinchuk/javapro/Module2/DataParse/json.txt";

    public static void main(String[] args) {

        Reader reader = new Reader();
        String jsonString = reader.reaFromFile (path);

        Gson gson = new GsonBuilder().create();

        Person person = gson.fromJson(jsonString, Person.class);

        System.out.println(person);
    }

}

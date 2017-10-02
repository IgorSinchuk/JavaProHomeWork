package com.igorsinchuk.javapro.Module2.DataParse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public String reaFromFile(String path){
        String res = "";
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(path))){
                while (br.ready()){
                    res +=br.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }
}

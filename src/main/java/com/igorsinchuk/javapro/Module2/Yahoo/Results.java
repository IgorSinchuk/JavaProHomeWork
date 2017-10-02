package com.igorsinchuk.javapro.Module2.Yahoo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "result")
public class Results {

    @XmlElement
    private Rate[] rate;

    @Override
    public String toString() {
        return "Results{" +
                "rate=" + Arrays.toString(rate) +
                '}';
    }
}

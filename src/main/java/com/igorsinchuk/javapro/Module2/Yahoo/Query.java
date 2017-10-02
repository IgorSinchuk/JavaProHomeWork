package com.igorsinchuk.javapro.Module2.Yahoo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "query")
public class Query {
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    private int count;
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    private String created;
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    private String lang;
    @XmlElement
    private Results results;

    @Override
    public String toString() {
        return "Query{" +
                "count=" + count +
                ", created='" + created + '\'' +
                ", lang='" + lang + '\'' +
                ", results=" + results +
                '}';
    }
}

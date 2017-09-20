package com.igorsinchuk.javapro.Module2.Train;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement(name = "train")
public class Train {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
    @XmlAttribute
    private int id;
    @XmlElement
    private String from;
    @XmlElement
    private String to;
    private Date dateD;
    @XmlElement
    private String date;
    @XmlElement
    private String departure;

    public Train() {
    }

    public Train(int id, String from, String to, String date) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.dateD = parseDate(date);
        this.date = sdf.format(dateD);
        this.departure = sdf1.format(dateD);

    }

    public Train(int id, String from, String to, Date date) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.dateD = date;
        this.date = sdf.format(date);
        this.departure = sdf1.format(date);

    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }


    public Date getDeparture() {
        StringBuilder sb = new StringBuilder("")
                .append(date + " " + departure);
        return parseDate(sb.toString());
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date='" + date + '\'' +
                ", departure='" + departure + '\'' +
                "}\n";
    }

    private Date parseDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
package com.igorsinchuk.javapro.Module2.Train;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "trains")
public class Trains{
    @XmlElement(name = "train")
    private List<Train> trains = new ArrayList<>();

    public Trains add(Train train) {
        this.trains.add(train);
        return this;
    }

    public Trains departureFromTo(String from, String to) {
        Date dFrom = parseDate(from);
        Date dTo = parseDate(to);
        Trains timeFilt = new Trains();
        trains.stream().filter(train -> train.getDeparture().after(dFrom)
                && train.getDeparture().before(dTo)
                || train.getDeparture().equals(dFrom) ).collect(Collectors.toList())
                .forEach(timeFilt::add);
        return timeFilt;
    }

    private Date parseDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date1 = null;
        try {
            date1 = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

    @Override
    public String toString() {
        return "Trains{" +
                "trains=" + trains +
                '}';
    }
}

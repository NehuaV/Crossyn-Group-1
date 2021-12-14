package com.example.demo.models;

import kotlinx.serialization.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

//@Serializable
//@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "DataLines")
public class DataLine {


    private int vehicleId;

    private Double lat;

    private Double lon;

    private int alt;

    private String dateTime;

    private int speed;

    private int speedLimit;

    private Byte roadType;

    private Boolean ignition;

}
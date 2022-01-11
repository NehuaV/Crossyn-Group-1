package com.example.demo.models.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@Data
@NoRepositoryBean
@AllArgsConstructor
public class DataLinePOJO implements Serializable {

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

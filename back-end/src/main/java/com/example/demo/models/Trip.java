package com.example.demo.models;

import com.example.demo.models.POJO.DataLinePOJO;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import kotlinx.serialization.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;


@Serializable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trips")
@TypeDefs({
        @TypeDef(name="jsonb",typeClass = JsonBinaryType.class)
})
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tripId;

    @Column(name = "vehicleId")
    private int vehicleId;
    
    @Column(name = "driverId", nullable = true)
    private int driverId;

    @Column(name = "startPoint")
    private String startPoint;

    @Column(name = "endPoint")
    private String endPoint;

    @Column(name = "duration")
    private Double duration;

    @Column(name = "distance")
    private String distance;

    @Column(name = "avgSpeed")
    private Double avgSpeed;

    @Column(name = "weatherInfo")
    private String weatherInfo;

    @Type(type ="jsonb")
    @Column(columnDefinition = "jsonb")
    private List<DataLinePOJO> datalines;

    public Trip(int driverId, int vehicleId, String startPoint, String endPoint, Double duration, String distance, Double avgSpeed, String weatherInfo) {
        this.vehicleId = vehicleId;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.duration = duration;
        this.distance = distance;
        this.avgSpeed = avgSpeed;
        this.driverId = driverId;
        this.weatherInfo = weatherInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trip)) return false;
        Trip trip = (Trip) o;
        return getTripId() == trip.getTripId() && getVehicleId() == trip.getVehicleId() && getDriverId() == trip.getDriverId() && Objects.equals(getStartPoint(), trip.getStartPoint()) && Objects.equals(getEndPoint(), trip.getEndPoint()) && Objects.equals(getDuration(), trip.getDuration()) && Objects.equals(getDistance(), trip.getDistance()) && Objects.equals(getAvgSpeed(), trip.getAvgSpeed()) && Objects.equals(getWeatherInfo(), trip.getWeatherInfo()) && Objects.equals(getDatalines(), trip.getDatalines());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTripId(), getVehicleId(), getDriverId(), getStartPoint(), getEndPoint(), getDuration(), getDistance(), getAvgSpeed(), getWeatherInfo(), getDatalines());
    }
}

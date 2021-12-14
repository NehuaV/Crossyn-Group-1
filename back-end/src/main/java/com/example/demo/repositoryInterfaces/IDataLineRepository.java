package com.example.demo.repositoryInterfaces;

import com.example.demo.models.DataLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.xml.crypto.Data;
import java.util.List;

public interface IDataLineRepository extends MongoRepository<DataLine,Integer> {
    List<DataLine> getAllByVehicleId(int vehicleID);
}

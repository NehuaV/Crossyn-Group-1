package com.example.demo.repositoryInterfaces;

import com.example.demo.models.DataLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDataLineRepository extends JpaRepository<DataLine, Integer> {

    List<DataLine> getTripObjectsByTripId(int tripId);
}

package br.edu.parkinglot.repository;

import br.edu.parkinglot.enums.ParkingSpaceStatus;
import br.edu.parkinglot.model.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {

    boolean existsByNumberAndBlock(Integer number, String block);
    List<ParkingSpace> findByStatus (ParkingSpaceStatus status);
    List<ParkingSpace> findByBlock (String block);
}

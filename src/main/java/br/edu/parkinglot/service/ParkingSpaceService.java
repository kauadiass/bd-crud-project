package br.edu.parkinglot.service;

import br.edu.parkinglot.enums.ParkingSpaceStatus;
import br.edu.parkinglot.model.ParkingSpace;
import br.edu.parkinglot.repository.ParkingSpaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceService {

    private final ParkingSpaceRepository repository;

    public ParkingSpaceService (ParkingSpaceRepository repository){
        this.repository = repository;
    }

    public ParkingSpace createSpace (ParkingSpace space){

        if (repository.existsByNumberAndBlock(space.getNumber(),space.getBlock())){
            throw new RuntimeException("Parking space already exists in this block");
        }

        return repository.save(space);
    }

    public List<ParkingSpace> getAllSpaces() {
        return repository.findAll();
    }

    public ParkingSpace getSpaceById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Parking space not found"));
    }

    public ParkingSpace updateSpace(Long id, ParkingSpace updateSpace){

        ParkingSpace space = getSpaceById(id);

        space.setNumber(updateSpace.getNumber());
        space.setBlock(updateSpace.getBlock());
        space.setType(updateSpace.getType());
        space.setStatus(updateSpace.getStatus());

        return repository.save(space);
    }

    public void deleteSpace(Long id){

        ParkingSpace space = getSpaceById(id);

        repository.delete(space);
    }

    public List<ParkingSpace> getAvailableSpaces(){
        return repository.findByStatus(ParkingSpaceStatus.AVAILABLE);
    }

    public List<ParkingSpace> getSpacesByBlock(String block){
        return repository.findByBlock(block);
    }

    public ParkingSpace occupySpace(Long id){

        ParkingSpace space = getSpaceById(id);

        if(space.getStatus() == ParkingSpaceStatus.OCCUPIED){
            throw new RuntimeException("Parking space already occupied");
        }

        space.setStatus(ParkingSpaceStatus.OCCUPIED);

        return repository.save(space);
    }

    public ParkingSpace freeSpace(Long id){

        ParkingSpace space = getSpaceById(id);

        space.setStatus(ParkingSpaceStatus.AVAILABLE);

        return repository.save(space);
    }
}

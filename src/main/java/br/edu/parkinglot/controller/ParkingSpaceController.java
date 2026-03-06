package br.edu.parkinglot.controller;

import br.edu.parkinglot.model.ParkingSpace;
import br.edu.parkinglot.service.ParkingSpaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-spaces")
public class ParkingSpaceController {

    private final ParkingSpaceService spaceService;

    public ParkingSpaceController(ParkingSpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @PostMapping
    public ParkingSpace createSpace(@RequestBody ParkingSpace space){
        return spaceService.createSpace(space);
    }

    @GetMapping
    public List<ParkingSpace> getAllSpaces(){
        return spaceService.getAllSpaces();
    }

    @GetMapping("/{id}")
    public ParkingSpace getSpaceById(@PathVariable Long id) {
       return spaceService.getSpaceById(id);
    }

    @PutMapping("/{id}")
    public ParkingSpace updateSpace(@PathVariable Long id, @RequestBody ParkingSpace space){
        return spaceService.updateSpace(id, space);
    }

    @DeleteMapping("/{id}")
    public void deleteSpace(@PathVariable Long id){
        spaceService.deleteSpace(id);
    }

    @GetMapping("/available")
    public List<ParkingSpace> getAvailableSpaces(){
        return spaceService.getAvailableSpaces();
    }

    @GetMapping("/block/{block}")
    public List<ParkingSpace> getSpacesByBlock(@PathVariable String block){
        return spaceService.getSpacesByBlock(block);
    }

    @PatchMapping("/{id}/occupy")
    public ParkingSpace occupySpace(@PathVariable Long id){
       return spaceService.occupySpace(id);
    }

    @PatchMapping("/{id}/free")
    public ParkingSpace freeSpace(@PathVariable Long id){
        return spaceService.freeSpace(id);
    }
}

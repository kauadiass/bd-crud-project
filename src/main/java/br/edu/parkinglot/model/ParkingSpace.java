package br.edu.parkinglot.model;

import br.edu.parkinglot.enums.ParkingSpaceStatus;
import br.edu.parkinglot.enums.ParkingSpaceType;
import jakarta.persistence.*;


@Entity
@Table(name = "parking_space")
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "block", nullable = false)
    private String block;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ParkingSpaceType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ParkingSpaceStatus status;

    public ParkingSpace() { }

    public ParkingSpace(Integer number, String block, ParkingSpaceType type, ParkingSpaceStatus status){
        this.number = number;
        this.block = block;
        this.type = type;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public ParkingSpaceType getType() {
        return type;
    }

    public void setType(ParkingSpaceType type) {
        this.type = type;
    }

    public ParkingSpaceStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSpaceStatus status) {
        this.status = status;
    }
}

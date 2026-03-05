package br.edu.parkinglot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String registration;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType type;

    public User(){}

    public User(String name, String registration, UserType type) {
        this.name = name;
        this.registration = registration;
        this.type = type;
    }

    public Long getId(){return this.id;}

    public String getName () {return this.name;}

    public String getRegistration(){return this.registration;}

    public UserType getType(){ return this.type;}

    public void setName(String name){this.name = name;}

    public void setRegistration(String registration){this.registration = registration;}

    public void setType(UserType type){this.type = type;}
}

package br.edu.parkinglot.repository;

import br.edu.parkinglot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByRegistration(String registration);
    boolean existsByRegistrationAndIdNot(String registration, Long id);
}

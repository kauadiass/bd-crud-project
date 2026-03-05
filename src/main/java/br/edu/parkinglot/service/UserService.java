package br.edu.parkinglot.service;

import br.edu.parkinglot.model.User;
import br.edu.parkinglot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){

        if (userRepository.existsByRegistration(user.getRegistration())) {
            throw new RuntimeException("Registration already exists");
        }

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(Long id, User userDetails){

        User user = getUserById(id);

        if (userRepository.existsByRegistrationAndIdNot(userDetails.getRegistration(), id)){
            throw new RuntimeException("Registration already in use");
        }

        user.setName(userDetails.getName());
        user.setRegistration(userDetails.getRegistration());
        user.setType(userDetails.getType());

        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

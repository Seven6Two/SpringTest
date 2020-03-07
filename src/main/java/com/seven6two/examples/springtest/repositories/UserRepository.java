package com.seven6two.examples.springtest.repositories;

import com.seven6two.examples.springtest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    User save(User user);
    User findById(int id);
    User findByEmail(String email);
    List<User> findAll();

}

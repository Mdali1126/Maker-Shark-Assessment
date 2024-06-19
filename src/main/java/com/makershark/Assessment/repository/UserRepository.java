package com.makershark.Assessment.repository;

import com.makershark.Assessment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User>findByUsername(String username);
    void deleteUserByUsername(String userName);

}

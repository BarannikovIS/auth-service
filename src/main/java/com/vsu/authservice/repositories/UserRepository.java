package com.vsu.authservice.repositories;

import com.vsu.authservice.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Person, Long>{

    @Query(value = "SELECT * FROM person where login = ?1", nativeQuery = true)
    Person findByLogin(String login);
}

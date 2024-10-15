
package com.example.FirstTask.repository;

import com.example.FirstTask.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByTckn(long tc);

    @Query("select p from Person p where p.tckn = :tckn")
    Optional<Person> getPersonByTckn(@Param("tckn")long tckn);
}


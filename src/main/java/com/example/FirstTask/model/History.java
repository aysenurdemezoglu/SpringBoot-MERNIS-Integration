package com.example.FirstTask.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "history")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","Person"})
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tckn", referencedColumnName = "tckn")
    @JsonBackReference
    private Person person;
    private LocalDate date;
    private String feeling;

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setId(Long id) {
        this.id = id;
    }





    public LocalDate getDate() {
        return date;
    }

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }





    public void setDate(LocalDate date) {
        this.date = date;
    }




}

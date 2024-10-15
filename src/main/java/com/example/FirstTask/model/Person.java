package com.example.FirstTask.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="people")
public class Person {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tckn;
    private String name;
    private String surname;
    private int birthYear;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<History> historyList ;

    public List<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
    }

    public Person(){

    }

    public Person(long tckn,String name, String surname, int birthYear){
        this.tckn=tckn;
        this.name=name;
        this.surname=surname;
        this.birthYear=birthYear;
    }

    public void setTckn(long tckn) {
        this.tckn = tckn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public long getTckn() {
        return tckn;
    }


}

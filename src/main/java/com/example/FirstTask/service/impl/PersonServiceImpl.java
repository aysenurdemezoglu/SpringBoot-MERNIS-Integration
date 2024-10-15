package com.example.FirstTask.service.impl;

import com.example.FirstTask.dto.PersonHistoryDto;
import com.example.FirstTask.model.Person;
import com.example.FirstTask.service.TcService;
import jakarta.jws.WebMethod;

public class PersonServiceImpl {
    private final TcService tcService;

    public PersonServiceImpl(TcService tcService) {
        this.tcService = tcService;
    }

    @WebMethod
    public boolean addPerson(Long tc, String ad, String soyad, int dogumyili, String feeling) {
        PersonHistoryDto personDto = new PersonHistoryDto(tc, ad, soyad, dogumyili, feeling);
        Person addedPerson = tcService.add(personDto);
        return addedPerson != null;
    }
}

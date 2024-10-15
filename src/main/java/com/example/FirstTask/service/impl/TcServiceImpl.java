package com.example.FirstTask.service.impl;

import Mernis.NAUKPSPublicSoap;
import com.example.FirstTask.dto.PersonHistoryDto;
import com.example.FirstTask.model.History;
import com.example.FirstTask.model.Person;
import com.example.FirstTask.repository.HistoryRepository;
import com.example.FirstTask.repository.PersonRepository;
import com.example.FirstTask.service.TcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@Service
public class TcServiceImpl implements TcService {
    private final PersonRepository personRepository;
    private final HistoryRepository historyRepository;
    private final Logger logger = LoggerFactory.getLogger(TcServiceImpl.class);

    public TcServiceImpl(HistoryRepository historyRepository, PersonRepository personRepository) {
        this.historyRepository = historyRepository;
        this.personRepository = personRepository;
    }

    @Override
    public boolean tcnodogrula(Long tc, String ad, String soyad, int dogumyili) {
        NAUKPSPublicSoap client = new NAUKPSPublicSoap();
        boolean result = true; //false
        try {
            result = client.TCKimlikNoDogrula(tc, ad, soyad, dogumyili);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Person add(PersonHistoryDto person) {

        Optional<Person> existPerson = personRepository.getPersonByTckn(person.tckn());
        boolean mernisResult = this.tcnodogrula(person.tckn(), person.name(), person.surname(), person.birthYear());

        if (!mernisResult){
            logger.error("mernis result hatalı, kişi tabloya eklenmiyor.");
            return null;
        }

        if (existPerson.isPresent()) {
            logger.info("Kayıt var");
            logger.warn("kayıt var historye kaydedildi.mernis sonucu " + mernisResult);

            History history = new History();
            history.setPerson(existPerson.get());
            history.setFeeling(person.feeling());
            history.setDate(LocalDate.now());
            historyRepository.save(history);

            return existPerson.get();
        }


        Person tempPerson = new Person();
        tempPerson.setName(person.name());
        tempPerson.setSurname(person.surname());
        tempPerson.setTckn(person.tckn());
        tempPerson.setBirthYear(person.birthYear());

        History tempHistory = new History();
        tempHistory.setFeeling(person.feeling());
        tempHistory.setDate(LocalDate.now());

        tempPerson.setHistoryList(Arrays.asList(tempHistory));
        Person saveresult = personRepository.save(tempPerson);
        logger.info("Kayıt yok");
        logger.warn("kayıt yok historye ve people kaydedildi.mernis sonucu " + mernisResult);

        return saveresult;
    }

    @Override
    public Optional<Person> findByTc(Long tc) {
        return personRepository.findByTckn(tc);
    }

    @Override
    public String askFeeling(String feeling) {
        return null;
    }
}

package com.example.FirstTask.service;
import com.example.FirstTask.dto.PersonHistoryDto;
import com.example.FirstTask.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface TcService {
    static ApplicationContext context = null;

    boolean tcnodogrula(Long tc, String ad, String soyad, int dogumyili);

     Person add(PersonHistoryDto person);
     Optional<Person> findByTc(Long tc);

     String askFeeling(String feeling);




}

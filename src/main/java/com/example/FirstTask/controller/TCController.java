package com.example.FirstTask.controller;

import com.example.FirstTask.dto.PersonHistoryDto;
import com.example.FirstTask.model.Person;
import com.example.FirstTask.service.TcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tcController")
public class TCController {
    private final TcService tcService;
    public TCController(TcService tcService){

        this.tcService = tcService;
    }
    @GetMapping("/tc")
    public Boolean TCKimlikNoDogrula(@RequestParam Long tc, @RequestParam String ad, @RequestParam String soyad, @RequestParam int dogumyili){
        boolean result = this.tcService.tcnodogrula(tc,ad,soyad,dogumyili);
        return result;
    }
    @PostMapping("/addPerson")
    public Person add(@RequestBody PersonHistoryDto person){

        return this.tcService.add(person);
    }
    @PostMapping("/feeling")
    public String askFeeling(@RequestBody String feeling){
        return this.tcService.askFeeling(feeling);
    }

    @PostMapping("/checkUser")
    public ResponseEntity<Person> checkUser(@RequestBody PersonHistoryDto person) {
        Person person1 = tcService.add(person);

        return ResponseEntity.ok(person1);
    }

}


package ng.edu.binghamuni.depot.controller.api;

import ng.edu.binghamuni.depot.repository.MedRepository;
import ng.edu.binghamuni.depot.services.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ng.edu.binghamuni.depot.Domain.Med;

import java.util.List;

@Controller
public class GroupAPIController {
    @Autowired
    MedRepository medRepository;

    @Autowired
    MedService medService;

    @RequestMapping("/meds")
    @GetMapping("/meds")
    public ResponseEntity<List<Med>> getAllMeds(){
        return ResponseEntity.ok().body(medRepository.findAll());
    }

    @RequestMapping("/meds/{id}")
    @GetMapping
    public ResponseEntity<Med> getDrinkById(@PathVariable long id){
        return ResponseEntity.ok().body(medService.getMedById(id));
    }

    @PostMapping("/med")
    public ResponseEntity<Med> createDrink(@RequestBody Med med){
        return ResponseEntity.ok().body(medService.saveMed(med));
    }

    @PutMapping("/med/{id}")
    public ResponseEntity<Med> updateDrink(@PathVariable long id, @RequestBody Med med){
        return ResponseEntity.ok().body(medService.updateMedById(med));
    }

    @DeleteMapping("/med/{id}")
    public HttpStatus deleteDrink(@PathVariable long id){
        MedService.deleteMedById(id);
        return HttpStatus.OK;
    }
}

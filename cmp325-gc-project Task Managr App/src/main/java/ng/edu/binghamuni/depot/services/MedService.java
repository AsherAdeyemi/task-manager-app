package ng.edu.binghamuni.depot.services;

import ng.edu.binghamuni.depot.Domain.Med;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MedService {

    //    interfaces have nobody because they are abstracts
    Med saveMed(Med med);
    Med getMedById(long id);
    List<Med> getAllMeds();

    Med updateDrink(Med drink);

    Med updateMedById(Med drink);

    static void deleteMedById(long id) {

    }

//    void deleteMedById(long id){
//
//    };
}

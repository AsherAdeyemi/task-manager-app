package ng.edu.binghamuni.depot.services;

import ng.edu.binghamuni.depot.Domain.Med;
import ng.edu.binghamuni.depot.repository.MedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedServiceImpl implements MedService {
    @Autowired
    MedRepository medRepository;
    @Override
    public Med saveMed(Med med) {
        return medRepository.save(med);
    }

    @Override
    public Med getMedById(long id) {
        Optional<Med> med = medRepository.findById(id);

        Med emptyMed = null;
        if (med.isPresent()){
            emptyMed = Med.get();
            return emptyMed;
        } else {
            throw new RuntimeException("Drug Not Found");
        }
    }

    @Override
    public List<Med> getAllMeds() {
        return medRepository.findAll();
    }

    @Override
    public Med updateDrink(Med med) {
        return null;
    }

//    @Override
//    public Med updateMedById(Med med) {
//        return null;
//    }


    @Override
    public Med updateMedById(Med med) {
        Optional<Med> optionalMed = medRepository.findById(med.getId());

        if (optionalMed.isPresent()){
            Med updateMed = new Med();
            updateMed.setBody(med.getBody());
            updateMed.setName(med.getName());
            medRepository.save(updateMed);
            return updateMed;
        } else{
            throw new RuntimeException("Drug does not exist");
        }

    }

//    @Override
//    public void deleteMedById(long id) {
//        medRepository.deleteById(id);
//    }
}

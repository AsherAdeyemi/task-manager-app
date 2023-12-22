package ng.edu.binghamuni.depot.repository;

import ng.edu.binghamuni.depot.Domain.Med;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedRepository extends JpaRepository<Med, Long> {
//    @Query("")
//    List<Drink> finddrinkByPriceGreaterthan(int Price);
}
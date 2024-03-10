package GalapagosookYonan.GalapagosookYonan.farm;

import GalapagosookYonan.GalapagosookYonan.entity.PlanTerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<PlanTerms, Long> {

}

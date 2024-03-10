package GalapagosookYonan.GalapagosookYonan.repository;

import GalapagosookYonan.GalapagosookYonan.entity.farmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface farmRepository extends JpaRepository<farmEntity, Integer> {
    // CRUD methods are already included by extending JpaRepository
}

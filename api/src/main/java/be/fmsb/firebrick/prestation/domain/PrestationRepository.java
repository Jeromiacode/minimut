package be.fmsb.firebrick.prestation.domain;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrestationRepository extends JpaRepository<Prestation, String> {

    @Query("SELECT prestation FROM Prestation prestation WHERE prestation.category IN (SELECT prestation.category FROM Prestation prestation WHERE prestation.code IN (:prestationCode))")
    List<Prestation> getAllPrestationsMatchingRequestPrestationCategory(String prestationCode);

    @Modifying
    @Transactional
    void deletePrestationByCode(String code);

}

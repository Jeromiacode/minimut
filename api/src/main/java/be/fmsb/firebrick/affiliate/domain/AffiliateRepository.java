package be.fmsb.firebrick.affiliate.domain;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AffiliateRepository extends JpaRepository<Affiliate, String> {

    Affiliate findAffiliateByNationalNumber(String nationalNumber);

    @Modifying
    @Transactional
    void deleteAffiliateByNationalNumber(String nationalNumber);

}
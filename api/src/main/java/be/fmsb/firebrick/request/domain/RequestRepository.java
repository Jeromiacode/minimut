package be.fmsb.firebrick.request.domain;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, String> {

    @Query("SELECT request FROM Request request WHERE request.affiliateCode = :affiliateCode AND request.prestationCode = :prestationCode AND YEAR(request.date) = :yearOfDate")
    Request getRequestByAffiliateCodeWithSamePrestationInCurrentYear(String affiliateCode, String prestationCode, Integer yearOfDate);

    @Query("SELECT request FROM Request request WHERE request.prestationCode IN (:prestationCodesMatchingCategory) AND QUARTER(request.date) = QUARTER(:requestDate)")
    List<Request> getRequestByPrestationCategoryInSameQuarter(List<String> prestationCodesMatchingCategory, Date requestDate);

}

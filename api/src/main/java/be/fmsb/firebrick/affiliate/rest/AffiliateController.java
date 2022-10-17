package be.fmsb.firebrick.affiliate.rest;

import be.fmsb.firebrick.affiliate.app.AffiliateService;
import be.fmsb.firebrick.affiliate.app.dto.AffiliateCreationDTO;
import be.fmsb.firebrick.affiliate.app.dto.AffiliateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/affiliates")
@RequiredArgsConstructor
public class AffiliateController {

    private final AffiliateService affiliateService;

    @GetMapping
    public List<AffiliateDTO> getAllAffiliates() {
        return affiliateService.getAllAffiliates();
    };

    @GetMapping("/{nationalNumber}")
    public AffiliateDTO getAffiliateByNationalNumber(@PathVariable String nationalNumber) {
        return affiliateService.getAffiliateByNationalNumber(nationalNumber);
    };

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AffiliateDTO createAffiliate(@RequestBody AffiliateCreationDTO affiliateCreationDTO) {
        return affiliateService.createAffiliate(affiliateCreationDTO);
    }

    @DeleteMapping("/{nationalNumber}")
    public void deleteAffiliateByNationalNumber(@PathVariable String nationalNumber) {
        affiliateService.deleteAffiliateByNationalNumber(nationalNumber);
    };

    @PutMapping("/{nationalNumber}")
    public AffiliateDTO updateAffiliate(@RequestBody AffiliateCreationDTO affiliateCreationDTO, @PathVariable String nationalNumber) {
        return affiliateService.updateAffiliate(affiliateCreationDTO, nationalNumber);
    }
}

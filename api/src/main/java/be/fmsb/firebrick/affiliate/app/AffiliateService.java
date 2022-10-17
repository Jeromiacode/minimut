package be.fmsb.firebrick.affiliate.app;

import be.fmsb.firebrick.affiliate.domain.Affiliate;
import be.fmsb.firebrick.affiliate.domain.AffiliateRepository;
import be.fmsb.firebrick.affiliate.app.dto.AffiliateCreationDTO;
import be.fmsb.firebrick.affiliate.app.dto.AffiliateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AffiliateService {

    private final AffiliateRepository affiliateRepository;
    private final AffiliateMapper affiliateMapper;

    public List<AffiliateDTO> getAllAffiliates() {

        return affiliateRepository.findAll().stream()
                .map(affiliateMapper::toAffiliateDTO)
                .collect(Collectors.toList());
    }

    public AffiliateDTO getAffiliateByNationalNumber(String nationalNumber) {
        return affiliateMapper.toAffiliateDTO(affiliateRepository.findAffiliateByNationalNumber(nationalNumber));
    }

    public AffiliateDTO createAffiliate(AffiliateCreationDTO affiliateCreationDTO) {
        Affiliate affiliate = affiliateMapper.toAffiliate(affiliateCreationDTO);
        affiliateRepository.save(affiliate);

        return affiliateMapper.toAffiliateDTO(affiliate);
    }

    public AffiliateDTO updateAffiliate(AffiliateCreationDTO affiliateCreationDTO, String nationalNumber) {
        Affiliate updatedAffiliate = affiliateRepository.findAffiliateByNationalNumber(nationalNumber);
        updatedAffiliate.setCode(affiliateCreationDTO.getCode());
        updatedAffiliate.setFirstName(affiliateCreationDTO.getFirstName());
        updatedAffiliate.setLastName(affiliateCreationDTO.getLastName());
        updatedAffiliate.setEmail(affiliateCreationDTO.getEmail());
        updatedAffiliate.setPhoneNumber(affiliateCreationDTO.getPhoneNumber());
        updatedAffiliate.setBirthdate(affiliateCreationDTO.getBirthdate());
        updatedAffiliate.setGender(affiliateCreationDTO.getGender());
        updatedAffiliate.setAddresses(affiliateCreationDTO.getAddresses());
        affiliateRepository.save(updatedAffiliate);

        return affiliateMapper.toAffiliateDTO(updatedAffiliate);
    }

    public void deleteAffiliateByNationalNumber(String nationalNumber) {
        affiliateRepository.deleteAffiliateByNationalNumber(nationalNumber);
    }
}


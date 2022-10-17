package be.fmsb.firebrick.affiliate.app;

import be.fmsb.firebrick.affiliate.app.dto.AddressDTO;
import be.fmsb.firebrick.affiliate.app.dto.AffiliateCreationDTO;
import be.fmsb.firebrick.affiliate.app.dto.AffiliateDTO;
import be.fmsb.firebrick.affiliate.domain.Affiliate;
import org.springframework.stereotype.Component;

@Component
public class AffiliateMapper {

    public AffiliateDTO toAffiliateDTO(Affiliate affiliate) {
        return new AffiliateDTO(affiliate.getCode(),
                affiliate.getNationalNumber(),
                affiliate.getFirstName(),
                affiliate.getLastName(),
                affiliate.getEmail(),
                affiliate.getPhoneNumber(),
                affiliate.getGender(),
                affiliate.getBirthdate(),
                affiliate.getAddresses().stream()
                        .map(address -> new AddressDTO(
                                address.getStreet(),
                                address.getStreetNumber(),
                                address.getPostalCode(),
                                address.getCity(),
                                address.getMoveInDate(),
                                address.getIsMain()
                        ))
                        .toList());
    }

    public Affiliate toAffiliate(AffiliateCreationDTO affiliateCreationDTO) {
        return new Affiliate(affiliateCreationDTO.getId(),
                affiliateCreationDTO.getCode(),
                affiliateCreationDTO.getNationalNumber(),
                affiliateCreationDTO.getFirstName(),
                affiliateCreationDTO.getLastName(),
                affiliateCreationDTO.getEmail(),
                affiliateCreationDTO.getPhoneNumber(),
                affiliateCreationDTO.getGender(),
                affiliateCreationDTO.getBirthdate(),
                affiliateCreationDTO.getAddresses());
    }
}

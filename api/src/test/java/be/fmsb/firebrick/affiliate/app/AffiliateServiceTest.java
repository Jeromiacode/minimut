package be.fmsb.firebrick.affiliate.app;

import be.fmsb.firebrick.affiliate.domain.Affiliate;
import be.fmsb.firebrick.affiliate.domain.AffiliateRepository;
import be.fmsb.firebrick.affiliate.app.dto.AffiliateCreationDTO;
import be.fmsb.firebrick.affiliate.app.dto.AffiliateDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AffiliateServiceTest {

    private static final String NATIONAL_NUMBER = "NATIONAL_NUMBER";

    @Mock
    private AffiliateRepository affiliateRepository;

    @Mock
    private AffiliateMapper affiliateMapper;

    @InjectMocks
    private AffiliateService affiliateService;

    @Test
    public void when_getAllAffiliates_thenAllAffiliatesAreReturned() {
        // given
        Affiliate affiliate = mock(Affiliate.class);
        AffiliateDTO affiliateDTO = affiliateMapper.toAffiliateDTO(affiliate);
        when(affiliateRepository.findAll().stream()
                .map(affiliateMapper::toAffiliateDTO)
                .collect(Collectors.toList())).thenReturn(asList(affiliateDTO, affiliateDTO));

        // when
        List<AffiliateDTO> allAffiliates = affiliateService.getAllAffiliates();

        // then
        verify(affiliateRepository).findAll();
        assertEquals(2, allAffiliates.size());
    }

    @Test
    public void when_createAffiliate_thenCreatedAffiliateIsReturned() {
        // given
        AffiliateCreationDTO affiliateCreationDTO = mock(AffiliateCreationDTO.class);
        AffiliateDTO affiliateDTO = mock(AffiliateDTO.class);
        Affiliate affiliate = mock(Affiliate.class);
        when(affiliateMapper.toAffiliate(affiliateCreationDTO)).thenReturn(affiliate);
        when(affiliateMapper.toAffiliateDTO(affiliate)).thenReturn(affiliateDTO);

        // when
        AffiliateDTO createdAffiliate = affiliateService.createAffiliate(affiliateCreationDTO);

        // then
        verify(affiliateRepository).save(affiliate);
        assertEquals(affiliateDTO, createdAffiliate);
    }

    @Test
    public void when_deleteAffiliateByNationalNumber_thenAffiliateIsDeleted() {
        //when
        affiliateService.deleteAffiliateByNationalNumber(NATIONAL_NUMBER);

        // then
        verify(affiliateRepository).deleteAffiliateByNationalNumber(NATIONAL_NUMBER);
    }

    @Test
    public void when_getAffiliateByNationalNumber_thenAffiliateMatchingHisNationalNumberIsReturned() {
        // given
        Affiliate affiliate = mock(Affiliate.class);
        AffiliateDTO affiliateDTO = mock(AffiliateDTO.class);
        when(affiliateRepository.findAffiliateByNationalNumber(NATIONAL_NUMBER)).thenReturn(affiliate);
        when(affiliateMapper.toAffiliateDTO(affiliate)).thenReturn(affiliateDTO);

        //when
        AffiliateDTO affiliateByNationalNumber = affiliateService.getAffiliateByNationalNumber(NATIONAL_NUMBER);

        // then
        verify(affiliateRepository).findAffiliateByNationalNumber(NATIONAL_NUMBER);
        assertEquals(affiliateDTO, affiliateByNationalNumber);
    }

    @Test
    public void when_updateAffiliate_thenSelectedAffiliateByNationalNumberIsUpdated() {
        // given
        Affiliate affiliate = mock(Affiliate.class);
        AffiliateDTO affiliateDTO = mock(AffiliateDTO.class);
        when(affiliateRepository.findAffiliateByNationalNumber(NATIONAL_NUMBER)).thenReturn(affiliate);
        when(affiliateMapper.toAffiliateDTO(affiliate)).thenReturn(affiliateDTO);

        //when
        AffiliateDTO updatedAffiliate = affiliateService.updateAffiliate(mock(AffiliateCreationDTO.class), NATIONAL_NUMBER);

        // then
        verify(affiliateRepository).findAffiliateByNationalNumber(NATIONAL_NUMBER);
        verify(affiliateRepository).save(affiliate);
        assertEquals(affiliateDTO, updatedAffiliate);
    }
}

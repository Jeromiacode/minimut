package be.fmsb.firebrick.prestation.app;

import be.fmsb.firebrick.prestation.app.dto.PrestationCreationDTO;
import be.fmsb.firebrick.prestation.app.dto.PrestationDTO;
import be.fmsb.firebrick.prestation.domain.Prestation;
import be.fmsb.firebrick.prestation.domain.PrestationRepository;
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
public class PrestationServiceTest {

    private static final String PRESTATION_CODE = "PRESTATION_CODE";

    @Mock
    private PrestationRepository prestationRepository;

    @Mock
    private PrestationMapper prestationMapper;

    @InjectMocks
    private PrestationService prestationService;

    @Test
    public void when_getAllPrestations_thenAllPrestationsAreReturned() {
        // given
        Prestation prestation = mock(Prestation.class);
        PrestationDTO prestationDTO = prestationMapper.toPrestationDTO(prestation);
        when(prestationRepository.findAll().stream()
                .map(prestationMapper::toPrestationDTO)
                .collect(Collectors.toList())).thenReturn(asList(prestationDTO, prestationDTO));

        // when
        List<PrestationDTO> allPrestations = prestationService.getAllPrestations();

        // then
        verify(prestationRepository).findAll();
        assertEquals(2, allPrestations.size());
    }

    @Test
    public void when_createPrestation_thenCreatedPrestationIsReturned() {
        // given
        PrestationDTO prestationDTO = mock(PrestationDTO.class);
        PrestationCreationDTO prestationCreationDTO = mock(PrestationCreationDTO.class);
        Prestation prestation = mock(Prestation.class);
        when(prestationMapper.toPrestation(prestationCreationDTO)).thenReturn(prestation);
        when(prestationMapper.toPrestationDTO(prestation)).thenReturn(prestationDTO);

        // when
        PrestationDTO createdPrestation = prestationService.createPrestation(prestationCreationDTO);

        // then
        verify(prestationRepository).save(prestation);
        assertEquals(prestationDTO, createdPrestation);
    }

    @Test
    public void when_deletePrestationByCode_thenPrestationIsDeleted() {
        //when
        prestationService.deletePrestationByCode(PRESTATION_CODE);

        // then
        verify(prestationRepository).deletePrestationByCode(PRESTATION_CODE);
    }

    @Test
    public void when_getAllPrestationsMatchingRequestPrestationCategory_thengetAllPrestationsMatchingRequestPrestationCategoryAreReturned() {
        // given
        Prestation prestation = mock(Prestation.class);
        PrestationDTO prestationDTO = prestationMapper.toPrestationDTO(prestation);
        when(prestationRepository.getAllPrestationsMatchingRequestPrestationCategory(PRESTATION_CODE).stream()
                .map(prestationMapper::toPrestationDTO)
                .collect(Collectors.toList())).thenReturn(asList(prestationDTO, prestationDTO));

        // when
        List<PrestationDTO> allPrestationsMatchingRequestPrestationCategory = prestationService.getAllPrestationsMatchingRequestPrestationCategory(PRESTATION_CODE);

        // then
        verify(prestationRepository).getAllPrestationsMatchingRequestPrestationCategory(PRESTATION_CODE);
        assertEquals(2, allPrestationsMatchingRequestPrestationCategory.size());
    }
}

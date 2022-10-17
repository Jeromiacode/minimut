package be.fmsb.firebrick.prestation.app;

import be.fmsb.firebrick.prestation.app.dto.PrestationCreationDTO;
import be.fmsb.firebrick.prestation.app.dto.PrestationDTO;
import be.fmsb.firebrick.prestation.domain.Prestation;
import be.fmsb.firebrick.prestation.domain.PrestationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrestationService {

    private final PrestationRepository prestationRepository;
    private final PrestationMapper prestationMapper;

    public List<PrestationDTO> getAllPrestations() {
        return prestationRepository.findAll().stream()
                .map(prestationMapper::toPrestationDTO)
                .collect(Collectors.toList());
    }

    public List<PrestationDTO> getAllPrestationsMatchingRequestPrestationCategory(String prestationCode) {
        return prestationRepository.getAllPrestationsMatchingRequestPrestationCategory(prestationCode).stream()
                .map(prestationMapper::toPrestationDTO)
                .collect(Collectors.toList());
    }

    public PrestationDTO createPrestation(PrestationCreationDTO prestationCreationDTO) {
        Prestation prestation = prestationMapper.toPrestation(prestationCreationDTO);
        prestationRepository.save(prestation);

        return prestationMapper.toPrestationDTO(prestation);
    }

    public void deletePrestationByCode(String prestationCode) {
        prestationRepository.deletePrestationByCode(prestationCode);
    }

}

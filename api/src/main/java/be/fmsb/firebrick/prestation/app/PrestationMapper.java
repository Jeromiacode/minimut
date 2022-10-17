package be.fmsb.firebrick.prestation.app;

import be.fmsb.firebrick.prestation.app.dto.PrestationCreationDTO;
import be.fmsb.firebrick.prestation.app.dto.PrestationDTO;
import be.fmsb.firebrick.prestation.domain.Prestation;
import org.springframework.stereotype.Component;

@Component
public class PrestationMapper {

    public PrestationDTO toPrestationDTO(Prestation prestation) {
        return new PrestationDTO(prestation.getCode(),
                prestation.getDescription(),
                prestation.getStartDate(),
                prestation.getEndDate(),
                prestation.getPrice(),
                prestation.getCategory());
    }

    public Prestation toPrestation(PrestationCreationDTO prestationCreationDTO) {
        return new Prestation(prestationCreationDTO.getId(),
                prestationCreationDTO.getCode(),
                prestationCreationDTO.getDescription(),
                prestationCreationDTO.getStartDate(),
                prestationCreationDTO.getEndDate(),
                prestationCreationDTO.getPrice(),
                prestationCreationDTO.getCategory());
    }
}

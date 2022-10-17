package be.fmsb.firebrick.prestation.rest;

import be.fmsb.firebrick.prestation.app.PrestationService;
import be.fmsb.firebrick.prestation.app.dto.PrestationCreationDTO;
import be.fmsb.firebrick.prestation.app.dto.PrestationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestations")
@RequiredArgsConstructor
public class PrestationController {

    public final PrestationService prestationService;

    @GetMapping
    public List<PrestationDTO> getAllPrestations() {
        return prestationService.getAllPrestations();
    };

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrestationDTO createPrestation(@RequestBody PrestationCreationDTO prestationCreationDTO) {
        return prestationService.createPrestation(prestationCreationDTO);
    }

    @DeleteMapping("/{prestationCode}")
    public void deletePrestationByCode(@PathVariable String prestationCode) {
        prestationService.deletePrestationByCode(prestationCode);
    };
}

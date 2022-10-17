package be.fmsb.firebrick.request.rest;

import be.fmsb.firebrick.request.app.RequestService;
import be.fmsb.firebrick.request.app.dto.RequestCreationDTO;
import be.fmsb.firebrick.request.app.dto.RequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
public class RequestController {

    public final RequestService requestService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RequestDTO createRequest(@RequestBody RequestCreationDTO requestCreationDTO) {
        return requestService.createRequest(requestCreationDTO);
    }
}

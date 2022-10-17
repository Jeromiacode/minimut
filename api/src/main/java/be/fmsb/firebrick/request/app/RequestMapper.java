package be.fmsb.firebrick.request.app;

import be.fmsb.firebrick.request.app.dto.RequestCreationDTO;
import be.fmsb.firebrick.request.app.dto.RequestDTO;
import be.fmsb.firebrick.request.domain.Request;
import org.springframework.stereotype.Component;

@Component
public class RequestMapper {

    public RequestDTO toRequestDTO(Request request) {
        return new RequestDTO(request.getPrestationCode(),
                request.getAffiliateCode(),
                request.getDate());
    }

    public Request toRequest(RequestCreationDTO RequestCreationDTO) {
        return new Request(RequestCreationDTO.getId(),
                RequestCreationDTO.getPrestationCode(),
                RequestCreationDTO.getAffiliateCode(),
                RequestCreationDTO.getDate());
    }
}
package be.fmsb.firebrick.request.app;

import be.fmsb.firebrick.prestation.app.PrestationService;
import be.fmsb.firebrick.prestation.app.dto.PrestationDTO;
import be.fmsb.firebrick.request.app.dto.RequestCreationDTO;
import be.fmsb.firebrick.request.app.dto.RequestDTO;
import be.fmsb.firebrick.request.domain.Request;
import be.fmsb.firebrick.request.domain.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final PrestationService prestationService;
    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;

    public RequestDTO createRequest(RequestCreationDTO requestCreationDTO) {

        throwExceptionForRequestWithSamePrestationInCurrentYear(requestCreationDTO, requestRepository);

        throwExceptionForRequestByPrestationCategoryInSameQuarter(requestCreationDTO, requestRepository, prestationService);

        Request request = requestMapper.toRequest(requestCreationDTO);
        requestRepository.save(request);

        return requestMapper.toRequestDTO(request);
    }

    public void throwExceptionForRequestWithSamePrestationInCurrentYear(RequestCreationDTO requestCreationDTO, RequestRepository requestRepository) {

        Request requestWithPrestationInCurrentYear = requestRepository.getRequestByAffiliateCodeWithSamePrestationInCurrentYear(
                requestCreationDTO.getAffiliateCode(),
                requestCreationDTO.getPrestationCode(),
                (requestCreationDTO.getDate().getYear() + 1900)
        );

        if (requestWithPrestationInCurrentYear != null) {
            throw new IllegalArgumentException("There is already another request with the same prestation or the current year made by this affiliate");
        }
    }

    public void throwExceptionForRequestByPrestationCategoryInSameQuarter(RequestCreationDTO requestCreationDTO, RequestRepository requestRepository, PrestationService prestationService) {

        List<PrestationDTO> prestationsMatchingCategory = prestationService.getAllPrestationsMatchingRequestPrestationCategory(requestCreationDTO.getPrestationCode());
        List<String> prestationCodesMatchingCategory = prestationsMatchingCategory.stream().map(PrestationDTO::getCode).toList();

        List<Request> requestByPrestationCategoryInSameQuarter = requestRepository.getRequestByPrestationCategoryInSameQuarter(
                prestationCodesMatchingCategory,
                requestCreationDTO.getDate()
        );

        if (!requestByPrestationCategoryInSameQuarter.isEmpty()) {
            throw new IllegalArgumentException("There is already another request for the same prestation category in this quarter");
        }
    }

}

package be.fmsb.firebrick.request.app;

import be.fmsb.firebrick.request.app.dto.RequestCreationDTO;
import be.fmsb.firebrick.request.domain.Request;
import be.fmsb.firebrick.request.domain.RequestRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RequestServiceTest {

    private static final String PRESTATION_CODE = "PRESTATION_CODE";

    private static final String AFFILIATE_CODE = "AFFILIATE_CODE";

    private static final Date DATE = new Date();

    @Mock
    private RequestRepository requestRepository;

    @Mock
    private RequestMapper requestMapper;

    @InjectMocks
    private RequestService requestService;

    @Test
    public void when_createRequest_thenRequestIsCheckedThenReturnedIfValidAndIfNotValidAnErrorIsThrow() {
        // given
        RequestCreationDTO requestCreationDTO = mock(RequestCreationDTO.class);
        Request request = mock(Request.class);

        when(requestCreationDTO.getPrestationCode()).thenReturn(PRESTATION_CODE);
        when(requestCreationDTO.getAffiliateCode()).thenReturn(AFFILIATE_CODE);
        when(requestCreationDTO.getDate()).thenReturn(DATE);
        when(requestRepository.getRequestByAffiliateCodeWithSamePrestationInCurrentYear(
                requestCreationDTO.getAffiliateCode(),
                requestCreationDTO.getPrestationCode(),
                (requestCreationDTO.getDate().getYear() + 1900))).thenReturn(request);

        // when
        try {
            requestService.createRequest(requestCreationDTO);

            fail();
        } catch (IllegalArgumentException illegalArgumentException) {}
    }
}

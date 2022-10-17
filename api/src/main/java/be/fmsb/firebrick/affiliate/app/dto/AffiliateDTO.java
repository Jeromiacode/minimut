package be.fmsb.firebrick.affiliate.app.dto;

import be.fmsb.firebrick.affiliate.domain.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class AffiliateDTO {

    private String code;
    private String nationalNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate birthdate;
    private List<AddressDTO> addresses;

}

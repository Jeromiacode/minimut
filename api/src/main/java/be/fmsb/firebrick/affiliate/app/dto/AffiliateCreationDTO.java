package be.fmsb.firebrick.affiliate.app.dto;

import be.fmsb.firebrick.affiliate.domain.Address;
import be.fmsb.firebrick.affiliate.domain.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Data
public class AffiliateCreationDTO {

    @Id
    @Type(type="uuid-char")
    @GeneratedValue
    private UUID id;

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
    private List<Address> addresses;
}

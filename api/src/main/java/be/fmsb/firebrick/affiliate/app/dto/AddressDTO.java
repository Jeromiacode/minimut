package be.fmsb.firebrick.affiliate.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AddressDTO {

    private String street;
    private String streetNumber;
    private String postalCode;
    private String city;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate moveInDate;
    private Boolean isMain;

}

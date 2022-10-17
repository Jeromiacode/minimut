package be.fmsb.firebrick.affiliate.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@Table
public class Address {

    protected Address() {}

    @Id
    @Type(type="uuid-char")
    @GeneratedValue
    private UUID id;
    private String street;
    private String streetNumber;
    private String postalCode;
    private String city;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate moveInDate;
    private Boolean isMain;

}

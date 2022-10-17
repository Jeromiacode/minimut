package be.fmsb.firebrick.affiliate.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@Table
public class Affiliate {

    protected Affiliate() {}

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "affiliateId")
    private List<Address> addresses;

}

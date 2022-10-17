package be.fmsb.firebrick.prestation.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@Table
public class Prestation {

    protected Prestation() {}

    @Id
    @Type(type="uuid-char")
    @GeneratedValue
    private UUID id;
    private String code;
    private String description;
    private Date startDate;
    private Date endDate;
    private Integer price;

    @Enumerated(EnumType.STRING)
    private Category category;

}

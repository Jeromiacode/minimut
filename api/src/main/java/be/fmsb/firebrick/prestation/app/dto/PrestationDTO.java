package be.fmsb.firebrick.prestation.app.dto;

import be.fmsb.firebrick.prestation.domain.Category;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@AllArgsConstructor
public class PrestationDTO {

    private String code;
    private String description;
    private Date startDate;
    private Date endDate;
    private Integer price;

    @Enumerated(EnumType.STRING)
    private Category category;
}

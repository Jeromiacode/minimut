package be.fmsb.firebrick.request.app.dto;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Data
public class RequestCreationDTO {

    @Id
    @Type(type="uuid-char")
    @GeneratedValue
    private UUID id;
    private String prestationCode;
    private String affiliateCode;
    private Date date;

}
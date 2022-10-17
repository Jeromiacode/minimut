package be.fmsb.firebrick.request.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
public class Request {

    protected Request() {}

    @Id
    @Type(type="uuid-char")
    @GeneratedValue
    private UUID id;
    private String prestationCode;
    private String affiliateCode;
    private Date date;
}

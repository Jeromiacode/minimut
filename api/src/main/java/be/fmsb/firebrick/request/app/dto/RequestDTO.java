package be.fmsb.firebrick.request.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class RequestDTO {

    private String prestationCode;
    private String affiliateCode;
    private Date date;
}
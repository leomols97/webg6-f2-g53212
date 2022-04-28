package g53212.webg6.pae.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BMIResponse {
    private double bmi;
    private String corpulence;
}
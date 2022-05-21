package g53212.webg6.pae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import g53212.webg6.pae.business.BMIService;
import g53212.webg6.pae.model.BMIResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * BMIRest
 */

// @RestController
// @Slf4j
// public class BMIRest {

// @Autowired
// BMIService bmiService;

// @GetMapping(value = "/api/bmi", produces = "text/html; charset=UTF-8")
// public ModelAndView bmi(Model model,
// @RequestParam int height,
// @RequestParam int weight,
// @RequestParam String gender) {
// log.info("Rest: calcul du BMI");
// double bmi = bmiService.computeBMI(height, weight);
// String corpulence = bmiService.computeCategory(bmi, gender);
// model.addAttribute("bmi", bmi);
// model.addAttribute("corpulence", corpulence);
// return new ModelAndView("bmi::content");
// }
// }
@RestController
@RequestMapping("/api/bmi")
public class BMIRest {
    @Autowired
    private BMIService bmiService;

    @GetMapping
    public BMIResponse bmi(@RequestParam int height, @RequestParam int weight,
            @RequestParam String gender) {
        double bmi = bmiService.computeBMI(height, weight);
        String corpulence = bmiService.computeCategory(bmi, gender);
        return new BMIResponse(bmi, corpulence);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class BMIResponse {
        private double bmi;
        private String corpulence;
    }
}
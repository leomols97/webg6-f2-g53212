package g52006.webg6.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import g52006.webg6.pae.business.MyService;
import g52006.webg6.pae.model.Course;
import g52006.webg6.pae.model.Student;

@Controller
public class HomeController {

    @Autowired
    private MyService myService;

    @GetMapping("/")
    public String showIndex(Model model) {
        int ects = 3;
        System.out.println();
        System.out.println("Derived Queries Results");
        for (Course course : myService.getCourseWithGreaterEctsCountThan(ects)) {
            System.out.print(" " + course + " ");
        }
        System.out.println();

        for (Course course : myService.getCoursesResemblingByName("ommunication")) {
            System.out.print(" " + course + " ");
        }
        System.out.println();
        System.out.println("JPQL Queries Results");
        System.out.println(" getStudentNamesAndTheirAmountOfEcts Results");
        for (Object[] tuple : myService.getStudentNamesAndTheirAmountOfEcts()) {
            for (int i = 0; i < tuple.length; i++) {
                System.out.print("  " + tuple[i] + " ");
            }
            System.out.println();
        }
        System.out.println(" getStudentsWhoHaveHigherEctsCount Results");
        long ects2 = 4;
        for (Student student : myService.getStudentsWhoHaveHigherEctsCount(ects2)) {
            System.out.println("  " + student.toString());
        }
        model.addAttribute("username", "Leopold Mols");
        model.addAttribute("username", "Olivier Dyck");
        return "home";
    }
}
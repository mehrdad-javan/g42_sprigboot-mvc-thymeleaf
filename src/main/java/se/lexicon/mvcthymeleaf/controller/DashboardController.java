package se.lexicon.mvcthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        LocalDate currentDate = LocalDate.now();
        model.addAttribute("serverDate", currentDate);

        model.addAttribute("productListSize", 2);
        model.addAttribute("categoryListSize", 3);
        model.addAttribute("userListSize", 10);


        return "dashboard";
    }


}

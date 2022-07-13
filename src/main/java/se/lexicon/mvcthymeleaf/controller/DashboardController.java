package se.lexicon.mvcthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.lexicon.mvcthymeleaf.model.dto.CategoryView;
import se.lexicon.mvcthymeleaf.service.CategoryService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DashboardController {

    CategoryService categoryService;

    @Autowired
    public DashboardController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        LocalDate currentDate = LocalDate.now();
        model.addAttribute("serverDate", currentDate);


        model.addAttribute("productListSize", 2);
        model.addAttribute("categoryListSize", categoryService.categoriesSize());
        model.addAttribute("userListSize", 10);


        return "dashboard";
    }


}

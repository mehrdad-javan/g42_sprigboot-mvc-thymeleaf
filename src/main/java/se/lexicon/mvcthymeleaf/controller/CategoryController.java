package se.lexicon.mvcthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.lexicon.mvcthymeleaf.model.dto.CategoryView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    static List<CategoryView> categoryViews = new ArrayList<>();

    public CategoryController() {
        System.out.println("default data loaded");
        categoryViews.add(new CategoryView(1, "book", LocalDate.now()));
        categoryViews.add(new CategoryView(2, "laptop", LocalDate.now()));
        categoryViews.add(new CategoryView(3, "mobile", LocalDate.now()));
    }

    @GetMapping("/list")
    public String shoAllList(Model model) {
        model.addAttribute("categoryViews", categoryViews);

        return "category/categories-view";
    }

    @GetMapping("/view/{id}")
    public String findById(@PathVariable("id") Integer id, Model model) {
        System.out.println("ID:" + id);
        CategoryView categoryView = categoryViews.stream().filter(category -> category.getId() == id).findFirst().orElse(null);
        model.addAttribute("categoryView", categoryView);

        return "category/category-view";
    }


    @PostMapping("/view")
    public String findByIdPost(@RequestParam("id") Integer id, Model model) {
        System.out.println("ID:" + id);
        CategoryView categoryView = categoryViews.stream().filter(category -> category.getId() == id).findFirst().orElse(null);
        model.addAttribute("categoryView", categoryView);

        return "category/category-view";
    }


    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        System.out.println("ID:" + id);
        categoryViews.removeIf(view -> view.getId() == id);
        redirectAttributes.addFlashAttribute("message", "Category Id " + id + " was successfully deleted");
        redirectAttributes.addFlashAttribute("alertClass", "alert alert-info");
        return "redirect:/category/list";
    }

}

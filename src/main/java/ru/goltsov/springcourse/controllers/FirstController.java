package ru.goltsov.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname, Model model) {
//        System.out.println("Hello! " + name + " " + surname);
        model.addAttribute("message", "Hello! " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("goodbye")
    public String goodbayPage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a", required = false) int a,
                                 @RequestParam(value = "b", required = false) int b,
                                 @RequestParam(value = "c", required = false) String action,
                                 Model model) {
        double result = switch (action) {
            case "multiplication" -> a * b;
            case "addition" -> a + b;
            case "substruction" -> a - b;
            case "division" -> (double) a / (double) b;
            default -> 0;
        };
        model.addAttribute("return","Hello! Answer is " + result);
            return "first/calculator";
    }
}
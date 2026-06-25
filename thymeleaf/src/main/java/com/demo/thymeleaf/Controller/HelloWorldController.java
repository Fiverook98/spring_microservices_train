package com.demo.thymeleaf.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @PostMapping("/processFormV2")
    public String letsShoutDude(@RequestParam("firstName") String name, Model model){
        String result = "Hi " + name.toUpperCase();
        model.addAttribute("message", result);
        return "helloworld";
    }

}

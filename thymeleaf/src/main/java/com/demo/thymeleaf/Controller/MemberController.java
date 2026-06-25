package com.demo.thymeleaf.Controller;

import com.demo.thymeleaf.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("bindingForm")
    public String showBinding(Model memberModel){
        memberModel.addAttribute("member", new Member());
        return "data-binding-form";
    }

    @PostMapping("processBinding")
    public String ProcessBinding(@ModelAttribute("member") Member newMember){
        System.out.printf("The member: %s %s %s\n Favourite Language: %s", newMember.getFirstName(), newMember.getLastName(), newMember.getCountry(), newMember.getLanguage());

        return "data-binding-confirmation";
    }
}


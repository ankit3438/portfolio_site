package com.ankit.ankit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ankit.ankit.dto.ContactRequest;
import com.ankit.ankit.service.emailService;


@Controller
public class controller {
    @Autowired
    private emailService emailService;

    @GetMapping({"/home","","/"})
    public String home(){
        return "home";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("contactRequest", new ContactRequest());
        return "contact";
    }

    @GetMapping("/projects")
    public String projects(){
        return "projects";
    }

    @GetMapping("/resume")
    public String resume(){
        return "resume";
    }

    @PostMapping("/submit")
    public String submitContactForm(@ModelAttribute ContactRequest request, Model model) {
        emailService.sendContactEmail(request);
        model.addAttribute("successMessage", "Your message has been sent successfully!");
        return "contact"; // Return to the same contact page with success message
    }
    
}

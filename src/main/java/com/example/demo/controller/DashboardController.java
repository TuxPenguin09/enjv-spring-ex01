package com.example.demo.controller;

import com.example.demo.entity.PersonEntity;
import com.example.demo.repository.PersonRepository;
import com.example.demo.request.UserInputRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/dashboard")
    public String home(Model model){
        List<PersonEntity> getPersonEntities = personRepository.findAll();
        model.addAttribute("persons", getPersonEntities);
        return "index";
    }

    @GetMapping("/all")
    public String createPerson(Model model) {
        if (!model.containsAttribute("successMessage")) {
            model.addAttribute("successMessage", new UserInputRequest());
        }
        return "person/create";
    }

    @PostMapping("/submit")
    public String createPerson(@ModelAttribute UserInputRequest userInputRequest, RedirectAttributes redirectAttributes) {
        System.out.println(userInputRequest.getFirstName() + " " + userInputRequest.getLastName());
        PersonEntity personEntity = new PersonEntity();
        personEntity.setLastName(userInputRequest.getLastName());
        personEntity.setFirstName(userInputRequest.getFirstName());
        personRepository.save(personEntity);
        redirectAttributes.addAttribute("successMessage", "Person saved successfully!");
        return "redirect:/person/create";
    }

}

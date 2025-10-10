package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PokemonController {


    @GetMapping("/add/tet")
    public String createPokemon(Model model){
        return "pokemon/create";
    }
}

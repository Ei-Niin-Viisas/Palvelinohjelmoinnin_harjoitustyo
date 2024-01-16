package com.example.Harjoitustyo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import javax.xml.crypto.Data;

@Controller
public class HarjoitystyoController {
    @GetMapping("*")
    public String home(Model model) {
        model.addAttribute("teksti", new DataObject("Tuesday", 5));
        return "index";
    }
}

package com.example.Harjoitustyo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.io.Console;
import java.util.Calendar;

import javax.xml.crypto.Data;

@Controller
public class HarjoitystyoController {
    public DataObject[] luotaulukko() {
        int paivat = 6*7;
        DataObject[] taulukko = new DataObject[paivat];

        String[] viikonpaivat = {"sunnuntai", "maanantai", "tiistai",
                "keskiviikko", "torstai", "perjantai", "lauantai"};

        int pvm = Calendar.getInstance().get(Calendar.DATE);
        int viikonpaiva = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1;
        int kuukausi = Calendar.getInstance().get(Calendar.MONTH) + 1;



        for (int i = 0; i < paivat; i++) {
            DataObject paiva = new DataObject("Maanantai" , i);
            taulukko[i] = paiva;
        }

        return taulukko;
    }

    @GetMapping("*")
    public String home(Model model) {
        DataObject[] taulukko = luotaulukko();
        model.addAttribute("teksti",taulukko);
        return "index";
    }
}

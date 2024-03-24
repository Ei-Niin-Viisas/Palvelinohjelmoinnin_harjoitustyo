package com.example.Harjoitustyo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.Calendar;
//import java.time.LocalDate;
//import java.time.DayOfWeek;
import java.time.*;

@Controller
public class HarjoitystyoController {
    public DataObjectPaiva[] luotaulukko() {
        int paivat = 6*7;
        DataObjectPaiva[] taulukko = new DataObjectPaiva[paivat];

        LocalDate nykyinenPaivamaara = LocalDate.now();

        // Hanki kuukauden ensimmäinen päivä
        LocalDate kuukaudenEnsimmainenPaiva = nykyinenPaivamaara.withDayOfMonth(1);

        // Hanki viikonpäivä
        DayOfWeek viikonpaiva = kuukaudenEnsimmainenPaiva.getDayOfWeek();

        if (viikonpaiva.getValue() == 5){
            System.out.println("toimii");
        }

        LocalDate jotain = nykyinenPaivamaara.withDayOfMonth(1).plusDays(40);
        System.out.println(jotain);
        System.out.println(jotain.getDayOfMonth());

        System.out.println("Tämän kuukauden ensimmäinen viikonpäivä on: " + viikonpaiva);
        int luku = viikonpaiva.getValue()-1;

        int viimeinenPaiva = (nykyinenPaivamaara.withDayOfMonth(1).plusMonths(1).minusDays(1)).getDayOfMonth();

        int parasta = 1;

        for (int i = 0; i < paivat; i++) {
            if (i < luku) {
                LocalDate paiva = nykyinenPaivamaara.withDayOfMonth(1).minusDays(luku - i);
                DataObjectPaiva lisattava = new DataObjectPaiva(paiva.getDayOfWeek().name() , paiva.getDayOfMonth());
                taulukko[i] = lisattava;
            }
            else {
                LocalDate paiva = nykyinenPaivamaara.withDayOfMonth(1).plusDays(i-luku);
                DataObjectPaiva lisattava = new DataObjectPaiva(paiva.getDayOfWeek().name() , paiva.getDayOfMonth());
                taulukko[i] = lisattava;
            }
        }

        return taulukko;
    }

    @GetMapping("*")
    public String home(Model model) {
        DataObjectPaiva[] taulukko = luotaulukko();
        model.addAttribute("teksti",taulukko);
        return "index";
    }
}

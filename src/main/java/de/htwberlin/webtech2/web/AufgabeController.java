package de.htwberlin.webtech2.web;

import de.htwberlin.webtech2.web.api.Aufgabe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AufgabeController {

    private List<Aufgabe> aufgaben;

    public void AufgabeRestController() {
        aufgaben = new ArrayList<>();
        aufgaben.add(new Aufgabe(1, "Milch kaufen", "18.12.2021", false));
        aufgaben.add(new Aufgabe(2, "Klausur", "10.10.2020", true));
    }


    @GetMapping(path = "/api/w1/todo")
    public ResponseEntity<List<Aufgabe>> fetchTask() {
        return ResponseEntity.ok(aufgaben);
    }
}

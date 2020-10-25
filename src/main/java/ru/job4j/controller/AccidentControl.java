package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.job4j.model.Accident;
import ru.job4j.service.AccidentService;

import java.util.Collection;

@Controller
public class AccidentControl {

    private final AccidentService accidents;

    public AccidentControl(AccidentService accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create() {
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        this.accidents.addAccident(accident);
        return "redirect:/";
    }

    @GetMapping("/getAll")
    public ModelAndView getAllAccidents() {
        Collection<Accident> list = this.accidents.getAllAccidents();
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("allAccidents", list);
        return model;
    }
}

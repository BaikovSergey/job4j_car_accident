package ru.job4j.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.model.Accident;
import ru.job4j.service.AccidentService;

import java.util.Collection;


@Controller
public class IndexControl {

    private AccidentService accidentService;

    public IndexControl(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/")
    public String index(Model model) {
        Collection<Accident> list = this.accidentService.getAllAccidents();
        model.addAttribute("allAccidents", list);
        return "index";
    }

}

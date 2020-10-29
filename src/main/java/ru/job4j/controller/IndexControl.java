package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.service.AccidentHbmService;
import ru.job4j.service.AccidentJDBCService;



@Controller
public class IndexControl {

    private final AccidentHbmService hbmService;

    public IndexControl(AccidentHbmService hbmService) {
        this.hbmService = hbmService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("allAccidents", this.hbmService.findAll());
        return "index";
    }

}

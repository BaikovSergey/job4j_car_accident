package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.service.AccidentJDBCService;



@Controller
public class IndexControl {

    private final AccidentJDBCService serviceJDBC;

    public IndexControl(AccidentJDBCService serviceJDBC) {
        this.serviceJDBC = serviceJDBC;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("allAccidents", this.serviceJDBC.findAll());
        return "index";
    }

}

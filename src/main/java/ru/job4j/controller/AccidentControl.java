package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.job4j.model.Accident;
import ru.job4j.service.AccidentService;

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

    @GetMapping("/update")
    public String update(@RequestParam(name = "id") String id,
                         @RequestParam(name = "name") String name,
                         @RequestParam(name = "text") String text,
                         @RequestParam(name = "address") String address) {
        return "accident/update";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        this.accidents.addAccident(accident);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident) {
        this.accidents.updateAccident(accident);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        this.accidents.deleteAccident(id);
        return "redirect:/";
    }

}

package ru.job4j.controller;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Accident;
import ru.job4j.service.AccidentHbmService;

@Controller
public class AccidentControl {

    private final AccidentHbmService hbmService;

    public AccidentControl(AccidentHbmService hbmService) {
        this.hbmService = hbmService;
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
        this.hbmService.create(accident);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident) {
        this.hbmService.update(accident);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        this.hbmService.delete(id);
        return "redirect:/";
    }

    @RequestMapping( value="/getAllAccidents", method= RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getAll() {
        return new JSONArray(this.hbmService.findAll()).toString();
    }

}

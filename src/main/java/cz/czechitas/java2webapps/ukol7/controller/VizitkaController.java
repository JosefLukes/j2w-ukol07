package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.entity.Vizitka;
import cz.czechitas.java2webapps.ukol7.repository.VizitkaRepository;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class VizitkaController {

    private final VizitkaRepository vizitkaRepository;

    public VizitkaController(VizitkaRepository vizitkaRepository) {
        this.vizitkaRepository = vizitkaRepository;
    }


    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public Object seznam() {
        Iterable<Vizitka> vizitkas = vizitkaRepository.findAll();

        return new ModelAndView("seznam")
                .addObject("vizitkas", vizitkas);
    }

    @GetMapping(path = "/{id}")
    public Object detail(@PathVariable Integer id) {
        Optional<Vizitka> vizitka = vizitkaRepository.findById(id);

        if (vizitka.isPresent()) {
            return new ModelAndView("vizitka")
                    .addObject("vizitka", vizitka.get());

        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping(path = "/nova")
    public Object formularNovaVizitka() {
        return new ModelAndView("formular")
                .addObject("vizitka",new Vizitka());
    }

    @PostMapping(path = "/nova")
    public Object novaVizitka(@ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "formular";
        }
        vizitkaRepository.save(vizitka);
        return "redirect:/";
    }

    
}

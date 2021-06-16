package main;

import entity.MarvelHero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.MarvelHeroService;

import java.util.List;

@RestController
@RequestMapping("/front/marvel")
public class MarvelHeroController {

    @Autowired
    private MarvelHeroService service;

    @GetMapping("/{id}")
    public MarvelHero getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping
    public List<MarvelHero> getAll() {
        return service.findAll();
    }
}

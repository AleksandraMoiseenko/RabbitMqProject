package main;

import entity.MarvelHero;
import org.springframework.stereotype.Service;
import service.MarvelHeroService;

import java.util.Arrays;
import java.util.List;

@Service
public class MarvelHeroServiceImpl implements MarvelHeroService {

    private List<MarvelHero> heroes = Arrays.asList(new MarvelHero(1, "Captain America", 34, "USA"),
            new MarvelHero(2, "Black Widow", 32, "Russia"));

    @Override
    public MarvelHero findById(Integer id) {
        return heroes.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst()
                .orElse(new MarvelHero());
    }

    @Override
    public List<MarvelHero> findAll() {
        return heroes;
    }
}

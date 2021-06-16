package service;

import entity.MarvelHero;

import java.util.List;

public interface MarvelHeroService {

    MarvelHero findById (Integer id);
    List<MarvelHero> findAll();
}

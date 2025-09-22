package br.edu.ifsp.graphql.service;

import br.edu.ifsp.graphql.model.Starship;
import br.edu.ifsp.graphql.repository.StarshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarshipService {
    private final StarshipRepository starshipRepository;

    public StarshipService(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    public List<Starship> getAllStarships() {
        return starshipRepository.findAllStarships();
    }

    public Starship createStarship(int id, String name, Double length) {
        Starship newStarship = new Starship(id, name, length);
        return starshipRepository.saveStarship(newStarship);
    }
}

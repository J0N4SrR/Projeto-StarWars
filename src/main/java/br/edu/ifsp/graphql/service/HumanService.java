package br.edu.ifsp.graphql.service;

import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.repository.HumanRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HumanService {
    private final HumanRepository humanRepository;

    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    public List<Human> getAllHumans() {
        return humanRepository.findAllHumans();
    }

    public Human getHumanById(String id) {
        return humanRepository.findHumanById(id);
    }

    public Human createHuman(String name, String s, double height) {
        Human newHuman = new Human(null, name, new ArrayList<>(), new ArrayList<>(), height);
        return humanRepository.saveHuman(newHuman);
    }
}

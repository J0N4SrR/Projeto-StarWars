package br.edu.ifsp.graphql.service;

import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.repository.DroidsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DroidsService {
    private final DroidsRepository droidRepository;

    public DroidsService(DroidsRepository droidRepository) {
        this.droidRepository = droidRepository;
    }

    public List<Droid> getAllDroids() {
        return droidRepository.findAllDroids();
    }

    public Droid getDroidById(String id) {
        return droidRepository.findDroidById(id);
    }

    public Droid createDroid(String id, String name, String primaryFunction) {
        Droid newDroid = new Droid(id, name, new ArrayList<>(), new ArrayList<>(), primaryFunction);
        return droidRepository.saveDroid(newDroid);
    }
}

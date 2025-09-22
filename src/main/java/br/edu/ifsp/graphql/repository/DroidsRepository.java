package br.edu.ifsp.graphql.repository;

import br.edu.ifsp.graphql.model.Droid;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static br.edu.ifsp.graphql.util.Utilities.ConvertToNumeric;
import static br.edu.ifsp.graphql.util.Utilities.isNumeric;

@Repository
public class DroidsRepository {

    private final List<Droid> droids = new ArrayList<>();

    public List<Droid> findAllDroids(){
        return droids;
    }

    public Droid findDroidById(String id){
        if(isNumeric(id)) {
            int index = ConvertToNumeric(id);
            if (index >= 0 && index < droids.size()) {
                return droids.get(index);
            }
        }
        return null;
    }

    public Droid saveDroid(Droid droid) {
        droids.add(droid);
        return droid;
    }

    public Droid updateDroid(String id, Droid droidToUpdate) {
        if(isNumeric(id)){
            int index = ConvertToNumeric(id);
            if (index >= 0 && index < droids.size()) {
                droids.set(index, droidToUpdate);
                return droids.get(index);
            }
        }
        return null;
    }

    public Droid updateDroid(Droid droidToUpdate) {
        for (int i = 0; i < droids.size(); i++) {
            if (droids.get(i).getId().equals(droidToUpdate.getId())) {
                droids.set(i, droidToUpdate);
                return droidToUpdate;
            }
        }
        return null;
    }

    public boolean deleteDroid(String id){
        if(isNumeric(id)){
            int index = ConvertToNumeric(id);
            if (index >= 0 && index < droids.size()) {
                droids.remove(index);
                return true;
            }
        }
        return false;
    }
}
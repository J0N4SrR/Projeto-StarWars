package br.edu.ifsp.graphql.repository;

import br.edu.ifsp.graphql.model.Human;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static br.edu.ifsp.graphql.util.Utilities.ConvertToNumeric;
import static br.edu.ifsp.graphql.util.Utilities.isNumeric;

@Repository
public class HumanRepository {
    private final List<Human> humans = new ArrayList<>();

    public List<Human> findAllHumans(){
        return humans;
    }

    public Human findHumanById(String id){
        if(isNumeric(id)) {
            int index = ConvertToNumeric(id);
            if (index >= 0 && index < humans.size()) {
                return humans.get(index);
            }
        }
        return null;
    }

    public Human saveHuman(Human human) {
        humans.add(human);
        return human;
    }

    public Human updateHuman(String id, Human humanToUpdate) {
        if(isNumeric(id)){
            humans.set(ConvertToNumeric(id), humanToUpdate);
            return humans.get(ConvertToNumeric(id));
        }
        return null;
    }

    public Human updateHuman(Human humanToUpdate) {
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).getId().equals(humanToUpdate.getId())) {
                humans.set(i, humanToUpdate);
                return humanToUpdate;
            }
        }
        return null;
    }

    public boolean deleteHuman(String id){
        if(isNumeric(id)){
            int index = ConvertToNumeric(id);
            if (index >= 0 && index < humans.size()) {
                humans.remove(index);
                return true;
            }
        }
        return false;
    }

}

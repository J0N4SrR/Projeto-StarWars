package br.edu.ifsp.graphql.repository;

import br.edu.ifsp.graphql.model.Starship;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static br.edu.ifsp.graphql.util.Utilities.ConvertToNumeric;
import static br.edu.ifsp.graphql.util.Utilities.isNumeric;

@Repository
public class StarshipRepository {

    private final List<Starship> starships = new ArrayList<>();

    public List<Starship> findAllStarships(){
        return starships;
    }

    public Starship findStarshipById(String id){
        if(isNumeric(id)) {
            int index = ConvertToNumeric(id);
            if (index >= 0 && index < starships.size()) {
                return starships.get(index);
            }
        }
        return null;
    }

    public Starship saveStarship(Starship starship) {
        starships.add(starship);
        return starship;
    }

    public Starship updateStarship(Starship starshipToUpdate) {
        for (int i = 0; i < starships.size(); i++) {
            if (starships.get(i).getId() == starshipToUpdate.getId()) {
                  starships.set(i, starshipToUpdate);
                return starshipToUpdate;
            }
        }
        return null;
    }

    public boolean deleteStarship(int id){
            if (id >= 0 && id < starships.size()) {
                starships.remove(id);
                return true;
            }

        return false;
    }
}

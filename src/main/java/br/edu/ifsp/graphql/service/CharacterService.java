package br.edu.ifsp.graphql.service;

import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.repository.DroidsRepository;
import br.edu.ifsp.graphql.repository.HumanRepository;
import br.edu.ifsp.graphql.model.Character;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private final HumanRepository humanRepository;
    private final DroidsRepository droidsRepository; // Use o nome exato da sua classe

    public CharacterService(HumanRepository humanRepository, DroidsRepository droidsRepository) {
        this.humanRepository = humanRepository;
        this.droidsRepository = droidsRepository;
    }


    public Character findCharacterById(String id) {
        Human human = humanRepository.findHumanById(id);
        if (human != null) {
            return human;
        }

        Droid droid = droidsRepository.findDroidById(id);
        if (droid != null) {
            return droid;        }

        return null;
    }

    public Character addFriend(String characterId, String friendId) {
        Character character = findCharacterById(characterId);
        Character friend = findCharacterById(friendId);

        if (character != null && friend != null) {

            if (!character.getFriends().contains(friend)) {
                character.getFriends().add(friend);
            }

            return character;
        }

        return null;
    }
}

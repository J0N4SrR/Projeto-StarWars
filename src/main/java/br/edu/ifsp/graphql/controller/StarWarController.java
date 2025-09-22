package br.edu.ifsp.graphql.controller;

import java.util.List;

import br.edu.ifsp.graphql.service.CharacterService;
import br.edu.ifsp.graphql.service.DroidsService;
import br.edu.ifsp.graphql.service.HumanService;
import br.edu.ifsp.graphql.service.StarshipService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.model.Starship;

@Controller
public class StarWarController {
    private final HumanService humanService;
    private final DroidsService droidsService;
    private final StarshipService starshipService;
    private final CharacterService characterService;


    public StarWarController(
            HumanService humanService,
            DroidsService droidsService,
            StarshipService starshipService, CharacterService characterService) {
        this.humanService = humanService;
        this.droidsService = droidsService;
        this.starshipService = starshipService;
        this.characterService = characterService;


    }

    @QueryMapping
    public List<Human> humans() {
        return humanService.getAllHumans();
    }

    @QueryMapping
    public List<Starship> starships() {
        return starshipService.getAllStarships();
    }

    @QueryMapping
    public Character character(@Argument String id) {
        return characterService.findCharacterById(id);
    }


    @MutationMapping
    public Human createHuman(@Argument String id, @Argument String name, @Argument Double height) {
        return humanService.createHuman(id, name, height);
    }

    @MutationMapping
    public Droid createDroid(@Argument String id, @Argument String name, @Argument String primaryFunction) {
        return droidsService.createDroid(id, name, primaryFunction);
    }

    @MutationMapping
    public Starship createStarship(@Argument String id, @Argument String name, @Argument Double length) {
        return starshipService.createStarship(Integer.parseInt(id), name, length);
    }

    @MutationMapping
    public Character addFriend(@Argument String characterId, @Argument String friendId) {
        return characterService.addFriend(characterId, friendId);
    }




}

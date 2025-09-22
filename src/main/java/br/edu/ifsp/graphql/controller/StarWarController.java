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
import br.edu.ifsp.graphql.model.Episode;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.model.Review;
import br.edu.ifsp.graphql.model.ReviewInput;
import br.edu.ifsp.graphql.model.Starship;

@Controller
public class StarWarController {
    private final HumanService humanService;
    private final DroidsService droidService;
    private final StarshipService starshipService;
    private final CharacterService characterService;


    public StarWarController(
            HumanService humanService,
            DroidsService droidService,
            StarshipService starshipService, CharacterService characterService) {
        this.humanService = humanService;
        this.droidService = droidService;
        this.starshipService = starshipService;
        this.characterService = characterService;


    }


    @QueryMapping
    public List<Human> humans() {
        // Delega a tarefa para o serviço. Nenhuma lógica aqui.
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

    @QueryMapping
    public Character hero(@Argument Episode episode) {
        return new Droid(
                "2001", 
                "R2-D2", 
                List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI), 
                List.of(),
                "Astromech"
        );
    }

    @QueryMapping
    public Droid droid(@Argument String id) {
        return new Droid(
            id, 
            "R2-D2",
            List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI),
            List.of(), 
            "Astromech"
        );
    }


    @QueryMapping
    public List<Object> search(@Argument String text) {
        return List.of(
                new Droid("2001", "R2-D2", List.of(), List.of(), "Astromech"),
                new Human("1001", "Luke", List.of(), List.of(), 1.72f),
                new Starship(3000, "Millenium Falcon", 1000));
    }


    @MutationMapping
    public Review createReview(@Argument Episode episode, @Argument ReviewInput review) {
        return new Review(review.getStars(), review.getCommentary());
    }

    @MutationMapping
    public Human createHuman(@Argument String id, @Argument String name, @Argument Double height) {
        return humanService.createHuman(id, name, height);
    }

    @MutationMapping
    public Droid createDroid(@Argument String id, @Argument String name, @Argument String primaryFunction) {
        return droidService.createDroid(id, name, primaryFunction);
    }

    @MutationMapping
    public Starship createStarship(@Argument int id, @Argument String name, @Argument Double length) {
        return starshipService.createStarship(id, name, length);
    }

    @MutationMapping
    public Character addFriend(@Argument String characterId, @Argument String friendId) {
        return characterService.addFriend(characterId, friendId);
    }


}

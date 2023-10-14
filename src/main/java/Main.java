import configuration.inyectors.RepositoryModule;
import core.repositories.PokemonApiRepositoryInterface;
import repositories.PokemonApiRepository;

import static com.google.inject.Guice.createInjector;

public class Main {
    private static PokemonApiRepository pokemonApiRepository = new PokemonApiRepository();

    public static void main (String [ ] args) {
        createApplicationInjectors();

        PokemonApiRepositoryInterface.PokemonModel requestModel =
                PokemonApiRepositoryInterface.PokemonModel.builder()
                        .name("charizard")
                        .build();

        pokemonApiRepository.getPokemon(requestModel);
    }

    private static void createApplicationInjectors(){
        createInjector(new RepositoryModule());
    }
}
package configuration.inyectors;

import com.google.inject.AbstractModule;
import core.repositories.PokemonApiRepositoryInterface;
import repositories.PokemonApiRepository;

public class RepositoryModule extends AbstractModule{

    @Override
    protected void configure(){
        bind(PokemonApiRepositoryInterface.class).to(PokemonApiRepository.class);
    }
}

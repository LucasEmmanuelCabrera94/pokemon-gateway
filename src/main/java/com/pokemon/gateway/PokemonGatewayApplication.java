package com.pokemon.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pokemon.gateway.core.repositories.PokemonApiRepositoryInterface;
import com.pokemon.gateway.repositories.PokemonApiRepository;

@SpringBootApplication
public class PokemonGatewayApplication {
	private static final PokemonApiRepository pokemonApiRepository = new PokemonApiRepository();

	public static void main(String[] args) {
		SpringApplication.run(PokemonGatewayApplication.class, args);
		
		PokemonApiRepositoryInterface.PokemonModel requestModel =
				PokemonApiRepositoryInterface.PokemonModel.builder()
						.name("charizard")
						.build();

		pokemonApiRepository.getPokemon(requestModel);
	}

}

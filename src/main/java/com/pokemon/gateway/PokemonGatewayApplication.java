package com.pokemon.gateway;

import com.pokemon.gateway.core.controller.RestController;
import com.pokemon.gateway.core.dto.pokemon.PokemonDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pokemon.gateway.core.repositories.PokemonApiRepositoryInterface;
import com.pokemon.gateway.repositories.PokemonApiRepository;

@SpringBootApplication
public class PokemonGatewayApplication {
	private static final PokemonApiRepository pokemonApiRepository = new PokemonApiRepository();

	public static void main(String[] args) {
		SpringApplication.run(PokemonGatewayApplication.class, args);
		RestController restController = new RestController();
		PokemonDTO charizard = restController.get();
		System.out.println(charizard);

	}

}

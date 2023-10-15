package com.pokemon.gateway.core.controller;

import com.pokemon.gateway.core.dto.pokemon.PokemonDTO;
import com.pokemon.gateway.core.repositories.PokemonApiRepositoryInterface;
import com.pokemon.gateway.repositories.PokemonApiRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/url")
public class RestController {
    private static final PokemonApiRepository pokemonApiRepository = new PokemonApiRepository();

    @RequestMapping(method = RequestMethod.GET, value = "/pokemon")
    public PokemonDTO get(){
    PokemonApiRepositoryInterface.PokemonModel requestModel =
            PokemonApiRepositoryInterface.PokemonModel.builder()
                    .name("charizard")
                    .build();

		return pokemonApiRepository.getPokemon(requestModel);
    }
}

package com.pokemon.gateway.core.repositories;

import com.pokemon.gateway.core.dto.pokemon.PokemonDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface PokemonApiRepositoryInterface {

    PokemonDTO getPokemon(PokemonModel pokemon);

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class PokemonModel {
        private String name;
    }
}

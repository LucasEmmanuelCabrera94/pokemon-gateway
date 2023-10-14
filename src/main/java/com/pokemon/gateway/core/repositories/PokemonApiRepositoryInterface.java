package com.pokemon.gateway.core.repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface PokemonApiRepositoryInterface {

    void getPokemon(PokemonModel pokemon);

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class PokemonModel {
        private String name;
    }
}
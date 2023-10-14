package com.pokemon.gateway.repositories;

import com.google.gson.Gson;
import com.pokemon.gateway.core.dto.pokemon.PokemonDTO;
import com.pokemon.gateway.core.repositories.PokemonApiRepositoryInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PokemonApiRepository implements PokemonApiRepositoryInterface {
    private static final String apiUrl = "https://pokeapi.co/api/v2/pokemon/%s";

    public void getPokemon(PokemonModel pokemon) {
        try{
            URL url = new URL(String.format(apiUrl, pokemon.getName()));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            validateResponse(responseCode);

            consumeResponse(connection);
        } catch (Exception e){
            //TODO: hacer throw new Exceptions
            e.printStackTrace();
        }
    }

    private static void validateResponse(int responseCode) throws Exception {
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception("Error al realizar la solicitud. Código de respuesta: " + responseCode);
        }
    }

    private static void consumeResponse(HttpURLConnection connection) throws IOException {
        // Leer la respuesta del servidor
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Gson gson = new Gson();
        PokemonDTO pokemonDTO = gson.fromJson(response.toString(), PokemonDTO.class);
        System.out.println(pokemonDTO.toString());

    }
}

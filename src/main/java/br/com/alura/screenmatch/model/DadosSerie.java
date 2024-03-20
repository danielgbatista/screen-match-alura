package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// @JsonProperty normalmente utilizado para definir o nome da propriedade JSON que está associada ao campo
// @JsonAlias normalmente utilizado para definir um ou mais apelidos para o nome da propriedade JSON associada
// @JsonIgnoreProperties utilizado para ignorar as propriedades não mapeadas pela nossa classe
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalTemporadas,
        @JsonAlias("imdbRating") Double avaliacao,
        @JsonAlias("Poster") String cartaz,
        @JsonAlias("Genre") String genero,
        @JsonAlias("Plot") String sinopse,
        @JsonAlias("Actors") String atores
        ) {}

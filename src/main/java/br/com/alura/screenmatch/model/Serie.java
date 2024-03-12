package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonProperty normalmente utilizado para definir o nome da propriedade JSON que está associada ao campo
// @JsonAlias normalmente utilizado para definir um ou mais apelidos para o nome da propriedade JSON associada
// @JsonIgnoreProperties utilizado para ignorar as propriedades não mapeadas pela nossa classe
@JsonIgnoreProperties(ignoreUnknown = true)
public record Serie(@JsonAlias("Title") String titulo,
                    @JsonAlias("totalSeasons") Integer temporada,
                    @JsonAlias("imdbRating") Double avaliacao) {

}

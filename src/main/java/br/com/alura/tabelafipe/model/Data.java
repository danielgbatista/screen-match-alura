package br.com.alura.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Data(
        @JsonAlias("code") String code,
        @JsonAlias("name") String name
) {}

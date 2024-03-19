package br.com.alura.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Datas(
        @JsonAlias("codigo") String code,
        @JsonAlias("nome") String name
) {}

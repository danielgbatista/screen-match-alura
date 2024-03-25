package br.com.alura.screenmusic.model;

import br.com.alura.screenmatch.model.Categoria;

public enum Tipo {
    SOLO("solo"),
    DUPLA("dupla"),
    BANDA("banda");
    private String tipoPortugues;
    Tipo(String tipoPortugues){};

    public static Tipo fromString(String text) {
        for (br.com.alura.screenmusic.model.Tipo tipo : br.com.alura.screenmusic.model.Tipo.values()) {
            if (tipo.tipoPortugues.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}

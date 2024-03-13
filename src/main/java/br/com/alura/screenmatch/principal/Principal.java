package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.service.ConsumoApi;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO;
    private final String API_KEY;

    public Principal() {
        this.ENDERECO = "https://www.omdbapi.com/?t=";
        this.API_KEY = "&apikey=7ff69bd3";
    }

    public void exibeMenu(){
        System.out.println("Digite o nome da série para buscar:");
        var nomeSerie = leitura.nextLine();

        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

    }
}

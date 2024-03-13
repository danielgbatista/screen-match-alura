package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.model.Temporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

// Como é uma aplicação via linha de comando é necessário utilizar do CommandLineRunner.
@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primeiro projeto Spring sem Web");
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=7ff69bd3");
		System.out.println("JSON puro: " + json);

		ConverteDados conversor = new ConverteDados();
		Serie serie = conversor.obterDados(json, Serie.class);
		System.out.println("JSON da serie convertido:" + json);

		json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=7ff69bd3");
		Episodio episodio = conversor.obterDados(json, Episodio.class);
		System.out.println("JSON do episodio convertido: " + episodio);
		List<Temporada> temporadas = new ArrayList<>();

		for(int i = 1; i <= serie.totalTemporadas(); i++){
			json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season="+ i +"&apikey=7ff69bd3");
			Temporada temporada = conversor.obterDados(json, Temporada.class);
			temporadas.add(temporada);
		}

		temporadas.forEach(System.out::println);
	}
}

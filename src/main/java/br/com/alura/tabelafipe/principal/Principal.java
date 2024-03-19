package br.com.alura.tabelafipe.principal;

import br.com.alura.tabelafipe.model.*;
import br.com.alura.tabelafipe.service.Consume;
import br.com.alura.tabelafipe.service.ConvertData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Consume consumer = new Consume();
    private Scanner reader = new Scanner(System.in);
    private ConvertData converter = new ConvertData();
    private final String QUERY_URL;

    public Principal (){
        this.QUERY_URL = "https://parallelum.com.br/fipe/api/v1/";
    }

    public void fipeConsultation() {
        System.out.println("**** OPÇÕES ****");
        System.out.println("Carro");
        System.out.println("Moto");
        System.out.println("Caminhão\n");
        System.out.println("Digite o tipo do veículo que deseja buscar:");

        var chosenModel = reader.nextLine();

        if("CARRO".equals(chosenModel.toUpperCase())){
            chosenModel = "carros/marcas/";
        } else if ("MOTO".equals(chosenModel.toUpperCase())) {
            chosenModel = "motos/marcas/";
        } else {
            chosenModel = "caminhoes/marcas/";
        }

        var json = consumer.runQuery(QUERY_URL + chosenModel);
        var brands = converter.getList(json, Datas.class);
        brands.stream()
                .sorted(Comparator.comparing(Datas::code))
                .forEach(System.out::println);

        System.out.println("Digite o código da marca escolhida: ");
        var brandId = reader.nextInt();

        System.out.println("\n Modelos dessa marca:");
        json = consumer.runQuery(QUERY_URL + chosenModel + brandId + "/modelos/");
        var models = converter.getData(json, Brands.class);
        models.models().stream()
                .sorted(Comparator.comparing(Datas::code))
                .forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do carro a ser buscado");
        var filterName = reader.next();

        System.out.println(filterName);
        List<Datas> filtedModels = models.models().stream()
                .filter(m -> m.name().toLowerCase().contains(filterName.toLowerCase()))
                .toList();

        System.out.println("\nModelos filtrados: ");
        filtedModels.forEach(System.out::println);

        System.out.println("Digite por favor o código do modelo para buscar os valores de avaliação");
        var modelId = reader.nextInt();

        json = consumer.runQuery(QUERY_URL + chosenModel + brandId + "/modelos/" + modelId + "/anos/");
        List<Datas> years = converter.getList(json, Datas.class);
        List<Vehicle> vehicles = new ArrayList<>();


        for (int i = 0; i < years.size(); i++) {
            var yearsUrl = QUERY_URL + chosenModel + brandId + "/modelos/" + modelId + "/anos/" + years.get(i).code();
            json = consumer.runQuery(yearsUrl);
            Vehicle vehicle = converter.getData(json, Vehicle.class);
            vehicles.add(vehicle);
        }

        System.out.println("\nTodos os veículos filtrados com avaliações por ano");
        vehicles.forEach(System.out::println);


    }
}

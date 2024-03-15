package br.com.alura.tabelafipe.principal;

import br.com.alura.tabelafipe.model.*;
import br.com.alura.tabelafipe.service.Consume;
import br.com.alura.tabelafipe.service.ConvertData;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Consume consumer = new Consume();
    private Scanner reader = new Scanner(System.in);
    private ConvertData converter = new ConvertData();
    private final String QUERY_URL;

    public Principal (){
        this.QUERY_URL = "https://parallelum.com.br/fipe/api/v2/";
    }

    public void fipeConsultation() {
        System.out.println("**** OPÇÕES ****");
        System.out.println("Carro");
        System.out.println("Moto");
        System.out.println("Caminhão\n");
        System.out.println("Digite o tipo do veículo que deseja buscar:");

        var chosenModel = reader.nextLine();

        if("CARRO".equals(chosenModel.toUpperCase())){
            chosenModel = "cars/brands/";
        } else if ("MOTO".equals(chosenModel.toUpperCase())) {
            chosenModel = "motorcycles/brands/";
        } else {
            chosenModel = "trucks/brands/";
        }

        var json = consumer.runQuery(QUERY_URL + chosenModel);

        List<Data> brands = converter.getList(json, Data.class);

        brands.stream()
                .map(b -> new Brand(b.code(), b.name()))
                .forEach(System.out::println);

        System.out.println("Digite o código da marca escolhida: ");
        var brandId = reader.nextInt();

        json = consumer.runQuery(QUERY_URL + chosenModel + brandId + "/models");

        List<Data> models = converter.getList(json, Data.class);

        models.stream()
                .map(m -> new Model(m.code(), m.name()))
                .forEach(System.out::println);

        if(models.size() > 2){
            System.out.println("Digite um trecho do nome do veículo para consulta: ");
            var modelFilter = reader.next();

            models.stream()
                    .filter(m -> m.name().toUpperCase().contains(modelFilter.toUpperCase()))
                    .map(m -> new Model(m.code(), m.name()))
                    .forEach(System.out::println);
        }

        System.out.println("Digite o código do modelo escolhido: ");
        var modelId = reader.nextInt();

        json = consumer.runQuery(QUERY_URL + chosenModel + brandId + "/models/" + modelId + "/years/");

        List<Data> years = converter.getList(json, Data.class);

        years.stream()
                .map(y -> new Year(y.code(), y.name()))
                .forEach(y -> );


    }
}

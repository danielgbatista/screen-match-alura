package br.com.alura.tabelafipe.model;

public class Model {
    private String code;
    private String name;

    public Model(String code, String model){
        this.code = code;
        this.name = model;
    }

    @Override
    public String toString() {
        return "Código:" + code +
                " Modelo:" + name ;
    }
}

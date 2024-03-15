package br.com.alura.tabelafipe.model;

public class Brand {
    private String code;
    private String name;

    public Brand(String code, String brand){
        this.code = code;
        this.name = brand;
    }


    @Override
    public String toString() {
    return "Código: " + code +
            " Modelo: " + name;
    }
}

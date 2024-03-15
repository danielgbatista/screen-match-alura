package br.com.alura.tabelafipe.model;

public class Year {
    private String code;
    private String name;

    public Year(String code, String name){
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return  "Código: " + code +
                " Descrição: " + name;
    }
}

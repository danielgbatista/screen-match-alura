package br.com.alura.tabelafipe.model;

public class Models {
    private String code;
    private String name;

    public Models(String code, String model){
        this.code = code;
        this.name = model;
    }

    @Override
    public String toString() {
        return "Código:" + code +
                " Descrição:" + name ;
    }
}

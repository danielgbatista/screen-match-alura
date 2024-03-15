package br.com.alura.tabelafipe;

import br.com.alura.tabelafipe.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelafipeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(br.com.alura.tabelafipe.TabelafipeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var principal = new Principal();
        principal.fipeConsultation();
    }
}
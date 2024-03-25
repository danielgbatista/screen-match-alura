package br.com.alura.screenmusic;


import br.com.alura.screenmusic.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmusicApplication implements CommandLineRunner {
//        @Autowired
//        private SerieRepository repositorio;

        public static void main(String[] args) {
            SpringApplication.run(ScreenmusicApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {
            Principal principal = new Principal();
            principal.exibeMenu();
        }

}

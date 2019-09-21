package bt.com.veggie.burgers.estoque;

import bt.com.veggie.burgers.estoque.desktop.Tela;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstoqueApplication {
    public static void main(String[] args) {
        SpringApplication.run(EstoqueApplication.class, args);
        Tela.run(args);
    }

}

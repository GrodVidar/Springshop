package co.uk.jdreamer.shoppingcart;
import co.uk.jdreamer.shoppingcart.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@AutoConfigureBefore(ErrorMvcAutoConfiguration.class)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)

//Gammal annotation
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CmsShoppingCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsShoppingCartApplication.class, args);
    }
}
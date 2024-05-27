package shopping.com.shopping_backend_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ShoppingBackend1Application {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingBackend1Application.class, args);
	}

}

package restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import restservice.dateAccess.GatherDrinkData;

@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RestServiceApplication.class, args);
        GatherDrinkData data = context.getBean(GatherDrinkData.class);
        data.initialize();

    }

}

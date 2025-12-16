package edu.wgu.d288.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import edu.wgu.d288.entities.Country;
import edu.wgu.d288.entities.Division;
import edu.wgu.d288.entities.Customer;
import edu.wgu.d288.entities.Cart;
import edu.wgu.d288.entities.CartItem;
import edu.wgu.d288.entities.Vacation;
import edu.wgu.d288.entities.Excursion;

@Configuration
public class RestDataConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {


        config.exposeIdsFor(
                Country.class,
                Division.class,
                Customer.class,
                Cart.class,
                CartItem.class,
                Vacation.class,
                Excursion.class
        );
    }
}

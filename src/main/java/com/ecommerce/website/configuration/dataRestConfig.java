package com.ecommerce.website.configuration;

import com.ecommerce.website.Entity.Product;
import com.ecommerce.website.Entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class dataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupporetedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        //Disable HTTP methods for Product: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupporetedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupporetedActions));

        //Disable HTTP methods for ProductCategory: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupporetedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupporetedActions));
    }
}

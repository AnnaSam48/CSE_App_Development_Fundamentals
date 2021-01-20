package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import java.util.Collections;


@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket apiDocket() {
        //returns prepared Docket instance
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.acenture.applicationDevelopmentFundamentals.movieRatingApp"))
                .paths(PathSelectors.ant("*/movie/*"))
                .build()
                .apiInfo(movieRatingAPIDetails());
    }


    /**Customized info about API in swagger file
     * (http..your-app-root/swagger-ui/index.html -example uri for documentation
     */
    //TODO change example uri to uri for this API's documentation
    private ApiInfo movieRatingAPIDetails(){
        return new ApiInfo("Movie Rating API",
                "Simple movie rating application to rate movies",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Movie Rating API Team",
                        "https://awesomemovieratings.com","OurSuperE@mail.com"),
                "MovieRatingAPI Licence",
                "http://awesomeRatingsLicense.com",
                Collections.emptyList());
    }
}

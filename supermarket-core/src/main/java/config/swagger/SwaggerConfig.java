package config.swagger;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author Kavinda
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("greenleaf-api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.beepatterns.greenleaf.controller"))
                .paths(postPaths())
                .build()
                .apiInfo(apiInfo());
    }

    private Predicate<String> postPaths() {
        //return or(regex("/.*"));
        return or(regex("/user.*"),
                regex("/property.*"),
                regex("/bought_leaf.*"),
                regex("/supplier.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Greenleaf rest API")
                .description("Spring boot rest api for greenleaf")
                .termsOfServiceUrl("http://beepatterns.lk")
                .contact(contact())
                //.license("beepatterns License")
                //.licenseUrl("naskavinda@gmail.com")
                .version("1.0.0")
                .build();
    }

    public Contact contact() {
        return new Contact(" Supun Kavinda", "", "naskavinda@gmail.com");
    }


}

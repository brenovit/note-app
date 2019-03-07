package br.com.friends.noteapp.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Value("${version}")
	private String version;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.friends.noteapp.controller.api"))
                .paths(regex("/api/.*"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getAPIInfo());
	}
	
	 private ApiInfo getAPIInfo() {
	        return new ApiInfoBuilder()
	                .title("NotaAqui")
	                .description("\"API de lembretes do NotaAqui\"")
	                .version(version)
	                .contact(new Contact("Friends", "http://www.notaaqui.com.br/Conteudo/Pagina/QuemSomos", ""))
	                .build();
	    }
}

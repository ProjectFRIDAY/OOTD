package OOTD.demo.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "OOTD API Specification",
                description = "OOTD API 명세서",
                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi ootdApi() {
        String[] paths = {"/**"};

        return GroupedOpenApi.builder()
                .group("OOTD API v1")
                .pathsToMatch(paths)
                .build();
    }
}

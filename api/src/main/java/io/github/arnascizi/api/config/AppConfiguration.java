package io.github.arnascizi.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
@ComponentScan({"io.github.arnascizi"})
@EntityScan("io.github.arnascizi.model")
public class AppConfiguration {
}

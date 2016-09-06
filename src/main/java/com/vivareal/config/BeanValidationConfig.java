package com.vivareal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validator;

import static javax.validation.Validation.buildDefaultValidatorFactory;

@Configuration
public class BeanValidationConfig {

    @Bean
    Validator getValidator() {
        return buildDefaultValidatorFactory().getValidator();
    }

}

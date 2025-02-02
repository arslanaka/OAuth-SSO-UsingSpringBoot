package com.aka.oauthssospringboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@EnableOAuth2Client
public class OAuth2Config {

    @Autowired
    private Environment environment;

    @Value("${google.client.id}")
    private String clientId;

    @Value("${google.client.secret}")
    private String clientSecret;

    @Bean
    public OAuth2Client oauth2Client() {
        return new OAuth2Client(
                environment.get("google.client.id"),
                environment.get("google.client.secret"));
    }
}

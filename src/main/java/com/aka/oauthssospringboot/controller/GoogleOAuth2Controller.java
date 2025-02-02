package com.aka.oauthssospringboot.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
public class GoogleOAuth2Controller {

    Logger logger = LoggerFactory.getLogger(GoogleOAuth2Controller.class);
//    private final OAuth2Client oauth2Client;
//
//    public GoogleOAuth2Controller(OAuth2Client oauth2Client) {
//        this.oauth2Client = oauth2Client;
//    }
//
//    @GetMapping("/login/google")
//    public String startGoogleLogin() {
//        try {
//            // Generate a URL for the user to authorize your application
//            URI uri = oauth2Client.authorize(new UriComponentsBuilder()
//                    .path("/oauth2/auth")
//                    .queryParam("response_type", "id_token")
//                    .queryParam("client_id", clientId)
//                    .queryParam("redirect_uri", environment.get("google.redirect_uri"))
//                    .build().toString());
//
//            return "Redirecting to Google for authentication";
//        } catch (AuthorizationException e) {
//            logger.error("Error during Google OAuth2 authorization", e);
//            return "Error: " + e.getMessage();
//        }
//    }
//
//    @GetMapping("/login/google/callback")
//    public String callback(@RequestParam(name = "code") String code,
//                           HttpServletRequest request) {
//        try {
//            // Exchange the code for an access token and ID token
//            OAuth2Token token = oauth2Client.tokenForCode(code, new DefaultUriComponentsBuilder()
//                    .path(request.getRequestURL().toString())
//                    .queryParam("code", code)
//                    .build());
//
//            // Now you have a token object, which contains id_token and access_token
//            return "Logged in with Google successfully";
//        } catch (AuthorizationException e) {
//            logger.error("Error during Google OAuth2 callback", e);
//            return "Error: " + e.getMessage();
//        }
//    }
}


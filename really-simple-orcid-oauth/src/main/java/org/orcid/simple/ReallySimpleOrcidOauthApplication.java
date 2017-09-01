package org.orcid.simple;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableOAuth2Sso
@Controller
public class ReallySimpleOrcidOauthApplication {

    @RequestMapping("/")
    @ResponseBody
    public final String home() {
        return "Welcome, " + SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ReallySimpleOrcidOauthApplication.class);
        Properties properties = new Properties();
        properties.put("security.oauth2.client.clientId", "XXX");
        properties.put("security.oauth2.client.clientSecret", "XXX");
        properties.put("security.oauth2.client.accessTokenUri", "https://sandbox.orcid.org/oauth/token");
        properties.put("security.oauth2.client.userAuthorizationUri", "https://sandbox.orcid.org/oauth/authorize");
        properties.put("security.oauth2.client.tokenName", "access_token");
        properties.put("security.oauth2.client.scope", "openid");
        properties.put("security.oauth2.resource.userInfoUri", "https://sandbox.orcid.org/oauth/userinfo");
        application.setDefaultProperties(properties);
        application.run(args);
    }
}

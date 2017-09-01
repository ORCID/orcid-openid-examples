package org.orcid.boot;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableOAuth2Sso
public class BootOrcidOauthApplication {

    /**
     * Used by the spring security components to extract the ORCIDUser from the
     * contents of the userinfo endpoint. 
     */
    @Bean
    public PrincipalExtractor getExtractor() {
        return new PrincipalExtractor() {
            @Override
            public Object extractPrincipal(Map<String, Object> map) {
                return new ORCIDUser(map);
            }
        };
    }
    
    /** Starts the application from the command line
     */
    public static void main(String[] args) {
        SpringApplication.run(BootOrcidOauthApplication.class, args);
    }

}
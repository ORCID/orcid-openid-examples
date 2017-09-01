package org.orcid.boot.openid;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/** Configures the ORCID OAuth endpoints
 * 
 * @author tom
 *
 */
@Configuration
@EnableOAuth2Client
public class ORCIDOpenIDConfig {
    @Value("${orcid.clientId}")
    private String clientId;
 
    @Value("${orcid.clientSecret}")
    private String clientSecret;
 
    @Value("${orcid.accessTokenUri}")
    private String accessTokenUri;
 
    @Value("${orcid.userAuthorizationUri}")
    private String userAuthorizationUri;
 
    @Value("${orcid.redirectUri}")
    private String redirectUri;
 
    @Bean
    public OAuth2ProtectedResourceDetails orcidOpenId() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setUserAuthorizationUri(userAuthorizationUri);
        details.setScope(Arrays.asList("openid"));
        details.setPreEstablishedRedirectUri(redirectUri);
        details.setUseCurrentUri(false);
        return details;
    }
 
    @Bean
    public OAuth2RestTemplate orcidOpenIdTemplate(OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(orcidOpenId(), clientContext);
    }
}

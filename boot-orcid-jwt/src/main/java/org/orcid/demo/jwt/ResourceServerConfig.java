package org.orcid.demo.jwt;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;

/** Configures our 'TokenServices'.
 * These are the parts that deal with looking at access tokens and turning them into users.
 * 
 * @author tom
 *
 */
@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    
    @Value("${orcid.jwks}")
    private String jwksURL;
    
    @Override
    public void configure(ResourceServerSecurityConfigurer config) {
        config.tokenServices(tokenServices());
        config.resourceId(null);// don't care about the audience of the token
    }
    
    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }
 
    @Bean
    public TokenStore tokenStore() {
        //note: a JWT token store doesn't actually store anything.
        return new JwtTokenStore(accessTokenConverter());
    }
 
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        
        try{
            //fetch key from qa.orcid.org.
            JWKSet publicKeys = JWKSet.load(new URL(jwksURL));
            byte[] bytes = ((RSAKey)publicKeys.getKeys().get(0)).toPublicKey().getEncoded();
            String key = "-----BEGIN PUBLIC KEY-----\n" + new String(Base64.getEncoder().encode(bytes))
                    + "\n-----END PUBLIC KEY-----";        
            converter.setVerifierKey(key);            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
        //converter.setSigningKey("123456");
        ((DefaultAccessTokenConverter) converter.getAccessTokenConverter()).setUserTokenConverter(userAuthenticationConverter());
        return converter;
    }
    
    @Bean
    public UserAuthenticationConverter userAuthenticationConverter(){
        return new ORCIDUserAuthenticationConverter();
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
         http.antMatcher("/secure")
                .authorizeRequests()
                    .anyRequest().authenticated();
    }
 
}

package org.orcid.demo.jwt;

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
    
    @Override
    public void configure(ResourceServerSecurityConfigurer config) {
        config.tokenServices(tokenServices());
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
        converter.setSigningKey("secret");
        ((DefaultAccessTokenConverter) converter.getAccessTokenConverter()).setUserTokenConverter(userAuthenticationConverter());
        //c.setAccessTokenConverter(ORCIDTokenConverter);
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

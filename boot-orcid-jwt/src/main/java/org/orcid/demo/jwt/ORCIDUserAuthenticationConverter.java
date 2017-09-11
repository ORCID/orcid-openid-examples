package org.orcid.demo.jwt;

import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

public class ORCIDUserAuthenticationConverter implements UserAuthenticationConverter {

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication userAuthentication) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        @SuppressWarnings("unchecked")
        Map<String, String> m2 = (Map<String, String>) map;
        ORCIDUserDetails user = new ORCIDUserDetails(m2);
        return new UsernamePasswordAuthenticationToken(user, "N/A", user.getAuthorities());
    }

}

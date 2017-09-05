package org.orcid.boot.openid;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class OpenIDConnectUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String name;
    private String username;
    private OAuth2AccessToken token;

    /** Takes userinfo from JWT token and turns into a User object
     * Example JWT: {"aud":"APP-6LKIJ3I5B1C4YIQP","sub":"0000-0002-5062-2209","auth_time":1504616151,"iss":"https:\/\/orcid.org","name":"Mr Credit Name","exp":1504617454,"given_name":"Tom","iat":1504616854,"family_name":"Dem","jti":"3b2b662a-2429-4144-a986-06282b88d211"}
     * @param userInfo
     * @param token
     */
    public OpenIDConnectUserDetails(Map<String, String> jwtUserInfo, OAuth2AccessToken token) {
        this.username = jwtUserInfo.get("sub");
        this.name = jwtUserInfo.get("name");
        this.token = token;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OAuth2AccessToken getToken() {
        return token;
    }

    public void setToken(OAuth2AccessToken token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

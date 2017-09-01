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

    private String userId;
    private String username;
    private OAuth2AccessToken token;

    /** Takes userinfo from JWT token and turns into a User object
     * Example JWT: {aud=APP-6LKIJ3I5B1C4YIQP, sub=0000-0002-5062-2209, auth_time=1504100815, iss=https://orcid.org, exp=1504103781, iat=1504103181, jti=e465e13f-50a3-4776-a231-c3432ec52c3e}
     * @param userInfo
     * @param token
     */
    public OpenIDConnectUserDetails(Map<String, String> jwtUserInfo, OAuth2AccessToken token) {
        this.userId = jwtUserInfo.get("sub");
        this.username = jwtUserInfo.get("sub");
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

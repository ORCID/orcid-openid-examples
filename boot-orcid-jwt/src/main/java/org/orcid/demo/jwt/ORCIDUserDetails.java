package org.orcid.demo.jwt;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class ORCIDUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String orcid;
    private String name;

    /** Takes userinfo from JWT token and turns into a User object
     * Example JWT: {aud=APP-6LKIJ3I5B1C4YIQP, sub=0000-0002-5062-2209, auth_time=1504100815, iss=https://orcid.org, exp=1504103781, iat=1504103181, jti=e465e13f-50a3-4776-a231-c3432ec52c3e}
     * @param userInfo
     * @param token
     */
    public ORCIDUserDetails(Map<String, ?> jwtUserInfo) {
        this.orcid = jwtUserInfo.get("sub").toString();
        if (jwtUserInfo.containsKey("name"))
            this.name = jwtUserInfo.get("name").toString();
    }

    @Override
    public String getUsername() {
        return orcid;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getName(){
        return name;
    }
    
    public String getOrcid() {
        return orcid;
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

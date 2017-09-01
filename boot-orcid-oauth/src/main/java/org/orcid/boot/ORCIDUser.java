package org.orcid.boot;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Representaiton of an ORCID user, based on the contents of the user info
 * endpoint
 * 
 * Example map from user info endpoint: {sub=0000-0002-5062-2209, name=Mr Credit
 * Name, family_name=Dem, given_name=Tom} Note, "sub" is mandatory, all names are
 * optional.
 * 
 * @author tom
 *
 */
@Configuration
public class ORCIDUser implements UserDetails {

    private static final long serialVersionUID = 1L;
    final Map<String, Object> userinfo;

    public ORCIDUser(Map<String, Object> userinfo) {
        this.userinfo = userinfo;
    }

    public String getCreditName() {
        return (userinfo.get("name") != null) ? userinfo.get("name").toString() : "unknown";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userinfo.get("sub").toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
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

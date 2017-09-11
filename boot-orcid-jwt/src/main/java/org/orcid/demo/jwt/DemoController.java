package org.orcid.demo.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Simple controler that returns a welcome message to the logged in user.
 * 
 * @author tom
 *
 */
@Controller
public class DemoController {

    @Value("${orcid.authUrl}")
    private String authUrl;

    @Value("${orcid.clientId}")
    private String clientId;

    @RequestMapping("/secure")
    @ResponseBody
    public final String home() {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ORCIDUserDetails user = (ORCIDUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getName() == null)
            return "Welcome to the secure spring service, " + username;
        else
            return "Welcome to the secure spring service, " + user.getName() + " (" + username + ")";
    }

    @RequestMapping("/login")
    public final RedirectView loginUrl() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(
                authUrl + "?response_type=token%20id_token&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2F/index2.html&scope=openid&nonce=whatever&client_id=" + clientId);
        return redirectView;
    }

}

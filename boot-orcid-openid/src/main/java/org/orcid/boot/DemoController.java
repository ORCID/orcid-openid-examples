package org.orcid.boot;

import org.orcid.boot.openid.OpenIDConnectUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** Simple controler that returns a welcome message to the logged in user.
 * 
 * @author tom
 *
 */
@Controller
public class DemoController {

    @RequestMapping("/")
    @ResponseBody
    public final String home() {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        final String creditName = ((OpenIDConnectUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getName();
        return "Welcome, " + creditName + " (" + username + ")";
    }

}

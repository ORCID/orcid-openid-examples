package org.orcid.demo.jwt;

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

    @RequestMapping("/secure")
    @ResponseBody
    public final String home() {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ORCIDUserDetails user = (ORCIDUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getName() == null)
            return "Welcome to the secure service, " + username;
        else
            return "Welcome to the secure service, " + user.getName() + " ("+username+")";
    }

}

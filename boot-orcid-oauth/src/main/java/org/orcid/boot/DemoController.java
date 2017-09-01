package org.orcid.boot;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    //private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    @ResponseBody
    public final String home() {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        final String creditName = ((ORCIDUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCreditName();
        return "Welcome, " + creditName + " (" + username + ")";
    }

}

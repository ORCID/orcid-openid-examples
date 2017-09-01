package org.orcid.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Bootstraps the application
 * 
 * @author tom
 *
 */
@SpringBootApplication
public class BootOrcidOpenidApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootOrcidOpenidApplication.class, args);
	}
}

Spring ORCID OAuth examples
===========================
This repo contains several example applications demonstratng ORCID integration with Spring boot.  They vary in aproach and complexity.

All that's required to see them in action are some ORCID API credentials.

Four examples
-------------
Under thier own directories there are 4 examples

* **really-simple-orcid-oauth**
36 lines of code in a single file.  What could be simpler!

* **boot-orcid-oauth**
Moves config to an external file, does a few clever things to extract more info from the login, like the user's name.

* **boot-orcid-openid**
Moves some of the boot automagic into the actual code, enables fine grained configuration of security.  Extracts the user info from the JWT instead of the userinfo endpoint

* **simple-orcid-jwt**
This server checks for a JWT access token and uses that to perform stateless auth.

Quick start
-----------
0. Choose a variation from above

1. CD into the directory for example

        cd really-simple-orcid-oauth

2. Modify application.properties to contain your API credentials

        nano src/main/resources/application.properties

4. Run the example application (or import it into eclipse/sts or your favourite IDE.)
        
        mvn spring-boot:run

    or

        ./mvnw spring-boot:run 



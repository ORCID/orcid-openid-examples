Spring ORCID OAuth examples
===========================
This repo contains several example applications demonstratng ORCID integration with Spring boot.  They vary in aproach and complexity.

All that's required to see them in action are some ORCID API credentials.

really-simple-orcid-oauth
-------------------------
36 lines of code in a single file.  What could be simpler!

js-orcid-jwt
------------
HTML/Javascript client side one-pager.  Sends you to ORCID to authenticate, then confirms your identity by checking the signature of the JWT id_token.

boot-orcid-oauth
----------------
Moves config to an external file, does a few clever things to extract more info from the login, like the user's name.

boot-orcid-openid
-----------------
Moves some of the boot automagic into the actual code, enables fine grained configuration of security.  Extracts the user info from the JWT instead of the userinfo endpoint

simple-orcid-jwt
----------------
This server checks for a JWT access token and uses that to perform stateless auth.

Quick start
-----------
0. Choose a variation from above
1. Modify application.properties to contain your API credentials
2. mvn spring-boot:run, ./mvnw spring-boot:run or import it into eclipse/sts or your favourite IDE.

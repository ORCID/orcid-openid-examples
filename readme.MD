ORCID OpenID Connect and implicit OAuth examples
================================================
This repo contains several example applications demonstrating ORCID integration with javascript or Spring boot.  They vary in aproach and complexity.

All that's required to see them in action are some ORCID API credentials.

js-orcid-jwt
------------
HTML/Javascript client side one-pager.  
Sends you to ORCID to authenticate, then confirms your identity by checking the signature of the JWT id_token.

js-implicit-popup
-----------------
HTML/Javascript client side with popup.
Client side only app that uses javascript and a popup to authenticate a user and populate a form

really-simple-orcid-oauth
-------------------------
Spring boot Java implementation.  
36 lines of code in a single file.  What could be simpler!

boot-orcid-oauth
----------------
Spring boot Java implementation.  
Moves config to an external file, does a few clever things to extract more info from the login, like the user's name.

boot-orcid-openid
-----------------
Spring boot Java implementation.  
Moves some of the boot automagic into the actual code, enables fine grained configuration of security.  Extracts the user info from the JWT instead of the userinfo endpoint

simple-orcid-jwt
----------------
Spring boot Java implementation.  
This server checks for a JWT access token and uses that to perform stateless auth.

Quick start for Spring boot versions
------------------------------------
0. Choose a variation from above
1. Modify application.properties to contain your API credentials
2. mvn spring-boot:run, ./mvnw spring-boot:run or import it into eclipse/sts or your favourite IDE.

Basic ORCID Spring boot integration
===================================

This app does the minimum required to get an authenticated ORCID user.  To try it out, update the config with your api credentials, start the server (from the command line using ./mvnw or via eclpise/sts/whatever) and visit http://localhost:8080.

application.yml
---------------
Contains the OAuth config.  Simply add your own client id and client secret.

BootOrcidOauthApplication.java
------------------------------
1. Starts the spring app
2. Is annotated with @EnableOAuth2Sso which forces app to require authentation for all endpoints
3. Configures a PrincipalExtractor to turn the contents of the userinfo endpoint into an ORCIDUser object. 

DemoController.java
-------------------
Serves a simple page welcoming the user by name and number.

ORCIDUser.java
--------------
Simple bean containing the user details.  Created by from the user info by the PrincipalExtractor.

Notes
-----
Note that configuring a PrincipalExtractor and implementing ORCIDUser.java is optional - if omitted, spring will find the ORCID ID and use that in place of an ORCIDUser object.

Quick start
-----------
1. Modify application.properties to contain your API credentials
2. mvn spring-boot:run, ./mvnw spring-boot:run or import it into eclipse/sts or your favourite IDE.
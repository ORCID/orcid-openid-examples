boot-orcid-openid
=================

This example uses the Java Web Token (JWT) supplied by the ORCID OpenID connect implementation to create a local user session.  

In addition, it relies less on Spring Boot "magic" and enables finer grained security controls.

Based on the google OpenID implementation described here: http://www.baeldung.com/spring-security-openid-connect 

Quick start
-----------
1. Modify application.properties to contain your API credentials
2. mvn spring-boot:run, ./mvnw spring-boot:run or import it into eclipse/sts or your favourite IDE.
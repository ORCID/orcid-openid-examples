simple-orcid-jwt
================

Requests made to /secure on this example must include a JWT token in the Authorization: Bearer HTTP header.

These tokens are decrypted and/or have their signature checked.  If valid the user details extracted.  This is done in a stateless manner, no server side sessions are created.

Requests made to /login will redirect to the ORCID OAuth authentication endpoint and kickstart the OAuth flow.

ResourceServerConfig.java
-------------------------
Alongside its usual job of defining which paths are protected and how, this class creates a JWT based auth mechanism and injects ORCID specific classes into the normal spring authentication flow.  Fetches the ORCID certificate to check signatures.

ORCIDUserAuthenticationConverter.java
-------------------------------------
This is the key to it all.  It takes the JWT claims and turns them into an Authenticated user object.  Easy when you know how.

ORCIDUserDetails.java
---------------------
Represents the user.  Created from JWT claims.

DemoController.java
-------------------
- '/login' Redirects requests to the ORCID OAuth authentication endpoint
- '/secure' Provides a protected resource at which returns a welcome message and some user info

index.html
----------
Contains a link to /login

index2.html
-----------
Simple JQuery application that takes the id_token out of the URL and makes a request to a secure endpoint.

Notes
-----
The spring implementation is very sensitive to clock skew!
simple-orcid-jwt
================

Requests made to /secure on this example must include a JWT token in the Authorization: Bearer HTTP header.

These tokens are decrypted and/or have their signature checked.  If valid the user details extracted.  This is done in a stateless manner, no server side sessions are created.

ResourceServerConfig.java
-------------------------
Alongside its usual job of defining which paths are protected and how, this class creates a JWT based auth mechanism and injects ORCID specific classes into the normal spring authentication flow.  

ORCIDUserAuthenticationConverter.java
-------------------------------------
This is the key to it all.  It takes the JWT claims and turns them into an Authenticated user object.  Easy when you know how.

ORCIDUserDetails.java
---------------------
Represents the user.  Created from JWT claims.

DemoController.java
-------------------
Provides a protected resource at /secure which returns user info

index.html
----------
Contains a simple JQuery application that enables you to post a JWT bearer token and check that it works.

Notes
-----
This works against a demo JWT provider, not ORCID.  To work against ORCID, implicit OAuth (or another mechanism of obtaining id_tokens) is required.  TODO: make a quick version.
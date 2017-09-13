Simmple implicit OAuth with JWT
-------------------------------
This one-pager sends you to ORCID to authenticate, then cofirms your identity by checking the returned JWT signature.

Quickstart
----------
1. Update example.html to use your clientId `var clientId = "XXX";`
2. Start a server in this directory using something like `python -m SimpleHTTPServer 8080`
3. Visit http://localhost:8080/example.html and sign in.

Bonus configuration tips
------------------------
This tool is configured to use qa.orcid.org.  If you would like to use the sandbox server, update the following lines:

    var orcidAuthUrl = orcidQAAuthUrl;
    var orcidCert = orcidQACert;

becomes

    var orcidAuthUrl = orcidSandboxAuthUrl;
    var orcidCert = orcidSandboxCert;

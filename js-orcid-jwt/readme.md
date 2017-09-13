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

    var orcidAuthUrl = "https://sandbox.orcid.org/oauth/authorize";
    var orcidCert = {"kty":"RSA","e":"AQAB","use":"sig","kid":"sandbox-orcid-org-3hpgosl3b6lapenh1ewsgdob3fawepoj","n":"pl-jp-kTAGf6BZUrWIYUJTvqqMVd4iAnoLS6vve-KNV0q8TxKvMre7oi9IulDcqTuJ1alHrZAIVlgrgFn88MKirZuTqHG6LCtEsr7qGD9XyVcz64oXrb9vx4FO9tLNQxvdnIWCIwyPAYWtPMHMSSD5oEVUtVL_5IaxfCJvU-FchdHiwfxvXMWmA-i3mcEEe9zggag2vUPPIqUwbPVUFNj2hE7UsZbasuIToEMFRZqSB6juc9zv6PEUueQ5hAJCEylTkzMwyBMibrt04TmtZk2w9DfKJR91555s2ZMstX4G_su1_FqQ6p9vgcuLQ6tCtrW77tta-Rw7McF_tyPmvnhQ"};
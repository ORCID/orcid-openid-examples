Simple implicit OAuth with JWT
-------------------------------
This one-pager sends you to ORCID to authenticate, then cofirms your identity by checking the returned JWT signature.

Quickstart
----------
1. Update example.html to use your clientId `var clientId = "XXX";`
2. Start a server in this directory using something like `python -m SimpleHTTPServer 8080`
3. Visit http://localhost:8080/example.html and sign in.

Bonus configuration tips
------------------------
This tool is configured to use sandbox.orcid.org and some dummy credenitals.  If you would like to use the live server, update the following lines:

	var clientId = "YOUR CLIENT ID";
    var orcidAuthUrl = "https://orcid.org/oauth/authorize";
    var orcidCert = {"kty":"RSA","e":"AQAB","use":"sig","kid":"production-orcid-org-7hdmdswarosg3gjujo8agwtazgkp1ojs","n":"jxTIntA7YvdfnYkLSN4wk__E2zf_wbb0SV_HLHFvh6a9ENVRD1_rHK0EijlBzikb-1rgDQihJETcgBLsMoZVQqGj8fDUUuxnVHsuGav_bf41PA7E_58HXKPrB2C0cON41f7K3o9TStKpVJOSXBrRWURmNQ64qnSSryn1nCxMzXpaw7VUo409ohybbvN6ngxVy4QR2NCC7Fr0QVdtapxD7zdlwx6lEwGemuqs_oG5oDtrRuRgeOHmRps2R6gG5oc-JqVMrVRv6F9h4ja3UgxCDBQjOVT1BFPWmMHnHCsVYLqbbXkZUfvP2sO1dJiYd_zrQhi-FtNth9qrLLv3gkgtwQ"};

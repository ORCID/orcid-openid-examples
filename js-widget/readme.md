js widget
---------

Simple javascript library that will create an authentication link and process the response.  Simply:

- register for a n ORCID client id if you haven't done so already
- include the script tags
- create a config, 
- add ``<div id="orcidWidget"/>`` to your page where you want the link to appear
- write a function that does something with the response

Example config:
===============
	{
	"mode":"sandbox",
	"clientId":"APP-8SEU3HT2XC35A31D",
	"returnUrl":"http://localhost:8080/widget.html",
	"onSuccess":sayHello,
	"onFail":sayOops,
	"auto":true
	}
  
Example use:
============
	<script>
	function sayHello(idToken){
		alert("hello "+idToken.given_name+" "+idToken.family_name+" "+idToken.sub);
	}
	function sayOops(){
		alert("Something has gone wrong :(");
	}
	$(document).ready(function() {
		ORCID.init(config);
	});
	</script>
	<div id="orcidWidget"/>
  
Required libraries
==================
Requries the kjur crypto library and jquery (2+)

	<script src="https://kjur.github.io/jsrsasign/jsrsasign-latest-all-min.js"></script>
	<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
	<script src="orcid-widget.js"></script>

Non-automatic use
=================
You can pass "auto":false as a config parameter and handle button construction and response checking yourself.  This prevents the library from automatically populating the link and processing responses.

- call ``ORCID.buildReturnUrl(nonce)`` to generate a link to our Oauth servers.  Returns a String with the link.
- call ``ORCID.handleResponse()`` to process the response and call your callbacks.

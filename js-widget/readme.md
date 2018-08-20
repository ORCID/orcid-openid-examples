js widget
---------

Simple javascript library that will create an authentication link and process the response.  Simply:

- create a config, 
- add a <div id="orcidWidget"/> to your page where you want the link to appear
- write a function that does something with the response

Example config:
===============
  {
	"mode":"sandbox",
	"clientId":"APP-8SEU3HT2XC35A31D",
	"returnUrl":"http://localhost:8080/widget.html",
	"onSuccess":sayHello,
	"onFail":sayOops
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

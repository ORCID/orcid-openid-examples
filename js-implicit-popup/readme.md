Super easy Javascript implicit popup
====================================

The start_page.html contains a simple form. 

- User clicks the authenticate button
- a pop up asks them to log into ORCID
- Once logged in the pop up sends them to return_page.html
- orcid_popup.html tells start_page.html their ORCID ID
- start_page.html updates the form with information and closes the popup.

To test locally
---------------
- start a webserver in this directory
  - Python2: use `python -m SimpleHTTPServer 8080` or
  - Python3: use `python3 -m http.server 8080` or
  - use `http-server` (`npm install http-server -g` to install)
- visit http://localhost:8080/start_page.html
- test
- update to use your credentials and the live service.  Details in the html file.
- test

To use in your own system
-------------------------

- Copy the code from start_page.html into your page
- Host the code from return_page.html on your server
- Update the files to use your client id and the live ORCID server
- Add the URL of your return_page.html to your client setup in ORCID
- Done.

Notes
-----

- The example uses bootstrap to make itself pretty.  This is not required to make it work.
- This can be done without the popup with a simple redirect (see the js-orcid-jwt example).

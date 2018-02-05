Super easy Javascript implicit popup
====================================

The start_page.html contains a simple form.  A button and a field.  

- User clicks the button
- a pop up asks them to log into ORCID
- Once logged in the pop up sends them to return_page.html
- return_page.html tells start_page.html their ORCID ID
- start_page.html updates the form and closes the popup.

To use in your own system
-------------------------

- Copy the code from start_page.html into your page
- Host the code from return_page.html on your server
- Update the files to use your client id and the live ORCID server
- Add the URL of your return_page.html to your client setup in ORCID
- Done.
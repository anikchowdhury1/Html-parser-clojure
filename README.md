# html-parser

FIXME: description

## Installation

Download from http://example.com/FIXME.

## dev-config.edn
 
    {
     ;; nav panel related html
     :data-to-be-replaced "<body>\n\n<header>\n\t\t<div class=\"container\">\n\t\t\t<div class=\"company-name\"><a href=\"/\"><img src=\"/images/logo.svg\"\n\t\t\t\t\t\talt=\"Dandy Dialer Logo\" width=\"95\" height=\"33\" /></a></div>\n<nav>\n\t<a class=\"nav-toggle\" id=\"open-nav\" href=\"#\">&#9776;</a>\n\t<a class=\"editor-link btn\" href=\"cloudcannon:collections/_data/navigation.yml\" class=\"btn\"><strong>&#9998;</strong> Edit navigation</a>\n\t\n\t\t\n\t\t\n\n\t\t\n\t\t<a href=\"/pricing/\" class=\"\" >Pricing</a>\n\t\n\t\t\n\t\t\n\n\t\t\n\t\t<a href=\"/blog/\" class=\"\" >Blog</a>\n\t\n\t\t\n\t\t\n\n\t\t\n\t\t<a href=\"/about/\" class=\"\" >About</a>\n\t\n\t\t\n\t\t\n\n\t\t<a href=\"/contact/\" class=\"\" >Contact</a>\n\n\n\t\n\t\t<a href=\"/dandydialer-doc/latest/welcome\" class=\"\" >Documentations</a>\n\t\t\n\t\t\n\n\t\t\n\t\t<a href=\"/faqs/\" class=\"\" >Faqs</a>\n\t\n\t\t\n\t\t\n\n\t\t\n\t\t<a href=\"/\" class=\"\" target=\"_blank\">Login</a>\n\t\n\t\t\n\t\t\n\n\t\t\n\t\t<a href=\"/\" class=\" highlight\" target=\"_blank\">Sign Up</a>\n\t\n</nav>\n\n\t\t</div>\n\t</header>\n"
     ;; where to insert data
     :data-search "<body>"
    
     ;; doc-integration data
     ;; :doc-integration "<a href=\"/contact/\" class=\"\" >Contact</a>\n\n\n\t\n\t\t<a href=\"/dandydialer-doc/latest/welcome\" class=\"\" >Documentations</a>"
    
     ;; doc-integration search
     ;; :doc-search "<a href=\"/contact/\" class=\"\" >Contact</a>"
    
    
     ;; :path-to-integrate-doc "/Users/anik_chowdhury/IdeaProjects/dandy-dialer-website/_site/"
    
     ;; base url of the website
     :site-map-url "http://localhost:4000"
    
     ;; sitemap form
     :site-map-form "\n<url>\n<loc>%s</loc>\n</url>\n"
     
     
     ;; replace the url of generated sitemap with the :site-map-url (base url)
     :site-map-url-search "http://localhost:4000/"

    
     ;; search tag of sitemap.xml
     :site-map-search "\n<url>\n<loc>%s/contact/</loc>\n</url>\n"
    
     ;; sitemap path
     :site-map-file-path "/Users/anik_chowdhury/Pictures/dandydialer-doc/sitemap.xml"
    
     ;; required css
     :data-replaced-css "<link rel=\"stylesheet\" href=\"/css/screen.css\">\n\t<link rel=\"icon\" type=\"image/png\" href=\"/favicon.png\">\n  <!--[if IE]><link rel=\"shortcut icon\" href=\"../../latest/_images/favicon.ico\"><![endif]-->\n  <meta content=\"Dandy Dialer\" name=\"application-name\">"
    
     ;; where to insert css
     :data-css-search "<meta content=\"Dandy Dialer\" name=\"application-name\">"
    
     ;; the directory path where dandydialer-doc/latest/ is placed
     :directory-path-doc "/Users/anik_chowdhury/Pictures/dandydialer-doc/latest/"
    
     ;; folder's names
     :folder-name ["call_scripts"
                   "campaigns"
                   "live_agents"
                   "welcome"
                   "audio_files"
                   "caller_IDs"
                   "contacts"
                   "sip_gateways"
                   "account"]}




## Usage

FIXME: explanation

    $ java -Dconfig="dev-config.edn" -jar target/html-parser.jar


## Options

FIXME: listing of options this app accepts.

## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2020 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.

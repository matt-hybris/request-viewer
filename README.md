# request-viewer
Super simple web server to view requests.

I've used things like this when dealing with external systems (such as payment gateways) that send back notifications by http (usually POST). This is just a simple interceptor that accepts the request and dumps all headers and request parameters to the console.

It's using Spring boot so the server is embedded. Run it with gradle.

<code>gradlew run</code>

Then have whatever external system is sending you notifications point to the root of your address.

<code>http://my-ip-or-dns:8080</code>

Often these systems are doing redirects from your own browser, so you can actually just use:

<code>http://localhost:8080</code>

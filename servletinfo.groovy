def method = request.method

if (!session) {
    session = request.getSession(true)

    if (!session.counter) {
        session.counter = 1
    }
}

if (!session?.groovlet) {
    session?.groovlet = 'Groovlets rock!'
}

html.html {
    head {
        title 'Groovlet info'
    }
    body {
        h1 'General info'
        ul {
            li "Method: ${method}"
            li "RequestURI: ${request.requestURI}"
            li "session.groovlet: ${session.groovlet}"
            li "application.version: ${context.version}"
        }
        
        h1 'Headers'
        ul {
            headers.each {
                li "${it.key} = ${it.value}"
            }
        }

        h1 'Data'
        ul {
            li "Session Counter: ${session?.counter}"
        }
    }
}

session.counter += 1
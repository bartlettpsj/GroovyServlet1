import org.mortbay.jetty.Server
import org.mortbay.jetty.servlet.*
import groovy.servlet.*

def startJetty() {
    def jetty = new Server(9090)

    new Context(jetty, '/', Context.SESSIONS).with {
        resourceBase = '.'  // Look in current dir for Groovy scripts.
        addServlet(GroovyServlet, '*.groovy')  // All files ending with .groovy will be served.
        setAttribute('version', '1.0')  // Set an context attribute.
    }

    jetty.start()
}

println "Starting Jetty Server, press Ctrl+C to stop."
startJetty()
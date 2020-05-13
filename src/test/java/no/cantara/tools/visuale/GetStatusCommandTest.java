package no.cantara.tools.visuale;


import org.slf4j.Logger;

import java.net.URI;

import static org.slf4j.LoggerFactory.getLogger;


public class GetStatusCommandTest {
    private static final Logger log = getLogger(GetStatusCommandTest.class);

    public static void main(String[] args) {
        URI baseUri = URI.create("http://localhost:8080/status");
        GetStatusCommand command = new GetStatusCommand(baseUri, "test");
        String statusJson = command.getAsJson();
        System.out.println(statusJson);
    }

}
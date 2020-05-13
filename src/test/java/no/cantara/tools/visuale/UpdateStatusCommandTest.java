package no.cantara.tools.visuale;

import org.junit.Test;

import java.net.URI;

import static org.junit.Assert.assertEquals;

public class UpdateStatusCommandTest {

    @Test
    public void buildUriTest() {
        URI baseUri = URI.create("http://localhost:8080/status");
        String groupKey = "test";
        String serviceName = "testService";
        VisualeStatus visualeStatus = new VisualeStatus(VisualeStatus.Status.OK,serviceName);
        UpdateStatusCommand command = new UpdateStatusCommand(baseUri, groupKey, serviceName)
                .withEnv("test")
                .withNode("n1");
        String expectedUri = "http://localhost:8080/status/test/testService/n1";
        assertEquals(expectedUri, command.buildUri().toString());
    }

    @Test
    public void buildServiceNameOnlyUriTest() {
        URI baseUri = URI.create("http://localhost:8080/status");
        String groupKey = "test";
        String serviceName = "testService";
        VisualeStatus visualeStatus = new VisualeStatus(VisualeStatus.Status.OK,serviceName);
        UpdateStatusCommand command = new UpdateStatusCommand(baseUri, groupKey, serviceName);
        String expectedUri = "http://localhost:8080/status/testService/testService/n1";
        assertEquals(expectedUri, command.buildUri().toString());
    }

    public static void main(String[] args) {

        URI baseUri = URI.create("http://localhost:8080/status");
        String groupKey = "test";
        String serviceName = "testService";
        VisualeStatus visualeStatus = new VisualeStatus(VisualeStatus.Status.OK,serviceName);
        UpdateStatusCommand command = new UpdateStatusCommand(baseUri, groupKey, serviceName)
                .withEnv("test")
                .withNode("n1")
                .withTag("tagKey", "tagValue")
                .withStatus(visualeStatus);

    }

}
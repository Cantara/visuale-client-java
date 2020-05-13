package no.cantara.tools.visuale;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class PingTest {

    @Test
    public void ping() throws Exception {
        Ping ping = new Ping("testme");
        String expected = "{\"status\":\"OK\",\"name\":\"testme\"}";
        JSONAssert.assertEquals(expected, ping.toJson(), true);
    }
}
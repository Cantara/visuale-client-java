package no.cantara.tools.visuale;

public class Ping extends VisualeStatus {

    public Ping () {
        this("ping");
    }
    public Ping(String serviceName) {
        this(serviceName, "-not-set-", "0.0.0.0");
    }

    public Ping(String serviceName, String version, String ip) {
        super(Status.OK, serviceName, version, ip);
    }
}

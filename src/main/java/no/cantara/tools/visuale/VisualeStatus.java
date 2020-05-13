package no.cantara.tools.visuale;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;


public class VisualeStatus {

    public enum Status {OK, FAIL, UNHEALTHY}

    private final Status status;
    private final String name;
    private final String version;
    private final String ip;

    public VisualeStatus(Status status, String name) {
        this(status,name, null, null);
    }

    public VisualeStatus(Status status, String name, String version, String ip) {
        this.status = status;
        this.name = name;
        this.version = version;
        this.ip = ip;
    }



    /**
     * {
     *   "Status": "OK",
     *   "name": "Jenkins",
     *   "version": "2.222",
     *   "ip": "172.31.34.121 "
     * }
     * @return
     */
    public String toJson () {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
                .add("status", status.toString())
                .add("name", name);
        if (version != null) {
            objectBuilder.add("version", version);
        }
        if (ip != null) {
            objectBuilder.add("ip", ip);
        }
        JsonObject value = objectBuilder.build();
        return value.toString();
    }

    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getIp() {
        return ip;
    }
}

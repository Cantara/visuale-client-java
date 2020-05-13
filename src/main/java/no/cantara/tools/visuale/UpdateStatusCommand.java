package no.cantara.tools.visuale;

import no.cantara.base.command.BaseHttpPutResilience4jCommand;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class UpdateStatusCommand extends BaseHttpPutResilience4jCommand {
    private String serviceName = null;
    private String nodeId;
    private Map<String,String> tags = null;
    private VisualeStatus visualeStatus = null;
    private String environment = null;

    protected UpdateStatusCommand(URI baseUri, String groupKey) {
        super(baseUri, groupKey);
    }

    public UpdateStatusCommand(URI baseUri, String groupKey, String serviceName) {
        super(baseUri, groupKey);
        this.serviceName = serviceName;
    }

    public UpdateStatusCommand withNode(String nodeId) {
        this.nodeId = nodeId;
        return this;
    }

    public UpdateStatusCommand withTag(String tagKey, String tagValue) {
        if (tags == null) {
            tags = new HashMap<>();
        }
        tags.put(tagKey,tagValue);
        return this;
    }

    public UpdateStatusCommand withStatus(VisualeStatus visualeStatus) {
        this.visualeStatus = visualeStatus;
        return this;
    }

    public UpdateStatusCommand withEnv(String environment) {
        this.environment = environment;
        return this;
    }

    @Override
    protected String getBodyAsString() {
      return visualeStatus.toJson();
    }

    @Override
    protected URI buildUri() {
        String fullUri = getBaseUri().toString();
        if (environment == null) {
            fullUri += "/" + serviceName;
        } else {
            fullUri += "/" + environment;
        }
        fullUri += "/" + serviceName;
        if (nodeId == null) {
            fullUri += "/" + "n1";
        } else {
            fullUri += "/" + nodeId;
        }
        return URI.create(fullUri);
    }


}

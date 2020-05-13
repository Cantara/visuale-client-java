package no.cantara.tools.visuale;

import no.cantara.base.command.BaseHttpGetResilience4jCommand;

import java.net.URI;

public class GetStatusCommand extends BaseHttpGetResilience4jCommand {
    protected GetStatusCommand(URI baseUri, String groupKey) {
        super(baseUri, groupKey);
    }
}

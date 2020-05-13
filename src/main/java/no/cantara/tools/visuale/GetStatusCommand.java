package no.cantara.tools.visuale;

import no.cantara.base.command.BaseHttpPutResilience4jCommand;

import java.net.URI;

public class GetStatusCommand extends BaseHttpPutResilience4jCommand {
    protected GetStatusCommand(URI baseUri, String groupKey) {
        super(baseUri, groupKey);
    }
}

package no.cantara.tools.visuale;

import no.cantara.base.command.BaseHttpPutResilience4jCommand;

import java.net.URI;

public class UpdateStatusCommand extends BaseHttpPutResilience4jCommand {
    protected UpdateStatusCommand(URI baseUri, String groupKey) {
        super(baseUri, groupKey);
    }
}

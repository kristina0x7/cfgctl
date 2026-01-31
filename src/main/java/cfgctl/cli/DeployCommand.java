package cfgctl.cli;

import cfgctl.config.*;
import cfgctl.deploy.*;
import cfgctl.git.*;
import java.nio.file.Path;

public class DeployCommand {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: java DeployCommand <environment>");
            return;
        }

        String env = args[0];

        DeploymentService service = new DeploymentService(
            new ConfigLoader(),
            new ConfigValidator(),
            new GitRepository(Path.of("."))
        );

        service.deploy(env);
    }
}

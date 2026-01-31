package cfgctl.deploy;

import cfgctl.config.*;
import cfgctl.git.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class DeploymentService {
    private final ConfigLoader loader;
    private final ConfigValidator validator;
    private final GitRepository git;

    public DeploymentService(ConfigLoader loader, ConfigValidator validator, GitRepository git) {
        this.loader = loader;
        this.validator = validator;
        this.git = git;
    }

    public void deploy(String env) throws Exception {
        Path configPath = Path.of(env, "app.yaml");
        Config config = loader.load(configPath);
        validator.validate(config);

        String commit = git.currentCommit();
        Files.writeString(Path.of(".active-" + env), commit);

        System.out.println("Deployed " + env + " using commit " + commit);
    }
}

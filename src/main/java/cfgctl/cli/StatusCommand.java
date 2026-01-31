package cfgctl.cli;

import java.nio.file.Files;
import java.nio.file.Path;

public class StatusCommand {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: java StatusCommand <environment>");
            return;
        }

        String env = args[0];
        Path activeFile = Path.of(".active-" + env);

        if (!Files.exists(activeFile)) {
            System.out.println("No deployment found for environment: " + env);
            return;
        }

        String commit = Files.readString(activeFile).trim();
        System.out.println("Current active commit for " + env + ": " + commit);
    }
}

package cfgctl.cli;

import java.nio.file.Files;
import java.nio.file.Path;

public class RollbackCommand {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: java RollbackCommand <environment> <commit>");
            return;
        }

        String env = args[0];
        String commit = args[1];
        Path activeFile = Path.of(".active-" + env);

        Files.writeString(activeFile, commit);
        System.out.println("Rolled back " + env + " to commit " + commit);
    }
}

package cfgctl.config;

import java.io.*;
import java.nio.file.*;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public class ConfigLoader {
    public Config load(Path path) throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream in = Files.newInputStream(path)) {
            Map<String, Object> data = yaml.load(in);
            return new Config(
                (String) data.get("serviceName"),
                (int) data.get("timeoutMs"),
                (int) data.get("maxRetries")
            );
        }
    }
}


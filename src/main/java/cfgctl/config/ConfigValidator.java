package cfgctl.config;

public class ConfigValidator {
    public void validate(Config config) {
        if (config.timeoutMs() <= 0)
            throw new IllegalStateException("timeout must be > 0");
        if (config.maxRetries() < 0)
            throw new IllegalStateException("maxRetries cannot be negative");
    }
}

package cfgctl.config;

public record Config(String serviceName, int timeoutMs, int maxRetries) {}


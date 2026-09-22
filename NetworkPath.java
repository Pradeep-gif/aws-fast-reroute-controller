package com.portfolio.reroute;

public record NetworkPath(String id, int latencyMs, int residualCapacityGbps, boolean available) {
    public boolean healthyFor(int requiredGbps, int latencyBudgetMs) {
        return available && residualCapacityGbps >= requiredGbps && latencyMs <= latencyBudgetMs;
    }
}

package com.portfolio.reroute;

import java.util.Comparator;
import java.util.List;

public final class FastRerouteController {
    public RerouteDecision reroute(List<NetworkPath> candidates, int requiredGbps, int latencyBudgetMs) {
        return candidates.stream()
            .filter(path -> path.healthyFor(requiredGbps, latencyBudgetMs))
            .max(Comparator.comparingInt(NetworkPath::residualCapacityGbps)
                .thenComparing(Comparator.comparingInt(NetworkPath::latencyMs).reversed()))
            .map(path -> new RerouteDecision(path.id(), "Selected healthy alternate: " + path.id()))
            .orElseGet(() -> new RerouteDecision(null, "No healthy route meets the capacity and latency constraints."));
    }
}

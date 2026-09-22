package com.portfolio.reroute;

public record RerouteDecision(String selectedPathId, String reason) {
    public boolean rerouted() { return selectedPathId != null; }
}

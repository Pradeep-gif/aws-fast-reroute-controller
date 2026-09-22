package com.portfolio.reroute;

import java.util.List;

public final class FastRerouteControllerTest {
    public static void main(String[] args) {
        var controller = new FastRerouteController();
        var candidates = List.of(
            new NetworkPath("sea-pdx-a", 15, 50, true),
            new NetworkPath("sea-pdx-b", 11, 80, true),
            new NetworkPath("sea-pdx-failed", 8, 100, false));

        var decision = controller.reroute(candidates, 40, 20);
        assert decision.rerouted();
        assert "sea-pdx-b".equals(decision.selectedPathId());

        var noRoute = controller.reroute(candidates, 120, 20);
        assert !noRoute.rerouted();
        System.out.println("FastRerouteController tests passed");
    }
}

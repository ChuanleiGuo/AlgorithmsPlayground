import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BootCamp {
    public static class MatchResult {
        public String winningTeam;
        public String losingTeam;

        public MatchResult(String winningTeam, String losingTeam) {
            this.winningTeam = winningTeam;
            this.losingTeam = losingTeam;
        }
    }

    private static Map<String, Set<String>> buildGraph(List<MatchResult> matches) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (MatchResult match : matches) {
            Set<String> edges = graph.get(match.winningTeam);
            if (edges == null) {
                edges = new HashSet<>();
                graph.put(match.winningTeam, edges);
            }
            edges.add(match.losingTeam);
        }
        return graph;
    }

    private static boolean isReachableDFS(Map<String, Set<String>> graph, String curr, String dest, Set<String> visited) {
        if (curr.equals(dest)) {
            return true;
        } else if (visited.contains(curr) || graph.get(curr) == null) {
            return false;
        }

        visited.add(curr);
        for (String team : graph.get(curr)) {
            if (isReachableDFS(graph, team, dest, visited)) {
                return true;
            }
        }

        return false;
    }

    public static boolean canTeamABeatB(List<MatchResult> matches, String teamA, String teamB) {
        Set<String> visited = new HashSet<>();
        return isReachableDFS(buildGraph(matches), teamA, teamB, visited);
    }
}

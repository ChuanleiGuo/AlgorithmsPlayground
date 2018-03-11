import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamPhoto {
    private static class Player implements Comparable<Player> {

        public int height;

        public Player(int height) {
            this.height = height;
        }

        @Override
        public int compareTo(Player other) {
            return Integer.compare(height, other.height);
        }
    }

    public static class Team {

        private List<Player> players;

        public Team(List<Integer> heights) {
            players = new ArrayList<>();
            for (int i = 0; i < heights.size(); i++) {
                players.add(new Player(heights.get(i)));
            }
        }

        private List<Player> sortPlayersByHeight() {
            List<Player> sortedPlayers = new ArrayList<Player>(players);
            Collections.sort(sortedPlayers);
            return sortedPlayers;
        }

        public static boolean validPlacementExists(Team A, Team B) {
            List<Player> ASorted = A.sortPlayersByHeight();
            List<Player> BSorted = B.sortPlayersByHeight();

            for (int i = 0; i < ASorted.size() && i < BSorted.size(); i++) {
                if (ASorted.get(i).compareTo(BSorted.get(i)) >= 0) {
                    return false;
                }
            }
            return true;
        }
    }
}

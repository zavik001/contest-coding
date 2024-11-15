import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;

public class MainE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LocalTime startTime = LocalTime.parse(in.nextLine().trim());
        int n = Integer.parseInt(in.nextLine().trim());
        Map<String, TeamResult> teamResults = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = in.nextLine().split(" ");
            String teamName = input[0].replaceAll("\"", "");
            LocalTime eventTime = LocalTime.parse(input[1]);
            String server = input[2];
            String status = input[3];

            int elapsedMinutes = (int) Duration.between(startTime, eventTime).toMinutes();
            if (elapsedMinutes < 0) {
                elapsedMinutes += 1440;
            }

            TeamResult team = teamResults.computeIfAbsent(teamName, TeamResult::new);

            switch (status) {
                case "ACCESSED":
                    if (!team.servers.containsKey(server)) {
                        int penalty = team.failedAttempts.getOrDefault(server, 0) * 20;
                        team.servers.put(server, true);
                        team.totalPenalty += penalty + elapsedMinutes;
                        team.hackedServers++;
                    }
                    break;
                case "DENIED":
                case "FORBIDEN":
                    team.failedAttempts.put(server, team.failedAttempts.getOrDefault(server, 0) + 1);
                    break;
                case "PONG":
                    break;
            }
        }
        in.close();

        List<TeamResult> results = new ArrayList<>(teamResults.values());
        results.sort(Comparator.comparingInt((TeamResult t) -> -t.hackedServers)
                .thenComparingInt(t -> t.totalPenalty)
                .thenComparing(t -> t.name));

        int rank = 1;
        for (int i = 0; i < results.size(); i++) {
            if (i > 0 && results.get(i).compareTo(results.get(i - 1)) != 0) {
                rank = i + 1;
            }
            TeamResult team = results.get(i);
            System.out.printf("%d \"%s\" %d %d%n", rank, team.name, team.hackedServers, team.totalPenalty);
        }
    }

    static class TeamResult implements Comparable<TeamResult> {
        String name;
        int hackedServers = 0;
        int totalPenalty = 0;
        Map<String, Boolean> servers = new HashMap<>();
        Map<String, Integer> failedAttempts = new HashMap<>();

        TeamResult(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(TeamResult other) {
            if (this.hackedServers != other.hackedServers) {
                return Integer.compare(other.hackedServers, this.hackedServers);
            }
            if (this.totalPenalty != other.totalPenalty) {
                return Integer.compare(this.totalPenalty, other.totalPenalty);
            }
            return this.name.compareTo(other.name);
        }
    }
}

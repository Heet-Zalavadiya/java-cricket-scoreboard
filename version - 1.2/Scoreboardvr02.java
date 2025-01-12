import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class Scoreboardvr02{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String team1_Name;
        String team2_Name;
        System.out.println("Enter Name of team 1 :   ");
        team1_Name = sc.nextLine();
        System.out.println("Enter Name of team 2 :    ");
        team2_Name = sc.nextLine();

        System.out.println("Enter no of overs : ");
        int no_of_Overs = sc.nextInt();

        int runPerOver[][][] = new int[2][no_of_Overs][];

        for (int i = 0; i < runPerOver.length; i++) {
            System.out.println("For Team" + (i + 1));
            
            for (int j = 0; j < runPerOver[i].length; j++) {
                int ball_in_this_over = 0;
                while (ball_in_this_over < 6) {
                    System.out.println("Enter no of ball played in over " + (j + 1));
                    ball_in_this_over = sc.nextInt();
                    if (ball_in_this_over < 6) {
                        System.out.println("Invalid input. An over must have at least 6 balls. Please try again.");
                    }

                }
                runPerOver[i][j] = new int[ball_in_this_over];
                for (int k = 0; k < runPerOver[i][j].length; k++) {
                    System.out.println("Enter runs taken in this over" + (j + 1) + "ball" + (k + 1) + "=");
                    runPerOver[i][j][k] = sc.nextInt();

                }
            }

        }

        int[] totalRun = new int[2];
        int[] totalExtra = new int[2];
        int[] totalwickets = new int[2];

        for (int i = 0; i < runPerOver.length; i++) {
            int total_Run = 0;
            int total_Extra = 0;
            int total_wickets = 0;
            for (int j = 0; j < runPerOver[i].length; j++) {

                for (int k = 0; k < runPerOver[i][j].length; k++) {
                    int runs = runPerOver[i][j][k];
                   
                    if (runs == -61) {
                        System.out.println("Wide ball");
                        total_Extra += 1;
                        total_Run += 1;
                    } else if (runs == -62) {
                        System.out.println("No ball");
                        total_Extra += 1;
                        total_Run += 1;

                    } else if (runs == -51) {
                        System.out.println("Wicket");
                        total_wickets += 1;
                    } else {
                        total_Run += runs;
                    }

                }

            }
            totalRun[i] = total_Run;
            totalExtra[i] = total_Extra;
            totalwickets[i] = total_wickets;
        }

        System.out.println("Score Board Summary:");

        for (int i = 0; i < runPerOver.length; i++) {
            System.out.println("Team " + (i + 1) + " | " + " Runs : " + totalRun[i] + " | " + " Extra : "
                    + totalExtra[i] + " | " + " Wickets : " + totalwickets[i]);
        }

        String Winner = (totalRun[0] > totalRun[1]) ? (team1_Name) : (team2_Name);

        System.out.println("Winner : " + Winner);

    }

}
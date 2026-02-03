import java.util.*;

/* CreatorStats class */
class CreatorStats {

    private String creatorName;
    private double[] weeklyLikes;

    // Static list as mentioned
    public static List<CreatorStats> EngagementBoard = new ArrayList<>();

    // Getters & Setters
    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public double[] getWeeklyLikes() {
        return weeklyLikes;
    }

    public void setWeeklyLikes(double[] weeklyLikes) {
        this.weeklyLikes = weeklyLikes;
    }
}

/* Program class */
public class Program {

    // Register creator
    public void RegisterCreator(CreatorStats record) {
        CreatorStats.EngagementBoard.add(record);
    }

    // Get top post counts
    public Map<String, Integer> GetTopPostCounts(List<CreatorStats> records, double likeThreshold) {

        Map<String, Integer> result = new LinkedHashMap<>();

        for (CreatorStats creator : records) {
            int count = 0;
            for (double like : creator.getWeeklyLikes()) {
                if (like >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                result.put(creator.getCreatorName(), count);
            }
        }
        return result;
    }

    // Calculate average likes
    public double CalculateAverageLikes() {

        if (CreatorStats.EngagementBoard.isEmpty())
            return 0;

        double totalLikes = 0;
        int totalWeeks = 0;

        for (CreatorStats creator : CreatorStats.EngagementBoard) {
            for (double like : creator.getWeeklyLikes()) {
                totalLikes += like;
                totalWeeks++;
            }
        }
        return totalLikes / totalWeeks;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Program program = new Program();
        int choice;

        do {
            System.out.println("\n1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("\nEnter your choice:");
            choice = sc.nextInt();
            sc.nextLine(); // buffer clear

            switch (choice) {

                case 1:
                    CreatorStats creator = new CreatorStats();

                    System.out.println("Enter Creator Name:");
                    creator.setCreatorName(sc.nextLine());

                    double[] likes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        likes[i] = sc.nextDouble();
                    }
                    creator.setWeeklyLikes(likes);

                    program.RegisterCreator(creator);
                    System.out.println("Creator registered successfully");
                    break;

                case 2:
                    System.out.println("Enter like threshold:");
                    double threshold = sc.nextDouble();

                    Map<String, Integer> topPosts =
                            program.GetTopPostCounts(
                                    CreatorStats.EngagementBoard, threshold);

                    if (topPosts.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (Map.Entry<String, Integer> entry : topPosts.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    double average = program.CalculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + average);
                    break;

                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}

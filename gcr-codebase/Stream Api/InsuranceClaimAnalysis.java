import java.util.*;
import java.util.stream.Collectors;

public class InsuranceClaimAnalysis {

    static class InsuranceClaim {
        String claimType;
        double claimAmount;

        InsuranceClaim(String claimType, double claimAmount) {
            this.claimType = claimType;
            this.claimAmount = claimAmount;
        }
    }

    public static void main(String[] args) {

        List<InsuranceClaim> claims = List.of(
                new InsuranceClaim("Health", 5000),
                new InsuranceClaim("Health", 7000),
                new InsuranceClaim("Vehicle", 12000),
                new InsuranceClaim("Vehicle", 8000),
                new InsuranceClaim("Life", 15000)
        );

        // Find average claim amount for each claim type
        Map<String, Double> averageClaims =
                claims.stream()
                        .collect(
                                Collectors.groupingBy(
                                        c -> c.claimType,
                                        Collectors.averagingDouble(c -> c.claimAmount)
                                )
                        );

        System.out.println("Average Claim Amount by Claim Type:");

        averageClaims.forEach((type, avg) ->
                System.out.println(type + " : " + avg)
        );
    }
}

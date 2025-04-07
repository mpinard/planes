# Planes Project

## Tasks
* Get Simple JPA query Working
    * Fix 

* Start creating tests from controller down

* Once all unit tests are present, start next feature using TDD

## Features

* Store the current coins and BUX in a bank with current value displayed on screen

* Open an airport
    * Verify sufficient bank balance to open airport
    * Once opened change status of airport from closed to open
    * Decrement bank by appropriate balance

* Generate passengers at an airport for other open airports

* Add plane page that can be opened from the planes page

* Add a passenger/ cargo to a plane
    * Limit the passengers / cargo to what is allowable on a plane

* Calculate distance and flight time between two airports    

* Hava a plane take off
    * Choose destination
    * Verify plane class can land at airport
    * Change from landed / loading to flying
    * Change list of planes to show appropriate status for flying plane

* Increment time by one minute
    * Planes who have landed have status changed appropriately
    * Change status of landed plane to loading
    * Change plane status in planes view to loading
    * If multiple of 5 minutes passengers/cargo available at airport is refreshed if airport is viewed (and preserved until next refresh)

* Increment time to when first plane has landed

* Increment time to arbitrary amount

* Close an airport

## Passenger generation

Here is suggestion from Copilot to weight results more towards lower numbers (passengers / cargo) and less towards higher
This would match expection that 0-4 are pretty common, but you also will rarely get numbers as high as 10-14 but in much less frequency than
the lower numbers
Should alter this to factor in the population size of the source and destination airport, so when both airports are big you get more jobs,
and the smaller the combination of the populations of the two cities are the less jobs you get for that combination

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeightedRandomGenerator {

    public static void main(String[] args) {
        // Define weights for numbers 0 to 14
        int[] weights = {30, 20, 15, 10, 8, 6, 4, 3, 2, 1, 1, 1, 1, 1, 1};
        int[] values = new int[15]; // Array to store counts of each value
        Random random = new Random();

        // Generate 100 random values
        for (int i = 0; i < 100; i++) {
            int result = getWeightedRandom(weights, random);
            values[result]++;
        }

        // Print results
        System.out.println("Counts for each value:");
        for (int i = 0; i < values.length; i++) {
            System.out.println(i + ": " + values[i]);
        }
    }

    private static int getWeightedRandom(int[] weights, Random random) {
        // Calculate the total weight
        int totalWeight = 0;
        for (int weight : weights) {
            totalWeight += weight;
        }

        // Generate a random number between 0 and totalWeight
        int randomValue = random.nextInt(totalWeight);

        // Determine which value corresponds to the random number
        int cumulativeWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            cumulativeWeight += weights[i];
            if (randomValue < cumulativeWeight) {
                return i;
            }
        }

        // Fallback (should never happen)
        return -1;
    }
}
```

## Implementation:
* consider actor / event based interaction to ensure state changes atomically for a given pair of interacting objects
* For example a passenger can be in the airport or on a plane but not both, how to make sure the transition back and forth is atomic, but
the maximum size of the plane is also respected?
* This is a tradeoff between the desirability of the atomic change to an actor versus the additional complexity of the actor model
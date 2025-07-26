package com.kmstimes.nexon.api;

import com.kmstimes.nexon.MapleStoryApi;
import com.kmstimes.nexon.model.probability.potential.cube.CubeResponse;
import com.kmstimes.nexon.model.probability.potential.potential.PotentialResponse;
import com.kmstimes.nexon.model.probability.starforce.StarforceResponse;
import com.kmstimes.nexon.model.probability.user.OuidResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProbabilityApiTest {
    static MapleStoryApi api = TestValue.api;
    static String userApiKey = TestValue.apiKey;
    static String legacyApiKey = TestValue.legacyApiKey;
    static LocalDate cubeDate = TestValue.cubeDate;
    static int count = TestValue.count;

    @Test
    void getLegacyOuid() {
        try {
            OuidResponse response = api.Probability().getLegacyOuid(legacyApiKey);
            assertNotNull(response);

            System.out.println("OUID: " + response.ouid());
            System.out.println(response);
        } catch (Exception e) {
            System.out.println("Expected error (invalid user API key): " + e.getMessage());
        }
    }

    @Test
    void getOuid(){
        try {
            OuidResponse response = api.Probability().getOuid(userApiKey);
            assertNotNull(response);

            System.out.println("OUID: " + response.ouid());
            System.out.println(response);
        } catch (Exception e) {
            System.out.println("Expected error (invalid user API key): " + e.getMessage());
        }
    }

    @Test
    void getStarforce() {
        try {
            String cursor = null;
            LocalDate date = TestValue.StarDate;
            do {
                StarforceResponse res = api.Probability().getStarforce(userApiKey, count, date, cursor);
                cursor = res.next_cursor();
                System.out.println(res + "\n\n");
            } while (cursor != null);
        } catch (Exception e) {
            System.out.println("Expected error (invalid user API key or no data): " + e.getMessage());
        }
    }

    @Test
    void getPotential() {
        try {
            PotentialResponse response = api.Probability().getPotential(userApiKey, count, cubeDate, null);
            assertNotNull(response);
            String cursor = response.next_cursor();
            System.out.println(response);

            while (cursor != null) {
                PotentialResponse res2 = api.Probability().getPotential(userApiKey, count, null, cursor);
                cursor = res2.next_cursor();
                System.out.println(res2);
            }
        } catch (Exception e) {
            System.out.println("Expected error (invalid user API key or no data): " + e.getMessage());
        }
    }

    @Test
    void getCube() {
        try {
            CubeResponse response = api.Probability().getCube(userApiKey, count, cubeDate, null);
            assertNotNull(response);
            String cursor = response.next_cursor();
            System.out.println(response);

            while (cursor != null) {
                CubeResponse res2 = api.Probability().getCube(userApiKey, count, null, cursor);
                cursor = res2.next_cursor();
                System.out.println(res2);
            }
        } catch (Exception e) {
            System.out.println("Expected error (invalid user API key or no data): " + e.getMessage());
        }
    }
}

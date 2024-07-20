package tests;

import org.junit.jupiter.api.Test;
import steps.ApiSteps;

import java.net.http.HttpResponse;

public class Test1 {
    private final Integer expectedStatusCode = 200;
    private final Integer expectedThemesAmount = 1899;
    private final Integer expectedPresentsAmount = 0;
    private final Integer expectedPhotosAmount = 28678;
    private final Integer expectedMembersAmount = 5153;
    private final String counters = "themes,photos,members,presents,photo_albums,videos,links,moderators,join_requests," +
            "black_list,maybe";

    @Test
    public void test1() {

        HttpResponse<String> response = ApiSteps.get().getOneCounter(counters);

        ApiSteps.get().assertResponseStatusCode(response, expectedStatusCode);
        ApiSteps.get().assertThemesAmountEqualsExpected(response, expectedThemesAmount);
        System.out.println(response.body());
        ApiSteps.get().assertMembersAmountEqualsExpected(response, expectedMembersAmount);
        ApiSteps.get().assertPhotosAmountEqualsExpected(response, expectedPhotosAmount);
        ApiSteps.get().assertPhotoPresentsAmountEqualsExpected(response, expectedPresentsAmount);
    }
}

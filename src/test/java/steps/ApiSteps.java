package steps;

import com.google.gson.Gson;
import constants.ApiConstants;
import models.OkRequest;
import models.OkResponse;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static constants.ApiConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiSteps {

    private static final ApiSteps instance = new ApiSteps();
    private final HttpClient client = HttpClient.newHttpClient();

    public static ApiSteps get() {
        return instance;
    }

    //action steps
    public HttpResponse<String> getOneCounter(String counter) {
        HttpResponse<String> response = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(OkRequest.builder()
                            .url(ApiConstants.ENDPOINT_URL)
                            .applicationKey(APPLICATION_KEY)
                            .counterTypes(counter)
                            .format(FORMAT)
                            .groupId(GROUP_ID)
                            .method(METHOD)
                            .sig(generateSignature(counter))
                            .sessionKey(SESSION_KEY)
                            .build().toString()))
                    .GET()
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    //assertion steps
    public void assertResponseStatusCode(HttpResponse<String> response, int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.statusCode(), "Response code mismatch.");
    }

    public void assertThemesAmountEqualsExpected(HttpResponse<String> response, Integer expectedValue) {
        OkResponse okResponse = new Gson().fromJson(response.body(), OkResponse.class);
        assertEquals(okResponse.getCounters().getThemes(), expectedValue, "Themes amount mismatch.");
    }

    public void assertPhotosAmountEqualsExpected(HttpResponse<String> response, Integer expectedValue) {
        OkResponse okResponse = new Gson().fromJson(response.body(), OkResponse.class);
        assertEquals(okResponse.getCounters().getPhotos(), expectedValue, "Photos amount mismatch.");
    }

    public void assertMembersAmountEqualsExpected(HttpResponse<String> response, Integer expectedValue) {
        OkResponse okResponse = new Gson().fromJson(response.body(), OkResponse.class);
        assertEquals(okResponse.getCounters().getMembers(), expectedValue, "Members amount mismatch.");
    }

    public void assertPhotoPresentsAmountEqualsExpected(HttpResponse<String> response, Integer expectedValue) {
        OkResponse okResponse = new Gson().fromJson(response.body(), OkResponse.class);
        assertEquals(okResponse.getCounters().getPresents(), expectedValue, "Presents amount mismatch.");
    }

    private String generateSignature(String counter) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] bytesOfMessage = String.format(ApiConstants.SIG_MATCHER,
                APPLICATION_KEY,
                counter,
                FORMAT,
                GROUP_ID,
                METHOD,
                SESSION_KEY,
                SESSION_KEY).getBytes("UTF-8");

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] MD5digest = md.digest(bytesOfMessage);
        StringBuilder sb = new StringBuilder();
        for (byte b : MD5digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

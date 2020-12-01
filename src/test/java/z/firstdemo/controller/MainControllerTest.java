package z.firstdemo.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {

    private CloseableHttpClient client;
    private Gson gson;
    private final String PREFIX = "http://localhost:8000/";

    @BeforeEach
    void setUp() {
        this.client = HttpClients.createDefault();
        GsonBuilder builder = new GsonBuilder();
        this.gson = builder.setPrettyPrinting().create();
    }


    @Test
    void getPostEmailRequest() throws IOException {
        Map<String, String> map = Collections.singletonMap("email", "test10@test.com");
        String json = gson.toJson(map);
        StringEntity entity = new StringEntity(json, StandardCharsets.UTF_8);
        HttpPost httpPost = new HttpPost(PREFIX);
        httpPost.setHeader("Content-type", "application/json; charset=utf-8");
        httpPost.setEntity(entity);
        CloseableHttpResponse response = client.execute(httpPost);
        System.out.println(response.getStatusLine().getStatusCode());
        String answer = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        System.out.println(answer);
    }
}
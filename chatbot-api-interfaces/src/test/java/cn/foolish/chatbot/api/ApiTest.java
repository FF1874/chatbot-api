package cn.foolish.chatbot.api;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;


import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/48885444115418/topics?scope=all&count=20");

        httpGet.addHeader("cookie", "zsxq_access_token=5E544D9B-B92D-55E0-87F6-55BBF67A41EC_2C09332324B58A94; zsxqsessionid=a5a642729406a90c10ae242a6d2fc09d; abtest_env=product");
        httpGet.addHeader("content-Type", "application/json, charset=utf8");

        CloseableHttpResponse response = httpClient.execute(httpGet);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);

        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
    @Test
    public void answer_query() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/5121854411115144/comments");

        httpPost.addHeader("cookie", "zsxq_access_token=5E544D9B-B92D-55E0-87F6-55BBF67A41EC_2C09332324B58A94; zsxqsessionid=a5a642729406a90c10ae242a6d2fc09d; abtest_env=product");
        httpPost.addHeader("content-Type", "application/json, charset=utf8");

        String paraJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我不会！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity entity = new StringEntity(paraJson, ContentType.create("text/json", "UTF-8"));

        httpPost.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(httpPost);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);

        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
}

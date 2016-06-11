package com.chatak.iplteams;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

public class ProductClient {
    private static final String API_BASE_URL = "http://ec2-54-165-229-42.compute-1.amazonaws.com:3000/";
    private AsyncHttpClient client;

    public ProductClient() {
        this.client = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

    public void getProducts(JsonHttpResponseHandler handler) {
        try {
            String url = getApiUrl("api/cakes");
            client.get(url, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
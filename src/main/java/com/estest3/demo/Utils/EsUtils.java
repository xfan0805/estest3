package com.estest3.demo.Utils;

import com.estest3.demo.Config;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Component;

@Component
public class EsUtils {

    public RestHighLevelClient client = null;

    private String IP = "localhost";
    private int PORT = 9200;

    public EsUtils(){
        try{
            RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(
                    new HttpHost(IP, PORT, "http")));
            this.client = client;
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public RestHighLevelClient getConnection(){
        return  client;
    }
}

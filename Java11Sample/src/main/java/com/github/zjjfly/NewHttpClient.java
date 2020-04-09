package com.github.zjjfly;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import static java.net.http.HttpClient.Version;
import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author z00405ze
 */
public class NewHttpClient {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //构建request
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder();
        HttpRequest httpRequest = requestBuilder
                .uri(new URI("https://postman-echo.com/post"))
                //设定HTTP协议版本
                .version(Version.HTTP_2)
                //设定Header
                .header("Accept", "application/json")
                .timeout(Duration.of(10, SECONDS))
                //设定HTTP Method
                .POST(HttpRequest.BodyPublishers.ofString("Sample request body"))
//                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("./build.gradle")))
                .build();
        //构建client
        HttpClient.Builder clientBuilder = HttpClient.newBuilder();
        HttpClient client = clientBuilder
                //设置重定向规则
                .followRedirects(HttpClient.Redirect.ALWAYS)
                //设置代理
                .proxy(ProxySelector.getDefault())
                //设置authentication
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("user", "password".toCharArray());
                    }
                })
                .build();
        //发送请求,返回响应
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        CompletableFuture<HttpResponse<String>> responseFuture = client
                .sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
        responseFuture.whenCompleteAsync((stringHttpResponse, throwable) -> {
            if (null != throwable) {
                throwable.printStackTrace();
            }
            System.out.println(stringHttpResponse.body());
        });
        //等待future完成
        responseFuture.join();
    }
}

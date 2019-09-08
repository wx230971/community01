package com.wx.community.provide;

import com.alibaba.fastjson.JSON;
import com.wx.community.dto.AccessTokenDTO;
import com.wx.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Auther: WX
 * @Date 2019/9/8 17:53
 * @Description:
 */

@Component
public class GithubProvide {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
         MediaType mediaType  = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();


        RequestBody body = RequestBody.create(mediaType ,JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String str= response.body().string();

            String token = str.split("&")[0].split("=")[1];

            System.out.println(token);
            return token;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token ="+accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }


}

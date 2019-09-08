package com.wx.community.controller;

import com.wx.community.dto.AccessTokenDTO;
import com.wx.community.dto.GithubUser;
import com.wx.community.provide.GithubProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: WX
 * @Date 2019/9/8 17:47
 * @Description:
 */

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvide githubProvide;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.url}")
    private String redirectUrl;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,@RequestParam(name= "state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_url(redirectUrl);
        accessTokenDTO.setState(state);
        String accessToken = githubProvide.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvide.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}

package com.wx.community.dto;

/**
 * @Auther: WX
 * @Date 2019/9/8 18:33
 * @Description:
 */


 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;
 import lombok.experimental.Accessors;

 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 @Accessors(chain = true)
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
}

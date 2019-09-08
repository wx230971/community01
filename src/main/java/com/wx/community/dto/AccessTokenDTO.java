package com.wx.community.dto;

/**
 * @Auther: WX
 * @Date 2019/9/8 17:56
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
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;
}

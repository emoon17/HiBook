package com.HiBook.kakao.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
public class KakaoToken {

    private String access_token;
    private String refresh_token;
    private String token_type;
    private int expires_in;

    private int refresh_token_expires_in;
}

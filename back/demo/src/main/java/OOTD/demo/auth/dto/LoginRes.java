package OOTD.demo.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 로그인 성공 시 반환하는 Dto 클래스입니다.
 * TODO : Refresh Token 도입
 *
 * @author CHO Min Ho
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRes {

    Long memberId;

    String accessToken;

    String refreshToken;
}

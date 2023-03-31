package OOTD.demo.auth.controller;

import OOTD.demo.auth.dto.*;
import OOTD.demo.common.HttpResponseUtil;
import OOTD.demo.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    private final AuthService authService;
    private final HttpResponseUtil httpResponseUtil;

    @Operation(summary = "회원가입 API", description = "회원가입 API 입니다.", tags = { "Auth Controller" })
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserReq dto) {

        if (authService.existEmail(dto.getEmail())) {
            return httpResponseUtil.createErrorResponse(null, "이미 존재하는 이메일입니다.",
                    NOT_ACCEPTABLE);
        }

        return httpResponseUtil.createOkHttpResponse(authService.createUser(dto), "회원가입에 성공했습니다.");

    }

    @Operation(summary = "닉네임 중복체크 API", description = "닉네임 중복체크 API 입니다.", tags = { "Auth Controller" })
    @PostMapping("/checkname")
    public ResponseEntity<?> checkName(@RequestBody CheckNameRes name) {

        if (authService.existAccountName(name.getName())) {
            return httpResponseUtil.createErrorResponse(null, "이미 존재하는 닉네임입니다.",
                    NOT_ACCEPTABLE);
        }
        return httpResponseUtil.createOkHttpResponse(null, "사용가능한 닉네임입니다.");

    }

    @Operation(summary = "로그인 API", description = "로그인 API 입니다.", tags = { "Auth Controller" })
    @PostMapping("/login")
    public ResponseEntity<?> login(HttpServletResponse response, @Valid @RequestBody LoginReq dto) {

        return httpResponseUtil.createOkHttpResponse(authService.login(dto, response), "로그인에 성공했습니다.");

    }
    @Operation(summary = "로그아웃 API", description = "로그아웃 API 입니다.",
            tags = { "Auth Controller" })
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request){

        authService.logout(request);
        return httpResponseUtil.createOkHttpResponse(null, "로그아웃에 성공했습니다.");

    }

    @Operation(summary = "Access Token 재발급 API", description = "Access Token 재발급 API 입니다.",
            tags = { "Auth Controller" })
    @GetMapping("/reissuance")
    public ResponseEntity<?> reissueRefreshToken(HttpServletRequest request) {
        log.info("여긴 들어옴?");

        AccessTokenRes accessTokenRes = authService.reissueAccessToken(request);

        if (accessTokenRes == null) {
            return httpResponseUtil.createErrorResponse(null, "refreshToken이 만료되었습니다.",
                    FORBIDDEN);
        }

        return httpResponseUtil.createOkHttpResponse(authService.reissueAccessToken(request),
                "access token 재발급에 성공했습니다.");
    }

}

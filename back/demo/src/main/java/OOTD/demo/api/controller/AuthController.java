package OOTD.demo.api.controller;

import OOTD.demo.api.dto.auth.CheckNameDto;
import OOTD.demo.api.dto.auth.CreateUserDto;
import OOTD.demo.api.dto.auth.LoginDto;
import OOTD.demo.api.dto.auth.CheckPasswordDto;
import OOTD.demo.config.security.JwtTokenProvider;
import OOTD.demo.domain.Message;
import OOTD.demo.domain.user.User;
import OOTD.demo.service.user.AuthService;
import OOTD.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/api/auth/create")
    public ResponseEntity createUser(@RequestBody CreateUserDto user){
        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        if(authService.existEmail(user.getEmail())){
            message.setStatus(Message.StatusEnum.NOT_ACCEPTABLE);
            message.setMessage("이미 존재하는 이메일입니다.");
            return new ResponseEntity<>(message, headers, HttpStatus.NOT_ACCEPTABLE);
        }
        Long result = authService.createUser(user);
        return result !=null?
                ResponseEntity.ok().body("회원가입 성공"):
                ResponseEntity.badRequest().build();
    }

    @PostMapping("/api/auth/checkname")
    public ResponseEntity<?> checkName(@RequestBody CheckNameDto name){
        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        if(authService.existName(name.getName())){
            message.setStatus(Message.StatusEnum.NOT_ACCEPTABLE);
            message.setMessage("이미 존재하는 닉네임입니다.");
            return new ResponseEntity<>(message, headers, HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok().body("사용 가능한 닉네임입니다.");
    }
    @PostMapping("/api/auth/login")
    public ResponseEntity<?> login(HttpServletResponse response, @RequestBody LoginDto dto){
        User member = authService.login(dto);
        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        String token = jwtTokenProvider.createToken(member.getEmail(), member.getRoles());
        response.setHeader("Auth", token);
        message.setStatus(Message.StatusEnum.OK);
        message.setMessage("로그인 성공");
        message.setData(member.getId());
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }
    @PostMapping("/api/auth/logout")
    public ResponseEntity<?> logout(HttpServletResponse response){
        response.setHeader("Auth", null);
        return ResponseEntity.ok().body("로그아웃 성공");
    }

    @PostMapping("/api/auth/checkpassword/{user-id}")
    public ResponseEntity<?> checkPassword(@PathVariable("user-id") Long id,
                                           @RequestBody CheckPasswordDto dto){
        boolean result = authService.checkPassword(id, dto.getPassword());
        return result == true?
                ResponseEntity.ok().build():
                ResponseEntity.badRequest().build();
    }

}

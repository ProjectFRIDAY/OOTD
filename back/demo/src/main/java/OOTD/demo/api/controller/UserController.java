package OOTD.demo.api.controller;


import OOTD.demo.api.dto.user.ReadUserDto;
import OOTD.demo.api.dto.user.UpdateUserDto;
import OOTD.demo.config.security.JwtTokenProvider;
import OOTD.demo.domain.Message;
import OOTD.demo.domain.user.User;
import OOTD.demo.service.user.AuthService;
import OOTD.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final AuthService authService;

    @GetMapping("/api/user/{user-id}")
    public ResponseEntity<?> readUser(@PathVariable("user-id") Long userId){
        ReadUserDto userDto = userService.readUser(userId);
        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setStatus(Message.StatusEnum.OK);
        message.setMessage("회원 조회 성공");
        message.setData(userDto);

        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @PutMapping("/api/user/{user-id}")
    public ResponseEntity<?> updateUser(@PathVariable("user-id") Long userId, @RequestBody UpdateUserDto dto){
        User updatedUser = userService.userUpdate(userId, dto);
        UpdateUserDto updatedUserDto = new UpdateUserDto(updatedUser);

        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        message.setStatus(Message.StatusEnum.OK);
        message.setMessage("회원 정보를 수정하였습니다.");
        message.setData(updatedUserDto);

        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @DeleteMapping("/api/user/{user-id}")
    public ResponseEntity<?> deleteUser(@PathVariable("user-id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().body("회원탈퇴 성공");
    }
}

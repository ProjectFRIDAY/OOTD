package OOTD.demo.user.controller;


import OOTD.demo.user.dto.ReadUserDto;
import OOTD.demo.user.dto.UpdateUserDto;
import OOTD.demo.common.Message;
import OOTD.demo.user.User;
import OOTD.demo.auth.service.AuthService;
import OOTD.demo.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
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
    private final UserService userService;
    private final AuthService authService;

    @Operation(summary = "회원 조회 API", description = "회원 조회 API 입니다.",
            tags = { "User Controller" })
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

    @Operation(summary = "회원 수정 API", description = "회원 수정 API 입니다.",
            tags = { "User Controller" })
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

    @Operation(summary = "회원 삭제(탈퇴) API", description = "회원 삭제(탈퇴) API 입니다.",
            tags = { "User Controller" })
    @DeleteMapping("/api/user/{user-id}")
    public ResponseEntity<?> deleteUser(@PathVariable("user-id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().body("회원탈퇴 성공");
    }
}

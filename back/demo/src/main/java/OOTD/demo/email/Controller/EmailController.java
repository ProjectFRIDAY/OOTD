package OOTD.demo.email.Controller;


import OOTD.demo.email.ConfirmationToken;
import OOTD.demo.email.service.EmailService;
import OOTD.demo.user.User;
import OOTD.demo.user.service.UserService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
public class EmailController {

    private final EmailService emailService;
    private final UserService userService;

    @PostMapping("/email")
    public ResponseEntity emailAuth(@RequestBody emailDTO email) throws Exception {
        emailService.sendSimpleMessage(email.getEmail());

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/verify")
    public ResponseEntity verifyEmail(@RequestBody VerifyDTO verifyRequest) {
        String code = verifyRequest.getCode();
        ConfirmationToken validToken = emailService.findValidToken(code);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/api/user/find")
    public ResponseEntity findPassword(@RequestBody findPasswordDTO request) throws Exception {
        User user = userService.findByEmailAndBirth(request.getEmail(), request.getUser_birth());
        String newPassword = emailService.sendMsgForPassword(request.getEmail());
        userService.setNewPassword(user.getId(), newPassword);

        return new ResponseEntity(HttpStatus.OK);
    }

    @JsonAutoDetect
    @Data
    @AllArgsConstructor
    static class VerifyDTO {
        private String code;
    }

    @JsonAutoDetect
    @Data
    @AllArgsConstructor
    static class emailDTO {
        private String email;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class findPasswordDTO {
        private String email;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate user_birth;
    }
}

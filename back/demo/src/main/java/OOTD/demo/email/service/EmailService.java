package OOTD.demo.email.service;

import OOTD.demo.email.ConfirmationToken;
import OOTD.demo.email.repository.ConfirmationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Random;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender emailSender;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final int PASSWORD_LEN = 10;
    private static final String SENDER_EMAIL = "";
    private static final String SENDER = "";

    private MimeMessage createMessage(String to) throws Exception {
        String code = createKey();
        saveToken(to, code);

        logger.info("보내는 대상 : " + to);
        logger.info("인증 번호 : " + code);
        MimeMessage message = emailSender.createMimeMessage();
        message.addRecipients(Message.RecipientType.TO, to);
        message.setSubject("OOTD 확인 코드: " + code);

        String msg = "";
        msg += code;

        message.setText(msg, "utf-8");
        message.setFrom(new InternetAddress(SENDER_EMAIL, SENDER));

        return message;
    }

    private MimeMessage createMsgForPassword(String to, String newPassword) throws Exception {

        logger.info("새 비밀번호 보내는 대상 : " + to);
        MimeMessage message = emailSender.createMimeMessage();
        message.addRecipients(Message.RecipientType.TO, to);
        message.setSubject("OOTD 새 비밀번호 : " + newPassword);

        String msg = "";
        msg += newPassword;

        message.setText(msg, "utf-8");
        message.setFrom(new InternetAddress(SENDER_EMAIL, SENDER));

        return message;
    }


    @Transactional
    public void saveToken(String to, String ePw) {
        ConfirmationToken confirmationToken = ConfirmationToken.createEmailConfirmationToken(to, ePw);
        confirmationTokenRepository.save(confirmationToken);
    }

    public void sendSimpleMessage(String to) throws Exception {
        MimeMessage message = createMessage(to);
        try {
            emailSender.send(message);
        } catch (MailException es) {
            es.printStackTrace();
            throw new IllegalArgumentException("이메일 인증 오류");
        }
    }

    public String sendMsgForPassword(String to) throws Exception {
        String newPassword = getNewPassword();
        MimeMessage message = createMsgForPassword(to, newPassword);
        try {
            emailSender.send(message);
        } catch (MailException es) {
            es.printStackTrace();
            throw new IllegalArgumentException("이메일 인증 오류");
        }
        return newPassword;
    }

    @Transactional
    public ConfirmationToken findValidToken(String code) {
        ConfirmationToken confirmationToken = confirmationTokenRepository.findByCodeAndExpirationDateAfterAndExpired(code, LocalDateTime.now(), false)
                .orElseThrow(() -> new IllegalArgumentException("Token을 찾을 수 없습니다."));
        confirmationToken.useToken();
        return confirmationToken;
    }

    private static String getNewPassword() {
        int index = 0;
        char[] charArr = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
                'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z' };
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < PASSWORD_LEN; i++) {
            index = (int)(charArr.length * Math.random());
            stringBuffer.append(charArr[index]);
        }
        return stringBuffer.toString();
    }


    private static String createKey() {
        StringBuffer key = new StringBuffer();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            key.append((random.nextInt(10)));
        }
        return key.toString();
    }
}

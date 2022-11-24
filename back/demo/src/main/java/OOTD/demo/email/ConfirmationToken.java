package OOTD.demo.email;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class ConfirmationToken {
    private static final long TOKEN_EXPIRATION_TIME = 5L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;
    @Column
    private LocalDateTime expirationDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    @Column
    private boolean expired;
    @Column
    private String email;
    @Column
    private String code;



    public static ConfirmationToken createEmailConfirmationToken(String email, String code){
        ConfirmationToken confirmationToken = new ConfirmationToken();
        confirmationToken.expirationDate= LocalDateTime.now().plusMinutes(TOKEN_EXPIRATION_TIME);
        confirmationToken.email = email;
        confirmationToken.expired = false;
        confirmationToken.code= code;

        return  confirmationToken;
    }
    public void useToken(){ expired=true; }
}

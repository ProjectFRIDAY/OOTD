package OOTD.demo.follow;

import OOTD.demo.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "FOLLOW")
public class Follow {

    @Id
    @GeneratedValue
    @Column(name = "follow_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id")
    private User follower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followee_id")
    private User followee;

    private Follow(User follower, User followee) {
        this.follower = follower;
        this.followee = followee;
    }

    /**
     * Follow 엔티티를 생성하는 메서드입니다.
     * @param follower 팔로워 (팔로우를 하는 사람)
     * @param followee 팔로우를 받는 사람
     * @return 생성된 Follow 엔티티
     */
    public static Follow createFollow(User follower, User followee) {
        return new Follow(follower, followee);
    }
}

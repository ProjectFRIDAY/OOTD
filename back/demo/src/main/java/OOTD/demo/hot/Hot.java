package OOTD.demo.hot;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Hot {
    @Id
    @GeneratedValue
    @Column()
    private Long id;

    @Column(name = "post_id", nullable = false)
    private Long postId;
    @Column(name = "weight", nullable = false)
    private int weight;
    @Column(name = "user_id", nullable = false)
    private Long userId;
}

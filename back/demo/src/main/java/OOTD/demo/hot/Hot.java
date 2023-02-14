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
    @Column(name = "diary_id")
    private Long id;

    @Column(name = "weight", nullable = false)
    private int weight;

    @Column(name = "user_id", nullable = false)
    private Long userId;
}

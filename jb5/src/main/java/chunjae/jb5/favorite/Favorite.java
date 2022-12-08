package chunjae.jb5.favorite;

import java.time.LocalDateTime;
//spring 3.0 부터는 javax -> jakarta
// import javax.persistence.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "favorite")
@Getter
@Setter
public class Favorite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String favoriteurl;

    @Column(nullable = false)
    private String nickname;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;
}

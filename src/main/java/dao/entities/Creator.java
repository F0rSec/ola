package dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Creator {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String email ;
    @OneToMany(mappedBy = "Creator")
    private List<Video> videos ;
}

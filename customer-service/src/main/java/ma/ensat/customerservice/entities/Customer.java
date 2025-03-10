package ma.ensat.customerservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor
//@ToString
@AllArgsConstructor @Builder
@Entity
@Table(name = "customer")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private String email;
}

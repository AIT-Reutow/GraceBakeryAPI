package cohort46.gracebakeryapi.accounting.model;


import cohort46.gracebakeryapi.bakery.address.model.Address;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;

    private Role role;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    @Nullable
    private String phone;

    @Nullable
    private long birth_date;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Address> addresses = new HashSet<>();

}
//{user_id*, role, login, password, name, email, phone*, birth_date,  [address,...], is_registered}

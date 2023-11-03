package id.starter.perustakaan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_data")
public class User extends BaseEntity<User>{

    private static final long serialVersionUID = 1L;

    @Column(name = "role", columnDefinition = "VARCHAR(50)")
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    @Column(name = "profilename", columnDefinition = "VARCHAR(100)", nullable = false )
    private String profileName;

    @Column(name = "username", columnDefinition = "VARCHAR(50)", nullable = false )
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "token")
    private String token;

    public User(String username) {
        this.username = username;
    }
}

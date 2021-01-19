package co.uk.jdreamer.shoppingcart.models;
/*
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, message = "Username must be at least 2 characters long")
    private String username;

    @Size(min = 4, message = "Password must be at least 4 characters long")
    private String password;

    @Transient // means that this field is not part of users table
    private String confirmPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Email(message = "Please enter a valid email")
    private String email;


    @Size(min = 6, message = "Phone number must be at least 6 characters long")
    private String phoneNumber;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    String role;

}

 */
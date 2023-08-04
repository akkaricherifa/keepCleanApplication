package com.example.keepcleanproxymapp.app.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class AppUser implements UserDetails {
    @Id
    @SequenceGenerator(name="appuser_sequence",sequenceName ="appuser_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "appuser_sequence")
    private Long id;
    private String FirstName;
    private String LastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean enabled=false;

    public AppUser(String FirstName,
                   String LastName,
                   String email,
                   String password,
                   AppUserRole appUserRole
    ) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;


    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    public Long getId() {
        return id;
    }

    public AppUserRole getAppUserRole() {
        return appUserRole;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

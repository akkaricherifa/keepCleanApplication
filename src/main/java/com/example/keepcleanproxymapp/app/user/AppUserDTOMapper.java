package com.example.keepcleanproxymapp.app.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AppUserDTOMapper implements Function<AppUser,AppUserDTO> {
    @Override
    public AppUserDTO apply(AppUser appUser) {
        return new AppUserDTO(
                appUser.getId(),
                appUser.getFirstName(),
                appUser.getLastName(),
                appUser.getEmail(),
                appUser.getAuthorities()
                        .stream().map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()),

                appUser.isEnabled()
        );
    }
}

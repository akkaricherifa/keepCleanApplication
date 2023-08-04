package com.example.keepcleanproxymapp.app.user;

import java.util.List;

public record AppUserDTO(
        Long id,
        String FirstName,
        String LastName,
        String email,
        List<String> appUserRoles,
        Boolean enabled
) {
}

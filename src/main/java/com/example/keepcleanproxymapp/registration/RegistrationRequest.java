package com.example.keepcleanproxymapp.registration;

import com.example.keepcleanproxymapp.app.user.AppUserRole;

public record RegistrationRequest(String first_name, String last_name, String email, AppUserRole app_user_role,
                                  String password) {
}

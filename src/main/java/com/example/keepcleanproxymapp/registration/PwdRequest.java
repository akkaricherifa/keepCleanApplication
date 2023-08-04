package com.example.keepcleanproxymapp.registration;

public record PwdRequest(
        String current,
        String newPWD,
        String renew
) {
}

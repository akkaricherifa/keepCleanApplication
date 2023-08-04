package com.example.keepcleanproxymapp.registration;

import com.example.keepcleanproxymapp.app.user.AppUser;
import com.example.keepcleanproxymapp.app.user.AppUserDTO;
import com.example.keepcleanproxymapp.app.user.AppUserDTOMapper;
import com.example.keepcleanproxymapp.app.user.AppUserRole;
import com.example.keepcleanproxymapp.repository.AppUserRepository;
import com.example.keepcleanproxymapp.service.AppUserService;
import com.example.keepcleanproxymapp.service.JwtService;
import com.example.keepcleanproxymapp.token.ConfirmationTokenRepository;
import com.example.keepcleanproxymapp.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final ConfirmationTokenService confirmationTokenService;
    private EmailValidator emailValidator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AppUserRepository appUserRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final AppUserDTOMapper appUserDTOMapper;
    private final JwtService jwtService;
    private AuthenticationManager authenticationManager;


    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.email());
        if (!isValidEmail) {
            return ("email n'est pas valide");
        }
        String token = appUserService.signUpUser(
                new AppUser(
                        request.first_name(),
                        request.last_name(),
                        request.email(),
                        request.password(),
                        AppUserRole.valueOf(String.valueOf(request.app_user_role()))
                )
        );
        return token;
    }

    public List<AppUserDTO> findAllAppUsers () {
        return appUserRepository.findAll()
                .stream()
                .map(appUserDTOMapper)
                .collect(Collectors.toList());
    }

    public HashMap<String,String> login(@RequestBody LoginRequest loginRequest){
        HashMap<String, String> map = new HashMap<>();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        AppUser appUser = appUserRepository.findByEmail(loginRequest.email()).orElse(null);
        assert appUser != null;
        String role=appUser.getAppUserRole().toString();

        if (!encoder.matches(loginRequest.password(), appUser.getPassword())) {
            map.put("response", "password");
            return map;
        } else if ((appUser.isEnabled()) &&
                encoder.matches(loginRequest.password(), appUser.getPassword())) {
            map.put("response", role);
            map.put("FirstName", appUser.getFirstName());
            map.put("LastName", appUser.getLastName());
            map.put("currentUserId", appUser.getId().toString());
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
            map.put("token", jwtService.generateToken(authentication));
            return map;
        } else if (!appUser.isEnabled()) {
            map.put("response", "disabled");
            return map;
        }
        return null;
    }

}

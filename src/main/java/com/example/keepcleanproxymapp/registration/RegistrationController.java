package com.example.keepcleanproxymapp.registration;

import com.example.keepcleanproxymapp.app.user.AppUserDTO;
import com.example.keepcleanproxymapp.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("registration")
@AllArgsConstructor
public class RegistrationController {
    private  RegistrationService registrationService;
    private final AppUserRepository appUserRepository;

    public ResponseEntity<List<AppUserDTO>> getAllAppUsers () {
        List<AppUserDTO> appUsers=registrationService.findAllAppUsers();
        return new ResponseEntity<>(appUsers, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request){
        if(appUserRepository.findByEmail(request.email()).isPresent()) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

        }else{
            return new ResponseEntity<>(registrationService.register(request), HttpStatus.OK);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<HashMap<String,String>> login(@RequestBody LoginRequest loginRequest) {

        return new ResponseEntity<>(registrationService.login(loginRequest), HttpStatus.OK);
    }
}

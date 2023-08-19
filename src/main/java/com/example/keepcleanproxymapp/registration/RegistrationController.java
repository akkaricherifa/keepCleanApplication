package com.example.keepcleanproxymapp.registration;

import com.example.keepcleanproxymapp.app.user.AppUser;
import com.example.keepcleanproxymapp.app.user.AppUserDTO;
import com.example.keepcleanproxymapp.app.user.AppUserRole;
import com.example.keepcleanproxymapp.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/registration")
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
    @GetMapping("/all/{role}")
    public ResponseEntity<List<AppUserDTO>> getAppUsersByRole(@PathVariable("role") AppUserRole role) {
        List<AppUserDTO> appUserDTOs = registrationService.findByRole(role);
        return new ResponseEntity<>(appUserDTOs, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAppUser(@PathVariable("id") Long id,@RequestBody RegistrationRequest request) {
        registrationService.updateAppUser(request,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppUser(@PathVariable("id") Long id) {
        registrationService.deleteAppUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}

package ChavesWeb.Chaves.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import ChavesWeb.Chaves.security.JwtUtils;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                                                loginRequest.getPassword()
      )
);
                                                                        
SecurityContextHolder.getContext().setAuthentication(authentication);
String jwt = jwtUtils.generateToken(authentication.getName());
                                                                        
return ResponseEntity.ok(new JwtResponse(jwt));
    }
}
                                                                        
class LoginRequest {
@SuppressWarnings("unused")
private String username;
    @SuppressWarnings("unused")
    private String password;
    public Object getUsername() {                                                                                
    throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
}
    public Object getPassword() {
    throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
}

}

class JwtResponse {
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}

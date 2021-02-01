package br.com.plannic.controller;


import br.com.plannic.model.AuthRequest;
import br.com.plannic.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class AuthenticateController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "WINXS IFSP";
    }

    @GetMapping("/{email}/{pswd}")
    public String generateToken(@PathVariable String email,@PathVariable String pswd) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, pswd)
            );
        } catch (Exception ex) {
            throw new Exception("erro na autenticação.");
        }
        return jwtUtil.generateToken(email);
    }
}

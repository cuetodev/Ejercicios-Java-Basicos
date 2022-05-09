package com.cuetodev.ej3_1.Login;

import com.cuetodev.ej3_1.ErrorHandling.NotFoundException;
import com.cuetodev.ej3_1.ErrorHandling.UnprocesableException;
import com.cuetodev.ej3_1.Persona.application.port.PersonaPort;
import com.cuetodev.ej3_1.Persona.domain.Persona;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoginController {
    @Autowired
    PersonaPort personaPort;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestParam("user") String username, @RequestParam("password") String password) throws Exception {
        List<Persona> peopleList = personaPort.findPersonaByUsuario(username);
        if (peopleList.size() == 0) throw new NotFoundException("Usuario " + username + " no encontrado");
        if (peopleList.size() > 1) throw new UnprocesableException("Usuario amiguo");
        Persona persona = peopleList.get(0);
        String personaPassword = persona.getPassword();
        if (!personaPassword.equals(password)) throw new UnprocesableException("Credenciales incorrectas");
        String rol = persona.getAdmin() ? "ROLE_ADMIN" : "ROLE_USER";
        return new ResponseEntity<>(getJWTToken(username, rol), HttpStatus.OK);
    }

    private String getJWTToken(String username, String rol) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}

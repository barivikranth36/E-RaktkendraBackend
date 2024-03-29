package com.dd.eraktkendrabackend.Controller;

import com.dd.eraktkendrabackend.DTO.JwtRequest;
import com.dd.eraktkendrabackend.DTO.JwtResponse;
import com.dd.eraktkendrabackend.DTO.JwtResponseFieldWorker;
import com.dd.eraktkendrabackend.DTO.JwtResponseUser;
import com.dd.eraktkendrabackend.Repository.FieldWorkerRepository;
import com.dd.eraktkendrabackend.Repository.UserRepository;
import com.dd.eraktkendrabackend.Service.CustomUserDetailService;
import com.dd.eraktkendrabackend.Service.MyInitialService;
import com.dd.eraktkendrabackend.Utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private MyInitialService myInitialService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JWTUtility jwtUtility;

    @PostMapping("/generateToken")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        System.out.println(jwtRequest.toString());

        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    jwtRequest.getUsername(), jwtRequest.getPassword()
            ));

        } catch (UsernameNotFoundException ne) {
            ne.printStackTrace();
            throw new Exception("Bad Credentials");
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }

        UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtility.generateToken(userDetails);

        System.out.println("Jwt token = " + token);

        // Everything is fine
        if(jwtRequest.getRole().equals("user")) {
            return ResponseEntity.ok(new JwtResponseUser(
                    token,
                    myInitialService.getUser(jwtRequest)
            ));
        }

        if(jwtRequest.getRole().equals("fieldworker")) {
            return ResponseEntity.ok(new JwtResponseFieldWorker(
                    token,
                    myInitialService.getFieldWorker(jwtRequest)
            ));
        }
        return ResponseEntity.ok(new JwtResponse(token));
    }
}

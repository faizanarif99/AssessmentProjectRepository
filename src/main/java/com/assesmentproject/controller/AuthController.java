package com.assesmentproject.controller;

import com.assesmentproject.dtos.AuthRequest;
import com.assesmentproject.dtos.AuthResponse;
import com.assesmentproject.security.JwtUtil;
import com.assesmentproject.utils.Constants;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "assessment")
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest)
            throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.ok(new AuthResponse(Constants.API_RESPONSE_CODE_BAD_REQUEST_ERROR, "Invalid username or password", Constants.TOKEN_NOT_VALID));
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails);
        if (token != null && !token.isEmpty()) {
            return ResponseEntity.ok(new AuthResponse(Constants.API_RESPONSE_CODE_OK, Constants.AUTHORIZED, token));
        }
        return ResponseEntity.ok(new AuthResponse(Constants.API_RESPONSE_CODE_BAD_REQUEST_ERROR, Constants.UNAUTHORIZED, Constants.TOKEN_NOT_VALID));
    }
}




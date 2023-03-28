package com.exam.exam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exam.config.JwtUtil;
import com.exam.exam.model.JwtRequest;
import com.exam.exam.model.JwtResponse;

@RestController
@CrossOrigin(origins="*")
public class AuthenticateController {
      @Autowired
	 private AuthenticationManager authenticationManager;
      @Autowired
      private UserDetailsService userDetailsService; 
        @Autowired
      private JwtUtil jwtUtil;
        
        //genrate token
        
        @PostMapping("/genrate-tokens")
        public ResponseEntity<?> genrateToken(@RequestBody JwtRequest jwtRequest)throws Exception
        { 
        	 
        	System.out.println("this is controller");
        	try {
        		
				authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
				 
			} catch (UsernameNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new Exception("UsernameNotFound");
				
			}
        	
        	
        	UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        	 String token=this.jwtUtil.generateToken(userDetails);
        	 
        	
        	 
			return ResponseEntity.ok(new JwtResponse(token));
        	
        }
        
	private void authenticate(String username,String password) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password) )
			;
		} catch (DisabledException e) {
			// TODO: handle exception
			throw  new Exception("user Disabled");
			
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw  new Exception("Invalid Creditionals" + e.getMessage());
		}
	}
}

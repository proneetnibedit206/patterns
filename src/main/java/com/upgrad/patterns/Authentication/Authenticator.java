package com.upgrad.patterns.Authentication;

import com.upgrad.patterns.Middleware.AuthenticationProcessor;
import com.upgrad.patterns.Middleware.BasicAuthProcessor;
import com.upgrad.patterns.Middleware.JwtAuthProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class Authenticator {

    static AuthenticationProcessor authenticationProcessor;
    //JwtAuthProcessor jwtAuthProcessor;
//create a public static method GetAuthProcessor of the return type AuthenticationProcessor
	// create an object of type JwtAuthProcessor
	// Chain Authentication processors, first JWT processor is to be used first and then basic auth processor
	// return the object

    public static AuthenticationProcessor GetAuthProcessor(){

        return new JwtAuthProcessor(authenticationProcessor);
        //new BasicAuthProcessor(authenticationProcessor);
    }

    public static AuthenticationProvider GetAuthProvider(HttpServletRequest request)
    {
        if(request.getHeader("Authorization") != null)
            return new JwtAuthProvider(request.getHeader("Authorization"));
        return new BasicAuthProvider(request.getHeader("Username"), request.getHeader("Password"));
    }
}

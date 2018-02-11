/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enti_ararasdev.enti_ararasdev.security;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author Michel
 */
@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        super.commence(request, response, authException); //To change body of generated methods, choose Tools | Templates.
        
        if(request instanceof HttpServletRequest){
            response.addHeader("WWW-Authenticate", "Basic realm = "+getRealmName());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter writer = response.getWriter();
            writer.println("HTTP Status 401 - " + authException.getMessage());
        }
        
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("ENTI-ARARASDEV");
        super.afterPropertiesSet(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

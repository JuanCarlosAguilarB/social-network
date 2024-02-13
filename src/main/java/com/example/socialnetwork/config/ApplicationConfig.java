package com.example.socialnetwork.config;

import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.exceptions.UserNotFoundException;
import com.example.socialnetwork.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Configuration
@RequiredArgsConstructor

public class ApplicationConfig {

    private final UserRepository userRepository;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

// refactoring, this class shuold be removed, single responsability principle
    @Bean
    public WebSecurityCustomizer ignoringCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/user", "/ignore2");
    }

    // create a bean for AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
    {
        return config.getAuthenticationManager();
    }


    @Bean
    public UserDetailsService userDetailService() {
        return new UserDetailsService() {
            @Autowired
            private UserRepository userRepository;

            @Override
            public UserDetails loadUserByUsername(String email) throws UserNotFoundException {
//                User user = userRepository.findByEmail(email);
                User user = userRepository.findByUsername(email);


                if (user == null) {
                    throw new UserNotFoundException("Usuario no encontrado con el correo electrónico: " + email);
                }
//                return new org.springframework.security.core.userdetails.User(
//                        user.getEmail(), user.getPassword(), user.getRoles());
//            }
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(), user.getPassword(),
                    true, true, true, true, Collections.emptyList());
            }

        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}

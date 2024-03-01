package com.example.socialnetwork.config;

import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.exceptions.UserNotFoundException;
import com.example.socialnetwork.repositories.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collection;
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
        return (web) -> web.ignoring().requestMatchers(
//                "/user",
                "/ignore2"
        );
    }

    // create a bean for AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
    {
        return config.getAuthenticationManager();
    }


    @ExceptionHandler({ UserNotFoundException.class })
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
                    user.getUsername(), user.getPassword(),
                    true, true, true, true, Collections.emptyList());
            }


//                return new CustomUserDetails(
//                        user.getUsername(),
//                        user.getEmail(),
//                        user.getPassword()
////                        Collections.emptyList()
//                );

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

//@Getter
//public class CustomUserDetails implements UserDetails {
//
//    private String username;
//    private String email;
//    private String password;
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public CustomUserDetails(String username, String email, String password) {
//        this.username = username;
//        this.email = email;
//        this.password = password;
//
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//
//    // Constructor, getters y setters
//}
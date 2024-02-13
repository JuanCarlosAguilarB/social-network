//package com.example.socialnetwork.config;
//
//import com.example.socialnetwork.entities.User;
//import com.example.socialnetwork.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("Usuario no encontrado con nombre de usuario: " + username);
//        }
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(), user.getPassword(), null);
//    }
//}

package com.example.socialnetwork.config;

import java.io.IOException;
import java.time.LocalDateTime;

import com.example.socialnetwork.Ininfrastructure.GetUsernameFromToken;
import com.example.socialnetwork.Ininfrastructure.IGetUsernameFromToken;
import com.example.socialnetwork.Ininfrastructure.ValidateToken;
import com.example.socialnetwork.exceptions.ApiExceptionResponse;
import com.example.socialnetwork.exceptions.JwtTokenException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.util.StringUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final IGetUsernameFromToken getUsernameFromToken;
    private final UserDetailsService userDetailsService;
    private final ValidateToken validateToken;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String token = getTokenFromRequest(request);
        final String username;

        if (token == null) {
            ApiResponseHelper.sendErrorResponse(response, HttpStatus.BAD_REQUEST, "Bad Request", "El token no puede ser nulo");
//            filterChain.doFilter(request, response);
        return;

        }
        username = getUsernameFromToken.getUsernameFromToken(token);
        if (username == null) {
            ApiResponseHelper.sendErrorResponse(response, HttpStatus.BAD_REQUEST, "Bad Request", "El token is not valid");
            return;
        }

        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (validateToken.isValidToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                // Token inválido
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
                return;
            }

        }



        filterChain.doFilter(request, response);
    }


    public class ApiResponseHelper {

        public static void sendErrorResponse(HttpServletResponse response, HttpStatus status, String error, String message) throws IOException {
            response.setStatus(status.value());
            response.setContentType("application/json");

            String jsonResponse = String.format("{\"timestamp\": \"%s\", \"status\": \"%d\", \"error\": \"%s\", \"message\": \"%s\"}",
                    LocalDateTime.now(), status.value(), error, message);

            response.getWriter().write(jsonResponse);
        }
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }
}




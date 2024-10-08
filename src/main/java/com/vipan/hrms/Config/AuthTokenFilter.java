//package com.vipan.hrms.Config;
//
//import com.vipan.hrms.security.JwtUtils;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//public class AuthTokenFilter extends OncePerRequestFilter {
//
//    private final JwtUtils jwtUtils;
//    private final UserDetailsService userDetailsService;
//    private final AuthenticationManager authenticationManager;
//
//    public AuthTokenFilter(JwtUtils jwtUtils, UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
//        this.jwtUtils = jwtUtils;
//        this.userDetailsService = userDetailsService;
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String jwt = parseJwt(request);
//        if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
//            String username = jwtUtils.getUsernameFromToken(jwt);
//
//            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//            UsernamePasswordAuthenticationToken authentication =
//                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    private String parseJwt(HttpServletRequest request) {
//        String headerAuth = request.getHeader("Authorization");
//
//        if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
//            return headerAuth.substring(7);
//        }
//
//        return null;
//    }
//}
//

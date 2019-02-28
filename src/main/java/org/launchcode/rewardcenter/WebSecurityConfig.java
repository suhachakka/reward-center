//package org.launchcode.rewardcenter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import java.util.HashSet;
//import java.util.Set;
//
////@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailsServiceImpl userDetailsServiceImpl;
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests()
//                .regexMatchers("/user/welcome").permitAll()
//                .regexMatchers("/user/signup").permitAll()
//                .regexMatchers( "/card/.*").permitAll()
//                .regexMatchers( "/list/base").permitAll()
//                .regexMatchers( "/user/*.*").permitAll()
//                .regexMatchers( "/category/.*").permitAll()
//                .regexMatchers( "/department/.*").permitAll()
//                .regexMatchers( "/offer/.*").permitAll()
//                .regexMatchers( "/*").permitAll()
//                  .anyRequest().authenticated()
//                  .and()
//                .formLogin()
//                .loginPage("/user/signin")
//                .loginProcessingUrl("/user/signin")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/user/base")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/user/signout")
//                .permitAll()
//                .and().exceptionHandling()
//                .accessDeniedPage("/user/signout");
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//      BCryptPasswordEncoder byCryptPasswordEncoder =new BCryptPasswordEncoder();
//      Set<SimpleGrantedAuthority> userAuthorities =new HashSet<>();
//      userAuthorities.add(new SimpleGrantedAuthority("admin"));
//        auth.userDetailsService(UserDetails)(new org.springframework.security.core.userdetails.User("suha@great.com","manasvi",
//                userAuthorities));
//    }
//
//}

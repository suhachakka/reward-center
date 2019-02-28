//package org.launchcode.rewardcenter;
//
//import org.launchcode.rewardcenter.models.User;
//import org.launchcode.rewardcenter.models.data.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
//        org.launchcode.rewardcenter.models.User userInfo = userDao.findByEmail(email);
//        GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
//
//        org.springframework.security.core.userdetails.User user =
//                new org.springframework.security.core.userdetails.User(userInfo.getEmail(),userInfo.getPassword(), Arrays.asList(authority));
//        UserDetails userDetails =(UserDetails)user;
//        return userDetails;
//    }
//}

package xyz.nesting.example.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by joe on 26/12/17.
 */
@Service
public class JwtUserDetailService implements UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String username) {

        return new JwtUser(
                1L,
                "admin",
                "admin",
                "admin",
                "admin@amin",
                "$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi",
                new ArrayList<GrantedAuthority>(),
                true,
                new Date()
        );

    }
}

package co.uk.jdreamer.shoppingcart.security;

import co.uk.jdreamer.shoppingcart.loginModels.LoginUser;
import co.uk.jdreamer.shoppingcart.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //LoginUser user = userRepository.findByUsername(username);
        LoginUser user = userRepository.findByUsername(username);

        if (user != null) {
            return (UserDetails) user;
        }

        throw new UsernameNotFoundException(username);
    }
}

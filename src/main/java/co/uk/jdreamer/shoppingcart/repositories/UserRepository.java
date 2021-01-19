package co.uk.jdreamer.shoppingcart.repositories;

import co.uk.jdreamer.shoppingcart.loginModels.LoginUser;
import co.uk.jdreamer.shoppingcart.loginModels.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer> {

    LoginUser findByUsername(String username);
    LoginUser findByEmail(String email);
}

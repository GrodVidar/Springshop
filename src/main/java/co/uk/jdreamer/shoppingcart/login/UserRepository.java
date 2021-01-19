package co.uk.jdreamer.shoppingcart.login;
import co.uk.jdreamer.shoppingcart.loginModels.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer> {
    Optional<LoginUser> findByUserName(String userName);
}
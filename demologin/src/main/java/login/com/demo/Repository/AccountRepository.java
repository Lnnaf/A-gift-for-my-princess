package login.com.demo.Repository;

import login.com.demo.Entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<AccountEntity,Integer> {
    AccountEntity findAccountByUsername(String username);

    @Query(value = "select id from AccountEntity where username = ?1", nativeQuery = true)
    Integer findIdUserByUserName(String username);

    @Query(value = "SELECT username from  AccountEntity where username = ?1", nativeQuery = true)
    String existsByUserName(String username);

    @Modifying
    @Query(value = "insert into AccountEntity(username,password) values (?1,?2)", nativeQuery = true)
    void addNewAccount(String username, String password);


}

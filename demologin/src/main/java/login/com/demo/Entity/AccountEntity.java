package login.com.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;


@Entity(name = "user")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<AccountRoleEntity> accountRoleList;

    public AccountEntity() {
    }

    public AccountEntity(Integer id, String username, String password, Set<AccountRoleEntity> accountRoleList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountRoleList = accountRoleList;
    }

    public Set<AccountRoleEntity> getAccountRoleList() {
        return accountRoleList;
    }

    public void setAccountRoleList(Set<AccountRoleEntity> accountRoleList) {
        this.accountRoleList = accountRoleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

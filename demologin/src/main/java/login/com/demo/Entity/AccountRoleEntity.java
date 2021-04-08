package login.com.demo.Entity;

import javax.persistence.*;

@Entity (name = "user_role")
public class AccountRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountRoleId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AccountEntity account;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    public AccountRoleEntity() {
    }

    public AccountRoleEntity(Integer accountRoleId, AccountEntity account, RoleEntity role) {
        this.accountRoleId = accountRoleId;
        this.account = account;
        this.role = role;
    }

    public Integer getAccountRoleId() {
        return accountRoleId;
    }

    public void setAccountRoleId(Integer accountRoleId) {
        this.accountRoleId = accountRoleId;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}

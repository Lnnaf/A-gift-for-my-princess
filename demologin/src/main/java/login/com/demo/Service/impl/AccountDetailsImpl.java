package login.com.demo.Service.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import login.com.demo.Entity.AccountEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class AccountDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;

    @JsonIgnore
    private String password;
    List<GrantedAuthority> authorities = null;

    public AccountDetailsImpl(Integer id, String username, String password, List<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }
    //lay tai khoan toi AccountService
    public static AccountDetailsImpl build(AccountEntity account) {
        List<GrantedAuthority> authorities = account.getAccountRoleList().stream().map(role -> new SimpleGrantedAuthority(role.getRole().getRole_name()))
                .collect(Collectors.toList());
        return new AccountDetailsImpl(account.getId(),
                account.getUsername(),
                account.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled( ) {
        return false;
    }
}

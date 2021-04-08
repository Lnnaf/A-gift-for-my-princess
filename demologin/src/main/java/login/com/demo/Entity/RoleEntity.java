package login.com.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "app_role")
public class RoleEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer role_ID;
    private String role_name;

    public RoleEntity() {

    }
    public RoleEntity(Integer role_ID, String role_name) {
        this.role_ID = role_ID;
        this.role_name = role_name;
    }
    public Integer getRole_ID() {
        return role_ID;
    }

    public void setRole_ID(Integer role_ID) {
        this.role_ID = role_ID;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}

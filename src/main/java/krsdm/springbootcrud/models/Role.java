package krsdm.springbootcrud.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }

    public String nameNoPrefix() {
       return name.split("_")[1];
    }

    @Override
    public String getAuthority() {
        return name;
    }
}

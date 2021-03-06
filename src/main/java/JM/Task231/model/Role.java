package JM.Task231.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Set;

@Table(name = "roles")
@Transient
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Transactional
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    @Transactional
    public String getAuthority() {
        return getName();
    }

    @Override
    public String toString() {
        return name;
    }
}

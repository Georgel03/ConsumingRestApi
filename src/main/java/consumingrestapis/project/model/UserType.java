package consumingrestapis.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "usertype")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usertype;

    public UserType(Long id, String usertype) {
        this.id = id;
        this.usertype = usertype;
    }

    public UserType(String usertype) {
        this.usertype = usertype;
    }

    public UserType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}

package BaseDeDonnee;

public class Player {
    
    private Integer id; //

    private String username;

    private String email;

    private String password;

    private Integer permission;

/*
    public enum permission {
        Admin,
        Inter,
        Basic
    };
*/
    public Player(){

    }

    public Player(Integer id,String username, String email, String password, Integer permission) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                '}';
    }
}

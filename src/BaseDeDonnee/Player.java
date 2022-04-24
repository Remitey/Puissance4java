package BaseDeDonnee;

public class Player {
    
    private Integer id;

    private String username;

    private String email;

    private String password;

    private Integer permission;

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
}

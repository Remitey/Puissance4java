package BaseDeDonnee;

public class Turn {

    private Integer game_id; //

    private Integer turn;

    private Integer player_id; //

    private Integer x;

    private Integer y;

    public Turn(){

    }

    public Turn(Integer game_id, Integer turn, Integer player_id, Integer x, Integer y){
        this.game_id = game_id;
        this.turn = turn;
        this.player_id = player_id;
        this.x = x;
        this.y = y;
    }

    public Integer getId() {
        return game_id;
    }

    public void setId(Integer id) {
        this.game_id = game_id;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}

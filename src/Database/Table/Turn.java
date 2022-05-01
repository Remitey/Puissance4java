package Database.Table;


public class Turn {

    private Integer game;

    private Integer turn;

    private Player player;

    private Integer x;

    private Integer y;

    public Turn(){}
    public Turn(Integer game, Integer turn, Player player, Integer x, Integer y){
        this.game = game;
        this.turn = turn;
        this.player = player;
        this.x = x;
        this.y = y;
    }

    public Integer getGame() {
        return game;
    }

    public void setGame(Integer game) {
        this.game = game;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public Player getPlayer_id() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    @Override
    public String toString() {
        return "Turn{" +
                "game=" + game +
                ", turn=" + turn +
                ", player=" + player +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

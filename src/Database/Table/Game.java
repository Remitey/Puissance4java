package Database.Table;

import java.util.Date;

public class Game {
    private Integer id;
    private Player player_1;
    private Player player_2;
    private Cpu cpu ;
    private Integer grid_size_row ;
    private Integer grid_size_col;
    private Integer result;
    private Long time;
    private Long duration;
    public Game() {}
    public Game(Integer id, Player player_1, Player player_2, Integer grid_size_row, Integer grid_size_col, Integer result, long time, long duration) {
        this.id = id;
        this.player_1 = player_1;
        this.player_2 = player_2;
        this.grid_size_row = grid_size_row;
        this.grid_size_col = grid_size_col;
        this.result = result;
        this.time = time;
        this.duration = duration;
    }

   public Game(Integer id, Player player_1,Cpu cpu, Integer grid_size_row, Integer grid_size_col, Integer result, long time, long duration){
        this.id = id;
        this.player_1 = player_1;
        this.cpu = cpu;
        this.grid_size_row = grid_size_row;
        this.grid_size_col = grid_size_col;
        this.result = result;
        this.time = time;
        this.duration = duration;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer_1() {
        return player_1;
    }

    public void setPlayer_1(Player player_1) {
        this.player_1 = player_1;
    }

    public Player getPlayer_2() {
        return player_2;
    }

    public void setPlayer_2(Player player_2) {
        this.player_2 = player_2;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Integer getGrid_size_row() {
        return grid_size_row;
    }

    public void setGrid_size_row(Integer grid_size_row) {
        this.grid_size_row = grid_size_row;
    }

    public Integer getGrid_size_col() {
        return grid_size_col;
    }

    public void setGrid_size_col(Integer grid_size_col) {
        this.grid_size_col = grid_size_col;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", player_1=" + player_1 +
                ", player_2=" + player_2 +
                ", cpu_level_id=" + cpu +
                ", grid_size_row=" + grid_size_row +
                ", grid_size_col=" + grid_size_col +
                ", result=" + result +
                ", time=" + time +
                ", duration=" + duration +
                '}';
    }
}

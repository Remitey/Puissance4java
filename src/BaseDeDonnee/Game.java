package BaseDeDonnee;

import java.time.*;

public class Game {

    private Integer id;

    private Integer player_1; //

    private Integer player_2;//

    private Integer cpu_level_id ;//

    private Integer grid_size_row ;

    private Integer grid_size_col;

    private Integer result;

    private LocalDateTime time;

    private Duration duration;


    // stockage du time pour DURATION ET DATETIME_START ??

    public Game() {

    }

    public Game(Integer id, Integer player_1, Integer player_2, Integer cpu_level_id, Integer grid_size_row, Integer grid_size_col, Integer result, LocalDateTime time, Duration duration) {
        this.id = id;
        this.player_1 = player_1;
        this.player_2 = player_2;
        this.cpu_level_id = cpu_level_id;
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

    public Integer getPlayer_1_id() {
        return player_1;
    }

    public void setPlayer_1_id(Integer player_1) {
        this.player_1 = player_1;
    }

    public Integer getPlayer_2_id() {
        return player_2;
    }

    public void setPlayer_2_id(Integer player_2) {
        this.player_2 = player_2;
    }

    public Integer getCpu_level_id() {
        return cpu_level_id;
    }

    public void setCpu_level_id(Integer cpu_level_id) {
        this.cpu_level_id = cpu_level_id;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}

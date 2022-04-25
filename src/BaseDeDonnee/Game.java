package BaseDeDonnee;

import java.time.*;

public class Game {

    private Integer id;

    private Integer player_1_id = Player.getId();

    private Integer player_2_id;//

    private Integer cpu_level_id;//

    private Integer grid_size_row ;

    private Integer grid_size_col;

    private Integer result;

    private LocalDateTime time;

    private Duration duration;


    // stockage du time pour DURATION ET DATETIME_START ??

    public Game() {

    }

    public Game(Integer id, Integer player_1_id, Integer player_2_id, Integer cpu_level_id, Integer grid_size_row, Integer grid_size_col, Integer result, LocalDateTime time, Duration duration) {
        this.id = id;
        this.player_1_id = player_1_id;
        this.player_2_id = player_2_id;
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
        return player_1_id;
    }

    public void setPlayer_1_id(Integer player_1_id) {
        this.player_1_id = player_1_id;
    }

    public Integer getPlayer_2_id() {
        return player_2_id;
    }

    public void setPlayer_2_id(Integer player_2_id) {
        this.player_2_id = player_2_id;
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

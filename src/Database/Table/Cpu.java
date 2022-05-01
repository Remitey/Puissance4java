package Database.Table;

public class Cpu {

    private Integer id;

    private String description;

    private Integer depth;

    public Cpu(){}

    public Cpu(Integer id, String description, Integer depth){
        this.id = id;
        this.description = description;
        this.depth = depth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", depth=" + depth +
                '}';
    }
}

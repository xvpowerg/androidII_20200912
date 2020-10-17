package tw.com.xvpower.sqlite_project.bean;

public class Student {
    private  int id;
    private String name;
    private  float score;
    private String createTime;

    public Student() {

    }

    public Student(int id, String name, float score, String createTime) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}

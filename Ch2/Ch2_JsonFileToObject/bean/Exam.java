package tw.com.xvpower.ch2_jsonfiletoobject.bean;

public class Exam {
    private String subject;
    private int score;

    public Exam(String subject, int score) {
        this.subject = subject;
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String toString(){
        return subject+":"+score;
    }
}

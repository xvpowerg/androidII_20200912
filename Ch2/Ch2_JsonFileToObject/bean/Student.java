package tw.com.xvpower.ch2_jsonfiletoobject.bean;


public class Student {
    private String name;
    private Exam[] exam;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Exam[] getExam() {
        return exam;
    }

    public void setExam(Exam[] exam) {
        this.exam = exam;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(":");
        sb.append("[");
        if (exam != null)
        for (Exam ex : exam){
            sb.append(ex.toString());
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Student {
    private String name;
    private String studentId;
    private int assignment1;
    private int assignment2;
    private int assignment3;

    public Student(String name, String studentId, int a1, int a2, int a3) {
        this.name = name;
        this.studentId = studentId;
        this.assignment1 = a1;
        this.assignment2 = a2;
        this.assignment3 = a3;
    }

    public int getTotalMarks() {
        return assignment1 + assignment2 + assignment3;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return name + " (" + studentId + ") - Total: " + getTotalMarks();
    }
}

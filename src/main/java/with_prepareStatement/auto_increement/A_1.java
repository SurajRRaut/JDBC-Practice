package with_prepareStatement.auto_increement;
// WITH AUTO INCREMENT
public class A_1 {
    private String student_Name;
    private char student_Div;

    @Override
    public String toString() {
        return "Array_1{" +
                ", student_Name='" + student_Name + '\'' +
                ", student_Div=" + student_Div +
                '}';
    }

    public A_1(String student_name, char student_div) {
        student_Name = student_name;
        student_Div = student_div;
    }

    public char getStudent_Div() {
        return student_Div;
    }

    public void setStudent_Div(char student_Div) {
        this.student_Div = student_Div;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }
}

package with_prepareStatement;
// INSERT DATA DYNAMICALLY BY USING ARRAY LIST WITH Array_2 Claas>>
// EX : take data from user , add in array list , and then add in the database
public class Array_1 {
    private int student_Roll_Number;
    private String student_Name;
    private char student_Div;

    @Override
    public String toString() {
        return "Array_1{" +
                "student_Roll_Number=" + student_Roll_Number +
                ", student_Name='" + student_Name + '\'' +
                ", student_Div=" + student_Div +
                '}';
    }

    public Array_1(int student_roll_number, String student_name, char student_div) {
        student_Roll_Number = student_roll_number;
        student_Name = student_name;
        student_Div = student_div;
    }

    public char getStudent_Div() {
        return student_Div;
    }

    public void setStudent_Div(char student_Div) {
        this.student_Div = student_Div;
    }

    public int getStudent_Roll_Number() {
        return student_Roll_Number;
    }

    public void setStudent_Roll_Number(int student_Roll_Number) {
        this.student_Roll_Number = student_Roll_Number;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }
}

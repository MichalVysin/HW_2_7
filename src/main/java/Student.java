import java.time.LocalDate;
import java.util.Objects;

public class Student {

    @TextFormat(format = TextFormatEnum.FIRST_CHAR_UPPER)
    private String name;
    @TextFormat(format = TextFormatEnum.FIRST_CHAR_UPPER)
    private String surname;
    @DateFormat(format = DateFormatEnum.d_MMMM_yyyy)
    private LocalDate born;
    @TextFormat(format = TextFormatEnum.UPPERCASE)
    private String studentClass;

    public Student(String name, String surname, LocalDate born, String studentClass) {
        this.name = name;
        this.surname = surname;
        this.born = born;
        this.studentClass = studentClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(born, student.born) && Objects.equals(studentClass, student.studentClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, born, studentClass);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", born=" + born +
                ", studentClass='" + studentClass + '\'' +
                '}';
    }
}



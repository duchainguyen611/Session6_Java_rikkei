package ra.oop;

import java.util.Scanner;

public class Student{
    private String studentId;
    private String getStudenName;
    private int age;
    private boolean sex;
    private float avgMark;

    public Student(String studentId, String getStudenName, int age, boolean sex, float avgMark) {
        this.studentId = studentId;
        this.getStudenName = getStudenName;
        this.age = age;
        this.sex = sex;
        this.avgMark = avgMark;
    }

    // getter: Lấy thông tin thuộc tính
    //setter : gán giá trị cho các thuộc tính
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGetStudenName() {
        return getStudenName;
    }

    public void setGetStudenName(String getStudenName) {
        this.getStudenName = getStudenName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    // các phương thức thể hiện hành vi
    public void helloTeacher() {
        System.out.println("Chào thầy Quang");
    }

    public void helloFriend(String name) {
        System.out.println("Hello ");
    }

    //void không phải return vì không phải trả về gì
    //int phải return vì nó trả ve
    public int addTwoNumber(int firstNumber, int lastNumber) {
        int sum = firstNumber + lastNumber;
        return sum;
    }

    //phương thức cho phép nhập thông tin đối tượng
    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên: ");
        this.studentId = scanner.nextLine();
        System.out.println("Nhập vào tên sinh viên: ");
        this.getStudenName = scanner.nextLine();
    }

    // phương thức cho hiểm thị thông tin
    public void dispData() {
        System.out.printf("Mã sinh viên: %s - Tên sinh viên: %s", studentId, getStudenName);
    }
}
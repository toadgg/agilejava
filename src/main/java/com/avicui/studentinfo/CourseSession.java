package com.avicui.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by zhangxiaoliang on 15/4/28.
 */
public class CourseSession {

    private String department;
    private String number;
    private ArrayList<Student> students = new ArrayList<Student>();
    private Date startDate;

    public CourseSession(String department, String number) {
        this.department = department;
        this.number = number;
    }

    public CourseSession(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public void enroll(Student student) {
        students.add(student);
    }

    public Student get(int index) {
        return students.get(index);
    }

    public Date getEndDate() {

        final int sessionLength = 16;
        final int daysInWeek = 7;
        final int daysFromFridayToMonday = 3;

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int numberOfDays = sessionLength * daysInWeek - daysFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }
}

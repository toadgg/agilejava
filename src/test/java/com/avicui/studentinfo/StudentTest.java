package com.avicui.studentinfo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zhangxiaoliang on 15/4/28.
 */
public class StudentTest {

    @Test
    public void testCreate() throws Exception {
        final String firstStudentName = "Jane Doe";
        Student student = new Student(firstStudentName);
        assertThat(student.getName(), is(firstStudentName));

        final String secondStudentName = "Joe Blow";
        Student secondStudent = new Student(secondStudentName);
        assertThat(secondStudent.getName(), is(secondStudentName));

        assertThat(student.getName(), is(firstStudentName));
    }
}

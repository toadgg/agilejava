package com.avicui.studentinfo;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zhangxiaoliang on 15/4/28.
 */
public class CourseSessionTest {

    @Test
    public void testCreate() throws Exception {
        CourseSession session = new CourseSession("ENGL", "101");
        assertThat(session.getDepartment(), is("ENGL"));
        assertThat(session.getNumber(), is("101"));
        assertThat(session.getNumberOfStudents(), is(0));
    }

    @Test
    public void testEnrollStudents() throws Exception {
        CourseSession session = new CourseSession("ENGL", "101");

        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        assertThat(session.getNumberOfStudents(), is(1));
        ArrayList<Student> allStudents = session.getAllStudents();
        assertThat(allStudents.size(), is(1));
        assertThat(allStudents.get(0), is(student1));

        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        assertThat(session.getNumberOfStudents(), is(2));
        assertThat(allStudents.size(), is(2));
        assertThat(allStudents.get(0), is(student1));
        assertThat(allStudents.get(1), is(student2));

    }
}

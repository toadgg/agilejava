package com.avicui.studentinfo;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zhangxiaoliang on 15/4/28.
 */
public class CourseSessionTest {

    private CourseSession session;
    private Date startDate;

    @Before
    public void setUp() throws Exception {
        startDate = createDate(2003, 1, 6);
        session = new CourseSession("ENGL", "101");
    }

    private Date createDate(int year, int month, int date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, date);
        return calendar.getTime();
    }

    @Test
    public void testCreate() throws Exception {

        assertThat(session.getDepartment(), is("ENGL"));
        assertThat(session.getNumber(), is("101"));
        assertThat(session.getNumberOfStudents(), is(0));
    }

    @Test
    public void testEnrollStudents() throws Exception {
        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        assertThat(session.getNumberOfStudents(), is(1));
        assertThat(session.get(0), is(student1));

        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        assertThat(session.getNumberOfStudents(), is(2));
        assertThat(session.get(0), is(student1));
        assertThat(session.get(1), is(student2));

    }

    @Test
    public void testCourseDates() throws Exception {
        CourseSession session = new CourseSession("ABCD", "200", startDate);
        Date sixteenWeeksOut = createDate(2003, 4, 25);
        assertThat(session.getEndDate(), is(sixteenWeeksOut));
    }
}

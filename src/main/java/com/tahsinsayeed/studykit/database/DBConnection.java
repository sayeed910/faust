package com.tahsinsayeed.studykit.database;
import com.tahsinsayeed.studykit.model.*;
import org.hsqldb.jdbcDriver;
import org.sormula.Database;
import org.sormula.SormulaException;
import org.sormula.Table;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private final static java.lang.String url;
    //public final String url;

    public static Connection getConnection(){
        Connection connection = DriverManager.getConnection(url, "imon", "1234" );
        Database database = new Database(connection);
    }

    //Attendance attendance = new Attendance();
    Table<Attendance> AttendanceTable = database.getTable(Attendance.class);
    public class AttendanceDAO extends Table<Attendance>
    {
        public AttendanceDAO(Database database) throws SormulaException
        {
            super(database, Attendance.class);
        }
    }
    // get part by primary key
    //Attendance attendance = AttendanceDAO.select("1234");
    public void AttendanceDB(){
        Attendance attendance = new Attendance();
        attendance.setClassHeld(attendance.getClassHeld() - 1);
        AttendanceDAO.update(attendance);
        attendance.setClassAttended(attendance.getClassAttended() - 1);
        AttendanceDAO.update(attendance);

    }

    //Course course = new Course();
    Table<Course> CourseTable = database.getTable(Course.class);
    public class CourseDAO extends Table<Course>
    {
        public CourseDAO(Database database) throws SormulaException
        {
            super(database, Course.class);
        }
    }
    public void CourseDB(){
        Course course = new Course();

        course.setId(course.getId() - 1);
        CourseDAO.update(course);

        course.setName(course.getName() - 1);
        CourseDAO.update(course);

    }

    Table<Event> EventTable = database.getTable(Event.class);
    public class EventDAO extends Table<Event>
    {
        public EventDAO(Database database) throws SormulaException
        {
            super(database, Event.class);
        }
    }
    public void EventDB(){
        Event event = new Event();

        event.setDate(event.getDate() - 1);
        EventDAO.update(event);

        event.setEventDescription(event.getEventDescription() - 1);
        EventDAO.update(event);

    }

    Table<Holiday> HolidayTable = database.getTable(Holiday.class);
    public class HolidayDAO extends Table<Holiday>
    {
        public HolidayDAO(Database database) throws SormulaException
        {
            super(database, Holiday.class);
        }
    }
    public void HolidayDB(){
        Holiday holiday = new Holiday();

        holiday.setDate(holiday.getDate() - 1);
        HolidayDAO.update(holiday);

        holiday.setHolidayName(holiday.getHolidayName() - 1);
        HolidayDAO.update(holiday);

    }


    Table<Semester> SemesterTable = database.getTable(Semester.class);
    public class SemesterDAO extends Table<Semester>
    {
        public SemesterDAO(Database database) throws SormulaException
        {
            super(database, Semester.class);
        }
    }
    public void SemesterDB(){
        Semester semester = new Semester();

        semester.setId(semester.getId() - 1);
        SemesterDAO.update(semester);

        semester.setStartDate(semester.getStartDate() - 1);
        SemesterDAO.update(semester);

        semester.setEndDate(semester.getEndDate() - 1);
        SemesterDAO.update(semester);

        semester.setSchedule(semester.getSchedule() - 1);
        SemesterDAO.update(semester);

    }

    
    
    
    
    
    

    /*public class Attendance
    {
        int classHeld;
        int classAttended;


        public int getclassHeld()
        {
            return classHeld;
        }
        public void setclassHeld(int classHeld)
        {
            this.classHeld = classHeld;
        }


        public int getclassAttended()
        {
            return classAttended;
        }
        public void setclassAttended(int classAttended)
        {
            this.classAttended = classAttended;
        }

    }*/











    /*
    public int delete(Attendance row)
    public int delete(Object... parameters)
    public int deleteAll()
    public int deleteAll(Collection<Attendance> rows)
    public int deleteAllBatch(Collection<Attendance> rows)
    public int insert(Attendance row)
    public int insertAll(Collection<Attendance> rows)
    public int insertAllBatch(Collection<Attendance> rows)
    public int save(Attendance row)
    public int saveAll(Collection<Attendance> rows)
    public Attendance select(Object... primaryKeys)
    public List<Attendance> selectAll()
    public List<Attendance> selectAllCustom(String customSql, Object... parameters)
    public List<Attendance> selectAllWhere(String whereConditionName, Object... parameters)
    public List<Attendance> selectAllWhereOrdered(String whereConditionName, String orderByName, Object... parameters)
    public Attendance selectAvg(String expression)
    public Attendance selectCount(String expression, String whereConditionName, Object... parameters)
    public Attendance selectCount(String expression)
    public Attendance selectCustom(String customSql, Object... parameters)
    public Attendance selectMax(String expression, String whereConditionName, Object... parameters)
    public Attendance selectMax(String expression)
    public Attendance selectMin(String expression, String whereConditionName, Object... parameters)
    public Attendance selectMin(String expression)
    public Attendance selectSum(String expression, String whereConditionName, Object... parameters)
    public Attendance selectSum(String expression)
    public Attendance selectWhere(String whereConditionName, Object... parameters)
    public int update(Attendance row)
    public int updateAll(Collection<Attendance> rows)
    public int updateAllBatch(Collection<Attendance> rows)
     */




}

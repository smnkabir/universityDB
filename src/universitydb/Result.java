/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydb;

/**
 *
 * @author nk
 */
public class Result {
    private String stId;
    private String courseTitle;
    private int semId;
    private String lecId;
    private String credit;
    private String gpa;

    public Result(String stId, String courseTitle, int semId, String lecId, String credit, String gpa) {
        this.stId = stId;
        this.courseTitle = courseTitle;
        this.semId = semId;
        this.lecId = lecId;
        this.credit = credit;
        this.gpa = gpa;
    }

    public String getStId() {
        return stId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getSemId() {
        return semId;
    }

    public String getLecId() {
        return lecId;
    }

    public String getCredit() {
        return credit;
    }

    public String getGpa() {
        return gpa;
    }
    
    
    
}

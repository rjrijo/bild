package com.rijofaith.Cohort;

/**
 * Created by rijo on 11-Sep-15.
 */
public class Users {

    int id;
    String c_id;
    String name;
    String leader;
    String cert_leader;
    String faculty;
    String location;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getC_id() {
        return c_id;
    }
    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLeader() {
        return leader;
    }
    public void setLeader(String leader) {
        this.leader = leader;
    }
    public String getCert_leader() {
        return cert_leader;
    }
    public void setCert_leader(String cert_leader) {
        this.cert_leader = cert_leader;
    }
    public String getFaculty() {
        return cert_leader;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
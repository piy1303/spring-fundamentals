
package org.example;

public class Student {
    private int StdId;
    private String StdName;
    private String StdAddress;
    private String number;
    private String Department;

    public Student(int stdId, String stdName, String stdAddress, String number, String department) {
        StdId = stdId;
        this.StdName = stdName;
        this.StdAddress = stdAddress;
        this.number = number;
        Department = department;
    }


    @Override
    public String toString() {
        return StdId + " | " + StdName + " | " + StdAddress + " | " + number +" | " + Department;
    }

    public int getStdId() {
        return StdId;
    }

    public void setStdId(int stdId) {
        StdId = stdId;
    }

    public String getStdName() {
        return StdName;
    }

    public void setStdName(String stdName) {
        this.StdName = stdName;
    }

    public String getStdAddress() {
        return StdAddress;
    }

    public void setStdAddress(String stdAddress) {
        this.StdAddress = stdAddress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}

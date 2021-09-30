package com.example.fleetprotry1;

public class EmployeeDetails {
    public String name;
    public String drivingLicenseNumber;
    public String DOB;
    public String phoneNumber;
    public String employeeID;

    public EmployeeDetails(){}

    public EmployeeDetails(String name, String dlnum, String DOB, String phnnum, String empid){
        this.name=name;
        this.drivingLicenseNumber=dlnum;
        this.DOB=DOB;
        this.phoneNumber=phnnum;
        this.employeeID=empid;
    }
}
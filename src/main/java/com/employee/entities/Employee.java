package com.employee.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employee")

public class Employee {
	
	@SequenceGenerator(name = "generator")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "emp_id", unique = true, columnDefinition = "serial")
	private Integer id;
	
	@Id
	@Column(name="emp_adhar")
	private Long adhar;
	
	@Column(name="emp_first_name")
	private String fname;
	
	@Column(name="emp_last_name")
	private String lname;
	
	@Column(name="emp_joining_date")
	private Date doj;
	
	@Column(name="emp_salary")
	private Double salary;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Long getAdhar() {
		return adhar;
	}
	public void setAdhar(Long adhar) {
		this.adhar = adhar;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", adhar=" + adhar + ", fname=" + fname + ", lname=" + lname + ", doj=" + doj
				+ ", salary=" + salary + "]";
	}	
	
	
}
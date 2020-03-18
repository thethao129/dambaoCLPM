package com.example.BTL.model;

import java.sql.Date;

public class MaThueDTO {
	private int id;
	private String maST;
	private Date startDate;
	private Date endDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaST() {
		return maST;
	}
	public void setMaST(String maST) {
		this.maST = maST;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public MaThueDTO() {
		super();
	}
	
	
}

package com.my.hr.domain;

import java.time.LocalDate;

public class Worker {
	private int workerId;
	private String name;
	private LocalDate regDate;
	
	public Worker(int workerId, String name, LocalDate regDate) {
		this.workerId = workerId;
		this.name = name;
		this.regDate = regDate;
	}
	
	public int getWorkerId() {
		return workerId;
	}

	public String getName() {
		return name;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return String.format("%3d %-11s %8s", workerId, name, regDate);
	}
}

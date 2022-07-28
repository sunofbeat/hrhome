package com.my.hr.domain;

import java.time.LocalDate;

public class Worker {
	private int workerId;
	private String workerName;
	private LocalDate regDate;
	
	public Worker(int workerId, String workerName, LocalDate regDate) {
		this.workerId = workerId;
		this.workerName = workerName;
		this.regDate = regDate;
	}
	
	public int getWorkerId() {
		return workerId;
	}

	public String getworkerName() {
		return workerName;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public void setworkerName(String workerName) {
		this.workerName = workerName;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return String.format("%3d %-5s %s", workerId, workerName, regDate);
	}
}

package com.my.hr.service;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Worker;

public interface WorkerService {
	List<Worker> getWorkers();
	Worker getWorker(int workerId);
	void addWorker(String workerName, LocalDate regDate);
	void fixWorker(Worker worker);
	void delWorker(int workerId);	
}

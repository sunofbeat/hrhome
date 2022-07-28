package com.my.hr.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Worker;

public interface WorkerDao {
	List<Worker> selectWorkers();
	Worker selectWorker(int workerId);
	int insertWorker(String workerName, LocalDate regDate);
	void updateWorker(Worker worker);
	void deleteWorler(int workerId);
	
}

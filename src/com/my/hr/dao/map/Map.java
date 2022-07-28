package com.my.hr.dao.map;

import java.util.List;

import com.my.hr.domain.Worker;

public interface Map {
	List<Worker> selectWorkers();
	int insertWorker(Worker worker);
	int updateWorker(Worker worker);
	int deleteWorker(int workerId);
}

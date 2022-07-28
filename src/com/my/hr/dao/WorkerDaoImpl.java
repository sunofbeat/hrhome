package com.my.hr.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Worker;

public class WorkerDaoImpl implements WorkerDao{
	private List<Worker> workers;
	private int workerIdSeq;
	
	public WorkerDaoImpl(List<Worker> workers) {
		this.workers = workers;
		this.workerIdSeq = 1;
	}
	
	@Override
	public List<Worker> selectWorkers(){
		return workers;
	}
	
	@Override
	public Worker selectWorker(int workerId) {
		Worker worker = null;
		for(Worker workerTmp: workers) {
			if(workerTmp.getWorkerId() == workerId) {
				worker = workerTmp;
				break;
			}
		}
		return worker;
	}
	
	@Override
	public void insertWorker(String workerName, LocalDate regDate) {
		workers.add(new Worker(workerIdSeq++, workerName, regDate));
	}
	
	@Override
	public void updateWorker(Worker workerTmp) {
		workers.forEach(workers -> {
			if(workers.getWorkerId() == workerTmp.getWorkerId()) {
				workers.setName(workerTmp.getName());
				workers.setRegDate(workerTmp.getRegDate());
			}
		});
	}
	
	@Override
	public void deleteWorler(int workerId) {
		Worker worker = null;
		worker = selectWorker(workerId);
		if(worker == null) {
			workers.remove(worker);
		}
	}	
}

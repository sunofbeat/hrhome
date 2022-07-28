package com.my.hr.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Worker;

import config.Configuration;

public class WorkerDaoImpl extends Configuration implements WorkerDao{
	private List<Worker> workers;
	private int workerIdSeq;
	
	public WorkerDaoImpl(List<Worker> workers) {
		this.workers = workers;
		this.workerIdSeq = 1;
	}
	
	@Override
	public List<Worker> selectWorkers(){
		WorkerDao mapper = Configuration.getMapper(WorkerDao.class);
		return mapper.selectWorkers();
	}
	
	@Override
	public Worker selectWorker(int workerId) {
		WorkerDao mapper = Configuration.getMapper(WorkerDao.class);
		return mapper.selectWorker(workerId);
	}
	
	@Override
	public int insertWorker(String workerName, LocalDate regDate) {
		WorkerDao mapper = Configuration.getMapper(WorkerDao.class);
		return mapper.insertWorker(workerName, regDate);
	}
	
	@Override
	public void updateWorker(Worker workerTmp) {
		workers.forEach(workers -> {
			if(workers.getWorkerId() == workerTmp.getWorkerId()) {
				workers.setworkerName(workerTmp.getworkerName());
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

package com.my.hr.service;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.dao.WorkerDao;
import com.my.hr.domain.Worker;

public class WorkerServiceImpl implements WorkerService{
	private WorkerDao workerDao;
	
	public WorkerServiceImpl(WorkerDao workerDao) {
		this.workerDao = workerDao;
	}
	
	@Override
	public List<Worker> getWorkers(){
		return workerDao.selectWorkers();
	}
	
	@Override
	public Worker getWorker(int workerId) {
		return workerDao.selectWorker(workerId);
	}
	
	@Override
	public void addWorker(String workerName, LocalDate regDate) {
		workerDao.insertWorker(workerName, regDate);
	}
	
	@Override
	public void fixWorker(Worker worker) {
		workerDao.updateWorker(worker);
	}
	
	@Override
	public void delWorker(int workerId) {
		workerDao.deleteWorler(workerId);
	}
}

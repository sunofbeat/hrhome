package com.my.hr.presentation;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Worker;
import com.my.hr.service.WorkerService;

public class WorkerIo {
	private WorkerService workerService;
	private String menu;
	
	public WorkerIo(WorkerService workerService) {
		this.workerService = workerService;
		this.menu = Job.labels();
	}
	
	public void play() {
		Job job = null;
		while((job = choose(menu)) != Job.EXIT) {
			switch(job) {
				case LIST: listWorkers(); break;
				case ADD: addWorker(); break;
				case FIX: fixWorker(); break;
				case DEL: delWorker();
			}
		}
	}
	
	private Job choose(String menu) {
		boolean isGood = false;
		int choice = 0;
		
		do {
			choice = Console.inNum(menu);
			if(choice < 0|| choice >= Job.length()) {
				Console.err("�޴� ��ȣ�� ������ �ּ���.");
			}else {
				isGood = true;
			}
			
		}while(!isGood);
		return Job.toJob(choice);
	}
	
	private void listWorkers() {
		List<Worker> workers = workerService.getWorkers();
		
		System.out.println(" ID  �̸�      �Ի���");
		System.out.println("----------------------");
		
		if(workers.size() > 0) {
			workers.forEach(worker -> Console.info(worker));
		}else {
			Console.info("�뵿�ڰ� �����ϴ�.");
		}
	}
	
	private void addWorker() {
		String workerName = Console.inStr("�뵿�ڸ��� �Է��ϼ���. 0.���", 5);
		
		if(!workerName.equals("0")) {
			LocalDate regDate = Console.inDate("�Ի����� �Է��ϼ���");
			workerService.addWorker(workerName, regDate);
			Console.info("�뵿�ڸ� �߰��߽��ϴ�.");
		} else {
			Console.info("���");
		}
	}

	private void fixWorker() {
		if(workerService.getWorkers().size() > 0) {
			int workerId = getWorker("����");
			if(workerId > 0) {
				String workerName = Console.inStr("�뵿�ڸ��� �Է��ϼ���.", 5);
				LocalDate regDate = Console.inDate("�Ի����� �Է��ϼ���.");
				workerService.fixWorker(new Worker(workerId, workerName, regDate));
				Console.info("�����Ǿ����ϴ�.");
			}
		}else {
			Console.info("������ �뵿�ڰ� �����ϴ�.");
		}
}

	private void delWorker() {
		if(workerService.getWorkers().size() > 0) {
			int workerId = getWorker("����");
			if(workerId > 0) {
				workerService.delWorker(workerId);
				Console.info("���� �Ǿ����ϴ�.");
			}
		}else {
			Console.info("������ �뵿�ڰ� �����ϴ�.");
		}
	}
	
	private int getWorker(String job) {
		Worker worker = null;
		int workerId = 0;
		
		do {
			workerId = Console.inNum("�뵿�� ID�� �Է��ϼ���. 0.���");
			if(workerId == 0) {
				Console.info(job + "����մϴ�.");
				return 0;
			}
			worker = workerService.getWorker(workerId);
			if(worker == null) {
				Console.info("�ش� �뵿�ڰ� �����ϴ�.");
			}
		}while(worker == null);
		return workerId;
	}
}

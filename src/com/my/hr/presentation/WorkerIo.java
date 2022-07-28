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
				Console.err("메뉴 번호를 선택해 주세요.");
			}else {
				isGood = true;
			}
			
		}while(!isGood);
		return Job.toJob(choice);
	}
	
	private void listWorkers() {
		List<Worker> workers = workerService.getWorkers();
		
		System.out.println(" ID  이름      입사일");
		System.out.println("----------------------");
		
		if(workers.size() > 0) {
			workers.forEach(worker -> Console.info(worker));
		}else {
			Console.info("노동자가 없습니다.");
		}
	}
	
	private void addWorker() {
		String workerName = Console.inStr("노동자명을 입력하세요. 0.취소", 5);
		
		if(!workerName.equals("0")) {
			LocalDate regDate = Console.inDate("입사일을 입력하세요");
			workerService.addWorker(workerName, regDate);
			Console.info("노동자를 추가했습니다.");
		} else {
			Console.info("취소");
		}
	}

	private void fixWorker() {
		if(workerService.getWorkers().size() > 0) {
			int workerId = getWorker("수정");
			if(workerId > 0) {
				String workerName = Console.inStr("노동자명을 입력하세요.", 5);
				LocalDate regDate = Console.inDate("입사일을 입력하세요.");
				workerService.fixWorker(new Worker(workerId, workerName, regDate));
				Console.info("수정되었습니다.");
			}
		}else {
			Console.info("수정할 노동자가 없습니다.");
		}
}

	private void delWorker() {
		if(workerService.getWorkers().size() > 0) {
			int workerId = getWorker("삭제");
			if(workerId > 0) {
				workerService.delWorker(workerId);
				Console.info("삭제 되었습니다.");
			}
		}else {
			Console.info("삭제할 노동자가 없습니다.");
		}
	}
	
	private int getWorker(String job) {
		Worker worker = null;
		int workerId = 0;
		
		do {
			workerId = Console.inNum("노동자 ID를 입력하세요. 0.취소");
			if(workerId == 0) {
				Console.info(job + "취소합니다.");
				return 0;
			}
			worker = workerService.getWorker(workerId);
			if(worker == null) {
				Console.info("해당 노동자가 없습니다.");
			}
		}while(worker == null);
		return workerId;
	}
}

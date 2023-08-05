package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.JobHistory;
import com.example.demo.repositories.JobHistoryRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/JobsHistory")
public class JobHistoryController {
	@Autowired
	private JobHistoryRepository jobHistoryRepository;

	
	@GetMapping
	public List<JobHistory> findAll(){
		return jobHistoryRepository.findAll();
	}
	@GetMapping("/{id}")
	public JobHistory findJobHistoryById(@PathVariable ("id") Long id){
		return jobHistoryRepository.findById(id).get();
	}
	@PostMapping
	public JobHistory saveJobHistory(@RequestBody JobHistory jobHistory){
		jobHistoryRepository.save(jobHistory);
		return jobHistory;
	}
	@PutMapping("/{id}")
	public JobHistory editJobHistory(@PathVariable ("id") Long id,@RequestBody JobHistory jobHistory){
		JobHistory j=jobHistoryRepository.findById(id).get();
		j.setDepartment(jobHistory.getDepartment());
		j.setEmployeeId(jobHistory.getEmployeeId());
		j.setJob(jobHistory.getJob());
		j.setStartDate(jobHistory.getStartDate());
		j.setEndDate(jobHistory.getEndDate());
		jobHistoryRepository.save(j);
		return j;
	}
	@DeleteMapping("/{id}")
	public String deleteJobHistory(@PathVariable ("id") Long id){
		jobHistoryRepository.deleteById(id);
		return "JobHistory has been deleted";
	}

}

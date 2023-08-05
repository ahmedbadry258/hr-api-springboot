package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Job;

import com.example.demo.repositories.JobRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/jobs")
public class JobController {
	@Autowired
	private JobRepository jobRepository;

	@GetMapping("/list")
	public Page<Job> findList(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int items) {
		System.out.println(page);
		System.out.println(items);
		Page<Job> findAll = jobRepository.findAll(PageRequest.of(page, items));
		return findAll;
	}
	
	@GetMapping
	public List<Job> findAll(){
		return jobRepository.findAll();
	}
	@GetMapping("/{id}")
	public Job findJobById(@PathVariable ("id") String id){
		return jobRepository.findById(id).get();
	}
	@PostMapping
	public Job saveJob(@RequestBody Job job){
		jobRepository.save(job);
		return job;
	}
	@PutMapping("/{id}")
	public Job editJob(@PathVariable ("id") String id,@RequestBody Job job){
		Job j=jobRepository.findById(id).get();
		j.setJobTitle(job.getJobTitle());
		j.setMinSalary(job.getMinSalary());
		j.setMaxSalary(job.getMaxSalary());
		jobRepository.save(j);
		return j;
	}
	@DeleteMapping("/{id}")
	public String deleteJob(@PathVariable ("id") String id){
		jobRepository.deleteById(id);
		return "Job has been deleted";
	}

}

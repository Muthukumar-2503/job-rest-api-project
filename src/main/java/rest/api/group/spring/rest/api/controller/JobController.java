package rest.api.group.spring.rest.api.controller;
import java.util.List;
import rest.api.group.spring.rest.api.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import rest.api.group.spring.rest.api.service.JobService;
@RestController
public class JobController {
	@Autowired
	public JobService service;
	
	@GetMapping("jobpost/{id}")
	public JobPost getOneJob(@PathVariable Integer id) {
		return service.getJob(id);
	}
	@PostMapping("/addjob")
	public void addJob(@Valid @RequestBody JobPost job) {
		service.addJob(job);
	}
	@PutMapping("/updatejob/{id}")
	public void updateJob(@PathVariable Integer id,@Valid @RequestBody JobPost jobpost) {
		service.updateJob(id,jobpost);
	}
	@DeleteMapping("deletejob/{id}")
	public void deletejob(@PathVariable Integer id) {
		service.deleteJob(id);
	}
	@GetMapping("/jobpost/keyword/{keyword}")
		public List<JobPost> keywordSearch(@PathVariable String keyword){
			return service.search(keyword);
			}
	@GetMapping("/getalljobs")
	public List<JobPost> getallJobs() {
		return service.getallJobs();
	}
	}



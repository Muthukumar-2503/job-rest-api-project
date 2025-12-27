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

import rest.api.group.spring.rest.api.service.JobService;
@RestController
public class JobController {
	@Autowired
	public JobService service;
	
	@GetMapping("jobposts")
	public List<JobPost> getjobs(){
		return service.getAllJobs();
	}
	
	@GetMapping("jobpost/{id}")
	public JobPost getOneJob(@PathVariable int id) {
		return service.getJob(id);
	}
	@PostMapping("addjob")
	public void addJob(@RequestBody JobPost job) {
		service.addJob(job);
	}
	@PutMapping("updatejob")
	public void updateJob(@RequestBody JobPost jobpost) {
		service.updateJob(jobpost);
	}
	@DeleteMapping("deletejob/{id}")
	public void deletejob(@PathVariable int id) {
		service.deleteJob(id);
	}
	@GetMapping("load")
	public String load() {
		service.load();
		return "added";
	}
	@GetMapping("/jobpost/keyword/{keyword}")
		public List<JobPost> keywordSearch(@PathVariable String keyword){
			return service.search(keyword);
			
		}
	}



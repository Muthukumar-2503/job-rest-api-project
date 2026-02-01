package rest.api.group.spring.rest.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.api.group.spring.rest.api.model.JobPost;
import rest.api.group.spring.rest.api.repo.JobRepo;


@Service
public class JobService {
	@Autowired
	public JobRepo repo;
	
	// method to add a jobPost
	public void addJob(JobPost jobPost) {
		 repo.save(jobPost);
	
	}

	public JobPost getJob(Integer postId) {
		
		return repo.findById(postId)
				.orElseThrow(() -> new RuntimeException("No JobPost found"));
	}

	public void updateJob(Integer postId,JobPost jobPost) {
		jobPost.setPostId(postId);
		repo.save(jobPost);
	}

	public void deleteJob(Integer postId) {
		repo.deleteById(postId);
		
	}
	// searching using keyword
	public List<JobPost> search(String keyword){
		return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
	}
	
	public List<JobPost> getallJobs() {
		return repo.findAll();
	}
}
	
package rest.api.group.spring.rest.api.repo;

import java.util.ArrayList;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rest.api.group.spring.rest.api.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
	
	List <JobPost> findByPostProfileContainingOrPostDescContaining(String keyword,String keyword1);

	// arrayList to store store JobPost objects
	//List<JobPost> jobs = new ArrayList<>();

	/*
	public List<JobPost> getAllJobs() {
		return jobs;
	}

	
	
	// method to save a job post object into arrayList
	public void addJob(JobPost job) {
		jobs.add(job);

	}

	
	
	
	//method to get a job by postId
	public JobPost getJob(int postId) {
		for (JobPost job : jobs) {
			if (job.getPostId() == postId) {
				return job;
			}
		}

		return null;
	}




	public void updateJob(JobPost jobPost) {
		for (JobPost jobPost1 : jobs) {
			if (jobPost1.getPostId() == jobPost.getPostId()) {
				
				jobPost1.setPostProfile(jobPost.getPostProfile());
				jobPost1.setPostDesc(jobPost.getPostDesc());
				jobPost1.setReqExperience(jobPost.getReqExperience());
				jobPost1.setPostTechStack(jobPost.getPostTechStack());
				
			}
		}
		

		
	}




	public void deleteJob(int postId) {
		for (JobPost jobPost : jobs) {
			if (jobPost.getPostId() == postId) {
				jobs.remove(jobPost);
				
			}
		}

		
		
	}*/

}
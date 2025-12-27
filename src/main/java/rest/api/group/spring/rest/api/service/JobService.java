package rest.api.group.spring.rest.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.api.group.spring.rest.api.model.JobPost;
import rest.api.group.spring.rest.api.repo.JobRepo;


@Service
public class JobService {
	@Autowired
	public JobRepo repo;
	
	
	
	//method to return all JobPosts
	public List<JobPost> getAllJobs() {
		return repo.findAll(); 

		
	} 
	
	
	
	

	// ***************************************************************************


	

	// method to add a jobPost
	public void addJob(JobPost jobPost) {
		 repo.save(jobPost);
	
	}


	public JobPost getJob(int postId) {
		
		return repo.findById(postId).orElse(new JobPost());
	}





	public void updateJob(JobPost jobPost) {
	repo.save(jobPost);
		
	}





	public void deleteJob(int postId) {
		repo.deleteById(postId);
		
	}
	// searching using keyword
	public List<JobPost> search(String keyword){
		return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
	}
	
	public void load() {
		List<JobPost> jobs = new ArrayList<>(List.of(
		// Java Developer Job Post
				new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
						List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

				// Frontend Developer Job Post
				new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
						3, List.of("HTML", "CSS", "JavaScript", "React")),

				// Data Scientist Job Post
				new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
						List.of("Python", "Machine Learning", "Data Analysis")),

				// Network Engineer Job Post
				new JobPost(4, "Network Engineer",
						"Design and implement computer networks for efficient data communication", 5,
						List.of("Networking", "Cisco", "Routing", "Switching")),

				// Mobile App Developer Job Post
				new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
						List.of("iOS Development", "Android Development", "Mobile App")),
		
		new JobPost(6, "Devops Engineer","Experience in devops is must",2,List.of("PL/SQL","Cloud","AWS cloud"))));
		
		repo.saveAll(jobs);
		

	}
	
	

	
}
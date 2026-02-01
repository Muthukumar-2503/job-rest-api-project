package rest.api.group.spring.rest.api.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rest.api.group.spring.rest.api.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
	
	List <JobPost> findByPostProfileContainingOrPostDescContaining(String keyword,String keyword1);

}
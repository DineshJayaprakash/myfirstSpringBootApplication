package com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Model.NotesUser;

@Repository
public interface NotesUserRepository extends PagingAndSortingRepository<NotesUser, Long>{
	
	

}

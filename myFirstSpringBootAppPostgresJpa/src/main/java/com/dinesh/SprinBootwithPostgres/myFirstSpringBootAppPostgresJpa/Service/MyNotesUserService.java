package com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Model.NotesUser;
import com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Model.NotesUserPage;
import com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Repository.NotesUserRepository;


@Service()
public class MyNotesUserService {
	
	private final NotesUserRepository notesUserRepository;

	public MyNotesUserService(NotesUserRepository notesUserRepository) {
		this.notesUserRepository = notesUserRepository;
	}
	
	public Page<NotesUser> getNotesUser(NotesUserPage notesUserPage)
	{
		Sort sort = Sort.by(notesUserPage.getSortDirection(), notesUserPage.getSortBy());
		Pageable page = PageRequest.of(notesUserPage.getPagenumber(), notesUserPage.getPageSize(), sort);
		
		return notesUserRepository.findAll(page);
	}
	
	
	public NotesUser addNewUser(NotesUser user)
	{
		return notesUserRepository.save(user);
	}

}

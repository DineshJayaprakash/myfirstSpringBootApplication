package com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Exception.RecordNotFoundException;
import com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Model.Note;
import com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Model.NotesUser;
import com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Model.NotesUserPage;
import com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Repository.NoteRepository;
import com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Service.MyNotesUserService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1")
public class NotesController{

	@Autowired
	private NoteRepository noteRepository;
	
	private final MyNotesUserService  myNotesUserService;
	
	
	public NotesController(MyNotesUserService myNotesUserService) {
		
		this.myNotesUserService = myNotesUserService;
	}

	@GetMapping("notes")
	public List<Note> getAllNotes()
	{
		return this.noteRepository.findAll();
	}
	
	@GetMapping("notesUsers")
	public ResponseEntity<Page<NotesUser>> getnotesUsersByPage(NotesUserPage notesUserPage)
	{
		return new ResponseEntity<>(myNotesUserService.getNotesUser(notesUserPage),HttpStatus.OK);
		
	}
	
	@PostMapping("notesUser")
	public NotesUser addNotesUser(@RequestBody NotesUser notesUser)
	{
		return myNotesUserService.addNewUser(notesUser);
		
	}
	{
		
	}
	
	@GetMapping("notes/{id}")
	public ResponseEntity<Note> getNoteWithId(@PathVariable(value = "id") Long noteid) throws RecordNotFoundException
	{
		Note note = noteRepository.findById(noteid).orElseThrow(()-> new RecordNotFoundException("This record is not found for " + noteid ));
		return ResponseEntity.ok().body(note);
	}
	
	@PostMapping("notes")
	public Note addNote(@RequestBody Note note)
	{
		
		return this.noteRepository.save(note);
		
	}
	
	@PutMapping("notes/{id}")
	public ResponseEntity<Note> updateNotes(@PathVariable(value = "id") Long noteid, @RequestBody Note updatedNote) throws RecordNotFoundException
 	{
		
		Note note = noteRepository.findById(noteid).orElseThrow(()-> new RecordNotFoundException("This record is not found for " + noteid ));
		
		note.setTitle(updatedNote.getTitle());
		note.setSubject(updatedNote.getSubject());
		note.setContent(updatedNote.getContent());
		
		return ResponseEntity.ok(this.noteRepository.save(note));
	 
 	}
	
	@DeleteMapping("notes/{id}")
	public Map<String,Boolean> deleteEmployee(@PathVariable(value = "id") Long noteid) throws RecordNotFoundException
	{
		Note note = noteRepository.findById(noteid).orElseThrow(()-> new RecordNotFoundException("This record is not found for " + noteid ));
		
		this.noteRepository.delete(note);
		
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
		
	}
	
	
	
}

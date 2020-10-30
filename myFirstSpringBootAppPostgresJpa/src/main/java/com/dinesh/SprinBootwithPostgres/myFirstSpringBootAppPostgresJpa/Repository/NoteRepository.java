package com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}

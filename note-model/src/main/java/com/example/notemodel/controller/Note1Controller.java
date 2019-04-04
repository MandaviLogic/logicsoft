package com.example.notemodel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.notemodel.entities.Note1;
import com.example.notemodel.exception.Note1Exception;
import com.example.notemodel.repos.Note1Repository;

@RestController
public class Note1Controller {

	@Autowired
	private Note1Repository note1Repository;
	
	@GetMapping("notes1")
	public List<Note1> getAllNotes() {
		return note1Repository.findAll();
	}
	
	@PostMapping("notes1")
	public Note1 createNote(@Valid @RequestBody Note1 note) {
		return note1Repository.save(note);
	}
	
	@PutMapping("notes1/{noteId}")
	public Note1 updateNote(@PathVariable Long noteId , @Valid @RequestBody Note1 noteRequest) {
		Note1 note = note1Repository.findById(noteId)
				.orElseThrow(() -> new Note1Exception("Note1", "id",noteId));
		note.setTitle(noteRequest.getTitle());
		note.setContent(noteRequest.getContent());
		return note1Repository.save(note);
	}
	
	@DeleteMapping("notes1/{noteId}")
	public ResponseEntity<?> deleteNote(@PathVariable Long noteId){
		
		Note1 note = note1Repository.findById(noteId)
				.orElseThrow(() -> new Note1Exception("Note1", "id", noteId));
		note1Repository.delete(note);
		return ResponseEntity.ok().build();
	}
}

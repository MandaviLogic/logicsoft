package com.example.notemodel.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.notemodel.entities.Note1;

@Repository
public interface Note1Repository extends JpaRepository<Note1, Long>{

}

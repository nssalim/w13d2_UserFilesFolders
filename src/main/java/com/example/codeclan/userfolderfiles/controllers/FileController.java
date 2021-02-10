package com.example.codeclan.userfolderfiles.controllers;

import com.example.codeclan.userfolderfiles.models.Folder;
import com.example.codeclan.userfolderfiles.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/file/{id}")
    public ResponseEntity getFile(@PathVariable Long id){

        return new ResponseEntity(fileRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping(value="/files")
    public ResponseEntity<File> postFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);

    }

}

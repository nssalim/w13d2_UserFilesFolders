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
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folder/{id}")
    public ResponseEntity getFolder(@PathVariable Long id){

        return new ResponseEntity(folderRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping(value="/folders")
    public ResponseEntity<Folder> postFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);

    }


}

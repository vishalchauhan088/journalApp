package com.vishalchauhan0688.journalApp.controller;

import com.vishalchauhan0688.journalApp.entity.JournalEntry;
import com.vishalchauhan0688.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<?> getAll(){

       try{
           List<JournalEntry> all =  journalEntryService.getAll();
           if(all != null && !all.isEmpty()){
               return new ResponseEntity<>(all, HttpStatus.OK);
           }

           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       catch (Exception e){
           System.out.println(e.getMessage());
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){

        myEntry.setDate(LocalDateTime.now());

        journalEntryService.save(myEntry);
        return true;
    }
    @GetMapping("/{myId}")
    public ResponseEntity<JournalEntry> getById(@PathVariable ObjectId myId){

        try{
            Optional<JournalEntry> myJournalEntry = journalEntryService.findById(myId);

            if (myJournalEntry.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(myJournalEntry.get(), HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }


    }


    @DeleteMapping("/{myId}")
    public ResponseEntity<?> deleteById(@PathVariable ObjectId myId){


        try{

            Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
            if(journalEntry.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            journalEntryService.deleteById(myId);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/{myId}")
    public Optional<JournalEntry> updateById(@PathVariable ObjectId myId, @RequestBody JournalEntry myEntry){

            Optional<JournalEntry> old = journalEntryService.findById(myId);

            if(old.isPresent()){
                old.get().setTitle(myEntry.getTitle() != null && myEntry.getTitle() != "" ? myEntry.getTitle() : old.get().getTitle() );
                old.get().setContent(myEntry.getContent() != null && myEntry.getContent() != "" ? myEntry.getContent() : old.get().getContent() );

                journalEntryService.save(old.get());
            }


           return old;

    }

}

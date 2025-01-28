package com.vishalchauhan0688.journalApp.controller;

import com.vishalchauhan0688.journalApp.entity.JournalEntry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        System.out.println("OK");

        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        System.out.println("fuck you in post");
        this.journalEntries.put(myEntry.getId(),myEntry);

        return true;

    }
    @GetMapping("/{myId}")
    public JournalEntry getById(@PathVariable Long myId){
        System.out.println("Fetching entry with ID: " + myId);
        JournalEntry entry = journalEntries.get(myId);
        System.out.println("Entry found: " + entry.toString());
        return entry;
    }
    @DeleteMapping("/{myId}")
    public String deleteById(@PathVariable Long myId){
        journalEntries.remove(myId);

        return "ok";

    }
    @PutMapping("/{myId}")
    public ResponseEntity<JournalEntry> updateById(@PathVariable Long myId, @RequestBody JournalEntry myEntry){

        journalEntries.put(myId,myEntry);

        return ResponseEntity.ok(journalEntries.get(myId));

    }

}

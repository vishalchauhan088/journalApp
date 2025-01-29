package com.vishalchauhan0688.journalApp.repository;

import com.vishalchauhan0688.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {
}

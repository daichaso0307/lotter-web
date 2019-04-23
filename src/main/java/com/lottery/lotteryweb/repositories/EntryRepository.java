package com.lottery.lotteryweb.repositories;

import com.lottery.lotteryweb.models.Entry;
import com.lottery.lotteryweb.responses.entry.EntryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    Entry findByPassIdAndEmailAndDeleteFlag(String passId, String email, Boolean deleteFlag);
}

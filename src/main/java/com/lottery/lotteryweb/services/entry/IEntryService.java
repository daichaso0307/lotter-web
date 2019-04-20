package com.lottery.lotteryweb.services.entry;

import com.lottery.lotteryweb.requestes.entry.CreateEntryRequest;
import org.springframework.http.ResponseEntity;

public interface IEntryService {

    ResponseEntity<?> createEntry(CreateEntryRequest createEntryRequest);
}

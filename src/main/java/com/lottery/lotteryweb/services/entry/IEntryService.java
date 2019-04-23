package com.lottery.lotteryweb.services.entry;

import com.lottery.lotteryweb.requestes.entry.CreateEntryRequest;
import com.lottery.lotteryweb.requestes.entry.GetEntryRequest;
import com.lottery.lotteryweb.responses.entry.EntryResponse;
import org.springframework.http.ResponseEntity;

public interface IEntryService {

    ResponseEntity<?> createEntry(CreateEntryRequest createEntryRequest);

    EntryResponse getEntry(GetEntryRequest getEntryRequest);
}

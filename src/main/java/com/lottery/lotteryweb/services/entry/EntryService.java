package com.lottery.lotteryweb.services.entry;

import com.lottery.lotteryweb.models.Entry;
import com.lottery.lotteryweb.models.User;
import com.lottery.lotteryweb.repositories.EntryRepository;
import com.lottery.lotteryweb.repositories.UserRepository;
import com.lottery.lotteryweb.requestes.entry.CreateEntryRequest;
import com.lottery.lotteryweb.responses.common.AppApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntryService implements IEntryService {

    @Autowired UserRepository userRepository;
    @Autowired EntryRepository entryRepository;

    @Override
    public ResponseEntity<AppApiResponse> createEntry(CreateEntryRequest createEntryRequest) {

        long yearId = createEntryRequest.getYearId();
        long gameId = createEntryRequest.getGameId();
        long gateId = createEntryRequest.getGateId();
        String passId = createEntryRequest.getPassId();
        String userName = createEntryRequest.getUserName();
        String userKana = createEntryRequest.getUserKana();
        int person = createEntryRequest.getPerson();
        String email = createEntryRequest.getEmail();

        //人数が4人以上の場合エラーにする。
        if (person <= 4) {
            // TODO エラー返す
        }

        Optional<User> userOptional = userRepository.findByPassIdAndDeleteFlag(passId, Boolean.FALSE);

        //ユーザが存在しない場合、エラーにする。
        if (!userOptional.isPresent()) {
            // TODO エラー返す
        }

        //入力されたgateIdとユーザ情報のgateIdが一致しない場合エラーとする。
        if (userOptional.get().getGateId() != gateId) {
            // TODO エラー返す
        }

        Entry entry = new Entry(
                yearId,
                gameId,
                gateId,
                passId,
                userName,
                userKana,
                person,
                email
        );
        entryRepository.save(entry);

        //申し込み完了メールを送信する。

        return new AppApiResponse().success();
    }
}

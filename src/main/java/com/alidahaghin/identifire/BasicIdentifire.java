package com.alidahaghin.identifire;

import com.alidahaghin.identifire.models.FormatElement;
import com.alidahaghin.identifire.models.Storage;

import java.util.List;
import java.util.Random;

public class BasicIdentifire extends AbstractIdentifire {

    private final List<FormatElement> formatElements;

    public BasicIdentifire(Storage storage, List<FormatElement> formatElements) {
        super(storage);
        this.formatElements = formatElements;
    }

    @Override
    public synchronized String generate() {
        StringBuilder newId;
        Random random = new Random();
        do {
            newId = new StringBuilder();
            for (FormatElement formatElement : formatElements) {
                List<String> candidate = formatElement.getCandidates();
                int index = random.nextInt(candidate.size());
                newId.append(candidate.get(index));
            }
        } while (this.storage.contains(newId.toString()));
        String result = newId.toString();
        this.storage.add(result);
        return result;
    }

}

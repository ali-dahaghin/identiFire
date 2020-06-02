package com.alidahaghin.identifire;

import com.alidahaghin.identifire.exceptions.BadCandidatesException;
import com.alidahaghin.identifire.exceptions.RequiredParameterNotFoundException;
import com.alidahaghin.identifire.exceptions.RunOutOfPossibilityExceptions;
import com.alidahaghin.identifire.models.FormatElement;
import com.alidahaghin.identifire.models.Options;
import com.alidahaghin.identifire.models.IdFireRepository;
import com.alidahaghin.identifire.models.formatElements.CandidatesFormatElement;
import com.alidahaghin.identifire.models.formatElements.ParameterFormatElement;

import java.util.*;

public class FormattedIdFire extends AbstractIdFire {

    private final List<FormatElement> formatElements;

    public FormattedIdFire(IdFireRepository idFireRepository, List<FormatElement> formatElements) {
        super(idFireRepository);
        this.formatElements = formatElements;
    }

    @Override
    public synchronized String generate(Options options) {
        int counter = this.getCounter(options);
        StringBuilder newId = null;
        Random random = new Random();
        while((--counter) != 0) {
            newId = new StringBuilder();
            for (FormatElement formatElement : formatElements) {
                List<String> candidates;
                if (formatElement instanceof CandidatesFormatElement) {
                    CandidatesFormatElement candidatesFormatElement = (CandidatesFormatElement) formatElement;
                    candidates = candidatesFormatElement.getCandidates();
                    if (Objects.isNull(candidates) || candidates.isEmpty()) {
                        throw new BadCandidatesException(formatElement.getClass().toString() + ": returns bad candidates");
                    }
                    int index = random.nextInt(candidates.size());
                    newId.append(candidates.get(index));
                } else if(formatElement instanceof ParameterFormatElement) {
                    ParameterFormatElement parameterFormatElement = (ParameterFormatElement) formatElement;
                     candidates = options.getParams().get(parameterFormatElement.getKey());
                     if (Objects.isNull(candidates)) {
                         throw new RequiredParameterNotFoundException("parameter [ " + parameterFormatElement.getKey() + " ] not found.");
                     }
                    int index = random.nextInt(candidates.size());
                    newId.append(candidates.get(index));
                }
            }
            if (!this.idFireRepository.contains(newId.toString())) {
                break;
            }
        }
        if (counter==0) {
            throw new RunOutOfPossibilityExceptions("this generator ran out of possible ids");
        }
        String result = newId.toString();
        this.idFireRepository.add(result);
        return result;
    }

    private int getCounter(Options options) {
        int par = formatElements.stream().filter(CandidatesFormatElement.class::isInstance).map(CandidatesFormatElement.class::cast).map(CandidatesFormatElement::getCandidates).map(List::size).reduce(1, (a,b) -> a*b);
        int opt = options.getParams().entrySet().stream().filter(stringListEntry -> formatElements.stream().filter(ParameterFormatElement.class::isInstance).map(ParameterFormatElement.class::cast).map(ParameterFormatElement::getKey).anyMatch(s -> Objects.equals(s, stringListEntry.getKey()))).map(Map.Entry::getValue).map(List::size).reduce(1, (a, b) -> a*b);
        return par*opt;
    }

}

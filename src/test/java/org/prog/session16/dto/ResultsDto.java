package org.prog.session16.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
public class ResultsDto {
    private List<PersonDto> results;

//    public List<PersonDto> getResults() {
//        return results;
//    }
//
//    public void setResults(List<PersonDto> results) {
//        this.results = results;
//    }
}

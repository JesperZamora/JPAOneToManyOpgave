package com.example.jpaonetomanyopgave.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class KommuneNamesDTO {
    private List<String> names;
    public KommuneNamesDTO(Set<Kommune> kommuneSet) {
        this.names = saveNamesToList(kommuneSet);
    }

    private List<String> saveNamesToList(Set<Kommune> kommuneSet) {
        List<String> namesList = new ArrayList<>();
        kommuneSet.forEach(kommune -> namesList.add(kommune.getNavn()));
        return namesList;
    }

    public List<String> getNames() {
        return names;
    }
}

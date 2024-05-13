package org.example;

public interface ICompetitionObserver {
    void participantsRegistered(int sampleId, int org) throws CompetitionException;

}

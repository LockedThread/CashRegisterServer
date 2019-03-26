package dev.warrensnipes.cashregisterserver.utils;

import java.util.Map;

public class Questionnaire {

    private final Map<Integer, String> questions;
    private int count;

    public Questionnaire(Map<Integer, String> questions) {
        this.questions = questions;
    }

    public String getQuestion() {
        return questions.get(count);
    }

    public String getFormattedQuestion() {
        return count + ". " + getQuestion();
    }

    public String getQuestion(int questionNumber) {
        if (questionNumber >= questions.size()) {
            throw new RuntimeException("You can't get a question that's out of the HashMap's size.");
        }
        return questions.get(questionNumber);
    }

    public int getCount() {
        return count;
    }

    public void reset() {
        this.count = 0;
    }

    public void increment() {
        this.count++;
    }
}

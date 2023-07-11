package com.humber.parenthood;

public class QAModel {
    private final String question;
    private final String answer;

    public QAModel(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

// --Commented out by Inspection START (2023-07-11, 18:45):
//    public void setQuestion(String question) {
//        this.question = question;
//    }
// --Commented out by Inspection STOP (2023-07-11, 18:45)

    public String getAnswer() {
        return answer;
    }

// --Commented out by Inspection START (2023-07-11, 18:45):
//    public void setAnswer(String answer) {
//        this.answer = answer;
//    }
// --Commented out by Inspection STOP (2023-07-11, 18:45)
}

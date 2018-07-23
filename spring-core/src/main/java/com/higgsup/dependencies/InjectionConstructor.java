package com.higgsup.dependencies;

public class InjectionConstructor {
    private int years;
    private String ultimateAnswer;

    public InjectionConstructor(int yearsXXX, String ultimateAnswerXXX) {
        System.out.println("Injection yearsXXX and ultimateAnswerXXX by constructor...");
        this.years = yearsXXX;
        this.ultimateAnswer = ultimateAnswerXXX;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getUltimateAnswer() {
        return ultimateAnswer;
    }

    public void setUltimateAnswer(String ultimateAnswer) {
        this.ultimateAnswer = ultimateAnswer;
    }
}

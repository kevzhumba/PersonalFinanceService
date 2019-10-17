package com.kevinzhang.app;

import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;

public class Budget {

    @Getter
    private HashMap<String, Double> expenses;
    @Getter @Setter
    private double totalBudget;
    @Getter
    private double totalExpenses;

    public Budget() {
        expenses = new HashMap<>();
        totalBudget = 0;
        totalExpenses = 0;
    }

    public void addExpense(String s, Double d) throws Error {
        if(d <= 0) {
            throw new Error("Expense is negative");
        }
        expenses.put(s, d);
        totalExpenses += d;
    }

    public Double removeExpense(String s) throws Error {
        if(!expenses.containsKey(s)) {
            throw new Error("Expense does not exist");
        }
        totalExpenses -= expenses.get(s) ;
        return expenses.remove(s);
    }
}

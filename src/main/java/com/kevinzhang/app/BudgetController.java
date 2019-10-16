package com.kevinzhang.app;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/budget")
public class BudgetController {
    private Budget budget = new Budget();

    @RequestMapping(method = RequestMethod.GET)
    public Budget getTotalBudget() {
        return budget;
    }

    @RequestMapping(path = "/{amount}", method = RequestMethod.PUT)
    public void setBudget(@PathVariable("amount") String amount) throws Exception{
        try {
            budget.setTotalBudget(Double.parseDouble(amount));
        } catch (Exception e) {
            throw new Exception("You must set the budget amount to a double");
        }
    }

    @RequestMapping(path = "/expense/{expenseName}/{amount}", method = RequestMethod.PUT)
    public void addExpense(@PathVariable("expenseName") String name,
                           @PathVariable("amount") String amount) throws Exception {
        try {
            budget.addExpense(name, Double.parseDouble(amount));
        } catch (Exception e) {
            throw new Exception("You must set the expense amount to a double");
        }
    }

    @RequestMapping(path = "/expense/{expenseName}", method = RequestMethod.DELETE)
    public void removeExpense(@PathVariable("expenseName") String name) throws Exception {
        Double amount = budget.removeExpense(name);
        if(amount == null) {
            throw new Exception("Expense doesn't exist");
        }
    }
}

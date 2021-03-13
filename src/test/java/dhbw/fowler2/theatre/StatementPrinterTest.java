package dhbw.fowler2.theatre;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class StatementPrinterTest {

    @Test
    public void printsStatements() {
        Invoice invoice = new Invoice("BigCo", List.of(new Performance(new TragedyPlay("Hamlet"), 55),
                new Performance(new ComedyPlay("As You Like It"), 35),
                new Performance(new TragedyPlay("Othello"), 40)));

        StatementPrinter statementPrinter = new WordStatementPrinter(invoice);
        var result = statementPrinter.print();

        Assert.assertEquals("Statement print mismatch", "Statement for BigCo\n" +
                "  Hamlet: $650.00 (55 seats)\n" +
                "  As You Like It: $580.00 (35 seats)\n" +
                "  Othello: $500.00 (40 seats)\n" +
                "Amount owed is $1,730.00\n" +
                "You earned 47 credits\n", result);
    }
}

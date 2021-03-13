package dhbw.fowler2.theatre;

import dhbw.fowler2.theatre.Play;
import dhbw.fowler2.theatre.Performance;
import dhbw.fowler2.theatre.StatementPrinter;
import dhbw.fowler2.theatre.Invoice;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class HtmlStatementPrinterTest {

    @Test
    public void printsStatements() {
        Invoice invoice = new Invoice("BigCo", List.of(new Performance(new TragedyPlay("Hamlet"), 55),
                new Performance(new ComedyPlay("As You Like It"), 35),
                new Performance(new TragedyPlay("Othello"), 40)));

        StatementPrinter statementPrinter = new WordStatementPrinter(invoice);
        var result = statementPrinter.print();

        Assert.assertEquals("Statement print mismatch", "<p>Statement for BigCo</p>" +
                "<p><b>Hamlet<b>: $650.00 (55 seats)</p>" +
                "<p><b>As You Like It<b>: $580.00 (35 seats)</p>" +
                "<p><b>Othello<b>: $500.00 (40 seats)</p>" +
                "</p>Amount owed is $1,730.00</p>" +
                "</p>You earned 47 credits</p>", result);
    }
}

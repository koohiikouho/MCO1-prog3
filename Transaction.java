import java.math.BigDecimal;

/**
 * the Transaction class is a class that holds a BigDecimal value and a String
 * description
 */
public class Transaction {
    private BigDecimal amount;
    private String description;

    /**
     * Transaction constructor has two parameters, the amount of the transaction,
     * and the string for the transaction
     * 
     * @param amount      amount of transaction in BigDecimal
     * @param description description of the transaction
     */
    public Transaction(BigDecimal amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    /**
     * gets Amount of transaction
     * 
     * @return BigDecimal returns a BigDecimal Value
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * sets transaction amount
     * 
     * @param amount amount is in BigDecimal
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * gets description
     * 
     * @return returns description as a String
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets description
     * 
     * @param description String to set description to
     */
    public void setDescription(String description) {
        this.description = description;
    }

}

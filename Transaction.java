public class Transaction {
 private Float amount;
 private String description;

    public Transaction(Float amount, String description){
        this.amount = amount;
        this.description = description;
    }
    public Float getAmount() {
        return amount;
    }
    public void setAmount(Float amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}

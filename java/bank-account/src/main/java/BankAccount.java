import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private AtomicBoolean isOpen = new AtomicBoolean();
    private AtomicInteger accountBalance = new AtomicInteger(0);

    public void open() {
        isOpen.set(true);
    }

    public void close() {
        isOpen.set(false);
    }

    public int deposit(int amount) throws BankAccountActionInvalidException {
        isTheAccountClosed();

        if (amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }

        return accountBalance.addAndGet(amount);
    }

    public int withdraw(int amount) throws BankAccountActionInvalidException {
        isTheAccountClosed();

        if (amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }

        if (accountBalance.get() == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }

        if (amount > accountBalance.get()) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }

        return accountBalance.addAndGet(-amount);
    }

    public int getBalance() throws BankAccountActionInvalidException {
        isTheAccountClosed();
        
        return accountBalance.get();
    }

    private void isTheAccountClosed() throws BankAccountActionInvalidException {
        if (!isOpen.get()) {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }
}

package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPhone(String)}
 */
public class BudgetAmount {

    public static final double MAX_VALUE = Double.parseDouble("9999999.99");
    public static final String MESSAGE_CONSTRAINTS =
            "Amount should only contain numbers, and it should be only 2 decimal points at maximum. It "
                    + "should also not be bigger than " + MAX_VALUE;
    public static final String VALIDATION_REGEX = "[0-9]+([.][0-9]{1,2})?";
    public final double value;

    /**
     * Constructs an {@code BudgetAmount}.
     *
     * @param amount A valid phone number.
     */
    public BudgetAmount(String amount) {
        requireNonNull(amount);
        checkArgument(isValidBudgetAmount(amount), MESSAGE_CONSTRAINTS);
        double amt = Double.parseDouble(amount);
        checkArgument(isValidBudgetValue(amt), MESSAGE_CONSTRAINTS);
        value = amt;
    }

    public BudgetAmount(double amount) {
        checkArgument(isValidBudgetValue(amount), MESSAGE_CONSTRAINTS);
        value = amount;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidBudgetAmount(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public static boolean isValidBudgetValue(double test) {
        return test <= MAX_VALUE;
    }

    @Override
    public String toString() {
        return value + "";
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof BudgetAmount) // instanceof handles nulls
                && value == ((BudgetAmount) other).value; // state check
    }

}
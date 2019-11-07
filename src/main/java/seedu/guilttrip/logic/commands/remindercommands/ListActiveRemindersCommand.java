package seedu.guilttrip.logic.commands.remindercommands;

import static java.util.Objects.requireNonNull;
import static seedu.guilttrip.model.Model.PREDICATE_SHOW_DISPLAYED_REMINDERS;

import seedu.guilttrip.logic.CommandHistory;
import seedu.guilttrip.logic.commands.Command;
import seedu.guilttrip.logic.commands.CommandResult;
import seedu.guilttrip.model.Model;

/**
 * List only reminders that are active;
 */
public class ListActiveRemindersCommand extends Command {

    public static final String COMMAND_WORD = "listReminders";

    public static final String MESSAGE_SUCCESS = "Listed reminders";

    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        requireNonNull(model);
        model.updateFilteredReminders(PREDICATE_SHOW_DISPLAYED_REMINDERS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}

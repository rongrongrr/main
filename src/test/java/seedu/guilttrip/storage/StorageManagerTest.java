package seedu.guilttrip.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.guilttrip.commons.core.GuiSettings;
import seedu.guilttrip.model.UserPrefs;
import seedu.guilttrip.ui.util.Theme;

//import static seedu.guilttrip.testutil.TypicalEntries.getTypicalAddressBook;
//import seedu.guilttrip.model.GuiltTrip;
//import seedu.guilttrip.model.ReadOnlyGuiltTrip;

public class StorageManagerTest {

    @TempDir
    public Path testFolder;

    private StorageManager storageManager;

    @BeforeEach
    public void setUp() {
        JsonGuiltTripStorage addressBookStorage = new JsonGuiltTripStorage(getTempFilePath("ab"));
        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(getTempFilePath("prefs"));
        storageManager = new StorageManager(addressBookStorage, userPrefsStorage);
    }

    private Path getTempFilePath(String fileName) {
        return testFolder.resolve(fileName);
    }

    @Test
    public void prefsReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonUserPrefsStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonUserPrefsStorageTest} class.
         */
        UserPrefs original = new UserPrefs();
        original.setGuiSettings(new GuiSettings(300, 600, 4, 6, "segoe UI", Theme.DARK));
        storageManager.saveUserPrefs(original);
        UserPrefs retrieved = storageManager.readUserPrefs().get();
        assertEquals(original, retrieved);
    }

    /**
    @Test
    public void addressBookReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonGuiltTripStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonAddressBookStorageTest} class.
         */
    /**
        GuiltTrip original = getTypicalAddressBook();
        storageManager.saveAddressBook(original);
        ReadOnlyGuiltTrip retrieved = storageManager.readAddressBook().get();
        assertEquals(original, new GuiltTrip(retrieved));
    }
    **/

    @Test
    public void getAddressBookFilePath() {
        assertNotNull(storageManager.getGuiltTripFilePath());
    }

}
package su.nightexpress.excellentcrates.config;

<<<<<<< HEAD
import org.bukkit.Sound;
import su.nightexpress.excellentcrates.editor.crate.RewardSortMenu;
import su.nightexpress.nightcore.core.CoreLang;
import su.nightexpress.nightcore.language.entry.LangEnum;
import su.nightexpress.nightcore.language.entry.LangString;
import su.nightexpress.nightcore.language.entry.LangText;
import su.nightexpress.nightcore.language.entry.LangUIButton;
import su.nightexpress.nightcore.util.bridge.wrapper.ClickEventType;

import static su.nightexpress.excellentcrates.Placeholders.*;
import static su.nightexpress.nightcore.language.tag.MessageTags.*;
import static su.nightexpress.nightcore.util.text.tag.Tags.*;

public class Lang extends CoreLang {

    //public static final LangKeyed<Particle> PARTICLE = LangKeyed.of("Particles", Registry.PARTICLE_TYPE);

    public static final LangEnum<RewardSortMenu.SortMode> REWARD_SORT_MODE = LangEnum.of("RewardSortMode", RewardSortMenu.SortMode.class);

    public static final LangString COMMAND_ARGUMENT_NAME_CRATE = LangString.of("Command.Argument.Name.Crate", "crate");
    public static final LangString COMMAND_ARGUMENT_NAME_KEY   = LangString.of("Command.Argument.Name.Key", "key");
    public static final LangString COMMAND_ARGUMENT_NAME_X     = LangString.of("Command.Argument.Name.X", "x");
    public static final LangString COMMAND_ARGUMENT_NAME_Y     = LangString.of("Command.Argument.Name.Y", "y");
    public static final LangString COMMAND_ARGUMENT_NAME_Z     = LangString.of("Command.Argument.Name.Z", "z");

    public static final LangText ERROR_COMMAND_INVALID_CRATE_ARGUMENT = LangText.of("Error.Command.Argument.InvalidCrate",
        LIGHT_GRAY.wrap(LIGHT_RED.wrap(GENERIC_VALUE) + " is not a valid crate!"));

    public static final LangText ERROR_COMMAND_INVALID_KEY_ARGUMENT = LangText.of("Error.Command.Argument.InvalidKey",
        LIGHT_GRAY.wrap(LIGHT_RED.wrap(GENERIC_VALUE) + " is not a valid key!"));

    public static final LangString COMMAND_EDITOR_DESC         = LangString.of("Command.Editor.Desc", "Open editor GUI.");
    public static final LangString COMMAND_DROP_DESC           = LangString.of("Command.Drop.Desc", "Spawn crate item in the world.");
    public static final LangString COMMAND_DROP_KEY_DESC       = LangString.of("Command.DropKey.Desc", "Spawn key item in the world.");
    public static final LangString COMMAND_OPEN_DESC           = LangString.of("Command.Open.Desc", "Open a crate.");
    public static final LangString COMMAND_OPEN_FOR_DESC       = LangString.of("Command.OpenFor.Desc", "Open crate for a player.");
    public static final LangString COMMAND_GIVE_DESC           = LangString.of("Command.Give.Desc", "Gives crate to a player.");
    public static final LangString COMMAND_KEY_DESC            = LangString.of("Command.Key.Desc", "Manage player's keys.");
    public static final LangString COMMAND_KEY_GIVE_DESC       = LangString.of("Command.Key.Give.Desc", "Give key to a player.");
    public static final LangString COMMAND_KEY_TAKE_DESC       = LangString.of("Command.Key.Take.Desc", "Take key from a player.");
    public static final LangString COMMAND_KEY_SET_DESC        = LangString.of("Command.Key.Set.Desc", "Set keys amount for a player.");
    public static final LangString COMMAND_KEY_INSPECT_DESC    = LangString.of("Command.Key.Show.Desc", "Inspect [player's] virtual keys.");
    public static final LangString COMMAND_PREVIEW_DESC        = LangString.of("Command.Preview.Desc", "Open crate preview.");
    public static final LangString COMMAND_RESET_COOLDOWN_DESC = LangString.of("Command.ResetCooldown.Desc", "Reset player's crate open cooldown.");
    public static final LangString COMMAND_MENU_DESC           = LangString.of("Command.Menu.Desc", "Open crate menu.");

    public static final LangText COMMAND_DROP_DONE = LangText.of("Command.Drop.Done",
        LIGHT_GRAY.wrap("Dropped " + LIGHT_YELLOW.wrap(CRATE_NAME) + " at " + LIGHT_YELLOW.wrap(LOCATION_X + ", " + LOCATION_Y + ", " + LOCATION_Z) + " in " + LIGHT_YELLOW.wrap(LOCATION_WORLD) + "."));

    public static final LangText COMMAND_DROP_KEY_DONE = LangText.of("Command.DropKey.Done",
        LIGHT_GRAY.wrap("Dropped " + LIGHT_YELLOW.wrap(KEY_NAME) + " at " + LIGHT_YELLOW.wrap(LOCATION_X + ", " + LOCATION_Y + ", " + LOCATION_Z) + " in " + LIGHT_YELLOW.wrap(LOCATION_WORLD) + "."));



    public static final LangText COMMAND_OPEN_FOR_DONE = LangText.of("Command.OpenFor.Done",
        LIGHT_GRAY.wrap("Opened " + LIGHT_YELLOW.wrap(CRATE_NAME) + " for " + LIGHT_YELLOW.wrap(PLAYER_NAME) + "."));

    public static final LangText COMMAND_OPEN_FOR_NOTIFY = LangText.of("Command.OpenFor.Notify",
        LIGHT_GRAY.wrap("You have been forced to open " + LIGHT_YELLOW.wrap(CRATE_NAME) + "."));



    public static final LangText COMMAND_GIVE_DONE = LangText.of("Command.Give.Done",
        LIGHT_GRAY.wrap("Given " + LIGHT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + LIGHT_YELLOW.wrap(CRATE_NAME) + " crate(s) to " + LIGHT_YELLOW.wrap(PLAYER_NAME) + "."));

    public static final LangText COMMAND_GIVE_NOTIFY = LangText.of("Command.Give.Notify",
        LIGHT_GRAY.wrap("You recieved " + LIGHT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + LIGHT_YELLOW.wrap(CRATE_NAME) + "."));



    public static final LangText COMMAND_KEY_GIVE_DONE = LangText.of("Command.Key.Give.Done",
        LIGHT_GRAY.wrap("Given " + LIGHT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + LIGHT_YELLOW.wrap(KEY_NAME) + " key(s) to " + LIGHT_YELLOW.wrap(PLAYER_NAME) + "."));

    public static final LangText COMMAND_KEY_GIVE_NOTIFY = LangText.of("Command.Key.Give.Notify",
        LIGHT_GRAY.wrap("You recieved " + LIGHT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + LIGHT_YELLOW.wrap(KEY_NAME) + "!"));

    public static final LangString COMMAND_KEY_GIVE_ALL_DESC = LangString.of("Command.Key.GiveAll.Desc",
        "Give key to all online players.");

    public static final LangText COMMAND_KEY_GIVE_ALL_DONE = LangText.of("Command.Key.GiveAll.Done",
        LIGHT_GRAY.wrap("Given " + LIGHT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + LIGHT_YELLOW.wrap(KEY_NAME) + " key(s) to " + LIGHT_YELLOW.wrap("All Players") + "."));

    public static final LangText COMMAND_KEY_TAKE_DONE = LangText.of("Command.Key.Take.Done",
        LIGHT_GRAY.wrap("Taken " + LIGHT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + LIGHT_YELLOW.wrap(KEY_NAME) + " key(s) from " + LIGHT_YELLOW.wrap(PLAYER_NAME) + "."));

    public static final LangText COMMAND_KEY_TAKE_NOTIFY = LangText.of("Command.Key.Take.Notify",
        LIGHT_GRAY.wrap("You lost " + LIGHT_RED.wrap("x" + GENERIC_AMOUNT) + " " + LIGHT_RED.wrap(KEY_NAME) + "."));

    public static final LangText COMMAND_KEY_SET_DONE = LangText.of("Command.Key.Set.Done",
        LIGHT_GRAY.wrap("Set " + LIGHT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + LIGHT_YELLOW.wrap(KEY_NAME) + " key(s) for " + LIGHT_YELLOW.wrap(PLAYER_NAME) + "."));

    public static final LangText COMMAND_KEY_SET_NOTIFY = LangText.of("Command.Key.Set.Notify",
        LIGHT_GRAY.wrap("Your " + LIGHT_YELLOW.wrap(KEY_NAME) + "'s amount has been changed to " + LIGHT_YELLOW.wrap("x" + GENERIC_AMOUNT) + "."));



    public static final LangText COMMAND_KEY_INSPECT_LIST = LangText.of("Command.Key.Show.Format.List",
        TAG_NO_PREFIX,
        " ",
        LIGHT_YELLOW.wrap(BOLD.wrap(PLAYER_NAME + "'s Virtual Keys: ")),
=======
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.api.crate.RewardType;
import su.nightexpress.excellentcrates.crate.limit.CooldownMode;
import su.nightexpress.nightcore.core.config.CoreLang;
import su.nightexpress.nightcore.locale.LangContainer;
import su.nightexpress.nightcore.locale.LangEntry;
import su.nightexpress.nightcore.locale.entry.*;
import su.nightexpress.nightcore.locale.message.MessageData;
import su.nightexpress.nightcore.util.bridge.RegistryType;

import static su.nightexpress.excellentcrates.Placeholders.*;
import static su.nightexpress.nightcore.util.text.night.wrapper.TagWrappers.*;

public class Lang implements LangContainer {

    public static final TextLocale COMMAND_ARGUMENT_NAME_CRATE = LangEntry.builder("Command.Argument.Name.Crate").text("crate");
    public static final TextLocale COMMAND_ARGUMENT_NAME_KEY   = LangEntry.builder("Command.Argument.Name.Key").text("key");
    public static final TextLocale COMMAND_ARGUMENT_NAME_X     = LangEntry.builder("Command.Argument.Name.X").text("x");
    public static final TextLocale COMMAND_ARGUMENT_NAME_Y     = LangEntry.builder("Command.Argument.Name.Y").text("y");
    public static final TextLocale COMMAND_ARGUMENT_NAME_Z     = LangEntry.builder("Command.Argument.Name.Z").text("z");

    public static final MessageLocale ERROR_COMMAND_INVALID_CRATE_ARGUMENT = LangEntry.builder("Error.Command.Argument.InvalidCrate").chatMessage(
        GRAY.wrap(SOFT_RED.wrap(GENERIC_VALUE) + " is not a valid crate!"));

    public static final MessageLocale ERROR_COMMAND_INVALID_KEY_ARGUMENT = LangEntry.builder("Error.Command.Argument.InvalidKey").chatMessage(
        GRAY.wrap(SOFT_RED.wrap(GENERIC_VALUE) + " is not a valid key!"));

    public static final TextLocale COMMAND_EDITOR_DESC         = LangEntry.builder("Command.Editor.Desc").text("Open editor GUI.");
    public static final TextLocale COMMAND_DROP_DESC           = LangEntry.builder("Command.Drop.Desc").text("Spawn crate item in the world.");
    public static final TextLocale COMMAND_DROP_KEY_DESC       = LangEntry.builder("Command.DropKey.Desc").text("Spawn key item in the world.");
    public static final TextLocale COMMAND_OPEN_DESC           = LangEntry.builder("Command.Open.Desc").text("Open a crate.");
    public static final TextLocale COMMAND_OPEN_FOR_DESC       = LangEntry.builder("Command.OpenFor.Desc").text("Open crate for a player.");
    public static final TextLocale COMMAND_GIVE_DESC           = LangEntry.builder("Command.Give.Desc").text("Gives crate to a player.");
    public static final TextLocale COMMAND_KEY_DESC            = LangEntry.builder("Command.Key.Desc").text("Manage player's keys.");
    public static final TextLocale COMMAND_KEY_GIVE_DESC       = LangEntry.builder("Command.Key.Give.Desc").text("Give key to a player.");
    public static final TextLocale COMMAND_KEY_TAKE_DESC       = LangEntry.builder("Command.Key.Take.Desc").text("Take key from a player.");
    public static final TextLocale COMMAND_KEY_SET_DESC        = LangEntry.builder("Command.Key.Set.Desc").text("Set keys amount for a player.");
    public static final TextLocale COMMAND_KEY_INSPECT_DESC    = LangEntry.builder("Command.Key.Show.Desc").text("Inspect [player's] virtual keys.");
    public static final TextLocale COMMAND_PREVIEW_DESC        = LangEntry.builder("Command.Preview.Desc").text("Open crate preview.");
    public static final TextLocale COMMAND_RESET_COOLDOWN_DESC = LangEntry.builder("Command.ResetCooldown.Desc").text("Reset player's crate open cooldown.");
    public static final TextLocale COMMAND_MENU_DESC           = LangEntry.builder("Command.Menu.Desc").text("Open crate menu.");

    public static final MessageLocale COMMAND_DROP_DONE = LangEntry.builder("Command.Drop.Done").chatMessage(
        GRAY.wrap("Dropped " + SOFT_YELLOW.wrap(CRATE_NAME) + " at " + SOFT_YELLOW.wrap(LOCATION_X + ", " + LOCATION_Y + ", " + LOCATION_Z) + " in " + SOFT_YELLOW.wrap(LOCATION_WORLD) + "."));

    public static final MessageLocale COMMAND_DROP_KEY_DONE = LangEntry.builder("Command.DropKey.Done").chatMessage(
        GRAY.wrap("Dropped " + SOFT_YELLOW.wrap(KEY_NAME) + " at " + SOFT_YELLOW.wrap(LOCATION_X + ", " + LOCATION_Y + ", " + LOCATION_Z) + " in " + SOFT_YELLOW.wrap(LOCATION_WORLD) + "."));



    public static final MessageLocale COMMAND_OPEN_FOR_DONE = LangEntry.builder("Command.OpenFor.Done").chatMessage(
        GRAY.wrap("Opened " + SOFT_YELLOW.wrap(CRATE_NAME) + " for " + SOFT_YELLOW.wrap(PLAYER_NAME) + "."));

    public static final MessageLocale COMMAND_OPEN_FOR_NOTIFY = LangEntry.builder("Command.OpenFor.Notify").chatMessage(
        GRAY.wrap("You have been forced to open " + SOFT_YELLOW.wrap(CRATE_NAME) + "."));



    public static final MessageLocale COMMAND_GIVE_DONE = LangEntry.builder("Command.Give.Done").chatMessage(
        GRAY.wrap("Given " + SOFT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + SOFT_YELLOW.wrap(CRATE_NAME) + " crate(s) to " + SOFT_YELLOW.wrap(PLAYER_NAME) + "."));

    public static final MessageLocale COMMAND_GIVE_NOTIFY = LangEntry.builder("Command.Give.Notify").chatMessage(
        GRAY.wrap("You recieved " + SOFT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + SOFT_YELLOW.wrap(CRATE_NAME) + "."));



    public static final MessageLocale COMMAND_KEY_GIVE_DONE = LangEntry.builder("Command.Key.Give.Done").chatMessage(
        GRAY.wrap("Given " + SOFT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + SOFT_YELLOW.wrap(KEY_NAME) + " key(s) to " + SOFT_YELLOW.wrap(PLAYER_NAME) + "."));

    public static final MessageLocale COMMAND_KEY_GIVE_NOTIFY = LangEntry.builder("Command.Key.Give.Notify").chatMessage(
        GRAY.wrap("You recieved " + SOFT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + SOFT_YELLOW.wrap(KEY_NAME) + "!"));

    public static final TextLocale COMMAND_KEY_GIVE_ALL_DESC = LangEntry.builder("Command.Key.GiveAll.Desc").text(
        "Give key to all online players.");

    public static final MessageLocale COMMAND_KEY_GIVE_ALL_DONE = LangEntry.builder("Command.Key.GiveAll.Done").chatMessage(
        GRAY.wrap("Given " + SOFT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + SOFT_YELLOW.wrap(KEY_NAME) + " key(s) to " + SOFT_YELLOW.wrap("All Players") + "."));

    public static final MessageLocale COMMAND_KEY_TAKE_DONE = LangEntry.builder("Command.Key.Take.Done").chatMessage(
        GRAY.wrap("Taken " + SOFT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + SOFT_YELLOW.wrap(KEY_NAME) + " key(s) from " + SOFT_YELLOW.wrap(PLAYER_NAME) + "."));

    public static final MessageLocale COMMAND_KEY_TAKE_NOTIFY = LangEntry.builder("Command.Key.Take.Notify").chatMessage(
        GRAY.wrap("You lost " + SOFT_RED.wrap("x" + GENERIC_AMOUNT) + " " + SOFT_RED.wrap(KEY_NAME) + "."));

    public static final MessageLocale COMMAND_KEY_SET_DONE = LangEntry.builder("Command.Key.Set.Done").chatMessage(
        GRAY.wrap("Set " + SOFT_YELLOW.wrap("x" + GENERIC_AMOUNT) + " of " + SOFT_YELLOW.wrap(KEY_NAME) + " key(s) for " + SOFT_YELLOW.wrap(PLAYER_NAME) + "."));

    public static final MessageLocale COMMAND_KEY_SET_NOTIFY = LangEntry.builder("Command.Key.Set.Notify").chatMessage(
        GRAY.wrap("Your " + SOFT_YELLOW.wrap(KEY_NAME) + "'s amount has been changed to " + SOFT_YELLOW.wrap("x" + GENERIC_AMOUNT) + "."));



    public static final MessageLocale COMMAND_KEY_INSPECT_LIST = LangEntry.builder("Command.Key.Show.Format.List").message(
        MessageData.CHAT_NO_PREFIX,
        " ",
        SOFT_YELLOW.wrap(BOLD.wrap(PLAYER_NAME + "'s Virtual Keys: ")),
>>>>>>> upstream/master
        GENERIC_ENTRY,
        " "
    );

<<<<<<< HEAD
    public static final LangString COMMAND_KEY_INSPECT_ENTRY = LangString.of("Command.Key.Show.Format.Entry",
        LIGHT_YELLOW.wrap("▪ " + LIGHT_GRAY.wrap(KEY_NAME + ": ") + "x" + GENERIC_AMOUNT)
    );

    public static final LangText COMMAND_PREVIEW_DONE_OTHERS = LangText.of("Command.Preview.Done.Others",
        LIGHT_GRAY.wrap("Opened " + LIGHT_YELLOW.wrap(CRATE_NAME) + " preview for " + LIGHT_YELLOW.wrap(PLAYER_DISPLAY_NAME) + "."));

    public static final LangText COMMAND_RESET_COOLDOWN_DONE = LangText.of("Command.ResetCooldown.Done",
        LIGHT_GRAY.wrap("Reset " + LIGHT_YELLOW.wrap(PLAYER_NAME) + "'s open cooldown for " + LIGHT_YELLOW.wrap(CRATE_NAME) + "."));

    public static final LangText COMMAND_MENU_DONE_OTHERS = LangText.of("Command.Menu.Done.Others",
        LIGHT_GRAY.wrap("Opened crates menu for " + LIGHT_YELLOW.wrap(PLAYER_DISPLAY_NAME) + "."));
=======
    public static final TextLocale COMMAND_KEY_INSPECT_ENTRY = LangEntry.builder("Command.Key.Show.Format.Entry").text(
        SOFT_YELLOW.wrap("▪ " + GRAY.wrap(KEY_NAME + ": ") + "x" + GENERIC_AMOUNT)
    );

    public static final MessageLocale COMMAND_PREVIEW_DONE_OTHERS = LangEntry.builder("Command.Preview.Done.Others").chatMessage(
        GRAY.wrap("Opened " + SOFT_YELLOW.wrap(CRATE_NAME) + " preview for " + SOFT_YELLOW.wrap(PLAYER_DISPLAY_NAME) + "."));

    public static final MessageLocale COMMAND_RESET_COOLDOWN_DONE = LangEntry.builder("Command.ResetCooldown.Done").chatMessage(
        GRAY.wrap("Reset " + SOFT_YELLOW.wrap(PLAYER_NAME) + "'s open cooldown for " + SOFT_YELLOW.wrap(CRATE_NAME) + "."));

    public static final MessageLocale COMMAND_MENU_DONE_OTHERS = LangEntry.builder("Command.Menu.Done.Others").chatMessage(
        GRAY.wrap("Opened crates menu for " + SOFT_YELLOW.wrap(PLAYER_DISPLAY_NAME) + "."));
>>>>>>> upstream/master





<<<<<<< HEAD
    public static final LangText CRATE_OPEN_ERROR_INVENTORY_SPACE = LangText.of("Crate.Open.Error.InventorySpace",
        OUTPUT.wrap(20, 80) + SOUND.wrap(Sound.ENTITY_VILLAGER_NO),
        LIGHT_RED.wrap(BOLD.wrap("Inventory is Full!")),
        LIGHT_GRAY.wrap("Clean up inventory to open crates.")
    );

    public static final LangText CRATE_OPEN_ERROR_COOLDOWN_TEMPORARY = LangText.of("Crate.Open.Error.Cooldown.Temporary",
        OUTPUT.wrap(20, 80) + SOUND.wrap(Sound.ENTITY_VILLAGER_NO),
        LIGHT_RED.wrap(BOLD.wrap("Crate is on Cooldown!")),
        LIGHT_GRAY.wrap("You can open it in " + LIGHT_RED.wrap(GENERIC_TIME))
    );

    public static final LangText CRATE_OPEN_ERROR_COOLDOWN_ONE_TIMED = LangText.of("Crate.Open.Error.Cooldown.OneTimed",
        OUTPUT.wrap(20, 80) + SOUND.wrap(Sound.ENTITY_VILLAGER_NO),
        LIGHT_RED.wrap(BOLD.wrap("Whoops!")),
        LIGHT_GRAY.wrap("You already have opened this one-timed crate!")
    );

    public static final LangText CRATE_OPEN_ERROR_NO_KEY = LangText.of("Crate.Open.Error.NoKey",
        OUTPUT.wrap(20, 80) + SOUND.wrap(Sound.ENTITY_VILLAGER_NO),
        LIGHT_RED.wrap(BOLD.wrap("Whoops!")),
        LIGHT_GRAY.wrap("You don't have a key for this crate!")
    );

    public static final LangText CRATE_OPEN_ERROR_NO_HOLD_KEY = LangText.of("Crate.Open.Error.NoHoldKey",
        OUTPUT.wrap(20, 80) + SOUND.wrap(Sound.ENTITY_VILLAGER_NO),
        LIGHT_RED.wrap(BOLD.wrap("Whoops!")),
        LIGHT_GRAY.wrap("You must hold a key to open a crate!")
    );

    public static final LangText CRATE_OPEN_ERROR_NO_REWARDS = LangText.of("Crate.Open.Error.NoRewards",
        OUTPUT.wrap(20, 80) + SOUND.wrap(Sound.ENTITY_VILLAGER_NO),
        RED.wrap(BOLD.wrap("Whoops!")),
        LIGHT_GRAY.wrap("There are no rewards for you! Try later.")
    );

    public static final LangText CRATE_OPEN_ERROR_TOO_EXPENSIVE = LangText.of("Crate.Open.Error.TooExpensive",
        OUTPUT.wrap(20, 80) + SOUND.wrap(Sound.ENTITY_VILLAGER_NO),
        LIGHT_RED.wrap(BOLD.wrap("Whoops!")),
        LIGHT_GRAY.wrap("You need " + LIGHT_RED.wrap(CRATE_OPEN_COST) + " to open it!")
    );

    public static final LangText CRATE_OPEN_ERROR_ALREADY = LangText.of("Crate.Open.Error.Already",
        OUTPUT.wrap(20, 80) + SOUND.wrap(Sound.ENTITY_VILLAGER_NO),
        RED.wrap(BOLD.wrap("Whoops!")),
        LIGHT_GRAY.wrap("You're already opening a crate!")
    );

    public static final LangText CRATE_OPEN_REWARD_INFO = LangText.of("Crate.Open.Reward.Info",
        TAG_NO_PREFIX,
        LIGHT_GRAY.wrap("You won " + LIGHT_GREEN.wrap(REWARD_NAME) + " from the " + LIGHT_GREEN.wrap(CRATE_NAME) + "!"));

    public static final LangText CRATE_OPEN_MILESTONE_COMPLETED = LangText.of("Crate.Open.Milestone.Completed",
        TAG_NO_PREFIX,
        SOUND.wrap(Sound.ENTITY_PLAYER_LEVELUP),
        LIGHT_GRAY.wrap("You completed " + LIGHT_GREEN.wrap(MILESTONE_OPENINGS + " Openings ") + "milestone and got " + LIGHT_GREEN.wrap(REWARD_NAME) + " as reward!")
    );

    public static final LangText CRATE_OPEN_REWARD_BROADCAST = LangText.of("Crate.Open.Reward.Broadcast",
        TAG_NO_PREFIX + SOUND.wrap(Sound.BLOCK_NOTE_BLOCK_BELL),
        " ",
        GRAY.wrap(LIGHT_PURPLE.wrap(PLAYER_DISPLAY_NAME) + " opened " + LIGHT_PURPLE.wrap(CRATE_NAME) + " and received " + LIGHT_PURPLE.wrap(REWARD_NAME) + "!"),
        " ",
        GRAY.wrap("Purchase keys: " + CLICK.wrap(LIGHT_PURPLE.wrap("[Click to open Store]"), ClickEventType.OPEN_URL, "https://spigotmc.org/")),
        " "
    );

    public static final LangText CRATE_PREVIEW_ERROR_COOLDOWN = LangText.of("Crate.Preview.Error.Cooldown",
        LIGHT_GRAY.wrap("You can preview this crate again in " + LIGHT_RED.wrap(GENERIC_TIME))
    );

    public static final LangText CRATE_CREATE_ERROR_DUPLICATED = LangText.of("Crate.Create.Error.Duplicated",
        LIGHT_RED.wrap("Crate with such ID already exists!")
    );

    public static final LangText KEY_CREATE_ERROR_DUPLICATED = LangText.of("Key.Create.Error.Duplicated",
        LIGHT_RED.wrap("Key with such ID already exists!")
    );

    public static final LangString OTHER_COOLDOWN_READY       = LangString.of("Other.Cooldown.Ready", LIGHT_GREEN.wrap("Ready to Open!"));
    public static final LangString OTHER_LAST_OPENER_EMPTY    = LangString.of("Other.LastOpener.Empty", "-");
    public static final LangString OTHER_LAST_REWARD_EMPTY    = LangString.of("Other.LastReward.Empty", "-");
    public static final LangString OTHER_NEXT_MILESTONE_EMPTY = LangString.of("Other.NextMilestone.Empty", "-");

    public static final LangString OTHER_MIDNIGHT = LangString.of("Other.Midnight", "Midnight");
    public static final LangString OTHER_FREE     = LangString.of("Other.Free", "Free");

    public static final LangUIButton OTHER_BROKEN_ITEM = LangUIButton.builder("Other.BrokenItem", LIGHT_RED.wrap(BOLD.wrap("< Invalid Item >")))
        .description(
            LIGHT_GRAY.wrap("This item wasn't parsed properly."),
            LIGHT_GRAY.wrap("Check console logs for details.")
        ).formatted(false).build();

    public static final LangString INSPECTION_PROBLEMS    = LangString.of("Inspection.Problems", GENERIC_AMOUNT + " problem(s)");
    public static final LangString INSPECTION_NO_PROBLEMS = LangString.of("Inspection.NoProblems", "No problems found");

    public static final LangString EDITOR_TITLE_MAIN             = LangString.of("Editor.Title.Main", BLACK.wrap("ExcellentCrates Editor"));
    public static final LangString EDITOR_TITLE_ITEM_TYPE        = LangString.of("Editor.Title.ItemSave", BLACK.wrap("Item Save Method"));
    public static final LangString EDITOR_TITLE_CRATE_LIST       = LangString.of("Editor.Title.Crates", BLACK.wrap("Crates Editor"));
    public static final LangString EDITOR_TITLE_CRATE_SETTINGS   = LangString.of("Editor.Title.Crate.Settings", BLACK.wrap("Crate Settings"));
    public static final LangString EDITOR_TITLE_CRATE_OPEN_COSTS = LangString.of("Editor.Title.Crate.OpenCosts", BLACK.wrap("Crate Open Costs"));
    public static final LangString EDITOR_TITLE_CRATE_MILESTONES = LangString.of("Editor.Title.Crate.Milestones", BLACK.wrap("Crate Milestones"));
    public static final LangString EDITOR_TITLE_CRATE_EFFECT     = LangString.of("Editor.Title.Crate.Effect", BLACK.wrap("Crate Effect"));
    public static final LangString EDITOR_TITLE_CRATE_PLACEMENT  = LangString.of("Editor.Title.Crate.Placement", BLACK.wrap("Crate Placement"));
    public static final LangString EDITOR_TITLE_REWARD_LIST      = LangString.of("Editor.Title.Reward.List", BLACK.wrap("Crate Rewards"));
    public static final LangString EDITOR_TITLE_REWARD_CREATION  = LangString.of("Editor.Title.Reward.Creation", BLACK.wrap("Reward Creator"));
    public static final LangString EDITOR_TITLE_REWARD_CONTENT  = LangString.of("Editor.Title.Reward.Content", BLACK.wrap("Reward Items"));
    public static final LangString EDITOR_TITLE_REWARD_SETTINGS  = LangString.of("Editor.Title.Reward.Settings", BLACK.wrap("Reward Settings"));
    public static final LangString EDITOR_TITLE_REWARD_LIMITS    = LangString.of("Editor.Title.Reward.Limits", BLACK.wrap("Reward Limits"));
    public static final LangString EDITOR_TITLE_REWARD_SORT      = LangString.of("Editor.Title.Reward.Sort", BLACK.wrap("Reward Sorting"));
    public static final LangString EDITOR_TITLE_KEY_LIST         = LangString.of("Editor.Title.Keys", BLACK.wrap("Keys Editor"));
    public static final LangString EDITOR_TITLE_KEY_SETTINGS     = LangString.of("Editor.Title.Key.Settings", BLACK.wrap("Key Settings"));

    public static final LangString EDITOR_ENTER_DISPLAY_NAME = LangString.of("Editor.Enter.DisplayName",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Display Name]")));

    public static final LangString EDITOR_ENTER_TEXT = LangString.of("Editor.Enter.Text",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Text]")));

    public static final LangString EDITOR_ENTER_AMOUNT = LangString.of("Editor.Enter.Amount",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Amount]")));

    public static final LangString EDITOR_ENTER_VALUE = LangString.of("Editor.Enter.Value",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Value]")));

    public static final LangString EDITOR_ENTER_SECONDS = LangString.of("Editor.Crate.Enter.Seconds",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Seconds Amount]")));

    public static final LangString EDITOR_ENTER_WEIGHT = LangString.of("Editor.Reward.Enter.Chance",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Weight]")));

    public static final LangString EDITOR_ENTER_COMMAND = LangString.of("Editor.Reward.Enter.Command",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Command]")));

    public static final LangString EDITOR_ENTER_CRATE_ID = LangString.of("Editor.Crate.Enter.Id",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Crate Identifier]")));

    public static final LangString EDITOR_ENTER_MODEL_NAME = LangString.of("Editor.Crate.Enter.ModelName",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Model Name]")));

    public static final LangString EDITOR_ENTER_PARTICLE_NAME = LangString.of("Editor.Crate.Enter.Particle.Name",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Particle Name]")));

    public static final LangString EDITOR_ENTER_KEY_ID = LangString.of("Editor.Crate.Enter.KeyId",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Key Identifier]")));

    public static final LangString EDITOR_ENTER_BLOCK_LOCATION = LangString.of("Editor.Crate.Enter.BlockLocation",
        LIGHT_GRAY.wrap("Click a " + LIGHT_GREEN.wrap("[Block] ") + " to assign crate."));

    public static final LangString EDITOR_ENTER_HOLOGRAM_TEMPLATE = LangString.of("Editor.Crate.Enter.HologramTemplate",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Hologram Template]")));

    public static final LangString EDITOR_ENTER_ANIMATION_ID = LangString.of("Editor.Crate.Enter.AnimationConfig",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Animation Name]")));

    public static final LangString EDITOR_ENTER_PREVIEW_ID = LangString.of("Editor.Crate.Enter.PreviewConfig",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Preview Name]")));

    public static final LangString EDITOR_ENTER_CURRENCY = LangString.of("Editor.Crate.Enter.Currency",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Currency ID]")));

    public static final LangString EDITOR_ENTER_REWARD_ID = LangString.of("Editor.Reward.Enter.Id",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Reward Identifier]")));

    public static final LangString EDITOR_ENTER_RARITY = LangString.of("Editor.Reward.Enter.Rarity",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Rarity]")));

    public static final LangString EDITOR_ENTER_PERMISSION = LangString.of("Editor.Reward.Enter.Permissions",
        LIGHT_GRAY.wrap("Enter " + LIGHT_GREEN.wrap("[Permission Node]")));

    public static final LangUIButton EDITOR_BUTTON_CRATE_ITEM_STACKABLE = LangUIButton.builder("Editor.Button.Crate.ItemStackable", "Item Stackable")
        .current(CRATE_ITEM_STACKABLE)
        .description("Controls whether crate item is stackable.")
        .leftClick("toggle")
        .build();

    public static final LangUIButton EDITOR_BUTTON_KEY_ITEM_STACKABLE = LangUIButton.builder("Editor.Button.Key.ItemStackable", "Item Stackable")
        .current(KEY_ITEM_STACKABLE)
        .description("Controls whether key item is stackable.")
        .leftClick("toggle")
        .build();

    public static final LangUIButton EDITOR_BUTTON_SORT_REWARDS = LangUIButton.builder("Editor.Button.Reward.SortMode", GENERIC_MODE)
        .description("Sort reward by their " + LIGHT_YELLOW.wrap(GENERIC_MODE) + ".")
        .leftClick("ascending")
        .rightClick("descending")
        .build();

    public static final LangUIButton EDITOR_BUTTON_ITEM_TYPE_BY_NBT = LangUIButton.builder("Editor.Button.ItemType.ByNBT", "By Pure NBT")
        .description(
            "Saves item by its NBT data.",
            "",
            GRAY.wrap(GREEN.wrap("✔") + " Saves the whole item NBT data"),
            GRAY.wrap("compatible with newer MC versions."),
            "",
            GRAY.wrap(RED.wrap("✘") + " Does " + RED.wrap("not") + " reflect any changes made"),
            GRAY.wrap("in its original plugin's configuration.")
        )
        .click("select")
        .build();

    public static final LangUIButton EDITOR_BUTTON_ITEM_TYPE_BY_ID = LangUIButton.builder("Editor.Button.ItemType.ByID", "By Item ID")
        .description(
            "Saves item by its unique ID.",
            "",
            GRAY.wrap(GREEN.wrap("✔") + " Always reflects all changes made"),
            GRAY.wrap("in its original plugin's configuration."),
            "",
            GRAY.wrap(RED.wrap("✘") + " Does " + RED.wrap("not") + " saves any NBT data"),
            GRAY.wrap("added outside of the item configuration.")
        )
        .click("select")
        .build();
=======
    public static final MessageLocale CRATE_OPEN_ERROR_INVENTORY_SPACE = LangEntry.builder("Crate.Open.Error.InventorySpace").titleMessage(
        SOFT_RED.wrap(BOLD.wrap("Inventory is Full!")),
        GRAY.wrap("Clean up inventory to open crates."),
        Sound.ENTITY_VILLAGER_NO
    );

    public static final MessageLocale CRATE_OPEN_ERROR_COOLDOWN_TEMPORARY = LangEntry.builder("Crate.Open.Error.Cooldown.Temporary").titleMessage(
        SOFT_RED.wrap(BOLD.wrap("Crate is on Cooldown!")),
        GRAY.wrap("You can open it again in " + SOFT_RED.wrap(GENERIC_TIME)),
        Sound.ENTITY_VILLAGER_NO
    );

    public static final MessageLocale CRATE_OPEN_ERROR_COOLDOWN_ONE_TIMED = LangEntry.builder("Crate.Open.Error.Cooldown.OneTimed").titleMessage(
        SOFT_RED.wrap(BOLD.wrap("Whoops!")),
        GRAY.wrap("You already have opened this one-timed crate!"),
        Sound.ENTITY_VILLAGER_NO
    );

    public static final MessageLocale CRATE_OPEN_ERROR_NO_REWARDS = LangEntry.builder("Crate.Open.Error.NoRewards").titleMessage(
        RED.wrap(BOLD.wrap("Whoops!")),
        GRAY.wrap("There are no rewards for you! Try later."),
        Sound.ENTITY_VILLAGER_NO
    );

    public static final MessageLocale CRATE_OPEN_ERROR_ALREADY = LangEntry.builder("Crate.Open.Error.Already").titleMessage(
        RED.wrap(BOLD.wrap("Whoops!")),
        GRAY.wrap("You're already opening a crate!"),
        Sound.ENTITY_VILLAGER_NO
    );

    public static final MessageLocale CRATE_OPEN_TOO_EXPENSIVE = LangEntry.builder("Crate.Open.TooExpensive").message(
        MessageData.CHAT_NO_PREFIX,
        " ",
        RED.and(BOLD).wrap("CRATE NOT OPENED:"),
        RED.wrap("» ") + GRAY.wrap("Crate: ") + WHITE.wrap(CRATE_NAME),
        RED.wrap("» ") + GRAY.wrap("You can't afford the open cost: " + GENERIC_COSTS),
        " "
    );

    public static final MessageLocale CRATE_OPEN_RESULT_INFO = LangEntry.builder("Crate.Rewards").message(
        MessageData.CHAT_NO_PREFIX,
        " ",
        YELLOW.and(BOLD).wrap("CRATE OPENED:"),
        YELLOW.wrap("» ") + GRAY.wrap("Crate: ") + WHITE.wrap(CRATE_NAME),
        YELLOW.wrap("» ") + GRAY.wrap("Rewards: ") + WHITE.wrap(GENERIC_REWARDS),
        " "
    );

    public static final TextLocale CRATE_OPEN_RESULT_REWARD = LangEntry.builder("Crate.Opened.Result.Reward").text(REWARD_NAME);

    public static final MessageLocale CRATE_OPEN_MILESTONE_COMPLETED = LangEntry.builder("Crate.Open.Milestone.Completed").message(
        MessageData.chat().usePrefix(false).sound(Sound.ENTITY_PLAYER_LEVELUP).build(),
        GRAY.wrap("You completed " + GREEN.wrap(MILESTONE_OPENINGS + " Openings ") + "milestone and got " + GREEN.wrap(REWARD_NAME) + " as reward!")
    );

    public static final MessageLocale CRATE_OPEN_REWARD_BROADCAST = LangEntry.builder("Crate.Open.Reward.Broadcast").message(
        MessageData.chat().usePrefix(false).sound(Sound.BLOCK_NOTE_BLOCK_BELL).build(),
        " ",
        GRAY.wrap(LIGHT_PURPLE.wrap(PLAYER_DISPLAY_NAME) + " opened " + LIGHT_PURPLE.wrap(CRATE_NAME) + " and received " + LIGHT_PURPLE.wrap(REWARD_NAME) + "!"),
        " ",
        GRAY.wrap("Purchase keys: " + OPEN_URL.with("https://YOUR_LINK_HERE.xyz").wrap(LIGHT_PURPLE.wrap("[Click to open Store]"))),
        " "
    );

    public static final MessageLocale CRATE_PREVIEW_ERROR_COOLDOWN = LangEntry.builder("Crate.Preview.Error.Cooldown").chatMessage(
        GRAY.wrap("You can preview this crate again in " + SOFT_RED.wrap(GENERIC_TIME))
    );

    public static final MessageLocale ERROR_DATA_IS_LOADING = LangEntry.builder("Error.DataIsLoading").chatMessage(
        SOFT_RED.wrap("Data is still loading... Please try again later.")
    );

    public static final TextLocale OTHER_COOLDOWN_READY       = LangEntry.builder("Other.Cooldown.Ready").text(GREEN.wrap("Ready to Open!"));
    public static final TextLocale OTHER_LAST_OPENER_EMPTY    = LangEntry.builder("Other.LastOpener.Empty").text("-");
    public static final TextLocale OTHER_LAST_REWARD_EMPTY    = LangEntry.builder("Other.LastReward.Empty").text("-");
    public static final TextLocale OTHER_NEXT_MILESTONE_EMPTY = LangEntry.builder("Other.NextMilestone.Empty").text("-");

    public static final TextLocale OTHER_MIDNIGHT = LangEntry.builder("Other.Midnight").text("Midnight");
    public static final TextLocale OTHER_FREE     = LangEntry.builder("Other.Free").text("Free");

    public static final TextLocale EFFECT_MODEL_NONE    = LangEntry.builder("EffectModel.None").text("None");
    public static final TextLocale EFFECT_MODEL_HELIX   = LangEntry.builder("EffectModel.Helix").text("Helix");
    public static final TextLocale EFFECT_MODEL_SPIRAL  = LangEntry.builder("EffectModel.Spiral").text("Spiral");
    public static final TextLocale EFFECT_MODEL_SPHERE  = LangEntry.builder("EffectModel.Sphere").text("Sphere");
    public static final TextLocale EFFECT_MODEL_HEART   = LangEntry.builder("EffectModel.Heart").text("Heart");
    public static final TextLocale EFFECT_MODEL_PULSAR  = LangEntry.builder("EffectModel.Pulsar").text("Pulsar");
    public static final TextLocale EFFECT_MODEL_BEACON  = LangEntry.builder("EffectModel.Beacon").text("Beacon");
    public static final TextLocale EFFECT_MODEL_TORNADO = LangEntry.builder("EffectModel.Tornado").text("Tornado");
    public static final TextLocale EFFECT_MODEL_VORTEX  = LangEntry.builder("EffectModel.Vortex").text("Vortex");
    public static final TextLocale EFFECT_MODEL_SIMPLE  = LangEntry.builder("EffectModel.Simple").text("Simple");

    public static final BooleanLocale INSPECTIONS_GENERIC_OVERVIEW = LangEntry.builder("Inspections.Generic.Overview").bool("No problems detected.", "Problems detected!");
    public static final BooleanLocale INSPECTIONS_GENERIC_ITEM     = LangEntry.builder("Inspections.Generic.Item").bool("Item is valid.", "Item is invalid!");
    public static final BooleanLocale INSPECTIONS_GENERIC_COMMANDS = LangEntry.builder("Inspections.Generic.Commands").bool("All commands are valid.", "Detected invalid commands!");

    public static final BooleanLocale INSPECTIONS_CRATE_PREVIEW      = LangEntry.builder("Inspections.Crate.Preview").bool("Preview is valid.", "Preview is invalid!");
    public static final BooleanLocale INSPECTIONS_CRATE_OPENING      = LangEntry.builder("Inspections.Crate.Opening").bool("Opening is valid.", "Opening is invalid!");
    public static final BooleanLocale INSPECTIONS_CRATE_HOLOGRAM     = LangEntry.builder("Inspections.Crate.Hologram").bool("Hologram template is valid.", "Hologram template is invalid!");
    public static final BooleanLocale INSPECTIONS_REWARD_PREVIEW     = LangEntry.builder("Inspections.Reward.Preview").bool("Preview item is valid.", "Preview item is invalid!");
    public static final BooleanLocale INSPECTIONS_REWARD_ITEMS       = LangEntry.builder("Inspections.Reward.Items").bool("All items are valid.", "Detected invalid items!");
    public static final TextLocale    INSPECTIONS_REWARD_NO_ITEMS    = LangEntry.builder("Inspections.Reward.NoItems").text("No items added.");
    public static final TextLocale    INSPECTIONS_REWARD_NO_COMMANDS = LangEntry.builder("Inspections.Reward.NoCommands").text("No commands defined.");

    public static final IconLocale UI_COSTS_OPTION_AVAILABLE = LangEntry.iconBuilder("UI.Costs.Option.Available")
        .rawName(WHITE.wrap(COST_NAME))
        .rawLore(
            GENERIC_COSTS,
            EMPTY_IF_ABOVE,
            YELLOW.and(BOLD).wrap("OPENINGS AVAILABLE: ") + WHITE.and(UNDERLINED).wrap(GENERIC_AVAILABLE),
            "",
            GREEN.wrap("→ " + UNDERLINED.wrap("Click to select"))
        )
        .build();

    public static final IconLocale UI_COSTS_OPTION_UNAVAILABLE = LangEntry.iconBuilder("UI.Costs.Option.Unavailable")
        .rawName(WHITE.wrap(COST_NAME))
        .rawLore(
            GENERIC_COSTS,
            EMPTY_IF_ABOVE,
            RED.and(BOLD).wrap("YOU CAN'T AFFORD THIS")
        )
        .build();

    public static final TextLocale UI_COSTS_ENTRY_AVAILABLE   = LangEntry.builder("UI.Costs.Entry0.Available").text(WHITE.wrap(GENERIC_ENTRY) + " " + GRAY.wrap("(" + GREEN.wrap("✔") + ")"));
    public static final TextLocale UI_COSTS_ENTRY_UNAVAILABLE = LangEntry.builder("UI.Costs.Entry0.Unavailable").text(WHITE.wrap(GENERIC_ENTRY) + " " + GRAY.wrap("(" + RED.wrap("✘") + ")"));

    public static final IconLocale UI_OPEN_AMOUNT_SINGLE = LangEntry.iconBuilder("UI.OpenAmount.Single")
        .rawName(YELLOW.and(BOLD).wrap("Open One"))
        .rawLore(
            GRAY.wrap("Open a single crate."),
            "",
            YELLOW.wrap("→ " + UNDERLINED.wrap("Click to select"))
        )
        .build();

    public static final IconLocale UI_OPEN_AMOUNT_ALL = LangEntry.iconBuilder("UI.OpenAmount.All")
        .rawName(YELLOW.and(BOLD).wrap("Open All"))
        .rawLore(
            GRAY.wrap("Open up to " + WHITE.wrap(GENERIC_MAX) + " crates."),
            "",
            YELLOW.wrap("→ " + UNDERLINED.wrap("Click to select"))
        )
        .build();

    public static final TextLocale EDITOR_TITLE_MAIN             = LangEntry.builder("Editor.Title.Main").text(BLACK.wrap("ExcellentCrates Editor"));
    public static final TextLocale EDITOR_TITLE_CRATE_LIST       = LangEntry.builder("Editor.Title.Crates").text(BLACK.wrap("Crates Editor"));
    public static final TextLocale EDITOR_TITLE_CRATE_SETTINGS   = LangEntry.builder("Editor.Title.Crate.Settings").text(BLACK.wrap("Crate Settings"));
    public static final TextLocale EDITOR_TITLE_CRATE_COSTS      = LangEntry.builder("Editor.Title.Crate.CostOptions").text(BLACK.wrap("Cost Options"));
    public static final TextLocale EDITOR_TITLE_CRATE_COST       = LangEntry.builder("Editor.Title.Crate.CostOption").text(BLACK.wrap("Cost Option Settings"));
    public static final TextLocale EDITOR_TITLE_CRATE_MILESTONES = LangEntry.builder("Editor.Title.Crate.Milestones").text(BLACK.wrap("Crate Milestones"));
    public static final TextLocale EDITOR_TITLE_REWARD_LIST      = LangEntry.builder("Editor.Title.Reward.List").text(BLACK.wrap("Crate Rewards"));
    public static final TextLocale EDITOR_TITLE_REWARD_CONTENT   = LangEntry.builder("Editor.Title.Reward.Content").text(BLACK.wrap("Reward Items"));
    public static final TextLocale EDITOR_TITLE_REWARD_SETTINGS  = LangEntry.builder("Editor.Title.Reward.Settings").text(BLACK.wrap("Reward Settings"));
    public static final TextLocale EDITOR_TITLE_KEY_LIST         = LangEntry.builder("Editor.Title.Keys").text(BLACK.wrap("Keys Editor"));
    public static final TextLocale EDITOR_TITLE_KEY_SETTINGS     = LangEntry.builder("Editor.Title.Key.Settings").text(BLACK.wrap("Key Settings"));

    @Deprecated
    public static final TextLocale EDITOR_ENTER_AMOUNT            = LangEntry.builder("Editor.Enter.Amount").text(GRAY.wrap("Enter " + GREEN.wrap("[Amount]")));
    @Deprecated
    public static final TextLocale EDITOR_ENTER_REWARD_ID         = LangEntry.builder("Editor.Reward.Enter.Id").text(GRAY.wrap("Enter " + GREEN.wrap("[Reward Identifier]")));


    public static final DialogElementLocale DIALOG_GENERIC_CREATION_BODY = LangEntry.builder("Dialog.Generic.Creation.Body").dialogElement(400,
        "Enter a " + SOFT_YELLOW.wrap("unique identifier") + " (ID) for the new object.",
        "",
        SOFT_ORANGE.wrap("⚠") + " You will need to reference this ID in " + SOFT_ORANGE.wrap("commands") + " and " + SOFT_ORANGE.wrap("config files") + ", so it's best to choose one that's " + SOFT_ORANGE.wrap("clear") + " and " + SOFT_ORANGE.wrap("easy") + " for you to remember.",
        "",
        SOFT_RED.wrap("→") + " Only " + SOFT_RED.wrap("letters") + ", " + SOFT_RED.wrap("digits") + " and an " + SOFT_RED.wrap("underscore") + " are allowed."
    );


    public static final DialogElementLocale DIALOG_GENERIC_NAME_BODY = LangEntry.builder("Dialog.Generic.Name.Body").dialogElement(400,
        "Enter the " + SOFT_YELLOW.wrap("display name") + "."
    );

    public static final TextLocale DIALOG_GENERIC_NAME_INPUT_NAME         = LangEntry.builder("Dialog.Generic.Name.Input.Name").text("Name");
    public static final TextLocale DIALOG_GENERIC_NAME_INPUT_REPLACE_NAME = LangEntry.builder("Dialog.Generic.Name.Input.ReplaceName").text("Replace Item Name");


    public static final DialogElementLocale DIALOG_GENERIC_DESCRIPTION_BODY = LangEntry.builder("Dialog.Generic.Description.Body").dialogElement(400,
        "Enter the " + SOFT_YELLOW.wrap("description") + "."
    );

    public static final TextLocale DIALOG_GENERIC_DESCRIPTION_INPUT_DESC         = LangEntry.builder("Dialog.Generic.Description.Input.Description").text("Description");
    public static final TextLocale DIALOG_GENERIC_DESCRIPTION_INPUT_REPLACE_LORE = LangEntry.builder("Dialog.Generic.Description.Input.ReplaceItemLore").text("Replace Item Lore");


    public static final DialogElementLocale DIALOG_GENERIC_ITEM_BODY_NORMAL = LangEntry.builder("Dialog.Generic.Item.Body.Normal").dialogElement(400,
        "Please confirm item replacement.",
        GRAY.wrap("Check the additional fields if needed.")
    );

    public static final DialogElementLocale DIALOG_GENERIC_ITEM_BODY_CUSTOM = LangEntry.builder("Dialog.Generic.Item.Body.Custom").dialogElement(400,
        "Please confirm item replacement.",
        GRAY.wrap("Check the additional fields if needed."),
        "",
        SOFT_RED.and(BOLD).wrap("IMPORTANT NOTE:"),
        "If the item above doesn't match the one you used, enable the " + SOFT_RED.wrap("Save as NBT") + " option.",
        GRAY.wrap("This ensures the exact item data is saved correctly.")
    );

    public static final TextLocale DIALOG_GENERIC_ITEM_INPUT_NBT      = LangEntry.builder("Dialog.Generic.Item.Input.NBT").text(SOFT_RED.wrap("Save as NBT"));
    public static final TextLocale DIALOG_GENERIC_ITEM_INPUT_REP_NAME = LangEntry.builder("Dialog.Generic.Item.Input.ReplaceName").text("Inherit Item's Name");
    public static final TextLocale DIALOG_GENERIC_ITEM_INPUT_REP_DESC = LangEntry.builder("Dialog.Generic.Item.Input.ReplaceDesc").text("Inherit Item's Lore");


    public static final EnumLocale<RewardType>   REWARD_TYPE   = LangEntry.builder("Enums.RewardType").enumeration(RewardType.class);
    public static final EnumLocale<CooldownMode> COOLDOWN_MODE = LangEntry.builder("Enums.CooldownMode").enumeration(CooldownMode.class);
    public static final RegistryLocale<Particle> PARTICLE      = LangEntry.builder("Assets.Particle").registry(RegistryType.PARTICLE_TYPE);

    @NotNull
    public static String inspection(@NotNull BooleanLocale locale, boolean state) {
        return CoreLang.formatEntry(locale.get(state), state);
    }
>>>>>>> upstream/master
}

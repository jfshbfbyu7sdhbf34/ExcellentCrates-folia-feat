package su.nightexpress.excellentcrates.command;


<<<<<<< HEAD
import org.jetbrains.annotations.NotNull;
import su.nightexpress.nightcore.command.experimental.builder.SimpleFlagBuilder;
import su.nightexpress.nightcore.command.experimental.flag.FlagTypes;

=======
>>>>>>> upstream/master
public class CommandFlags {

    public static final String SILENT          = "s";
    public static final String SILENT_FEEDBACK = "sf";
    public static final String FORCE           = "f";
<<<<<<< HEAD

    @NotNull
    public static SimpleFlagBuilder silent() {
        return FlagTypes.simple(SILENT);
    }

    @NotNull
    public static SimpleFlagBuilder silentFeedback() {
        return FlagTypes.simple(SILENT_FEEDBACK);
    }

    @NotNull
    public static SimpleFlagBuilder force() {
        return FlagTypes.simple(FORCE);
    }
=======
    public static final String MASS            = "mass";
>>>>>>> upstream/master
}

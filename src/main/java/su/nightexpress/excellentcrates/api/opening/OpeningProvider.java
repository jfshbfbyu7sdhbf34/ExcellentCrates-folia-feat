package su.nightexpress.excellentcrates.api.opening;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.crate.impl.CrateSource;
import su.nightexpress.excellentcrates.key.CrateKey;

public interface OpeningProvider {

    @NotNull Opening createOpening(@NotNull Player player, @NotNull CrateSource source, @Nullable CrateKey key);
=======
import su.nightexpress.excellentcrates.crate.cost.Cost;
import su.nightexpress.excellentcrates.crate.impl.CrateSource;
import su.nightexpress.nightcore.config.FileConfig;

public interface OpeningProvider {

    void load(@NotNull FileConfig config);

    @NotNull String getId();

    @NotNull Opening createOpening(@NotNull Player player, @NotNull CrateSource source, @Nullable Cost cost);
>>>>>>> upstream/master
}

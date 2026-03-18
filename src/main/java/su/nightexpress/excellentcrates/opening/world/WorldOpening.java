package su.nightexpress.excellentcrates.opening.world;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.excellentcrates.CratesPlugin;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.crate.impl.CrateSource;
import su.nightexpress.excellentcrates.key.CrateKey;
import su.nightexpress.excellentcrates.opening.AbstractOpening;

public abstract class WorldOpening extends AbstractOpening {

    public WorldOpening(@NotNull CratesPlugin plugin,
                        @NotNull Player player,
                        @NotNull CrateSource source,
                        @Nullable CrateKey key) {
        super(plugin, player, source, key);
    }

    protected void hideHologram() {
        this.plugin.manageHolograms(hologramHandler -> {
            hologramHandler.hide(this.crate);
        });
    }

    protected void showHologram() {
        this.plugin.manageHolograms(hologramHandler -> {
            hologramHandler.show(this.crate); // TODO Hides hologram for ALL blocks, need to hide only for the current one
        });
    }

    @Override
    public long getInterval() {
        return 1L;
=======
import su.nightexpress.excellentcrates.crate.cost.Cost;
import su.nightexpress.excellentcrates.crate.impl.CrateSource;
import su.nightexpress.excellentcrates.opening.AbstractOpening;
import su.nightexpress.excellentcrates.util.pos.WorldPos;

public abstract class WorldOpening extends AbstractOpening {

    public WorldOpening(@NotNull CratesPlugin plugin, @NotNull Player player, @NotNull CrateSource source, @Nullable Cost cost) {
        super(plugin, player, source, cost);
    }

    protected void hideHologram(@NotNull WorldPos blockPos) {
        this.plugin.getHologramManager().ifPresent(hologramManager -> hologramManager.disableBlockHologram(this.crate, blockPos));
    }

    protected void showHologram(@NotNull WorldPos blockPos) {
        this.plugin.getHologramManager().ifPresent(hologramManager -> hologramManager.enableBlockHologram(this.crate, blockPos));
>>>>>>> upstream/master
    }
}

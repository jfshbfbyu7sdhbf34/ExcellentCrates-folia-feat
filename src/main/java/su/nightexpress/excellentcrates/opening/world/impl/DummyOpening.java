package su.nightexpress.excellentcrates.opening.world.impl;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.excellentcrates.CratesPlugin;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.api.crate.Reward;
import su.nightexpress.excellentcrates.crate.impl.CrateSource;
import su.nightexpress.excellentcrates.key.CrateKey;
import su.nightexpress.excellentcrates.opening.AbstractOpening;
import su.nightexpress.excellentcrates.util.CrateUtils;
=======
import su.nightexpress.excellentcrates.crate.cost.Cost;
import su.nightexpress.excellentcrates.crate.impl.CrateSource;
import su.nightexpress.excellentcrates.opening.AbstractOpening;
>>>>>>> upstream/master

public class DummyOpening extends AbstractOpening {

    private boolean rolled;

<<<<<<< HEAD
    public DummyOpening(@NotNull CratesPlugin plugin, @NotNull Player player, @NotNull CrateSource source, @Nullable CrateKey key) {
        super(plugin, player, source, key);
=======
    public DummyOpening(@NotNull CratesPlugin plugin, @NotNull Player player, @NotNull CrateSource source, @Nullable Cost cost) {
        super(plugin, player, source, cost);
>>>>>>> upstream/master
    }

    @Override
    public void instaRoll() {
        this.roll();
        this.stop();
    }

    @Override
    public boolean isCompleted() {
        return this.rolled;
    }

    @Override
    public long getInterval() {
        return 1L;
    }

    @Override
    protected void onStart() {

    }

    @Override
    protected void onTick() {
        this.roll();
    }

    @Override
    protected void onComplete() {

    }

    private void roll() {
        this.setRefundable(false);

<<<<<<< HEAD
        Reward reward = this.getCrate().rollReward(this.player);
        reward.give(this.player);

        CrateUtils.callRewardObtainEvent(this.player, reward);
=======
        this.addReward(this.crate.rollReward(this.player));
>>>>>>> upstream/master

        this.rolled = true;
    }
}

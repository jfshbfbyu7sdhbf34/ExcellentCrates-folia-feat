package su.nightexpress.excellentcrates.opening;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.excellentcrates.CratesPlugin;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.api.opening.Opening;
=======
import su.nightexpress.excellentcrates.Placeholders;
import su.nightexpress.excellentcrates.api.crate.Reward;
import su.nightexpress.excellentcrates.api.opening.Opening;
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.excellentcrates.crate.cost.Cost;
>>>>>>> upstream/master
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.crate.impl.CrateSource;
import su.nightexpress.excellentcrates.data.crate.GlobalCrateData;
import su.nightexpress.excellentcrates.data.crate.UserCrateData;
import su.nightexpress.excellentcrates.user.CrateUser;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.key.CrateKey;
import su.nightexpress.nightcore.util.Players;
=======
import su.nightexpress.nightcore.util.Players;
import su.nightexpress.nightcore.util.placeholder.Replacer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
>>>>>>> upstream/master

public abstract class AbstractOpening implements Opening {

    protected final CratesPlugin plugin;
    protected final Player       player;
    protected final CrateSource  source;
    protected final Crate        crate;
<<<<<<< HEAD
    protected final CrateKey     key;
=======
    protected final Cost         cost;
    protected final List<Reward> rewards;
>>>>>>> upstream/master

    protected long    tickCount;
    protected boolean running;
    protected boolean refundable;

<<<<<<< HEAD
    public AbstractOpening(@NotNull CratesPlugin plugin, @NotNull Player player, @NotNull CrateSource source, @Nullable CrateKey key) {
=======
    public AbstractOpening(@NotNull CratesPlugin plugin, @NotNull Player player, @NotNull CrateSource source, @Nullable Cost cost) {
>>>>>>> upstream/master
        this.plugin = plugin;
        this.player = player;
        this.source = source;
        this.crate = source.getCrate();
<<<<<<< HEAD
        this.key = key;
=======
        this.cost = cost;
        this.rewards = new ArrayList<>();
>>>>>>> upstream/master
        this.setRefundable(true);
    }

    @Override
<<<<<<< HEAD
    public void run() {
        if (this.isRunning()) return;
=======
    public void start() {
        if (this.running) return;
>>>>>>> upstream/master

        this.running = true;
        this.onStart();
    }

    @Override
    public void stop() {
<<<<<<< HEAD
        if (!this.isRunning()) return;
=======
        if (!this.running) return;
>>>>>>> upstream/master

        this.running = false;
        this.onStop();
    }

    @Override
    public void tick() {
<<<<<<< HEAD
        if (!this.isRunning()) return;
=======
        if (!this.running) return;
>>>>>>> upstream/master

        if (this.isCompleted()) {
            this.stop();
            return;
        }

        if (this.isTickTime()) {
            this.onTick();
<<<<<<< HEAD
            //this.tickCount = 0L;
=======
>>>>>>> upstream/master
        }

        this.tickCount = Math.max(0L, this.tickCount + 1L);
    }

    @Override
<<<<<<< HEAD
    public boolean isRunning() {
=======
    public final boolean isRunning() {
>>>>>>> upstream/master
        return this.running;
    }

    @Override
    public long getTickCount() {
        return this.tickCount;
    }

    @Override
    public boolean isTickTime() {
        return this.tickCount == 0 || this.tickCount % this.getInterval() == 0L;
    }

    protected abstract void onStart();

    protected abstract void onTick();

    protected abstract void onComplete();

    protected void onStop() {
        if (this.isRefundable()) {
<<<<<<< HEAD
            if (this.key != null) {
                this.plugin.getKeyManager().giveKey(this.player, this.key, 1);
            }
            if (this.source.getItem() != null) {
                Players.addItem(this.player, this.crate.getItem());
            }

            this.crate.refundForOpen(this.player);
        }

=======
            if (this.cost != null) {
                this.cost.refundAll(this.player);
            }
            if (this.source.getItem() != null) {
                Players.addItem(this.player, this.crate.getItemStack());
            }
        }

        this.plugin.getOpeningManager().removeOpening(this.getPlayer());

>>>>>>> upstream/master
        if (this.isCompleted()) {
            this.onComplete();

            CrateUser user = plugin.getUserManager().getOrFetch(player);
            UserCrateData userData = user.getCrateData(this.crate);
            GlobalCrateData globalData = plugin.getDataManager().getCrateDataOrCreate(this.crate);

            userData.addOpenings(1);
            globalData.setLatestOpener(this.player);
<<<<<<< HEAD
            globalData.setSaveRequired(true);

            if (crate.hasOpenCooldown() && !crate.hasCooldownBypassPermission(player)) {
                userData.setCooldown(crate.getOpenCooldown());
=======
            globalData.setDirty(true);

            this.rewards.forEach(reward -> reward.give(this.player));

            if (crate.isOpeningCooldownEnabled()) {
                userData.addOpeningStreak(1);

                if (!userData.isOnCooldown() && !crate.hasCooldownBypassPermission(player)) {
                    userData.setCooldown(crate.getOpeningCooldownTime());
                }
>>>>>>> upstream/master
            }

            if (crate.hasMilestones()) {
                userData.addMilestones(1);
                plugin.getCrateManager().triggerMilestones(player, crate, userData.getMilestone());
                if (userData.getMilestone() >= crate.getMaxMilestone() && crate.isMilestonesRepeatable()) {
                    userData.setMilestone(0);
                }
            }

<<<<<<< HEAD
            this.plugin.getUserManager().save(user);
        }

        this.plugin.getOpeningManager().removeOpening(this.getPlayer());
=======
            Lang.CRATE_OPEN_RESULT_INFO.message().send(this.player, replacer -> replacer
                .replace(this.crate.replacePlaceholders())
                .replace(Placeholders.GENERIC_REWARDS, this.rewards.stream()
                    .map(reward -> reward.replacePlaceholders().apply(Lang.CRATE_OPEN_RESULT_REWARD.text()))
                    .collect(Collectors.joining(", "))
                )
            );

            List<String> postOpenCommands = Replacer.create().replace(this.crate.replacePlaceholders()).apply(this.crate.getPostOpenCommands());
            Players.dispatchCommands(this.player, postOpenCommands);

            this.plugin.getUserManager().save(user);
        }
    }

    @Override
    @NotNull
    public List<Reward> getRewards() {
        return this.rewards;
    }

    @Override
    public void addReward(@NotNull Reward reward) {
        this.rewards.add(reward);
    }

    @Override
    public void addRewards(@NotNull Collection<Reward> rewards) {
        this.rewards.addAll(rewards);
>>>>>>> upstream/master
    }

    @Override
    public boolean isRefundable() {
<<<<<<< HEAD
        return refundable;
=======
        return this.refundable;
>>>>>>> upstream/master
    }

    @Override
    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    @Override
    @NotNull
    public Player getPlayer() {
        return this.player;
    }

    @Override
    @NotNull
    public CrateSource getSource() {
        return this.source;
    }

    @Override
    @NotNull
    public Crate getCrate() {
        return this.crate;
    }

    @Override
    @Nullable
<<<<<<< HEAD
    public CrateKey getKey() {
        return this.key;
=======
    public Cost getCost() {
        return this.cost;
>>>>>>> upstream/master
    }
}

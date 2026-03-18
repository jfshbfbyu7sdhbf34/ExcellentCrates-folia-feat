package su.nightexpress.excellentcrates.opening.world.provider;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.excellentcrates.CratesPlugin;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.crate.impl.CrateSource;
import su.nightexpress.excellentcrates.key.CrateKey;
import su.nightexpress.excellentcrates.opening.world.WorldOpeningProvider;
import su.nightexpress.excellentcrates.opening.world.impl.SimpleRollOpening;
import su.nightexpress.nightcore.config.FileConfig;

import java.io.File;

public class SimpleRollProvider extends WorldOpeningProvider {

    public static final String ID = "simple_roll";

    private int stepsAmount;
    private long stepsTick;
    private long completePause;

    public SimpleRollProvider(@NotNull CratesPlugin plugin, @NotNull File file) {
        super(plugin, file);
=======
import su.nightexpress.excellentcrates.crate.cost.Cost;
import su.nightexpress.excellentcrates.crate.impl.CrateSource;
import su.nightexpress.excellentcrates.opening.AbstractProvider;
import su.nightexpress.excellentcrates.opening.world.impl.SimpleRollOpening;
import su.nightexpress.nightcore.config.ConfigValue;
import su.nightexpress.nightcore.config.FileConfig;

public class SimpleRollProvider extends AbstractProvider {

    private int  spinsRequired = 15;
    private long spinInterval = 3;
    private long finishDelay  = 40;

    public SimpleRollProvider(@NotNull CratesPlugin plugin, @NotNull String id) {
        super(plugin, id);
    }

    @Override
    public void load(@NotNull FileConfig config) {
        this.spinsRequired = ConfigValue.create("Settings.Steps_Amount", this.spinsRequired).read(config);
        this.spinInterval = ConfigValue.create("Settings.Steps_Tick", this.spinInterval).read(config);
        this.finishDelay = ConfigValue.create("Settings.Complete_Pause", this.finishDelay).read(config);
>>>>>>> upstream/master
    }

    @Override
    @NotNull
<<<<<<< HEAD
    public SimpleRollOpening createOpening(@NotNull Player player, @NotNull CrateSource source, @Nullable CrateKey key) {
        return new SimpleRollOpening(this.plugin, player, source, key, this.getStepsAmount(), this.getStepsTick(), this.getCompletePause());
    }

    @Override
    protected boolean readAdditional(@NotNull FileConfig config) {
        this.setStepsAmount(config.getInt("Settings.Steps_Amount"));
        this.setStepsTick(config.getLong("Settings.Steps_Tick"));
        this.setCompletePause(config.getLong("Settings.Complete_Pause"));

        return true;
    }

    @Override
    protected void writeAdditional(@NotNull FileConfig config) {
        config.set("Settings.Steps_Amount", this.stepsAmount);
        config.set("Settings.Steps_Tick", this.stepsTick);
        config.set("Settings.Complete_Pause", this.completePause);
    }

    public int getStepsAmount() {
        return this.stepsAmount;
    }

    public void setStepsAmount(int stepsAmount) {
        this.stepsAmount = Math.max(1, stepsAmount);
    }

    public long getStepsTick() {
        return this.stepsTick;
    }

    public void setStepsTick(long stepsTick) {
        this.stepsTick = Math.max(1, stepsTick);
    }

    public long getCompletePause() {
        return this.completePause;
    }

    public void setCompletePause(long completePause) {
        this.completePause = Math.max(0, completePause);
=======
    public SimpleRollOpening createOpening(@NotNull Player player, @NotNull CrateSource source, @Nullable Cost cost) {
        return new SimpleRollOpening(this.plugin, player, source, cost, this.spinsRequired, this.spinInterval, this.finishDelay);
    }

    public int getSpinsRequired() {
        return this.spinsRequired;
    }

    public void setSpinsRequired(int spinsRequired) {
        this.spinsRequired = Math.max(1, spinsRequired);
    }

    public long getSpinInterval() {
        return this.spinInterval;
    }

    public void setSpinInterval(long spinInterval) {
        this.spinInterval = Math.max(1, spinInterval);
    }

    public long getFinishDelay() {
        return this.finishDelay;
    }

    public void setFinishDelay(long finishDelay) {
        this.finishDelay = Math.max(0, finishDelay);
>>>>>>> upstream/master
    }
}

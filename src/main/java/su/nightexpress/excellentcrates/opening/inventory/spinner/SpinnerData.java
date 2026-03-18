package su.nightexpress.excellentcrates.opening.inventory.spinner;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
<<<<<<< HEAD
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.nightcore.config.Writeable;
import su.nightexpress.nightcore.util.NumberUtil;

public class SpinnerData implements Writeable {

    private final String   spinnerId;
    private final SpinMode mode;
    private final String   slots;
    private final int      spins;
    private final int     tickInterval;
    private final int     ticksToSkip;
    private final int     slowdownStep;
    private final int     slowdownAmount;
    private final String   sound;

    public SpinnerData(@NotNull String spinnerId,
                       @NotNull SpinMode mode,
                       @NotNull String slots,
                       int spins,
                       int tickInterval,
                       int ticksToSkip,
                       int slowdownStep,
                       int slowdownAmount,
                       @Nullable String sound) {
        this.spinnerId = spinnerId.toLowerCase();
        this.mode = mode;
        this.slots = slots;
        this.spins = spins;
        this.tickInterval = tickInterval;
        this.ticksToSkip = ticksToSkip;
        this.slowdownStep = slowdownStep;
        this.slowdownAmount = slowdownAmount;
=======
import su.nightexpress.nightcore.bridge.wrap.NightSound;
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.nightcore.config.Writeable;
import su.nightexpress.nightcore.util.Lists;
import su.nightexpress.nightcore.util.NumberUtil;

import java.util.List;

public class SpinnerData implements Writeable {

    private final String         spinnerId;
    private final SpinMode       mode;
    private final int[]          slots;
    private final int            spinDelay;
    private final List<SpinStep> spinSteps;
    private final NightSound     sound;

    public SpinnerData(@NotNull String spinnerId,
                       @NotNull SpinMode mode,
                       int[] slots,
                       int spinDelay,
                       @NotNull List<SpinStep> spinSteps,
                       @Nullable NightSound sound) {
        this.spinnerId = spinnerId.toLowerCase();
        this.mode = mode;
        this.slots = slots;
        this.spinDelay = spinDelay;
        this.spinSteps = spinSteps;
>>>>>>> upstream/master
        this.sound = sound;
    }

    @Nullable
    public static SpinnerData read(@NotNull FileConfig config, @NotNull String path) {
        String spinnerId = config.getString(path + ".SpinnerId");
        if (spinnerId == null) return null;

        SpinMode mode = config.getEnum(path + ".Mode", SpinMode.class);
        if (mode == null) return null;

<<<<<<< HEAD
        String slots = config.getString(path + ".Slots");
        if (slots == null || slots.isBlank()) return null;

        String spinParams = config.getString(path + ".SpinTimes");
        if (spinParams == null) return null;

        String[] spinSplit = spinParams.split(":");

        int spinTimes = NumberUtil.getIntegerAbs(spinSplit[0]);
        int spinInterval = spinSplit.length >= 2 ? NumberUtil.getIntegerAbs(spinSplit[1]) : 0;
        int ticksToSkip = spinSplit.length >= 3 ? NumberUtil.getIntegerAbs(spinSplit[2]) : 0;
        int slowStep = spinSplit.length >= 4 ? NumberUtil.getIntegerAbs(spinSplit[3]) : 0;
        int slowAmount = spinSplit.length >= 5 ? NumberUtil.getIntegerAbs(spinSplit[4]) : 0;

        String sound = config.getString(path + ".Sound");

        return new SpinnerData(spinnerId, mode, slots, spinTimes, spinInterval, ticksToSkip, slowStep, slowAmount, sound);
=======
        int[] slots = config.getIntArray(path + ".Slots");
        if (slots == null || slots.length == 0) return null;

        if (config.contains(path + ".SpinTimes")) {
            String spinParams = config.getString(path + ".SpinTimes");
            if (spinParams == null) return null;

            String[] spinSplit = spinParams.split(":");

            int spinTimes = NumberUtil.getIntegerAbs(spinSplit[0]);
            int spinInterval = spinSplit.length >= 2 ? NumberUtil.getIntegerAbs(spinSplit[1]) : 0;
            int ticksToSkip = spinSplit.length >= 3 ? NumberUtil.getIntegerAbs(spinSplit[2]) : 0;
            int slowStep = spinSplit.length >= 4 ? NumberUtil.getIntegerAbs(spinSplit[3]) : 0;
            int slowAmount = spinSplit.length >= 5 ? NumberUtil.getIntegerAbs(spinSplit[4]) : 0;

            List<SpinStep> segments = SpinStep.convertFromFlat(spinTimes, spinInterval, slowStep, slowAmount);

            config.set(path + ".Spins", Lists.modify(segments, SpinStep::serialize));
            config.set(path + ".SpinDelay", ticksToSkip);
            config.remove(path + ".SpinTimes");
        }

        int spinDelay = config.getInt(path + ".SpinDelay");
        List<SpinStep> spinSteps = Lists.modify(config.getStringList(path + ".Spins"), SpinStep::deserialize);

        NightSound sound = config.readSound(path + ".Sound");

        return new SpinnerData(spinnerId, mode, slots, spinDelay, spinSteps, sound);
>>>>>>> upstream/master
    }

    @Override
    public void write(@NotNull FileConfig config, @NotNull String path) {
        config.set(path + ".SpinnerId", this.spinnerId);
        config.set(path + ".Mode", this.mode.name());
<<<<<<< HEAD
        config.set(path + ".Slots", this.slots);
        config.set(path + ".SpinTimes", this.spins + ":" + this.tickInterval + ":" + this.ticksToSkip + ":" + this.slowdownStep + ":" + this.slowdownAmount);
=======
        config.setIntArray(path + ".Slots", this.slots);
        config.set(path + ".SpinDelay", this.spinDelay);
        config.set(path + ".Spins", Lists.modify(this.spinSteps, SpinStep::serialize));
>>>>>>> upstream/master
        config.set(path + ".Sound", this.sound);
    }

    @NotNull
    public String getSpinnerId() {
        return this.spinnerId;
    }

    @NotNull
    public SpinMode getMode() {
        return this.mode;
    }

<<<<<<< HEAD
    @NotNull
    public String getSlots() {
        return this.slots;
    }

    public int getSpins() {
        return this.spins;
    }

    public int getTickInterval() {
        return this.tickInterval;
    }

    public int getTicksToSkip() {
        return this.ticksToSkip;
    }

    public int getSlowdownAmount() {
        return this.slowdownAmount;
    }

    public int getSlowdownStep() {
        return this.slowdownStep;
    }

    @Nullable
    public String getSound() {
=======
    public int[] getSlots() {
        return this.slots;
    }

    @NotNull
    public List<SpinStep> getSpinSteps() {
        return this.spinSteps;
    }

    public int getSpinDelay() {
        return this.spinDelay;
    }

    @Nullable
    public NightSound getSound() {
>>>>>>> upstream/master
        return this.sound;
    }
}

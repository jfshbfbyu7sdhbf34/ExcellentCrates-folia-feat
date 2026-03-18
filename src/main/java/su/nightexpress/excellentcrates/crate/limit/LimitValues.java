package su.nightexpress.excellentcrates.crate.limit;

import org.jetbrains.annotations.NotNull;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.Placeholders;
import su.nightexpress.nightcore.config.ConfigValue;
import su.nightexpress.nightcore.config.FileConfig;
=======
import su.nightexpress.nightcore.config.ConfigValue;
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.nightcore.config.Writeable;
>>>>>>> upstream/master
import su.nightexpress.nightcore.util.TimeUtil;

import java.time.LocalDateTime;
import java.time.LocalTime;
<<<<<<< HEAD
import java.util.function.UnaryOperator;

public class LimitValues {

    public static final int NEVER_RESET    = -1;
    public static final int MIDNIGHT_RESET = -2;

    private boolean enabled;
    private int     amount;
    private long    resetTime;
    private int     resetStep;

    public LimitValues(boolean enabled, int amount, long resetTime, int resetStep) {
        this.setEnabled(enabled);
        this.setAmount(amount);
        this.setResetTime(resetTime);
        this.setResetStep(resetStep);
=======

public class LimitValues implements Writeable {

    private static final int UNLIMITED = -1;

    private boolean      enabled;
    private CooldownMode cooldownType;

    private int  globalAmount;
    private int  playerAmount;
    private long globalCooldown;
    private long playerCooldown;

    public LimitValues(boolean enabled, @NotNull CooldownMode cooldownType, int globalAmount, int playerAmount, long globalCooldown, long playerCooldown) {
        this.setEnabled(enabled);
        this.setCooldownType(cooldownType);
        this.setGlobalAmount(globalAmount);
        this.setPlayerAmount(playerAmount);
        this.setGlobalCooldown(globalCooldown);
        this.setPlayerCooldown(playerCooldown);
>>>>>>> upstream/master
    }

    @NotNull
    public static LimitValues unlimited() {
<<<<<<< HEAD
        return new LimitValues(false, -1, 0, 1);
=======
        return new LimitValues(false, CooldownMode.DAILY, UNLIMITED, UNLIMITED, 0, 0);
>>>>>>> upstream/master
    }

    @NotNull
    public static LimitValues read(@NotNull FileConfig config, @NotNull String path) {
        boolean enabled = ConfigValue.create(path + ".Enabled", false).read(config);
<<<<<<< HEAD
        int amount = ConfigValue.create(path + ".Amount", -1).read(config);
        long cooldown = ConfigValue.create(path + ".Cooldown", 0L).read(config);
        int cooldownStep = ConfigValue.create(path + ".CooldownStep", 1).read(config);

        return new LimitValues(enabled, amount, cooldown, cooldownStep);
    }

    public void write(@NotNull FileConfig config, @NotNull String path) {
        config.set(path + ".Enabled", this.enabled);
        config.set(path + ".Amount", this.amount);
        config.set(path + ".Cooldown", this.resetTime);
        config.set(path + ".CooldownStep", this.resetStep);
    }

    @NotNull
    public UnaryOperator<String> replacePlaceholders() {
        return Placeholders.LIMIT_VALUES.replacer(this);
    }

    public boolean isMidnight() {
        return this.resetTime == MIDNIGHT_RESET;
    }

    public boolean isNeverReset() {
        return this.resetTime == NEVER_RESET || this.resetTime == 0;
    }

    public long generateResetTimestamp() {
        if (this.isNeverReset()) return -1L;

        LocalDateTime now = LocalDateTime.now();
        if (this.isMidnight()) {
            return TimeUtil.toEpochMillis(LocalDateTime.of(now.toLocalDate().plusDays(1), LocalTime.MIDNIGHT));
        }
        return TimeUtil.toEpochMillis(now) + this.resetTime * 1000L;
    }

    public boolean isResetStep(int amount) {
        return amount % this.resetStep == 0;
    }

//    public boolean hasResetTime() {
//        return this.resetTime != 0L;// this.resetTime > 0L || this.isMidnight() || this.isNeverReset();
//    }

    public boolean isUnlimitedAmount() {
        return this.amount < 0;
    }

    public boolean isOneTimed() {
        return this.amount == 1;
    }

    public void setMidnightCooldown() {
        this.setResetTime(MIDNIGHT_RESET);
=======
        CooldownMode cooldownType = ConfigValue.create(path + ".CooldownType", CooldownMode.class, CooldownMode.DAILY).read(config);

        int globalAmount = ConfigValue.create(path + ".GlobalAmount", UNLIMITED).read(config);
        int playerAmount = ConfigValue.create(path + ".PlayerAmount", UNLIMITED).read(config);

        long globalCooldown = ConfigValue.create(path + ".GlobalCooldown", 0L).read(config);
        long playerCooldown = ConfigValue.create(path + ".PlayerCooldown", 0L).read(config);

        return new LimitValues(enabled, cooldownType, globalAmount, playerAmount, globalCooldown, playerCooldown);
    }

    @Override
    public void write(@NotNull FileConfig config, @NotNull String path) {
        config.set(path + ".Enabled", this.enabled);
        config.set(path + ".CooldownType", this.cooldownType.name());

        config.set(path + ".GlobalAmount", this.globalAmount);
        config.set(path + ".PlayerAmount", this.playerAmount);

        config.set(path + ".GlobalCooldown", this.globalCooldown);
        config.set(path + ".PlayerCooldown", this.playerCooldown);
    }

    public long generateGlobalCooldown() {
        return this.createCooldownTimestamp(this.globalCooldown);
    }

    public long generatePlayerCooldown() {
        return this.createCooldownTimestamp(this.playerCooldown);
    }

    private long createCooldownTimestamp(long cooldown) {
        if (cooldown == 0L) return 0L;

        return switch (this.cooldownType) {
            case CUSTOM -> TimeUtil.createFutureTimestamp(cooldown);
            case DAILY -> TimeUtil.toEpochMillis(LocalDateTime.of(TimeUtil.getCurrentDate().plusDays(1), LocalTime.MIDNIGHT));
        };
    }

    public boolean isGlobalAmountLimited() {
        return this.globalAmount > UNLIMITED;
    }

    public boolean isPlayerAmountLimited() {
        return this.playerAmount > UNLIMITED;
    }

    public boolean hasGlobalCooldown() {
        return this.globalCooldown > 0L;
    }

    public boolean hasPlayerCooldown() {
        return this.playerCooldown > 0L;
    }

    public boolean isAmountLimited() {
        return this.isGlobalAmountLimited() || this.isPlayerAmountLimited();
>>>>>>> upstream/master
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

<<<<<<< HEAD
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getResetTime() {
        return resetTime;
    }

    public void setResetTime(long resetTime) {
        this.resetTime = resetTime;
    }

    public int getResetStep() {
        return resetStep;
    }

    public void setResetStep(int resetStep) {
        this.resetStep = Math.max(1, resetStep);
=======
    @NotNull
    public CooldownMode getCooldownType() {
        return this.cooldownType;
    }

    public void setCooldownType(@NotNull CooldownMode cooldownType) {
        this.cooldownType = cooldownType;
    }

    public int getGlobalAmount() {
        return globalAmount;
    }

    public void setGlobalAmount(int globalAmount) {
        this.globalAmount = globalAmount;
    }

    public int getPlayerAmount() {
        return this.playerAmount;
    }

    public void setPlayerAmount(int playerAmount) {
        this.playerAmount = playerAmount;
    }

    public long getGlobalCooldown() {
        return this.globalCooldown;
    }

    public void setGlobalCooldown(long globalCooldown) {
        this.globalCooldown = Math.max(0, globalCooldown);
    }

    public long getPlayerCooldown() {
        return this.playerCooldown;
    }

    public void setPlayerCooldown(long playerCooldown) {
        this.playerCooldown = Math.max(0, playerCooldown);
>>>>>>> upstream/master
    }
}

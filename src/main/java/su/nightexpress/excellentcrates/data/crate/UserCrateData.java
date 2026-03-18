package su.nightexpress.excellentcrates.data.crate;

import su.nightexpress.nightcore.util.TimeUtil;

public class UserCrateData {

<<<<<<< HEAD
    private long openCooldown;
    private int openings;
    private int milestone;

    public UserCrateData() {
        this(0, 0, 0);
    }

    public UserCrateData(long openCooldown, int openings, int milestone) {
        this.openCooldown = openCooldown;
=======
    private long cooldownTimestamp;
    private int openingStreak;

    private int  openings;
    private int milestone;

    public UserCrateData() {
        this(0L, 0, 0, 0);
    }

    public UserCrateData(long cooldownTimestamp, int openingStreak, int openings, int milestone) {
        this.cooldownTimestamp = cooldownTimestamp;
        this.setOpeningStreak(openingStreak);

>>>>>>> upstream/master
        this.openings = openings;
        this.milestone = milestone;
    }

<<<<<<< HEAD
    public void removeCooldown() {
        this.setOpenCooldown(0L);
    }

    public void setCooldown(long seconds) {
        this.setOpenCooldown(TimeUtil.createFutureTimestamp(seconds));
    }

    public boolean hasCooldown() {
        return this.openCooldown != 0 && !this.isCooldownExpired();
    }

    public boolean isCooldownPermanent() {
        return this.openCooldown < 0;
    }

    public boolean isCooldownExpired() {
        return this.openCooldown > 0 && System.currentTimeMillis() > this.openCooldown;
=======
    public void resetCooldownAndStreak() {
        this.setCooldownTimestamp(0L);
        this.setOpeningStreak(0);
    }

    private void queryStreak() {
        if (this.cooldownTimestamp > 0 && TimeUtil.isPassed(this.cooldownTimestamp)) {
            this.resetCooldownAndStreak();
        }
    }

    public int queryOpeningStreak() {
        this.queryStreak();

        return this.getOpeningStreak();
    }

    public long queryCooldownTimestamp() {
        this.queryStreak();

        return this.getCooldownTimestamp();
    }

    public void setCooldown(long seconds) {
        this.setCooldownTimestamp(TimeUtil.createFutureTimestamp(seconds));
    }

    public boolean isOnCooldown() {
        return this.queryCooldownTimestamp() != 0;
    }

    public boolean isCooldownPermanent() {
        return this.cooldownTimestamp < 0;
    }

    public void addOpeningStreak(int amount) {
        this.setOpeningStreak(this.openingStreak + Math.abs(amount));
>>>>>>> upstream/master
    }

    public void addOpenings(int amount) {
        this.setOpenings(this.openings + Math.abs(amount));
    }

    public void addMilestones(int amount) {
        this.setMilestone(this.milestone + Math.abs(amount));
    }


<<<<<<< HEAD
    public long getOpenCooldown() {
        return this.openCooldown;
    }

    public void setOpenCooldown(long openCooldown) {
        this.openCooldown = openCooldown;
=======
    public long getCooldownTimestamp() {
        return this.cooldownTimestamp;
    }

    public void setCooldownTimestamp(long cooldownTimestamp) {
        this.cooldownTimestamp = cooldownTimestamp;
    }

    public int getOpeningStreak() {
        return this.openingStreak;
    }

    public void setOpeningStreak(int openingStreak) {
        this.openingStreak = Math.max(0, openingStreak);
>>>>>>> upstream/master
    }

    public int getOpenings() {
        return openings;
    }

    public void setOpenings(int openings) {
        this.openings = Math.max(0, openings);
    }

    public int getMilestone() {
        return milestone;
    }

    public void setMilestone(int milestone) {
        this.milestone = Math.max(0, milestone);
    }
}

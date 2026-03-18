package su.nightexpress.excellentcrates.opening.world.impl;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.excellentcrates.CratesPlugin;
import su.nightexpress.excellentcrates.api.crate.Reward;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.crate.impl.CrateSource;
import su.nightexpress.excellentcrates.key.CrateKey;
import su.nightexpress.excellentcrates.opening.OpeningUtils;
import su.nightexpress.excellentcrates.opening.world.WorldOpening;
import su.nightexpress.excellentcrates.util.CrateUtils;
import su.nightexpress.nightcore.util.LocationUtil;
import su.nightexpress.nightcore.util.bukkit.NightSound;

public class SimpleRollOpening extends WorldOpening {

    //private static final int  STEPS_AMOUNT = 15;
    //private static final long STEPS_TICK   = 3L;
    //private static final long MAX_TICKS    = STEPS_AMOUNT * STEPS_TICK + 40L;

    private final int stepsAmount;
    private final long stepsTick;
    private final long maxTicks;

    private int    step;
    private Item   rewardDisplay;
    private Reward reward;
    private Location    displayLocation;
=======
import su.nightexpress.excellentcrates.crate.cost.Cost;
import su.nightexpress.excellentcrates.crate.impl.CrateSource;
import su.nightexpress.excellentcrates.opening.OpeningUtils;
import su.nightexpress.excellentcrates.opening.world.WorldOpening;
import su.nightexpress.excellentcrates.util.pos.WorldPos;
import su.nightexpress.nightcore.util.EntityUtil;
import su.nightexpress.nightcore.util.LocationUtil;
import su.nightexpress.nightcore.util.sound.VanillaSound;

public class SimpleRollOpening extends WorldOpening {

    private final int    spinsRequired;
    private final long   spinInterval;
    private final Reward reward;

    private long spinCount;
    private long finishDelay;

    private Item     rewardDisplay;
    private Location displayLocation;
>>>>>>> upstream/master

    public SimpleRollOpening(@NotNull CratesPlugin plugin,
                             @NotNull Player player,
                             @NotNull CrateSource source,
<<<<<<< HEAD
                             @Nullable CrateKey key,
                             int stepsAmount,
                             long stepsTick,
                             long completePause) {
        super(plugin, player, source, key);
        this.stepsAmount = stepsAmount;
        this.stepsTick = stepsTick;
        this.maxTicks = (this.stepsAmount * this.stepsTick) + completePause;
=======
                             @Nullable Cost cost,
                             int spinsRequired,
                             long spinInterval,
                             long finishDelay) {
        super(plugin, player, source, cost);
        this.spinsRequired = spinsRequired;
        this.spinInterval = spinInterval;
        this.finishDelay = finishDelay;

        this.reward = source.getCrate().rollReward(player);
>>>>>>> upstream/master
    }

    private void onFirstTick() {
        Block block = this.source.getBlock();

        Location center;
        if (block == null) {
            Location playerLoc = this.player.getEyeLocation().clone();
            Vector direction = playerLoc.getDirection();

            for (int i = 0; i < 3; i++) {
                playerLoc.add(direction);
            }

            center = LocationUtil.setCenter3D(playerLoc);
        }
        else {
            double offset = Math.max(0, this.crate.getHologramYOffset());
            double height = block.getBoundingBox().getHeight() + offset;

            center = LocationUtil.setCenter2D(block.getLocation()).add(0, height, 0);
<<<<<<< HEAD
        }

        this.displayLocation = center;

        this.hideHologram();
=======

            WorldPos blockPos = WorldPos.from(block);
            this.hideHologram(blockPos);
        }

        this.displayLocation = center;
    }

    @Override
    public long getInterval() {
        return 1L;
>>>>>>> upstream/master
    }

    @Override
    public void instaRoll() {
<<<<<<< HEAD
        this.step = this.stepsAmount - 1;
        this.roll();
        // Display roll visuals only when instal roll was called in the middle of the opening process to "finish" the visual part.
        if (this.tickCount > 0) {
            this.displayRoll();
        }
        this.tickCount = this.maxTicks;
=======
        this.setRefundable(false);
        this.spinCount = this.spinsRequired - 1;
        this.finishDelay = 0L;

        this.spin();

        // Display roll visuals only when instal roll was called in the middle of the opening process to "finish" the visual part.
        if (this.tickCount > 0) {
            this.displayReward();
        }

>>>>>>> upstream/master
        this.stop();
    }

    @Override
    protected void onStart() {

    }

    @Override
    protected void onTick() {
<<<<<<< HEAD
        if (this.tickCount == 0) {
            this.onFirstTick();
        }

        if (this.tickCount % this.stepsTick == 0 && this.step < this.stepsAmount) {
            this.roll();
            this.displayRoll();
=======
        if (this.isSpinsCompleted()) {
            if (this.finishDelay > 0) {
                this.finishDelay--;
            }
            return;
        }

        if (this.tickCount == 0) {
            this.onFirstTick();
            this.setRefundable(false);
        }

        if (this.tickCount % this.spinInterval == 0) {
            this.spin();
            this.displayReward();
>>>>>>> upstream/master
        }
    }

    @Override
    protected void onComplete() {
<<<<<<< HEAD
        this.reward.give(this.player);

        CrateUtils.callRewardObtainEvent(this.player, this.reward);
=======

>>>>>>> upstream/master
    }

    @Override
    protected void onStop() {
<<<<<<< HEAD
=======
        this.addReward(this.reward);

>>>>>>> upstream/master
        if (this.rewardDisplay != null) {
            this.rewardDisplay.remove();
            this.rewardDisplay = null;
        }

<<<<<<< HEAD
        this.showHologram();
=======
        Block block = this.source.getBlock();
        if (block != null) {
            WorldPos blockPos = WorldPos.from(block);
            this.showHologram(blockPos);
        }
>>>>>>> upstream/master

        super.onStop();
    }

    @Override
    public boolean isCompleted() {
<<<<<<< HEAD
        return this.tickCount >= this.maxTicks;
    }

    private void roll() {
        this.reward = this.crate.rollReward(this.player);
        this.step++;
        if (this.step == this.stepsAmount) {
            this.setRefundable(false);
        }
    }

    private void displayRoll() {
=======
        return this.isSpinsCompleted() && this.finishDelay <= 0;
    }

    private void spin() {
        this.spinCount++;
    }

    private boolean isSpinsCompleted() {
        return this.spinCount >= this.spinsRequired;
    }

    private void displayReward() {
        Reward reward = this.isSpinsCompleted() ? this.reward : this.crate.rollReward(this.player);

>>>>>>> upstream/master
        if (this.rewardDisplay == null) {
            this.rewardDisplay = player.getWorld().spawn(this.displayLocation, Item.class, item -> item.setVelocity(new Vector()));
            this.rewardDisplay.setPersistent(false);
            this.rewardDisplay.setCustomNameVisible(true);
            this.rewardDisplay.setGravity(false);
            this.rewardDisplay.setPickupDelay(Integer.MAX_VALUE);
            this.rewardDisplay.setUnlimitedLifetime(true);
            this.rewardDisplay.setInvulnerable(true);
            //this.rewardDisplay.setBillboard(Display.Billboard.CENTER);
            //this.rewardDisplay.setTransformation(new Transformation(new Vector3f(), new AxisAngle4f(), new Vector3f(0.35f, 0.35f, 0.35f), new AxisAngle4f()));
        }
        if (this.rewardDisplay != null) {
<<<<<<< HEAD
            ItemStack itemStack = this.reward.getPreviewItem();
            this.rewardDisplay.setItemStack(itemStack);
            //this.rewardDisplay.setCustomName(this.reward.getNameTranslated());
        }

        NightSound.of(Sound.UI_BUTTON_CLICK, 0.5f).play(this.displayLocation);
        NightSound.of(Sound.BLOCK_NOTE_BLOCK_BELL, 0.5f).play(this.displayLocation);

        if (this.step == this.stepsAmount) {
            NightSound.of(Sound.ENTITY_GENERIC_EXPLODE, 0.7f).play(this.displayLocation);
=======
            ItemStack itemStack = reward.getPreviewItem();
            this.rewardDisplay.setItemStack(itemStack);
            EntityUtil.setCustomName(this.rewardDisplay, reward.getName());
        }

        VanillaSound.of(Sound.UI_BUTTON_CLICK, 0.5f).play(this.displayLocation);
        VanillaSound.of(Sound.BLOCK_NOTE_BLOCK_BELL, 0.5f).play(this.displayLocation);

        if (this.isSpinsCompleted()) {
            VanillaSound.of(Sound.ENTITY_GENERIC_EXPLODE, 0.7f).play(this.displayLocation);
>>>>>>> upstream/master
            OpeningUtils.createFirework(this.displayLocation);
        }
    }
}

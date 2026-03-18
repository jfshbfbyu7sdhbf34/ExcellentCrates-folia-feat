package su.nightexpress.excellentcrates.opening.inventory.spinner;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.api.opening.Spinner;
import su.nightexpress.excellentcrates.opening.inventory.InventoryOpening;
<<<<<<< HEAD
import su.nightexpress.nightcore.util.bukkit.NightSound;
=======
import su.nightexpress.nightcore.bridge.wrap.NightSound;
>>>>>>> upstream/master
import su.nightexpress.nightcore.util.random.Rnd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class AbstractSpinner implements Spinner {

    protected final SpinnerData      data;
    protected final InventoryOpening opening;
<<<<<<< HEAD
    protected final int[]            slots;
    protected final NightSound       sound;
    protected final Inventory inventory;

    protected boolean silent;
    protected long    spinCount;
    protected long    tickInterval;

    protected long    ticksToSkip;
    protected long    tickCount;
    protected boolean running;
=======
    protected final Inventory        inventory;
    protected final int[]            slots;
    protected final int[]            winSlots;

    protected boolean silent;
    protected boolean running;
    protected long    tickInterval;
    protected long    tickCount;

    protected List<SpinStep> steps;
    protected SpinStep       currentStep;
    protected long           stepCount;

    protected int  requiredSpins;
    protected long spinCount;
    protected long spinDelay;
>>>>>>> upstream/master

    public AbstractSpinner(@NotNull SpinnerData data, @NotNull InventoryOpening opening) {
        this.data = data;
        this.opening = opening;
<<<<<<< HEAD
        this.slots = opening.parseSlots(data.getSlots());
        this.ticksToSkip = data.getTicksToSkip();
        this.sound = data.getSound() == null ? null : new NightSound(data.getSound(), null, 0.7F, 1F);
        this.inventory = opening.getInventory();
=======
        this.inventory = opening.getInventory();

        this.slots = data.getSlots();
        this.winSlots = opening.getConfig().getWinSlots();

        this.steps = new ArrayList<>(data.getSpinSteps());
        this.requiredSpins = this.steps.stream().mapToInt(SpinStep::getSpinsAmount).sum();

        this.spinCount = 0;
        this.spinDelay = data.getSpinDelay();
    }

    private void nextStep() {
        if (this.steps.isEmpty()) {
            this.currentStep = null;
            return;
        }

        this.currentStep = this.steps.removeFirst();
        this.tickInterval = this.currentStep.getTickInterval();
        this.stepCount = 0L;
        this.tickCount = 0L;
    }

    private boolean isStepDone() {
        return this.stepCount >= this.currentStep.getSpinsAmount();
>>>>>>> upstream/master
    }

    @Override
    public void start() {
<<<<<<< HEAD
        if (this.isRunning()) return;

        this.running = true;
        this.tickInterval = this.data.getTickInterval();
=======
        if (this.running) return;

        this.running = true;
        this.nextStep();
>>>>>>> upstream/master
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

<<<<<<< HEAD
        if (this.isTickTime()) {
            this.onTick();
            this.tickCount = 0L;
        }
        this.tickCount++;
=======
        if (this.isSpinTime()) {
            this.onSpin();
        }

        this.tickCount = Math.max(0L, this.tickCount + 1L);
>>>>>>> upstream/master
    }

    @Override
    public void tickAll() {
<<<<<<< HEAD
        if (!this.isRunning()) return;
=======
        if (!this.running) return;
>>>>>>> upstream/master

        long total = Math.max(0L, this.getTotalSpins());

        for (int count = 0; count < total; count++) {
            if (this.isCompleted()) break;

<<<<<<< HEAD
            this.onTick();
=======
            this.onSpin();
>>>>>>> upstream/master
        }
    }

    @Override
<<<<<<< HEAD
    public boolean isTickTime() {
        if (this.ticksToSkip > 0) {
            this.ticksToSkip--;
            return false;
        }

        return this.tickCount == 0 || this.tickCount % this.getTickInterval() == 0L;
=======
    public boolean isSpinTime() {
        if (this.spinDelay > 0) {
            this.spinDelay--;
            return false;
        }

        return this.tickCount == 0 || this.tickCount % this.tickInterval == 0L;
>>>>>>> upstream/master
    }

    protected abstract void onStop();

    protected void onSpin() {
<<<<<<< HEAD
=======
        if (!this.isSilent()) {
            NightSound sound = this.data.getSound();
            if (sound != null) sound.play(this.opening.getPlayer());
        }

>>>>>>> upstream/master
        switch (this.data.getMode()) {
            case SEQUENTAL -> this.spinSequental();
            case INDEPENDENT -> this.spinIndependent();
            case SYNCRHONIZED -> this.spinSynchronized();
            case RANDOM -> this.spinRandom();
        }
<<<<<<< HEAD
    }

    protected void onTick() {
        //System.out.println("SpSd/TiCt/SpCt: " + this.spinSpeedTicks + " / " + this.tickCount + " / " + this.spinCount);

        if (!this.isSilent() && this.sound != null) {
            this.sound.play(this.opening.getPlayer());
        }

        this.onSpin();
        this.spinCount++;

        // Slowdown Spinner
        if (this.data.getSlowdownStep() > 0 && this.spinCount > 0) {
            if (this.spinCount % this.data.getSlowdownStep() == 0) {
                this.tickInterval += this.data.getSlowdownAmount();
            }
=======

        this.stepCount++;
        this.spinCount++;

        if (this.isStepDone()) {
            this.nextStep();
>>>>>>> upstream/master
        }
    }

    @NotNull
<<<<<<< HEAD
    public abstract ItemStack createItem();
=======
    public abstract ItemStack createItem(int slot);
>>>>>>> upstream/master

    private boolean isOutOfBounds(int slot) {
        return slot < 0 || slot >= this.inventory.getSize();
    }

<<<<<<< HEAD
    private void spinSequental() {
        ItemStack item = this.createItem();
        //if (item.getType().isAir()) return;
=======
    protected void spinSequental() {
        ItemStack item = this.createItem(-1);
>>>>>>> upstream/master

        for (int index = this.slots.length - 1; index > -1; index--) {
            int slot = slots[index];
            if (this.isOutOfBounds(slot)) continue;

            if (index == 0) {
                this.inventory.setItem(slot, item);
            }
            else {
                int previousSlot = slots[index - 1];
                this.inventory.setItem(slot, this.inventory.getItem(previousSlot));
            }
        }
    }

<<<<<<< HEAD
    private void spinIndependent() {
        for (int slot : this.slots) {
            if (this.isOutOfBounds(slot)) continue;

            ItemStack item = this.createItem();
=======
    protected void spinIndependent() {
        for (int slot : this.slots) {
            if (this.isOutOfBounds(slot)) continue;

            ItemStack item = this.createItem(slot);
>>>>>>> upstream/master

            this.inventory.setItem(slot, item);
        }
    }

<<<<<<< HEAD
    private void spinSynchronized() {
        ItemStack item = this.createItem();
=======
    protected void spinSynchronized() {
        ItemStack item = this.createItem(-1);
>>>>>>> upstream/master

        for (int slot : this.slots) {
            if (this.isOutOfBounds(slot)) continue;

            this.inventory.setItem(slot, item);
        }
    }

<<<<<<< HEAD
    private void spinRandom() {
=======
    protected void spinRandom() {
>>>>>>> upstream/master
        List<Integer> slots = new ArrayList<>(IntStream.of(this.slots).boxed().toList());
        int roll = Rnd.get(slots.size() + 1);
        if (roll <= 0) return;

        while (roll > 0 && !slots.isEmpty()) {
            int slot = slots.remove(Rnd.get(slots.size()));

            if (!this.isOutOfBounds(slot)) {
<<<<<<< HEAD
                ItemStack item = this.createItem();
=======
                ItemStack item = this.createItem(slot);
>>>>>>> upstream/master
                this.inventory.setItem(slot, item);
            }

            roll--;
        }
    }

    @NotNull
    public InventoryOpening getOpening() {
        return this.opening;
    }

    @Override
    public boolean isCompleted() {
<<<<<<< HEAD
        return this.getTotalSpins() >= 0 && this.spinCount >= this.getTotalSpins();
=======
        return this.currentStep == null;
>>>>>>> upstream/master
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }

    @Override
    public long getTickCount() {
        return this.tickCount;
    }

    @Override
    public long getTickInterval() {
        return this.tickInterval;
    }

    @NotNull
    @Override
    public String getId() {
        return this.data.getSpinnerId();
    }

    @Override
    public boolean isSilent() {
        return this.silent;
    }

    @Override
    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    @Override
    public int getTotalSpins() {
<<<<<<< HEAD
        return this.data.getSpins();
    }

    @Override
    public long getCurrentSpins() {
        return this.spinCount;
    }

    @Override
    public void setCurrentSpins(long spins) {
        this.spinCount = Math.max(0, spins);
=======
        return this.requiredSpins;
    }

    @Override
    public long getStepCount() {
        return this.stepCount;
    }

    @Override
    public void setStepCount(long spins) {
        this.stepCount = Math.max(0, spins);
>>>>>>> upstream/master
    }

    @Override
    public boolean hasSpin() {
        return this.spinCount > 0L;
    }
}

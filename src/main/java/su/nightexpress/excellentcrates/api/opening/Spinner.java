package su.nightexpress.excellentcrates.api.opening;

import org.jetbrains.annotations.NotNull;

public interface Spinner {

    void start();

    void stop();

    void tick();

    void tickAll();

    boolean isRunning();

    boolean isCompleted();

    long getTickInterval();

    long getTickCount();

<<<<<<< HEAD
    boolean isTickTime();
=======
    boolean isSpinTime();
>>>>>>> upstream/master

    @NotNull String getId();

    boolean isSilent();

    void setSilent(boolean silent);

    int getTotalSpins();

<<<<<<< HEAD
    long getCurrentSpins();

    void setCurrentSpins(long spins);
=======
    long getStepCount();

    void setStepCount(long spins);
>>>>>>> upstream/master

    boolean hasSpin();
}

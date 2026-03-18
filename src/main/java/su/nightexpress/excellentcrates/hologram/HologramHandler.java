package su.nightexpress.excellentcrates.hologram;

<<<<<<< HEAD
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
=======
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.hologram.entity.FakeEntity;
>>>>>>> upstream/master

import java.util.Set;

public interface HologramHandler {

<<<<<<< HEAD
    void displayHolograms(@NotNull Player player, int entityID, boolean create, @NotNull EntityType type, @NotNull Location location, @NotNull String textLine);

    void destroyEntity(@NotNull Player player, @NotNull Set<Integer> idList);

    void destroyEntity(@NotNull Set<Integer> idList);
=======
    void sendHologramPackets(@NotNull Player player, @NotNull FakeEntity entity, boolean needSpawn, @NotNull String textLine);

    void sendDestroyEntityPacket(@NotNull Player player, @NotNull Set<Integer> idList);

    void sendDestroyEntityPacket(@NotNull Set<Integer> idList);
>>>>>>> upstream/master
}

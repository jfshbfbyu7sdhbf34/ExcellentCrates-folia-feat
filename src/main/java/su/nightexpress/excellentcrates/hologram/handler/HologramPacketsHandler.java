package su.nightexpress.excellentcrates.hologram.handler;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.manager.player.PlayerManager;
import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerDestroyEntities;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
<<<<<<< HEAD
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.hologram.HologramHandler;
import su.nightexpress.nightcore.util.Players;
import su.nightexpress.nightcore.util.text.NightMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
=======
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.hologram.entity.FakeEntity;
import su.nightexpress.nightcore.util.Players;
import su.nightexpress.nightcore.util.text.night.NightMessage;

import java.util.ArrayList;
import java.util.List;
>>>>>>> upstream/master
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

<<<<<<< HEAD
public class HologramPacketsHandler implements HologramHandler {
=======
public class HologramPacketsHandler extends AbstractHologramHandler {
>>>>>>> upstream/master

    private final PlayerManager playerManager;

    public HologramPacketsHandler() {
        this.playerManager = PacketEvents.getAPI().getPlayerManager();
    }

    private void sendPacket(@NotNull Player player, @NotNull PacketWrapper<?> packet) {
        this.playerManager.sendPacket(player, packet);
    }

    private void broadcastPacket(@NotNull PacketWrapper<?> packet) {
        Players.getOnline().forEach(player -> this.playerManager.sendPacket(player, packet));
    }

    @SuppressWarnings("deprecation")
    @Override
<<<<<<< HEAD
    public void displayHolograms(@NotNull Player player, int entityID, boolean create, @NotNull EntityType type, @NotNull Location location, @NotNull String textLine) {
        PacketWrapper<?> spawnPacket = this.createSpawnPacket(type, location, entityID);
        PacketWrapper<?> dataPacket = this.createMetadataPacket(entityID, dataList -> {
            // Armor Stands (legacy)
            if (type == EntityType.ARMOR_STAND) {
                dataList.add(new EntityData(0, EntityDataTypes.BYTE, (byte) 0x20)); // invisible
                dataList.add(new EntityData(2, EntityDataTypes.OPTIONAL_COMPONENT, Optional.of(NightMessage.asJson(textLine)))); // display name
                dataList.add(new EntityData(3, EntityDataTypes.BOOLEAN, true)); // custom name visible
                dataList.add(new EntityData(5, EntityDataTypes.BOOLEAN, true)); // no gravity
                dataList.add(new EntityData(15, EntityDataTypes.BYTE, (byte) (0x01 | 0x08 | 0x10))); // isSmall noBasePlate setMarker
            }
            // Displays (modern)
            else {
                dataList.add(new EntityData(15, EntityDataTypes.BYTE, (byte) 1)); // billboard
                dataList.add(new EntityData(23, EntityDataTypes.COMPONENT, NightMessage.asJson(textLine))); // text
                dataList.add(new EntityData(24, EntityDataTypes.INT, Integer.MAX_VALUE)); // line width
                dataList.add(new EntityData(27, EntityDataTypes.BYTE, (byte) 0x1)); // shadow
            }
        });

        if (create) this.sendPacket(player, spawnPacket);
=======
    public void sendHologramPackets(@NotNull Player player, @NotNull FakeEntity entity, boolean needSpawn, @NotNull String textLine) {
        PacketWrapper<?> dataPacket = this.createMetadataPacket(entity.getId(), dataList -> {
            dataList.add(new EntityData<>(15, EntityDataTypes.BYTE, this.billboard));
            dataList.add(new EntityData<>(23, EntityDataTypes.COMPONENT, NightMessage.asJson(textLine)));
            dataList.add(new EntityData<>(24, EntityDataTypes.INT, this.lineWidth));
            dataList.add(new EntityData<>(25, EntityDataTypes.INT, this.backgroundColor));
            dataList.add(new EntityData<>(26, EntityDataTypes.BYTE, this.textOpacity));
            dataList.add(new EntityData<>(27, EntityDataTypes.BYTE, this.textBitmask));
        });

        if (needSpawn) {
            this.sendPacket(player, this.createSpawnPacket(entity));
        }

>>>>>>> upstream/master
        this.sendPacket(player, dataPacket);
    }

    @Override
<<<<<<< HEAD
    public void destroyEntity(@NotNull Set<Integer> idList) {
=======
    public void sendDestroyEntityPacket(@NotNull Set<Integer> idList) {
>>>>>>> upstream/master
        this.broadcastPacket(this.createDestroyPacket(idList));
    }

    @Override
<<<<<<< HEAD
    public void destroyEntity(@NotNull Player player, @NotNull Set<Integer> idList) {
=======
    public void sendDestroyEntityPacket(@NotNull Player player, @NotNull Set<Integer> idList) {
>>>>>>> upstream/master
        this.sendPacket(player, this.createDestroyPacket(idList));
    }

    @NotNull
    private WrapperPlayServerDestroyEntities createDestroyPacket(@NotNull Set<Integer> list) {
        return new WrapperPlayServerDestroyEntities(list.stream().mapToInt(i -> i).toArray());
    }

    @NotNull
<<<<<<< HEAD
    private WrapperPlayServerSpawnEntity createSpawnPacket(@NotNull EntityType entityType, @NotNull Location location, int entityID) {
        com.github.retrooper.packetevents.protocol.entity.type.EntityType type = SpigotConversionUtil.fromBukkitEntityType(entityType);
        com.github.retrooper.packetevents.protocol.world.Location loc = SpigotConversionUtil.fromBukkitLocation(location);

        return new WrapperPlayServerSpawnEntity(entityID, UUID.randomUUID(), type, loc, 0F, 0, null);
    }

    @NotNull
    private WrapperPlayServerEntityMetadata createMetadataPacket(int entityID, @NotNull Consumer<List<EntityData>> consumer) {
        List<EntityData> dataList = new ArrayList<>();
=======
    private WrapperPlayServerSpawnEntity createSpawnPacket(@NotNull FakeEntity entity) {
        com.github.retrooper.packetevents.protocol.entity.type.EntityType type = SpigotConversionUtil.fromBukkitEntityType(EntityType.TEXT_DISPLAY);
        com.github.retrooper.packetevents.protocol.world.Location location = SpigotConversionUtil.fromBukkitLocation(entity.getLocation());

        return new WrapperPlayServerSpawnEntity(entity.getId(), UUID.randomUUID(), type, location, 0F, 0, null);
    }

    @NotNull
    private WrapperPlayServerEntityMetadata createMetadataPacket(int entityID, @NotNull Consumer<List<EntityData<?>>> consumer) {
        List<EntityData<?>> dataList = new ArrayList<>();
>>>>>>> upstream/master

        consumer.accept(dataList);

        return new WrapperPlayServerEntityMetadata(entityID, dataList);
    }
}

package su.nightexpress.excellentcrates.hologram;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
<<<<<<< HEAD
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.CratesPlugin;
import su.nightexpress.excellentcrates.config.Config;
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.hologram.entity.HologramData;
import su.nightexpress.excellentcrates.hologram.entity.HologramEntity;
import su.nightexpress.excellentcrates.hologram.listener.HologramListener;
import su.nightexpress.excellentcrates.util.CrateUtils;
import su.nightexpress.excellentcrates.util.pos.WorldPos;
import su.nightexpress.nightcore.manager.AbstractManager;
import su.nightexpress.nightcore.universalscheduler.foliaScheduler.FoliaScheduler;
import su.nightexpress.nightcore.util.EntityUtil;
import su.nightexpress.nightcore.util.Lists;
import su.nightexpress.nightcore.util.LocationUtil;
import su.nightexpress.nightcore.util.Players;
import su.nightexpress.nightcore.util.placeholder.Replacer;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HologramManager extends AbstractManager<CratesPlugin> {

    private final Map<String, HologramData> hologramDataMap;
    private final Set<String>               hidden;
    private final HologramHandler           handler;

    private boolean useDisplays;
    private double  lineGap;

    public HologramManager(@NotNull CratesPlugin plugin, @NotNull HologramHandler handler) {
        super(plugin);
        this.hologramDataMap = new HashMap<>();
        this.hidden = new HashSet<>();
        this.handler = handler;
=======
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.excellentcrates.CratesPlugin;
import su.nightexpress.excellentcrates.config.Config;
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.hologram.entity.FakeDisplay;
import su.nightexpress.excellentcrates.hologram.entity.FakeEntity;
import su.nightexpress.excellentcrates.hologram.entity.FakeEntityGroup;
import su.nightexpress.excellentcrates.hologram.handler.HologramPacketsHandler;
import su.nightexpress.excellentcrates.hologram.handler.HologramProtocolHandler;
import su.nightexpress.excellentcrates.hologram.listener.HologramListener;
import su.nightexpress.excellentcrates.hooks.HookId;
import su.nightexpress.excellentcrates.util.CrateUtils;
import su.nightexpress.excellentcrates.util.pos.WorldPos;
import su.nightexpress.nightcore.manager.AbstractManager;
import su.nightexpress.nightcore.util.LocationUtil;
import su.nightexpress.nightcore.util.Plugins;
import su.nightexpress.nightcore.util.placeholder.Replacer;

import java.util.*;

public class HologramManager extends AbstractManager<CratesPlugin> {

    private final Map<String, FakeDisplay> displayMap;

    private HologramHandler handler;

    public HologramManager(@NotNull CratesPlugin plugin) {
        super(plugin);
        this.displayMap = new HashMap<>();
>>>>>>> upstream/master
    }

    @Override
    protected void onLoad() {
<<<<<<< HEAD
        this.useDisplays = Config.CRATE_HOLOGRAM_USE_DISPLAYS.get();
        this.lineGap = Config.CRATE_HOLOGRAM_LINE_GAP.get();

        this.addListener(new HologramListener(this.plugin, this));

        this.addAsyncTask(this::tickHolograms, Config.CRATE_HOLOGRAM_UPDATE_INTERVAL.get());
=======
        if (this.detectHandler()) {
            this.addListener(new HologramListener(this.plugin, this));

            this.addAsyncTask(this::tickHolograms, Config.CRATE_HOLOGRAM_UPDATE_INTERVAL.get());
        }
>>>>>>> upstream/master
    }

    @Override
    protected void onShutdown() {
<<<<<<< HEAD
        this.hologramDataMap.values().forEach(hologramData -> {
            this.handler.destroyEntity(hologramData.getEntityIDs());
        });
        this.hologramDataMap.clear();
        this.hidden.clear();
    }

    public void tickHolograms() {
        this.plugin.getCrateManager().getCrates().forEach(crate -> {
            if (!crate.isHologramEnabled()) return;

            this.refresh(crate);
        });
    }

    public void handleQuit(@NotNull Player player) {
        this.hologramDataMap.values().forEach(hologramData -> hologramData.getEntities().forEach(holo -> holo.removePlayer(player)));
    }

    public void hide(@NotNull Crate crate) {
        if (this.hidden.add(crate.getId())) {
            this.remove(crate);
        }
    }

    public void show(@NotNull Crate crate) {
        if (this.hidden.remove(crate.getId())) {
            this.refresh(crate);
        }
    }

    public void refresh(@NotNull Crate crate) {
        this.createIfAbsent(crate);

        HologramData hologramData = this.hologramDataMap.get(crate.getId());
        if (hologramData == null || this.hidden.contains(crate.getId())) return;

        for (HologramEntity entity : hologramData.getEntities()) {
            WorldPos position = entity.position();
            Location positionLocation = position.toLocation();

            new FoliaScheduler(plugin).runTask(positionLocation, () -> {
                if (!position.isChunkLoaded()) return;

                World world = position.getWorld();
                Block block = position.toBlock();
                if (world == null || block == null) return;

                double yOffset = crate.getHologramYOffset();
                if (this.useDisplays) yOffset += 0.2;

                double height = block.getBoundingBox().getHeight() / 2D + yOffset;
                Location location = LocationUtil.setCenter3D(block.getLocation()).add(0, height + entity.gap(), 0);

                Players.getOnline().forEach(player -> {
                    if (!CrateUtils.isInEffectRange(player, location)) {
                        entity.removePlayer(player);
                        this.handler.destroyEntity(player, Lists.newSet(entity.entityID()));
                        return;
                    }

                    String text = Replacer.create().replace(crate.replacePlaceholders()).replacePlaceholderAPI(player).apply(entity.text());

                    boolean create = !entity.isCreated(player);
                    if (create) {
                        entity.addPlayer(player);
                    }

                    this.sendHologramPackets(player, entity.entityID(), create, location, text);
                });
=======
        this.displayMap.values().forEach(this::discard);
        this.displayMap.clear();

        this.handler = null;
    }

    private boolean detectHandler() {
        if (Plugins.isInstalled(HookId.PACKET_EVENTS)) {
            this.handler = new HologramPacketsHandler();
        }
        else if (Plugins.isInstalled(HookId.PROTOCOL_LIB)) {
            this.handler = new HologramProtocolHandler();
        }
        else {
            this.plugin.warn("*".repeat(25));
            this.plugin.warn("You have no packet library plugins installed for the Holograms feature to work.");
            this.plugin.warn("Please install one of the following plugins to enable crate holograms: " + HookId.PACKET_EVENTS + " or " + HookId.PROTOCOL_LIB);
            this.plugin.warn("*".repeat(25));
        }

        return this.hasHandler();
    }

    private void tickHolograms() {
        this.plugin.getCrateManager().getCrates().forEach(crate -> {
            if (!crate.isHologramEnabled()) return;

            this.render(crate);
        });
    }

    public boolean hasHandler() {
        return this.handler != null;
    }

    @Nullable
    private FakeDisplay getDisplay(@NotNull Crate crate) {
        return this.displayMap.get(crate.getId());
    }

    public void disableBlockHologram(@NotNull Crate crate, @NotNull WorldPos blockPos) {
        this.toggleBlockHologram(crate, blockPos, false);
    }

    public void enableBlockHologram(@NotNull Crate crate, @NotNull WorldPos blockPos) {
        this.toggleBlockHologram(crate, blockPos, true);
    }

    private void toggleBlockHologram(@NotNull Crate crate, @NotNull WorldPos blockPos, boolean enabled) {
        FakeDisplay display = this.getDisplay(crate);
        if (display == null) return;

        FakeEntityGroup group = display.getGroup(blockPos);
        if (group == null) return;

        group.setDisabled(!enabled);

        if (group.isDisabled()) {
            this.discard(group);
        }
        else {
            this.render(crate);
        }
    }



    public void removeForViewer(@NotNull Player player) {
        this.displayMap.values().forEach(display -> this.removeForViewer(player, display));
    }

    public void removeForViewer(@NotNull Player player, @NotNull FakeDisplay display) {
        display.getGroups().forEach(group -> this.removeForViewer(player, group));
    }

    public void removeForViewer(@NotNull Player player, @NotNull FakeEntityGroup group) {
        group.removeViewer(player);
        this.handler.sendDestroyEntityPacket(player, group.getEntityIDs());
    }



    public void discard(@NotNull Crate crate) {
        FakeDisplay display = this.displayMap.remove(crate.getId());
        if (display == null) return;

        this.discard(display);
    }

    public void discard(@NotNull FakeDisplay display) {
        display.getGroups().forEach(this::discard);
    }

    public void discard(@NotNull FakeEntityGroup group) {
        group.clearViewers();
        this.handler.sendDestroyEntityPacket(group.getEntityIDs());
    }



    public void render(@NotNull Crate crate) {
        this.createIfAbsent(crate);

        FakeDisplay display = this.getDisplay(crate);
        if (display == null) return;

        List<String> text = Replacer.create().replace(crate.replacePlaceholders()).apply(crate.getHologramText().reversed());
        if (text.isEmpty()) return;

        for (FakeEntityGroup group : display.getGroups()) {
            if (group.isDisabled()) continue;

            WorldPos blockPosition = group.getBlockPosition();
            World world = blockPosition.getWorld();
            Location location = blockPosition.toLocation();

            if (!blockPosition.isChunkLoaded() || world == null || location == null) {
                this.discard(group); // Remove all viewers and send entity destroy packet.
                continue;
            }

            List<Player> players = new ArrayList<>(world.getPlayers());
            players.removeIf(player -> {
                if (CrateUtils.isInEffectRange(player, location)) return false;

                this.removeForViewer(player, group);
                return true;
            });

            if (players.isEmpty()) {
                this.discard(group); // Remove all viewers and send entity destroy packet.
                continue;
            }

            players.forEach(player -> {
                boolean needSpawn = !group.isViewer(player);

                List<String> hologramText = Replacer.create().replacePlaceholderAPI(player).apply(text);
                List<FakeEntity> holograms = group.getEntities();
                for (int index = 0; index < holograms.size(); index++) {
                    // Fix for fake entity's text not being updated/replaced when text size is less than holograms amount, so force it to empty string.
                    String line = index >= hologramText.size() ? "" : hologramText.get(index);
                    FakeEntity entity = holograms.get(index);
                    this.handler.sendHologramPackets(player, entity, needSpawn, line);
                }

                group.addViewer(player);
>>>>>>> upstream/master
            });
        }
    }

    private void createIfAbsent(@NotNull Crate crate) {
<<<<<<< HEAD
        if (this.hologramDataMap.containsKey(crate.getId())) return;
=======
        if (!this.hasHandler()) return;
        if (this.displayMap.containsKey(crate.getId())) return;
>>>>>>> upstream/master

        List<String> originText = crate.getHologramText();
        if (originText.isEmpty()) return;

<<<<<<< HEAD
        HologramData hologramData = this.hologramDataMap.computeIfAbsent(crate.getId(), k -> new HologramData());

        Collections.reverse(originText);

        crate.getBlockPositions().forEach(pos -> {
            double currentGap = 0;

            for (String text : originText) {
                int entityID = EntityUtil.nextEntityId();

                hologramData.getEntities().add(new HologramEntity(entityID, pos, text, currentGap, new HashSet<>()));
                currentGap += this.lineGap;
            }
        });
    }

    public void create(@NotNull Crate crate) {
        this.createIfAbsent(crate);
    }

    public void remove(@NotNull Crate crate) {
        HologramData hologramData = this.hologramDataMap.remove(crate.getId());
        if (hologramData == null) return;

        this.handler.destroyEntity(hologramData.getEntityIDs());
    }

    private void sendHologramPackets(@NotNull Player player, int entityID, boolean create, @NotNull Location location, @NotNull String textLine) {
        EntityType type = this.useDisplays ? EntityType.TEXT_DISPLAY : EntityType.ARMOR_STAND;

        this.handler.displayHolograms(player, entityID, create, type, location, textLine);
=======
        FakeDisplay display = new FakeDisplay();

        double yOffset = crate.getHologramYOffset() + 0.2;
        double lineGap = Config.CRATE_HOLOGRAM_LINE_GAP.get();

        crate.getBlockPositions().forEach(blockPos -> {
            Block block = blockPos.toBlock();
            if (block == null) return;

            double height = block.getBoundingBox().getHeight() / 2D + yOffset;

            // Allocate ID values for our fake entities, so there is no clash with new server entities.

            FakeEntityGroup group = display.getGroupOrCreate(blockPos);

            for (int index = 0; index < originText.size(); index++) {
                double gap = lineGap * index;

                Location location = LocationUtil.setCenter3D(block.getLocation()).add(0, height + gap, 0);
                group.addEntity(FakeEntity.create(location));
            }
        });

        this.displayMap.put(crate.getId(), display);
>>>>>>> upstream/master
    }
}

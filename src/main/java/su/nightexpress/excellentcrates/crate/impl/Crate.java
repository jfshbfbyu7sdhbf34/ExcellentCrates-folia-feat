package su.nightexpress.excellentcrates.crate.impl;

import org.bukkit.Location;
<<<<<<< HEAD
=======
import org.bukkit.Material;
>>>>>>> upstream/master
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.excellentcrates.CratesPlugin;
import su.nightexpress.excellentcrates.Placeholders;
import su.nightexpress.excellentcrates.api.crate.Reward;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.api.item.ItemProvider;
=======
>>>>>>> upstream/master
import su.nightexpress.excellentcrates.config.Config;
import su.nightexpress.excellentcrates.config.Keys;
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.excellentcrates.config.Perms;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.crate.effect.CrateEffect;
import su.nightexpress.excellentcrates.crate.effect.EffectId;
import su.nightexpress.excellentcrates.crate.effect.EffectRegistry;
=======
import su.nightexpress.excellentcrates.crate.cost.Cost;
import su.nightexpress.excellentcrates.crate.cost.CostTypeId;
import su.nightexpress.excellentcrates.crate.cost.entry.impl.EcoCostEntry;
import su.nightexpress.excellentcrates.crate.cost.entry.impl.KeyCostEntry;
import su.nightexpress.excellentcrates.crate.cost.type.impl.EcoCostType;
import su.nightexpress.excellentcrates.crate.cost.type.impl.KeyCostType;
import su.nightexpress.excellentcrates.crate.effect.CrateEffect;
import su.nightexpress.excellentcrates.crate.effect.EffectId;
>>>>>>> upstream/master
import su.nightexpress.excellentcrates.crate.reward.RewardFactory;
import su.nightexpress.excellentcrates.data.crate.GlobalCrateData;
import su.nightexpress.excellentcrates.hologram.HologramManager;
import su.nightexpress.excellentcrates.hologram.HologramTemplate;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.item.ItemTypes;
import su.nightexpress.excellentcrates.key.CrateKey;
import su.nightexpress.excellentcrates.util.CrateUtils;
import su.nightexpress.excellentcrates.util.pos.WorldPos;
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.nightcore.manager.AbstractFileData;
import su.nightexpress.nightcore.universalscheduler.foliaScheduler.FoliaScheduler;
import su.nightexpress.nightcore.util.*;
import su.nightexpress.nightcore.util.random.Rnd;
import su.nightexpress.nightcore.util.text.NightMessage;
import su.nightexpress.nightcore.util.wrapper.UniParticle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
=======
import su.nightexpress.excellentcrates.registry.CratesRegistries;
import su.nightexpress.excellentcrates.util.CrateUtils;
import su.nightexpress.excellentcrates.util.ItemHelper;
import su.nightexpress.excellentcrates.util.pos.WorldPos;
import su.nightexpress.nightcore.bridge.currency.Currency;
import su.nightexpress.nightcore.bridge.item.AdaptedItem;
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.nightcore.integration.currency.EconomyBridge;
import su.nightexpress.nightcore.manager.ConfigBacked;
import su.nightexpress.nightcore.util.FileUtil;
import su.nightexpress.nightcore.util.ItemUtil;
import su.nightexpress.nightcore.util.PDCUtil;
import su.nightexpress.nightcore.util.problem.ProblemCollector;
import su.nightexpress.nightcore.util.problem.ProblemReporter;
import su.nightexpress.nightcore.util.profile.CachedProfile;
import su.nightexpress.nightcore.util.profile.PlayerProfiles;
import su.nightexpress.nightcore.util.random.Rnd;
import su.nightexpress.nightcore.util.wrapper.UniParticle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
>>>>>>> upstream/master
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

<<<<<<< HEAD
public class Crate extends AbstractFileData<CratesPlugin> {

    private final Set<String>                   keyIds;
    private final Set<WorldPos>                 blockPositions;
    private final Set<Milestone>                milestones;
    private final Map<String, Cost>             openCostMap;
=======
public class Crate implements ConfigBacked {

    private final CratesPlugin plugin;
    private final Path         filePath;
    private final String       id;

    private final Set<WorldPos>                 blockPositions;
    private final Set<Milestone>                milestones;
    private final Map<String, Cost>             costMap;
>>>>>>> upstream/master
    private final LinkedHashMap<String, Reward> rewardMap;

    private String      name;
    private List<String> description;
<<<<<<< HEAD
    private ItemProvider itemProvider;
    private boolean itemStackable;

    private boolean previewEnabled;
    private String  previewId;
    private boolean animationEnabled;
    private String  animationId;

    private boolean     permissionRequired;
    private int         openCooldown;
    private boolean     keyRequired;
    private boolean     milestonesRepeatable;
=======
    private AdaptedItem  item;
    private boolean      itemStackable;

    private boolean previewEnabled;
    private String  previewId;
    private boolean openingEnabled;
    private String  openingId;

    private boolean openingCooldownEnabled;
    private int openingCooldownTime;
    private int openingLimitAmount;

    private boolean permissionRequired;

    private boolean milestonesRepeatable;
>>>>>>> upstream/master
    private boolean     pushbackEnabled;

    private boolean hologramEnabled;
    private String  hologramTemplateId;
    private double  hologramYOffset;

<<<<<<< HEAD
    private String      effectType;
    private UniParticle effectParticle;

    public Crate(@NotNull CratesPlugin plugin, @NotNull File file) {
        super(plugin, file);
        this.keyIds = new HashSet<>();
        this.openCostMap = new HashMap<>();
=======
    private boolean effectEnabled;
    private String      effectType;
    private UniParticle effectParticle;

    private List<String> postOpenCommands;

    private boolean dirty;

    public Crate(@NotNull CratesPlugin plugin, @NotNull Path path, @NotNull String id) {
        this.plugin = plugin;
        this.filePath = path;
        this.id = id;

        this.costMap = new LinkedHashMap<>();
>>>>>>> upstream/master
        this.rewardMap = new LinkedHashMap<>();
        this.blockPositions = new HashSet<>();
        this.milestones = new HashSet<>();
        this.description = new ArrayList<>();
    }

<<<<<<< HEAD
    @Override
    protected boolean onLoad(@NotNull FileConfig config) {
        if (!config.contains("_dataver")) {
            config.set("_dataver", 600);

            File source = config.getFile();
            File target = new File(source.getParentFile().getAbsolutePath() + "/backups", source.getName() + ".backup535");
            FileUtil.create(target);

            try {
                Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }
        if (config.contains("Item")) {
            ItemStack itemStack = config.getCosmeticItem("Item").getItemStack();
            ItemProvider provider = ItemTypes.vanilla(itemStack);
=======
    public void load() throws IllegalStateException {
        if (!this.hasFile()) {
            // TODO Throw
            return;
        }

        this.loadConfig().edit(this::load);
    }

    private void load(@NotNull FileConfig config) throws IllegalStateException {
        if (!config.contains("_dataver")) {
            config.set("_dataver", 600);

            Path source = this.getPath();
            Path target = Path.of(source.getParent() + "/backups", source.getFileName() + ".backup535");
            FileUtil.createFileIfNotExists(target);

            try {
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            }
            catch (IOException exception) {
                this.plugin.error("Could not backup crate file: " + source);
                exception.printStackTrace();
            }
        }

        if (config.contains("Item")) {
            ItemStack itemStack = config.getCosmeticItem("Item").getItemStack();
            AdaptedItem provider = ItemHelper.vanilla(itemStack);
>>>>>>> upstream/master
            config.set("ItemProvider", provider);
            config.remove("Item");
        }
        if (!config.contains("Preview")) {
            String oldId = config.getString("Preview_Config");
            config.set("Preview.Enabled", oldId != null);
            config.set("Preview.Id", oldId == null ? Placeholders.DEFAULT : oldId);
            config.remove("Preview_Config");
        }
        if (!config.contains("Animation")) {
            String oldId = config.getString("Animation_Config");
            config.set("Animation.Enabled", oldId != null);
            config.set("Animation.Id", oldId == null ? Placeholders.DEFAULT : oldId);
            config.remove("Animation_Config");
        }
<<<<<<< HEAD

        this.setName(config.getString("Name", this.getId()));
        this.setDescription(config.getStringList("Description"));
        this.setItemProvider(ItemTypes.read(config, "ItemProvider"));
=======
        if (config.contains("Opening.Cooldown")) {
            int old = config.getInt("Opening.Cooldown");
            config.set("OpeningCooldown.Enabled", old != 0);
            config.set("OpeningCooldown.Value", this.openingCooldownTime);
            config.remove("Opening");
        }

        this.setName(config.getString("Name", this.getId()));
        this.setDescription(config.getStringList("Description"));

        this.setItem(ItemHelper.read(config, "ItemProvider").orElse(ItemHelper.vanilla(CrateUtils.getDefaultItem(this))));
>>>>>>> upstream/master
        this.setItemStackable(config.getBoolean("ItemStackable", true));

        this.setPreviewEnabled(config.getBoolean("Preview.Enabled"));
        this.setPreviewId(config.getString("Preview.Id", Placeholders.DEFAULT));
<<<<<<< HEAD
        this.setAnimationEnabled(config.getBoolean("Animation.Enabled"));
        this.setAnimationId(config.getString("Animation.Id", Placeholders.DEFAULT));

        this.setPermissionRequired(config.getBoolean("Permission_Required"));
        this.setOpenCooldown(config.getInt("Opening.Cooldown"));

        // Load costs only if EconomyBridge is installed.
        if (Plugins.hasEconomyBridge()) {
            for (String curId : config.getSection("Opening.Cost")) {
                double amount = config.getDouble("Opening.Cost." + curId);
                Cost cost = new Cost(curId, amount);
                this.addOpenCost(cost);
            }
        }

        this.setKeyRequired(config.getBoolean("Key.Required"));
        this.setKeyIds(config.getStringSet("Key.Ids"));

        this.blockPositions.addAll(config.getStringList("Block.Positions").stream().map(WorldPos::deserialize).toList());
        if (!Config.isCrateInAirBlocksAllowed()) {
            new FoliaScheduler(plugin).runTask(() -> {
                List<WorldPos> blockPositionsTemp = new ArrayList<>(blockPositions);
                for (WorldPos pos : blockPositionsTemp) {
                    new FoliaScheduler(plugin).runTask(pos.toLocation(), () -> {
                        Block block = pos.toBlock();

                        if (block == null || block.isEmpty())
                            this.blockPositions.remove(pos);
                    });
                }
=======
        this.setOpeningEnabled(config.getBoolean("Animation.Enabled"));
        this.setOpeningId(config.getString("Animation.Id", Placeholders.DEFAULT));

        this.setOpeningCooldownEnabled(config.getBoolean("OpeningCooldown.Enabled"));
        this.setOpeningCooldownTime(config.getInt("OpeningCooldown.Value"));
        this.setOpeningLimitAmount(config.getInt("OpeningLimits.Amount"));

        this.setPermissionRequired(config.getBoolean("Permission_Required"));

        if (config.contains("Opening.Cost") || config.contains("Key.Ids")) {
            boolean keyRequired = config.getBoolean("Key.Required");
            Set<String> oldKeys = config.getStringSet("Key.Ids");

            if (!oldKeys.isEmpty() && CratesRegistries.getCostType(CostTypeId.KEY) instanceof KeyCostType keyType) {
                oldKeys.forEach(keyId -> {
                    KeyCostEntry entry = keyType.createEmpty();
                    entry.setKeyId(keyId);
                    entry.setAmount(1);

                    Cost cost = new Cost("key_" + keyId, keyRequired, keyId + " Key", ItemHelper.vanilla(new ItemStack(Material.TRIAL_KEY)), Collections.singletonList(entry));
                    config.set("CostOptions." + cost.getId(), cost);
                });
            }

            if (CratesRegistries.getCostType(CostTypeId.CURRENCY) instanceof EcoCostType ecoType) {
                for (String curId : config.getSection("Opening.Cost")) {
                    Currency currency = EconomyBridge.getCurrency(curId);
                    if (currency == null) continue;

                    double amount = config.getDouble("Opening.Cost." + curId);

                    EcoCostEntry entry = ecoType.createEmpty();
                    entry.setCurrencyId(curId);
                    entry.setAmount(amount);

                    Cost cost = new Cost("eco_" + curId, keyRequired, curId + " Currency", ItemHelper.adapt(currency.getIcon()), Collections.singletonList(entry));
                    config.set("CostOptions." + cost.getId(), cost);
                }
            }

            config.remove("Opening.Cost");
            config.remove("Key");
        }

        config.getSection("CostOptions").forEach(sId -> {
            Cost cost = Cost.read(config, "CostOptions." + sId, sId);
            this.addCost(cost);
        });

        this.blockPositions.addAll(config.getStringList("Block.Positions").stream().map(WorldPos::deserialize).toList());
        if (!Config.isCrateInAirBlocksAllowed()) {
            this.blockPositions.removeIf(pos -> {
                Block block = pos.toBlock();
                return block != null && block.isEmpty();
>>>>>>> upstream/master
            });
        }

        this.setPushbackEnabled(config.getBoolean("Block.Pushback.Enabled"));
        this.setHologramEnabled(config.getBoolean("Block.Hologram.Enabled"));
        this.setHologramTemplateId(config.getString("Block.Hologram.Template", Placeholders.DEFAULT));
        this.setHologramYOffset(config.getDouble("Block.Hologram.Y_Offset", 0D));

        this.setEffectType(config.getString("Block.Effect.Model", EffectId.NONE));
        this.setEffectParticle(UniParticle.read(config, "Block.Effect.Particle"));
<<<<<<< HEAD
=======
        this.setEffectEnabled(config.getBoolean("Block.Effect.Enabled", !this.effectType.equalsIgnoreCase(EffectId.NONE)));

        this.setPostOpenCommands(config.getStringList("Post-Open.Commands"));
>>>>>>> upstream/master

        for (String sId : config.getSection("Rewards.List")) {
            Reward reward = RewardFactory.read(this.plugin, this, sId, config, "Rewards.List." + sId);
            this.rewardMap.put(sId, reward);
        }

        // Load milestones only if the feature is enabled.
        if (Config.isMilestonesEnabled()) {
            this.setMilestonesRepeatable(config.getBoolean("Milestones.Repeatable"));
            for (String sId : config.getSection("Milestones.List")) {
                this.milestones.add(Milestone.read(this, config, "Milestones.List." + sId));
            }
        }
<<<<<<< HEAD

        return true;
    }

    @Override
    protected void onSave(@NotNull FileConfig config) {
=======
    }

    public void saveForce() {
        this.markDirty();
        this.saveIfDirty();
    }

    public void saveIfDirty() {
        if (this.dirty) {
            this.loadConfig().edit(this::write);
            this.dirty = false;
        }
    }

    private void write(@NotNull FileConfig config) {
>>>>>>> upstream/master
        this.writeSettings(config);
        this.writeRewards(config);
        this.writeMilestones(config);
    }

    private void writeSettings(@NotNull FileConfig config) {
        config.set("Name", this.name);
        config.set("Description", this.description);
<<<<<<< HEAD
        config.set("ItemProvider", this.itemProvider);
=======
        config.set("ItemProvider", this.item);
>>>>>>> upstream/master
        config.set("ItemStackable", this.itemStackable);
        config.set("Permission_Required", this.permissionRequired);

        config.set("Preview.Enabled", this.previewEnabled);
        config.set("Preview.Id", this.previewId);
<<<<<<< HEAD
        config.set("Animation.Enabled", this.animationEnabled);
        config.set("Animation.Id", this.animationId);

        config.set("Opening.Cooldown", this.openCooldown);

        // Write costs only if EconomyBridge is installed.
        if (Plugins.hasEconomyBridge()) {
            config.remove("Opening.Cost");
            this.getOpenCosts().forEach(cost -> config.set("Opening.Cost." + cost.getCurrencyId(), cost.getAmount()));
        }

        config.set("Key.Required", this.keyRequired);
        config.set("Key.Ids", this.keyIds);
=======
        config.set("Animation.Enabled", this.openingEnabled);
        config.set("Animation.Id", this.openingId);

        config.set("OpeningCooldown.Enabled", this.openingCooldownEnabled);
        config.set("OpeningCooldown.Value", this.openingCooldownTime);
        config.set("OpeningLimits.Amount", this.openingLimitAmount);

        config.remove("CostOptions");
        this.getCosts().forEach(cost -> config.set("CostOptions." + cost.getId(), cost));
>>>>>>> upstream/master

        config.set("Block.Positions", this.blockPositions.stream().map(WorldPos::serialize).toList());
        config.set("Block.Pushback.Enabled", this.pushbackEnabled);
        config.set("Block.Hologram.Enabled", this.hologramEnabled);
        config.set("Block.Hologram.Template", this.hologramTemplateId);
        config.set("Block.Hologram.Y_Offset", this.hologramYOffset);
<<<<<<< HEAD
        config.set("Block.Effect.Model", this.effectType);
        config.remove("Block.Effect.Particle");
        this.effectParticle.write(config, "Block.Effect.Particle");
=======
        config.set("Block.Effect.Enabled", this.effectEnabled);
        config.set("Block.Effect.Model", this.effectType);
        config.remove("Block.Effect.Particle");
        this.effectParticle.write(config, "Block.Effect.Particle");

        config.set("Post-Open.Commands", this.postOpenCommands);
>>>>>>> upstream/master
    }

    private void writeRewards(@NotNull FileConfig config) {
        config.remove("Rewards.List");
        this.getRewards().forEach(reward -> this.writeReward(config, reward));
    }

    private void writeReward(@NotNull FileConfig config, @NotNull Reward reward) {
        reward.write(config, "Rewards.List." + reward.getId());
    }

    private void writeMilestones(@NotNull FileConfig config) {
        // Write milestones only if the feature is enabled.
        if (!Config.isMilestonesEnabled()) return;

        config.set("Milestones.Repeatable", this.milestonesRepeatable);
        config.remove("Milestones.List");
        int i = 0;
        for (Milestone milestone : this.milestones) {
            milestone.write(config, "Milestones.List." + (i++));
        }
    }

<<<<<<< HEAD
    public void saveSettings() {
        this.writeConfig(this::writeSettings);
    }

    public void saveRewards() {
        this.writeConfig(this::writeRewards);
    }

    public void saveReward(@NotNull Reward reward) {
        this.writeConfig(config -> this.writeReward(config, reward));
    }

    public void saveMilestones() {
        this.writeConfig(this::writeMilestones);
    }

    private void writeConfig(@NotNull Consumer<FileConfig> consumer) {
        FileConfig config = this.getConfig();

        consumer.accept(config);
        config.saveChanges();
    }

=======
>>>>>>> upstream/master
    @NotNull
    public UnaryOperator<String> replacePlaceholders() {
        return Placeholders.CRATE.replacer(this);
    }

<<<<<<< HEAD
    @NotNull
    public UnaryOperator<String> replaceAllPlaceholders() {
        return Placeholders.CRATE_EDITOR.replacer(this);
=======
    public boolean hasProblems() {
        return !this.collectProblems().isEmpty();
    }

    @NotNull
    public ProblemReporter collectProblems() {
        ProblemCollector collector = new ProblemCollector(this.getName(), this.filePath.toString());

        if (!this.item.isValid()) collector.report(Lang.INSPECTIONS_GENERIC_ITEM.get(false));
        if (this.isPreviewEnabled() && !this.isPreviewValid()) collector.report(Lang.INSPECTIONS_CRATE_PREVIEW.get(false));
        if (this.isOpeningEnabled() && !this.isOpeningValid()) collector.report(Lang.INSPECTIONS_CRATE_OPENING.get(false));
        if (this.isHologramEnabled() && !this.isHologramTemplateValid()) collector.report(Lang.INSPECTIONS_CRATE_HOLOGRAM.get(false));

        this.postOpenCommands.stream().filter(Predicate.not(CrateUtils::isValidCommand)).forEach(command -> {
            collector.report("Post-Open Command '" + command + "' does no exist.");
        });

        this.costMap.values().forEach(cost -> {
            ProblemReporter reporter = cost.collectProblems();
            if (reporter.isEmpty()) return;

            collector.children("Problems in '" + cost.getId() + "' cost option.", reporter);
        });

        this.rewardMap.values().forEach(reward -> {
            ProblemReporter reporter = reward.collectProblems();
            if (reporter.isEmpty()) return;

            collector.children("Problems in '" + reward.getId() + "' reward.", reporter);
        });

        return collector;
>>>>>>> upstream/master
    }

    @Nullable
    public GlobalCrateData getData() {
        return this.plugin.getDataManager().getCrateData(this.getId());
    }

<<<<<<< HEAD
    @Nullable
    public String getLatestOpener() {
        GlobalCrateData data = this.getData();
        return data == null ? null : data.getLatestOpener();
    }

    @Nullable
    public String getLastOpenerName() {
        String last = this.getLatestOpener();
        return last == null ? Lang.OTHER_LAST_OPENER_EMPTY.getString() : last;
=======
    @NotNull
    public Optional<CachedProfile> getLastOpener() {
        GlobalCrateData data = this.getData();
        if (data == null) return Optional.empty();

        UUID playerId = data.getLatestOpenerId();
        String playerName = data.getLatestOpenerName();
        if (playerId == null || playerName == null) return Optional.empty();

        return Optional.of(PlayerProfiles.createProfile(playerId, playerName));
>>>>>>> upstream/master
    }

    @Nullable
    public String getLatestReward() {
        GlobalCrateData data = this.getData();
        if (data == null || data.getLatestRewardId() == null) return null;

        Reward reward = this.getReward(data.getLatestRewardId());
<<<<<<< HEAD
        return reward == null ? null : reward.getNameTranslated();
=======
        return reward == null ? null : reward.getName();
>>>>>>> upstream/master
    }

    @Nullable
    public String getLastRewardName() {
        String last = this.getLatestReward();
<<<<<<< HEAD
        return last == null ? Lang.OTHER_LAST_REWARD_EMPTY.getString() : last;
    }

    public void createHologram() {
        this.manageHologram(handler -> handler.create(this));
    }

    public void removeHologram() {
        this.manageHologram(handler -> handler.remove(this));
=======
        return last == null ? Lang.OTHER_LAST_REWARD_EMPTY.text() : last;
    }

    public void createHologram() {
        this.manageHologram(handler -> handler.render(this));
    }

    public void removeHologram() {
        this.manageHologram(handler -> handler.discard(this));
>>>>>>> upstream/master
    }

    public void recreateHologram() {
        this.manageHologram(handler -> {
<<<<<<< HEAD
            handler.remove(this);
            handler.refresh(this);
=======
            handler.discard(this);
            handler.render(this);
>>>>>>> upstream/master
        });
    }

    private void manageHologram(@NotNull Consumer<HologramManager> consumer) {
        if (this.hologramEnabled) {
<<<<<<< HEAD
            this.plugin.manageHolograms(consumer);
=======
            this.plugin.getHologramManager().ifPresent(consumer);
>>>>>>> upstream/master
        }
    }

    public boolean hasRewards() {
        return !this.rewardMap.isEmpty();
    }

    public boolean hasMilestones() {
        return Config.isMilestonesEnabled() && !this.milestones.isEmpty();
    }

<<<<<<< HEAD
    @NotNull
    public Set<CrateKey> getRequiredKeys() {
        return this.keyIds.stream().map(id -> plugin.getKeyManager().getKeyById(id)).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    public boolean isGoodKey(@NotNull CrateKey key) {
        return this.keyIds.contains(key.getId());
    }

    public boolean isAllPhysicalKeys() {
        return this.getRequiredKeys().stream().noneMatch(CrateKey::isVirtual);
    }

    public boolean isAllVirtualKeys() {
        return this.getRequiredKeys().stream().allMatch(CrateKey::isVirtual);
    }

=======
>>>>>>> upstream/master
    public boolean isPreviewValid() {
        return this.plugin.getCrateManager().getPreviewById(this.previewId) != null;
    }

<<<<<<< HEAD
    public boolean isAnimationValid() {
        return this.plugin.getOpeningManager().getProviderById(this.animationId) != null;
=======
    public boolean isOpeningValid() {
        return this.plugin.getOpeningManager().getProviderById(this.openingId) != null;
>>>>>>> upstream/master
    }

    public boolean isHologramTemplateValid() {
        return Config.getHologramTemplate(this.hologramTemplateId) != null;
    }

<<<<<<< HEAD
    public boolean isEffectEnabled() {
        return !this.getEffect().isDummy();
    }

    @NotNull
    public CrateEffect getEffect() {
        return EffectRegistry.getEffectOrDummy(this.effectType);
    }

    public boolean hasOpenCost() {
        return !this.openCostMap.isEmpty();
    }

    public boolean hasOpenCooldown() {
        return this.openCooldown != 0;
=======
    @NotNull
    public CrateEffect getEffect() {
        return CratesRegistries.effectOrDummy(this.effectType);
>>>>>>> upstream/master
    }

    public boolean hasPermission(@NotNull Player player) {
        if (!this.isPermissionRequired()) return true;

        return player.hasPermission(this.getPermission());
    }

<<<<<<< HEAD
    public boolean hasCostBypassPermisssion(@NotNull Player player) {
        return player.hasPermission(Perms.BYPASS_CRATE_OPEN_COST) || player.hasPermission(this.getCostBypassPermission());
    }

=======
>>>>>>> upstream/master
    public boolean hasCooldownBypassPermission(@NotNull Player player) {
        return player.hasPermission(Perms.BYPASS_CRATE_COOLDOWN);
    }

<<<<<<< HEAD
    public boolean canAffordOpen(@NotNull Player player) {
        if (!this.hasOpenCost()) return true;
        if (this.hasCostBypassPermisssion(player)) return true;

        return this.getOpenCosts().stream().allMatch(cost -> cost.hasEnough(player));
    }

    public void payForOpen(@NotNull Player player) {
        if (!this.hasOpenCost()) return;

        this.getOpenCosts().forEach(cost -> cost.withdraw(player));
    }

    public void refundForOpen(@NotNull Player player) {
        if (!this.hasOpenCost()) return;

        this.getOpenCosts().forEach(cost -> cost.deposit(player));
    }

=======
>>>>>>> upstream/master
    @NotNull
    public String getPermission() {
        return Perms.PREFIX_CRATE + this.getId();
    }

    @NotNull
<<<<<<< HEAD
    public String getCostBypassPermission() {
        return Perms.PREFIX_BYPASS_OPEN_COST + this.getId();
    }

    @NotNull
=======
>>>>>>> upstream/master
    public List<String> getHologramText() {
        HologramTemplate template = Config.getHologramTemplate(this.hologramTemplateId);
        return template == null ? Collections.emptyList() : template.getText();
    }

    public boolean hasRewards(@NotNull Player player) {
        return this.hasRewards(player, null);
    }

    public boolean hasRewards(@NotNull Rarity rarity) {
        return this.hasRewards(null, rarity);
    }

    public boolean hasRewards(@Nullable Player player, @Nullable Rarity rarity) {
        return !this.getRewards(player, rarity).isEmpty();
    }

    @NotNull
    public Reward rollReward() {
        return this.rollReward(null, null);
    }

    @NotNull
    public Reward rollReward(@NotNull Rarity rarity) {
        return this.rollReward(null, rarity);
    }

    @NotNull
    public Reward rollReward(@NotNull Player player) {
        return this.rollReward(player, null);
    }

    @NotNull
    public Reward rollReward(@Nullable Player player, @Nullable Rarity rarity) {
        List<Reward> rewards = this.getRewards(player, rarity);

        // If no rarity is specified, we have to select a random one and filter rewards by selected rarity.
        // Otherwise reward list is already obtained with specified rarity.
        if (rarity == null) {
            Map<Rarity, Double> rarities = new HashMap<>();
            rewards.stream().map(Reward::getRarity).forEach(rewardRarity -> {
                rarities.putIfAbsent(rewardRarity, rewardRarity.getWeight());
            });

            Rarity rarityRoll = Rnd.getByWeight(rarities);
            rewards.removeIf(reward -> reward.getRarity() != rarityRoll);
        }

        return this.rollReward(rewards);
    }

    @NotNull
    private Reward rollReward(@NotNull Collection<Reward> allRewards) {
        Map<Reward, Double> rewards = new HashMap<>();
        allRewards.forEach(reward -> {
            rewards.put(reward, reward.getWeight());
        });
        return Rnd.getByWeight(rewards);
    }

    public void addBlockPosition(@NotNull Location location) {
        WorldPos pos = WorldPos.from(location);

        this.plugin.getCrateManager().removeCratePositions(this);
        this.blockPositions.add(pos);
        this.plugin.getCrateManager().addCratePositions(this);
    }

    public void clearBlockPositions() {
        this.plugin.getCrateManager().removeCratePositions(this);
        this.blockPositions.clear();
    }

<<<<<<< HEAD
    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getNameTranslated() {
        return NightMessage.asLegacy(this.getName());
=======
    public int countRewards() {
        return this.rewardMap.size();
    }

    public int countMilestones() {
        return this.milestones.size();
    }

    public int countMaxOpenings(@NotNull Player player) {
        return this.getCosts().stream().filter(Cost::isEnabled).mapToInt(cost -> cost.countMaxOpenings(player)).max().orElse(-1);
    }

    public void markDirty() {
        this.dirty = true;
    }

    public boolean hasFile() {
        return Files.exists(this.filePath);
    }

    @NotNull
    public String getId() {
        return this.id;
    }

    @Override
    @NotNull
    public Path getPath() {
        return this.filePath;
    }

    @NotNull
    public String getName() {
        return this.name;
>>>>>>> upstream/master
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public List<String> getDescription() {
        return this.description;
    }

    public void setDescription(@NotNull List<String> description) {
        this.description = description;
    }

    @NotNull
<<<<<<< HEAD
    public ItemProvider getItemProvider() {
        return this.itemProvider;
    }

    public void setItemProvider(@NotNull ItemProvider itemProvider) {
        this.itemProvider = itemProvider;
    }

    @NotNull
    public ItemStack getRawItem() {
        ItemStack itemStack = this.itemProvider.getItemStack();//new ItemStack(this.itemProvider);

        ItemUtil.editMeta(itemStack, meta -> {
            meta.setDisplayName(this.getNameTranslated());
            meta.setLore(NightMessage.asLegacy(this.description));
=======
    public AdaptedItem getItem() {
        return this.item;
    }

    public void setItem(@NotNull AdaptedItem item) {
        this.item = item;
    }

    @NotNull
    public ItemStack getRawItemStack() {
        return this.getItemStack(false);
    }

    @NotNull
    public ItemStack getItemStack() {
        return this.getItemStack(true);
    }

    @NotNull
    public ItemStack getItemStack(boolean fullData) {
        ItemStack itemStack = this.item.itemStack().orElse(CrateUtils.getDefaultItem(this));

        ItemUtil.editMeta(itemStack, meta -> {
            //ItemUtil.setCustomName(meta, this.name);
            //ItemUtil.setLore(meta, this.description);

            if (fullData) {
                meta.setMaxStackSize(this.itemStackable ? null : 1);
                PDCUtil.set(meta, Keys.crateId, this.getId());
            }
>>>>>>> upstream/master
        });

        return itemStack;
    }

<<<<<<< HEAD
    @NotNull
    public ItemStack getItem() {
        ItemStack item = this.getRawItem();

        ItemUtil.editMeta(item, meta -> {
            if (!this.isItemStackable()) meta.setMaxStackSize(1);
            PDCUtil.set(meta, Keys.crateId, this.getId());
        });

        return item;
    }

=======
>>>>>>> upstream/master
    public boolean isItemStackable() {
        return this.itemStackable;
    }

    public void setItemStackable(boolean itemStackable) {
        this.itemStackable = itemStackable;
    }

    @NotNull
    public String getPreviewId() {
        return this.previewId;
    }

    public void setPreviewId(@NotNull String previewId) {
        this.previewId = previewId.toLowerCase();
    }

    public boolean isPreviewEnabled() {
        return this.previewEnabled;
    }

    public void setPreviewEnabled(boolean previewEnabled) {
        this.previewEnabled = previewEnabled;
    }

    @NotNull
<<<<<<< HEAD
    public String getAnimationId() {
        return this.animationId;
    }

    public void setAnimationId(@NotNull String animationId) {
        this.animationId = animationId.toLowerCase();
    }

    public boolean isAnimationEnabled() {
        return this.animationEnabled;
    }

    public void setAnimationEnabled(boolean animationEnabled) {
        this.animationEnabled = animationEnabled;
=======
    public String getOpeningId() {
        return this.openingId;
    }

    public void setOpeningId(@NotNull String openingId) {
        this.openingId = openingId.toLowerCase();
    }

    public boolean isOpeningEnabled() {
        return this.openingEnabled;
    }

    public void setOpeningEnabled(boolean openingEnabled) {
        this.openingEnabled = openingEnabled;
>>>>>>> upstream/master
    }



    public boolean isPermissionRequired() {
        return permissionRequired;
    }

    public void setPermissionRequired(boolean isPermissionRequired) {
        this.permissionRequired = isPermissionRequired;
    }

<<<<<<< HEAD
    public int getOpenCooldown() {
        return this.openCooldown;
    }

    public void setOpenCooldown(int openCooldown) {
        this.openCooldown = openCooldown;
    }

    @NotNull
    public Map<String, Cost> getOpenCostMap() {
        return this.openCostMap;
    }

    @NotNull
    public Set<Cost> getOpenCosts() {
        return new HashSet<>(this.openCostMap.values());
    }

    @Nullable
    public Cost getOpenCost(@NotNull String currency) {
        return this.openCostMap.get(currency.toLowerCase());
    }

    public void addOpenCost(@NotNull Cost cost) {
        this.openCostMap.put(cost.getCurrencyId(), cost);
    }

    public void removeOpenCost(@NotNull Cost cost) {
        this.openCostMap.remove(cost.getCurrencyId());
    }

    public boolean isKeyRequired() {
        return this.keyRequired;
    }

    public void setKeyRequired(boolean keyRequired) {
        this.keyRequired = keyRequired;
    }

    @NotNull
    public Set<String> getKeyIds() {
        return new HashSet<>(this.keyIds);
    }

    public boolean addKeyId(@NotNull String keyId) {
        return this.keyIds.add(keyId.toLowerCase());
    }

    public boolean removeKeyId(@NotNull String keyId) {
        return this.keyIds.remove(keyId.toLowerCase());
    }

    public void setKeyIds(@NotNull Set<String> keyIds) {
        this.keyIds.clear();
        this.keyIds.addAll(Lists.modify(keyIds, String::toLowerCase));
=======
    public boolean isOpeningCooldownEnabled() {
        return this.openingCooldownEnabled;
    }

    public void setOpeningCooldownEnabled(boolean openingCooldownEnabled) {
        this.openingCooldownEnabled = openingCooldownEnabled;
    }

    public int getOpeningCooldownTime() {
        return this.openingCooldownTime;
    }

    public void setOpeningCooldownTime(int openingCooldownTime) {
        this.openingCooldownTime = openingCooldownTime;
    }

    public int getOpeningLimitAmount() {
        return this.openingLimitAmount;
    }

    public void setOpeningLimitAmount(int openingLimitAmount) {
        this.openingLimitAmount = Math.max(1, openingLimitAmount);
    }

    @NotNull
    public Map<String, Cost> getCostMap() {
        return this.costMap;
    }

    @NotNull
    public List<Cost> getCosts() {
        return new ArrayList<>(this.costMap.values());
    }

    public void addCost(@NotNull Cost cost) {
        this.costMap.put(cost.getId(), cost);
    }

    public void removeCost(@NotNull Cost cost) {
        this.costMap.remove(cost.getId());
    }

    public boolean hasCost(@NotNull String id) {
        return this.costMap.containsKey(id);
    }

    @Nullable
    public Cost getCost(@NotNull String id) {
        return this.costMap.get(id);
    }

    @NotNull
    public Optional<Cost> getFirstCost() {
        return this.getCosts().stream().filter(Cost::isAvailable).findFirst();
    }

    @NotNull
    public Optional<Cost> getAnyCost(@NotNull Player player) {
        return this.getCosts().stream().filter(cost -> cost.isAvailable() && cost.canAfford(player)).findAny().or(this::getFirstCost);
    }

    public boolean hasCost() {
        return !this.costMap.isEmpty() && this.getCosts().stream().anyMatch(Cost::isAvailable);
    }

    public boolean hasMultipleCosts() {
        return this.getCosts().stream().filter(Cost::isAvailable).count() >= 2;
>>>>>>> upstream/master
    }

    public boolean isPushbackEnabled() {
        return this.pushbackEnabled;
    }

    public void setPushbackEnabled(boolean blockPushback) {
        this.pushbackEnabled = blockPushback;
    }

    @NotNull
    public Set<WorldPos> getBlockPositions() {
        return new HashSet<>(this.blockPositions);
    }

    public boolean isHologramEnabled() {
        return this.hologramEnabled;
    }

    public void setHologramEnabled(boolean hologramEnabled) {
        this.hologramEnabled = hologramEnabled;
    }

    @NotNull
    public String getHologramTemplateId() {
        return this.hologramTemplateId;
    }

    public void setHologramTemplateId(@NotNull String hologramTemplateId) {
        this.hologramTemplateId = hologramTemplateId.toLowerCase();
    }

    public double getHologramYOffset() {
        return hologramYOffset;
    }

    public void setHologramYOffset(double hologramYOffset) {
        this.hologramYOffset = hologramYOffset;
    }

<<<<<<< HEAD
=======
    public boolean isEffectEnabled() {
        return this.effectEnabled;
    }

    public void setEffectEnabled(boolean effectEnabled) {
        this.effectEnabled = effectEnabled;
    }

>>>>>>> upstream/master
    @NotNull
    public String getEffectType() {
        return this.effectType;
    }

    public void setEffectType(@NotNull String effectType) {
        this.effectType = effectType;
    }

    @NotNull
    public UniParticle getEffectParticle() {
        return this.effectParticle;
    }

    public void setEffectParticle(@NotNull UniParticle wrapped) {
<<<<<<< HEAD
        if (!CrateUtils.isSupportedParticle(wrapped.getParticle())) {
=======
        if (!CrateUtils.isSupportedParticle(wrapped.getParticle()) || wrapped.getParticle() == null) {
>>>>>>> upstream/master
            wrapped = UniParticle.of(Particle.CLOUD);
        }

        this.effectParticle = wrapped;
        this.effectParticle.validateData();
    }

    @NotNull
<<<<<<< HEAD
=======
    public List<String> getPostOpenCommands() {
        return this.postOpenCommands;
    }

    public void setPostOpenCommands(@Nullable List<String> postOpenCommands) {
        this.postOpenCommands = postOpenCommands == null ? new ArrayList<>() : new ArrayList<>(postOpenCommands);
    }

    @NotNull
>>>>>>> upstream/master
    public LinkedHashMap<String, Reward> getRewardsMap() {
        return this.rewardMap;
    }

    @NotNull
    public Set<Rarity> getRarities() {
        return this.getRewards().stream().map(Reward::getRarity).collect(Collectors.toSet());
    }

    @NotNull
    public Set<String> getRewardIds() {
        return new LinkedHashSet<>(this.rewardMap.keySet());
    }

    @NotNull
    public Set<Reward> getRewards() {
        return new LinkedHashSet<>(this.rewardMap.values());
    }

    @NotNull
    public List<Reward> getRewards(@NotNull Rarity rarity) {
        return this.getRewards(null, rarity);
    }

    @NotNull
    public List<Reward> getRewards(@NotNull Player player) {
        return this.getRewards(player, null);
    }

    @NotNull
    public List<Reward> getRewards(@Nullable Player player, @Nullable Rarity rarity) {
        Predicate<Reward> predicate = reward -> {
            if (rarity != null && reward.getRarity() != rarity) return false;

            return player == null || reward.canWin(player);
        };

        return new ArrayList<>(this.getRewards().stream().filter(predicate).toList());
    }

    public void setRewards(@NotNull List<Reward> rewards) {
        this.rewardMap.clear();
        this.rewardMap.putAll(rewards.stream().collect(
            Collectors.toMap(Reward::getId, Function.identity(), (has, add) -> add, LinkedHashMap::new)));
    }

    @Nullable
    public Reward getReward(@NotNull String id) {
        return this.rewardMap.get(id.toLowerCase());
    }

    @Nullable
    public Reward getMilestoneReward(int openings) {
        Milestone milestone = this.getMilestone(openings);
        return milestone == null ? null : milestone.getReward();
    }

    public void addReward(@NotNull Reward reward) {
        this.rewardMap.put(reward.getId(), reward);
    }

    public void removeReward(@NotNull Reward reward) {
        this.removeReward(reward.getId());
        this.plugin.getDataManager().handleRewardRemoval(reward);
    }

    public void removeReward(@NotNull String id) {
        this.rewardMap.remove(id);
    }

    @NotNull
    public Set<Milestone> getMilestones() {
        return this.milestones;
    }

    @Nullable
    public Milestone getMilestone(int openings) {
        return this.milestones.stream().filter(milestone -> milestone.getOpenings() == openings).findFirst().orElse(null);
    }

    public boolean isMilestonesRepeatable() {
        return milestonesRepeatable;
    }

    public void setMilestonesRepeatable(boolean milestonesRepeatable) {
        this.milestonesRepeatable = milestonesRepeatable;
    }

    public int getMaxMilestone() {
        return this.milestones.stream().mapToInt(Milestone::getOpenings).max().orElse(0);
    }

    @Nullable
    public Milestone getNextMilestone(int openings) {
        return this.milestones.stream().filter(milestone -> milestone.getOpenings() > openings).min(Comparator.comparingInt(Milestone::getOpenings)).orElse(null);
    }
}

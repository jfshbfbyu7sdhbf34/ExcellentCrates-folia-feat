package su.nightexpress.excellentcrates.crate;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
<<<<<<< HEAD
=======
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
>>>>>>> upstream/master
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.excellentcrates.CratesPlugin;
import su.nightexpress.excellentcrates.Placeholders;
import su.nightexpress.excellentcrates.api.crate.Reward;
<<<<<<< HEAD
=======
import su.nightexpress.excellentcrates.api.event.CrateObtainRewardEvent;
>>>>>>> upstream/master
import su.nightexpress.excellentcrates.api.event.CrateOpenEvent;
import su.nightexpress.excellentcrates.api.opening.Opening;
import su.nightexpress.excellentcrates.config.Config;
import su.nightexpress.excellentcrates.config.Keys;
import su.nightexpress.excellentcrates.config.Lang;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.config.Perms;
import su.nightexpress.excellentcrates.crate.effect.CrateEffect;
import su.nightexpress.excellentcrates.crate.effect.EffectId;
import su.nightexpress.excellentcrates.crate.effect.EffectRegistry;
import su.nightexpress.excellentcrates.crate.impl.*;
import su.nightexpress.excellentcrates.crate.listener.CrateListener;
import su.nightexpress.excellentcrates.crate.menu.MilestonesMenu;
import su.nightexpress.excellentcrates.crate.menu.PreviewMenu;
import su.nightexpress.excellentcrates.data.crate.GlobalCrateData;
import su.nightexpress.excellentcrates.data.crate.UserCrateData;
import su.nightexpress.excellentcrates.data.reward.RewardLimit;
import su.nightexpress.excellentcrates.hologram.HologramTemplate;
import su.nightexpress.excellentcrates.item.ItemTypes;
import su.nightexpress.excellentcrates.key.CrateKey;
import su.nightexpress.excellentcrates.user.CrateUser;
import su.nightexpress.excellentcrates.util.CrateUtils;
import su.nightexpress.excellentcrates.util.InteractType;
import su.nightexpress.excellentcrates.util.inspect.Inspectors;
import su.nightexpress.excellentcrates.util.pos.WorldPos;
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.nightcore.manager.AbstractManager;
import su.nightexpress.nightcore.util.*;
import su.nightexpress.nightcore.util.bukkit.NightItem;
import su.nightexpress.nightcore.util.text.tag.Tags;
=======
import su.nightexpress.excellentcrates.crate.cost.Cost;
import su.nightexpress.excellentcrates.crate.cost.CostDialogs;
import su.nightexpress.excellentcrates.crate.effect.CrateEffect;
import su.nightexpress.excellentcrates.crate.effect.EffectId;
import su.nightexpress.excellentcrates.crate.impl.*;
import su.nightexpress.excellentcrates.crate.limit.LimitValues;
import su.nightexpress.excellentcrates.crate.listener.CrateListener;
import su.nightexpress.excellentcrates.crate.menu.MilestonesMenu;
import su.nightexpress.excellentcrates.crate.menu.OpeningAmountMenu;
import su.nightexpress.excellentcrates.crate.menu.OpeningCostMenu;
import su.nightexpress.excellentcrates.crate.menu.PreviewMenu;
import su.nightexpress.excellentcrates.data.crate.GlobalCrateData;
import su.nightexpress.excellentcrates.data.crate.UserCrateData;
import su.nightexpress.excellentcrates.data.reward.RewardData;
import su.nightexpress.excellentcrates.dialog.DialogRegistry;
import su.nightexpress.excellentcrates.crate.reward.RewardDialogs;
import su.nightexpress.excellentcrates.dialog.cost.CostCreationDialog;
import su.nightexpress.excellentcrates.dialog.cost.CostEntryCreationDialog;
import su.nightexpress.excellentcrates.dialog.cost.CostNameDialog;
import su.nightexpress.excellentcrates.dialog.crate.*;
import su.nightexpress.excellentcrates.dialog.reward.*;
import su.nightexpress.excellentcrates.hologram.HologramTemplate;
import su.nightexpress.excellentcrates.registry.CratesRegistries;
import su.nightexpress.excellentcrates.user.CrateUser;
import su.nightexpress.excellentcrates.util.CrateUtils;
import su.nightexpress.excellentcrates.util.InteractType;
import su.nightexpress.excellentcrates.util.ItemHelper;
import su.nightexpress.excellentcrates.util.pos.WorldPos;
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.nightcore.core.config.CoreLang;
import su.nightexpress.nightcore.manager.AbstractManager;
import su.nightexpress.nightcore.util.*;
import su.nightexpress.nightcore.util.text.night.wrapper.TagWrappers;
>>>>>>> upstream/master
import su.nightexpress.nightcore.util.time.TimeFormatType;
import su.nightexpress.nightcore.util.time.TimeFormats;
import su.nightexpress.nightcore.util.wrapper.UniParticle;

import java.io.File;
<<<<<<< HEAD
=======
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
>>>>>>> upstream/master
import java.util.*;

public class CrateManager extends AbstractManager<CratesPlugin> {

<<<<<<< HEAD
=======
    private final DialogRegistry dialogs;

>>>>>>> upstream/master
    private final Map<String, Rarity>      rarityByIdMap;
    private final Map<String, Crate>       crateByIdMap;
    private final Map<WorldPos, Crate>     crateByPosMap;
    private final Map<String, PreviewMenu> previewByIdMap;
    private final Map<UUID, Long>          previewCooldown;

<<<<<<< HEAD
    private MilestonesMenu milestonesMenu;

    public CrateManager(@NotNull CratesPlugin plugin) {
        super(plugin);
=======
    private OpeningCostMenu   costMenu;
    private OpeningAmountMenu amountMenu;
    private MilestonesMenu    milestonesMenu;

    public CrateManager(@NotNull CratesPlugin plugin, @NotNull DialogRegistry dialogs) {
        super(plugin);
        this.dialogs = dialogs;

>>>>>>> upstream/master
        this.rarityByIdMap = new HashMap<>();
        this.crateByIdMap = new HashMap<>();
        this.crateByPosMap = new HashMap<>();
        this.previewByIdMap = new HashMap<>();
        this.previewCooldown = new HashMap<>();
    }

    @Override
    protected void onLoad() {
        this.updateHologramTemplates();

        this.loadRarities();
        this.loadPreviews();
        this.loadCrates();
        this.loadUI();
<<<<<<< HEAD
        this.plugin.runTask(this::runInspections); // After everything is loaded.
=======
        this.loadDialogs();
        this.plugin.runTask(task -> this.reportProblems()); // After everything is loaded.
>>>>>>> upstream/master

        this.addListener(new CrateListener(this.plugin, this));

        this.addAsyncTask(this::playCrateEffects, 1L);
<<<<<<< HEAD
=======
        this.addAsyncTask(this::saveCrates, Config.CRATE_SAVE_INTERVAL.get());
>>>>>>> upstream/master
    }

    @Override
    protected void onShutdown() {
<<<<<<< HEAD
=======
        this.saveCrates();

>>>>>>> upstream/master
        if (this.milestonesMenu != null) this.milestonesMenu.clear();

        this.previewByIdMap.values().forEach(PreviewMenu::clear);
        this.previewByIdMap.clear();
        this.crateByIdMap.clear();
        this.crateByPosMap.clear();
        this.rarityByIdMap.clear();
    }

    private void updateHologramTemplates() {
        FileConfig config = this.plugin.getConfig();
        if (!config.contains("Crate.Holograms.Templates")) return;

        config.remove("Crate.Holograms.TemplateList"); // Remove newly generated stuff.
        config.getSection("Crate.Holograms.Templates").forEach(sId -> {
            List<String> text = config.getStringList("Crate.Holograms.Templates." + sId);
            HologramTemplate template = new HologramTemplate(sId, text);
            template.write(config, "Crate.Holograms.TemplateList." + sId);
        });
        config.remove("Crate.Holograms.Templates"); // Remove old shit

        Config.CRATE_HOLOGRAM_TEMPLATES.read(config); // Re-read
    }

    private void loadRarities() {
        FileConfig config = this.plugin.getConfig();
        
        if (config.getSection("Rewards.Rarities").isEmpty()) {
            Set<Rarity> rarities = new HashSet<>();

            File oldFile = new File(plugin.getDataFolder(), "rarity.yml");
            if (oldFile.exists()) {
                FileConfig oldConfig = new FileConfig(oldFile);
                for (String id : oldConfig.getSection("")) {
                    rarities.add(Rarity.read(plugin, oldConfig, id, id));
                }
                oldFile.delete();
            }
            if (rarities.isEmpty()) {
<<<<<<< HEAD
                rarities.add(new Rarity(this.plugin, "common", Tags.WHITE.wrap("Common"), 70));
                rarities.add(new Rarity(this.plugin, "rare", Tags.LIGHT_GREEN.wrap("Rare"), 25));
                rarities.add(new Rarity(this.plugin, "mythic", Tags.LIGHT_PURPLE.wrap("Mythic"), 5));
=======
                rarities.add(new Rarity(this.plugin, "common", TagWrappers.WHITE.wrap("Common"), 70));
                rarities.add(new Rarity(this.plugin, "rare", TagWrappers.GREEN.wrap("Rare"), 25));
                rarities.add(new Rarity(this.plugin, "mythic", TagWrappers.SOFT_PURPLE.wrap("Mythic"), 5));
>>>>>>> upstream/master
            }

            rarities.forEach(rarity -> {
                rarity.write(config, "Rewards.Rarities." + rarity.getId());
            });
        }

        config.getSection("Rewards.Rarities").forEach(rarityId -> {
            Rarity rarity = Rarity.read(this.plugin, config, "Rewards.Rarities." + rarityId, rarityId);
            this.rarityByIdMap.put(rarity.getId(), rarity);
        });

        this.plugin.info("Loaded " + this.rarityByIdMap.size() + " rarities!");
    }

    private void loadPreviews() {
        File dir = new File(plugin.getDataFolder().getAbsolutePath(), Config.DIR_PREVIEWS);
        if (!dir.exists() && dir.mkdirs()) {
            new PreviewMenu(plugin, FileConfig.loadOrExtract(plugin, Config.DIR_PREVIEWS, Placeholders.DEFAULT + ".yml"));
        }

        for (FileConfig config : FileConfig.loadAll(plugin.getDataFolder() + Config.DIR_PREVIEWS, false)) {
            PreviewMenu menu = new PreviewMenu(plugin, config);
            String id = config.getFile().getName().replace(".yml", "").toLowerCase();
            this.previewByIdMap.put(id, menu);
        }
    }

    private void loadUI() {
<<<<<<< HEAD
=======
        this.costMenu = this.addMenu(new OpeningCostMenu(this.plugin, this), Config.DIR_UI, "crate_open_costs.yml");
        this.amountMenu = this.addMenu(new OpeningAmountMenu(this.plugin, this), Config.DIR_UI, "crate_open_amount.yml");

>>>>>>> upstream/master
        if (Config.isMilestonesEnabled()) {
            this.milestonesMenu = new MilestonesMenu(this.plugin);
        }
    }

    private void loadCrates() {
        for (File file : FileUtil.getFiles(plugin.getDataFolder() + Config.DIR_CRATES, false)) {
<<<<<<< HEAD
            Crate crate = new Crate(plugin, file);
=======
            String id = Strings.varStyle(FileConfig.getName(file)).orElseThrow(); // TODO Handle

            Crate crate = new Crate(plugin, file.toPath(), id);
>>>>>>> upstream/master
            this.loadCrate(crate);
        }
        this.plugin.info("Loaded " + this.crateByIdMap.size() + " crates.");
    }

    private void loadCrate(@NotNull Crate crate) {
<<<<<<< HEAD
        if (crate.load()) {
            this.crateByIdMap.put(crate.getId(), crate);
            this.addCratePositions(crate);
        }
        else this.plugin.error("Crate not loaded: '" + crate.getFile().getName() + "'.");
    }

    private void runInspections() {
        this.getCrates().forEach(crate -> {
            String filePath = crate.getFile().getPath();

            Inspectors.CRATE.printConsole(plugin, crate, "Problems in '" + crate.getId() + "' crate (" + filePath + "):");

            crate.getRewards().forEach(reward -> {
                Inspectors.REWARD.printConsole(plugin, reward, "Problems in '" + reward.getId() + "' reward (" + filePath + "):");
            });
        });
=======
        try {
            crate.load();
            this.crateByIdMap.put(crate.getId(), crate);
            this.addCratePositions(crate);
        }
        catch (IllegalStateException exception) {
            this.plugin.error("Crate '" + crate.getPath() + "' can not be loaded.");
            exception.printStackTrace();
        }
    }

    private void loadDialogs() {
        this.dialogs.register(CrateDialogs.CRATE_CREATION, CrateCreationDialog::new);
        this.dialogs.register(CrateDialogs.CRATE_NAME, CrateNameDialog::new);
        this.dialogs.register(CrateDialogs.CRATE_DESCRIPTION, CrateDescriptionDialog::new);
        this.dialogs.register(CrateDialogs.CRATE_ITEM, CrateItemDialog::new);
        this.dialogs.register(CrateDialogs.CRATE_PREVIEW, () -> new CratePreviewDialog(this.plugin));
        this.dialogs.register(CrateDialogs.CRATE_OPENING, () -> new CrateOpeningDialog(this.plugin));
        this.dialogs.register(CrateDialogs.CRATE_OPENING_LIMITS, CrateOpeningLimitsDialog::new);
        this.dialogs.register(CrateDialogs.CRATE_EFFECT, () -> new CrateEffectDialog(this.dialogs));
        this.dialogs.register(CrateDialogs.CRATE_PARTICLE, CrateParticleDialog::new);
        this.dialogs.register(CrateDialogs.CRATE_HOLOGRAM, CrateHologramDialog::new);
        this.dialogs.register(CrateDialogs.CRATE_POST_OPEN_COMMANDS, CratePostOpenCommandsDialog::new);

        this.dialogs.register(RewardDialogs.CREATION, () -> new RewardCreationDialog(this.plugin));
        this.dialogs.register(RewardDialogs.SORTING, RewardSortingDialog::new);
        this.dialogs.register(RewardDialogs.PREVIEW, RewardPreviewDialog::new);
        this.dialogs.register(RewardDialogs.ITEM, RewardItemDialog::new);
        this.dialogs.register(RewardDialogs.COMMANDS, RewardCommandsDialog::new);
        this.dialogs.register(RewardDialogs.NAME, RewardNameDialog::new);
        this.dialogs.register(RewardDialogs.DESCRIPTION, RewardDescriptionDialog::new);
        this.dialogs.register(RewardDialogs.WEIGHT, () -> new RewardWeightDialog(this.plugin));
        this.dialogs.register(RewardDialogs.PERMISSIONS, RewardPermissionsDialog::new);
        this.dialogs.register(RewardDialogs.LIMITS, RewardLimitsDialog::new);

        this.dialogs.register(CostDialogs.CREATION, CostCreationDialog::new);
        this.dialogs.register(CostDialogs.NAME, CostNameDialog::new);
        this.dialogs.register(CostDialogs.ENTRY_CREATION, CostEntryCreationDialog::new);
    }

    private void reportProblems() {
        this.getCrates().forEach(crate -> crate.collectProblems().print(this.plugin.getLogger()));
    }

    private void saveCrates() {
        this.getCrates().forEach(Crate::saveIfDirty);
    }

    public int countCrates() {
        return this.crateByIdMap.size();
    }

    public boolean hasCrate(@NotNull String id) {
        return this.crateByIdMap.containsKey(id);
>>>>>>> upstream/master
    }

    @NotNull
    public Map<String, Rarity> getRarityByIdMap() {
        return this.rarityByIdMap;
    }

    @NotNull
    public Set<Rarity> getRarities() {
        return new HashSet<>(this.rarityByIdMap.values());
    }

    @Nullable
    public Rarity getRarity(@NotNull String id) {
        return this.rarityByIdMap.get(id.toLowerCase());
    }

    @NotNull
    public Set<String> getRarityIds() {
        return new HashSet<>(this.rarityByIdMap.keySet());
    }

    @NotNull
    public Rarity getMostCommonRarity() {
        return this.getRarities().stream().max(Comparator.comparing(Rarity::getWeight)).orElseThrow();
    }

    @NotNull
    public Map<String, PreviewMenu> getPreviewByIdMap() {
        return this.previewByIdMap;
    }

    @Nullable
    public PreviewMenu getPreviewById(@NotNull String id) {
        return this.previewByIdMap.get(id.toLowerCase());
    }

    @NotNull
    public Set<PreviewMenu> getPreviews() {
        return new HashSet<>(this.previewByIdMap.values());
    }

    @NotNull
    public List<String> getPreviewNames() {
        return new ArrayList<>(this.previewByIdMap.keySet());
    }

    public void openMilestones(@NotNull Player player, @NotNull CrateSource source) {
        if (this.milestonesMenu != null) {
            this.milestonesMenu.open(player, source);
        }
    }



    @NotNull
    public List<String> getCrateIds() {
        return new ArrayList<>(this.crateByIdMap.keySet());
    }

    @NotNull
    public Map<String, Crate> getCratesMap() {
        return this.crateByIdMap;
    }

    @NotNull
    public Set<Crate> getCrates() {
        return new HashSet<>(this.crateByIdMap.values());
    }

    public boolean isCrate(@NotNull ItemStack item) {
        return this.getCrateByItem(item) != null;
    }

    @Nullable
    public Crate getCrateById(@NotNull String id) {
        return this.crateByIdMap.get(id.toLowerCase());
    }

    @Nullable
    public Crate getCrateByItem(@NotNull ItemStack item) {
        String id = PDCUtil.getString(item, Keys.crateId).orElse(null);
        return id != null ? this.getCrateById(id) : null;
    }

    @Nullable
    public Crate getCrateByBlock(@NotNull Block block) {
        return this.getCrateByLocation(block.getLocation());
    }

    @Nullable
    public Crate getCrateByLocation(@NotNull Location location) {
        WorldPos pos = WorldPos.from(location);
        return this.crateByPosMap.get(pos);
    }

    public void removeCratePositions(@NotNull Crate crate) {
        crate.getBlockPositions().forEach(this.crateByPosMap::remove);
    }

    public void addCratePositions(@NotNull Crate crate) {
        crate.getBlockPositions().forEach(pos -> this.crateByPosMap.put(pos, crate));
    }

<<<<<<< HEAD
    public boolean create(@NotNull String id) {
        id = CrateUtils.createID(id);
        if (this.getCrateById(id) != null) return false;

        File file = new File(plugin.getDataFolder() + Config.DIR_CRATES, id + ".yml");
        FileUtil.create(file);

        String name = StringUtil.capitalizeUnderscored(id) + " Crate";
        ItemStack item = NightItem.asCustomHead(Placeholders.SKULL_CRATE)
            .setDisplayName(name)
            .hideAllComponents()
            .getItemStack();

        Crate crate = new Crate(this.plugin, file);
        crate.setName(name);
        crate.setDescription(new ArrayList<>());
        crate.setItemProvider(ItemTypes.vanilla(item));
        crate.setAnimationEnabled(true);
        crate.setAnimationId(Placeholders.DEFAULT);
=======
    public void createCrate(@NotNull String id) {
        Path path = Path.of(this.plugin.getDataFolder() + Config.DIR_CRATES, FileConfig.withExtension(id));
        FileUtil.createFileIfNotExists(path);

        Crate crate = new Crate(this.plugin, path, id);
        crate.setName(StringUtil.capitalizeUnderscored(id) + " Crate");
        crate.setDescription(new ArrayList<>());
        crate.setItem(ItemHelper.vanilla(CrateUtils.getDefaultItem(crate)));
        crate.setOpeningEnabled(true);
        crate.setOpeningId(Placeholders.DEFAULT);
>>>>>>> upstream/master
        crate.setPreviewEnabled(true);
        crate.setPreviewId(Placeholders.DEFAULT);
        crate.setPushbackEnabled(true);
        crate.setHologramEnabled(true);
        crate.setHologramTemplateId(Placeholders.DEFAULT);
        crate.setEffectType(EffectId.HELIX);
        crate.setEffectParticle(UniParticle.of(Particle.CLOUD));
<<<<<<< HEAD
        crate.save();

        this.loadCrate(crate);
        return true;
    }

    public boolean delete(@NotNull Crate crate) {
        if (!crate.getFile().delete()) return false;
=======
        crate.saveForce();

        this.loadCrate(crate);
    }

    public boolean delete(@NotNull Crate crate) {
        try {
            if (!Files.deleteIfExists(crate.getPath())) return false;
        }
        catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }
>>>>>>> upstream/master

        crate.removeHologram();

        this.plugin.getDataManager().handleCrateRemoval(crate);
        this.crateByIdMap.remove(crate.getId());
        this.crateByPosMap.values().removeIf(stored -> stored == crate);
        return true;
    }

<<<<<<< HEAD
=======
    public void giveLinkTool(@NotNull Player player, @NotNull Crate crate) {
        ItemStack itemStack = Config.CRATE_LINK_TOOL.get().getItemStack();
        PDCUtil.set(itemStack, Keys.linkToolCrateId, crate.getId());
        Players.addItem(player, itemStack);
    }

    /*public boolean isLinkTool(@NotNull ItemStack itemStack) {
        return PDCUtil.getString(itemStack, Keys.linkToolCrateId).isPresent();
    }

    @Nullable
    public Crate getLinkToolCrate(@NotNull Player player, @NotNull ItemStack itemStack) {
        return PDCUtil.getString(itemStack, Keys.linkToolCrateId).map(this::getCrateById).orElse(null);
    }*/

    public boolean handleLinkToolInteraction(@NotNull Player player, @NotNull Block block, @NotNull ItemStack itemStack, @NotNull PlayerInteractEvent event) {
        String crateId = PDCUtil.getString(itemStack, Keys.linkToolCrateId).orElse(null);
        if (crateId == null) return false;

        itemStack.setAmount(0);
        event.setUseItemInHand(Event.Result.DENY);
        event.setUseInteractedBlock(Event.Result.DENY);

        Crate crate = this.getCrateById(crateId);
        if (crate != null) {
            crate.clearBlockPositions();
            crate.addBlockPosition(block.getLocation());
            crate.recreateHologram();
            crate.markDirty();
            this.plugin.getEditorManager().openOptionsMenu(player, crate);
        }

        return true;
    }

>>>>>>> upstream/master
    public boolean dropCrateItem(@NotNull Crate crate, @NotNull Location location) {
        World world = location.getWorld();
        if (world == null) return false;

<<<<<<< HEAD
        world.dropItemNaturally(location, crate.getItem());
=======
        world.dropItemNaturally(location, crate.getItemStack());
>>>>>>> upstream/master
        return true;
    }

    public void giveCrateItem(@NotNull Player player, @NotNull Crate crate, int amount) {
        amount = Math.max(1, amount);

<<<<<<< HEAD
        ItemStack crateItem = crate.getItem();
        Players.addItem(player, crateItem, amount);
    }

=======
        ItemStack crateItem = crate.getItemStack();
        Players.addItem(player, crateItem, amount);
    }

    public void openCostMenu(@NotNull Player player, @NotNull CrateSource source) {
        this.costMenu.open(player, source);
    }

    public void openAmountMenu(@NotNull Player player, @NotNull CrateSource source, @Nullable Cost cost) {
        this.amountMenu.open(player, source, cost);
    }

>>>>>>> upstream/master
    public void previewCrate(@NotNull Player player, @NotNull CrateSource source) {
        Crate crate = source.getCrate();
        if (!crate.isPreviewEnabled()) return;

        PreviewMenu menu = this.getPreviewById(crate.getPreviewId());
        if (menu == null) return;

        menu.open(player, source);
    }

    public void interactCrate(@NotNull Player player, @NotNull Crate crate, @NotNull InteractType action, @Nullable ItemStack item, @Nullable Block block) {
<<<<<<< HEAD
        //player.closeInventory();

=======
>>>>>>> upstream/master
        CrateSource source = new CrateSource(crate, item, block);

        if (action == InteractType.CRATE_PREVIEW) {
            this.previewCrate(player, source);
            return;
        }

<<<<<<< HEAD
        if (action == InteractType.CRATE_OPEN || action == InteractType.CRATE_MASS_OPEN) {
            OpenSettings settings = new OpenSettings().setSkipAnimation(action == InteractType.CRATE_MASS_OPEN);

            int keys = plugin.getKeyManager().getKeysAmount(player, crate);
            int openings = action == InteractType.CRATE_MASS_OPEN && crate.isKeyRequired() ? Math.max(1, keys) : 1;
            int massLimit = Math.max(1, Config.CRATE_MASS_OPENING_LIMIT.get());
            if (openings > massLimit) {
                openings = massLimit;
            }

            for (int spent = 0; spent < openings; spent++) {
                if (!this.openCrate(player, source, settings)) {
                    if (spent == 0 && block != null && crate.isPushbackEnabled()) {
                        player.setVelocity(player.getEyeLocation().getDirection().setY(Config.CRATE_PUSHBACK_Y.get()).multiply(Config.CRATE_PUSHBACK_MULTIPLY.get()));
                    }
                    break;
                }
=======
        this.preOpenCrate(player, source);
    }

    public void preOpenCrate(@NotNull Player player, @NotNull CrateSource source) {
        Crate crate = source.getCrate();

        // Check if it's possible for a player to open crates.
        if (!this.testRestrictions(player, crate)) {
            this.pushback(player, source);
            return;
        }

        if (!crate.hasCost()) {
            if (Config.MASS_OPENING_ALLOW_FOR_NO_COST.get()) {
                if (Config.MASS_OPENING_SNEAK_TO_USE.get() && player.isSneaking()) {
                    this.multiOpenCrate(player, source, OpenOptions.empty(), null, Config.MASS_OPENING_LIMIT.get());
                }
                else {
                    this.openAmountMenu(player, source, null);
                }
            }
            else {
                this.openCrate(player, source, OpenOptions.empty(), null);
            }
            return;
        }

        if (crate.hasMultipleCosts() || Config.OPENING_CONFIRM_FOR_SINGLE_COST.get()) {
            this.openCostMenu(player, source);
            return;
        }

        Cost cost = crate.getFirstCost().orElse(null);

        if (Config.MASS_OPENING_SNEAK_TO_USE.get() && player.isSneaking()) {
            this.multiOpenCrate(player, source, OpenOptions.empty(), cost, crate.countMaxOpenings(player));
        }
        else {
            this.openCrate(player, source, OpenOptions.empty(), cost);
        }
    }

    public void multiOpenCrate(@NotNull Player player, @NotNull CrateSource source, @NotNull OpenOptions options, @Nullable Cost cost, int amount) {
        int massLimit = Config.MASS_OPENING_LIMIT.get();
        int openings = Math.clamp(amount, 1, massLimit);

        if (openings > 1) {
            options.with(OpenOptions.Option.IGNORE_ANIMATION);
        }

        for (int spent = 0; spent < openings; spent++) {
            if (!this.openCrate(player, source, options, cost)) {
                break;
>>>>>>> upstream/master
            }
        }
    }

<<<<<<< HEAD
    public boolean openCrate(@NotNull Player player, @NotNull CrateSource source, @NotNull OpenSettings settings) {
        // Wait until crate datas and reward limits are loaded.
        if (!this.plugin.getDataManager().isDataLoaded()) {
=======
    private boolean testRestrictions(@NotNull Player player, @NotNull Crate crate) {
        // Wait until crate datas and reward limits are loaded.
        if (!this.plugin.getDataManager().isDataLoaded()) {
            Lang.ERROR_DATA_IS_LOADING.message().send(player);
>>>>>>> upstream/master
            return false;
        }

        // Check if player is in other opening or if crate block is occupied by others.
<<<<<<< HEAD
        if (!this.plugin.getOpeningManager().isOpeningAvailable(player, source)) {
            Lang.CRATE_OPEN_ERROR_ALREADY.getMessage().send(player);
            return false;
        }

        // Stop mass open (mostly only this case) if crate itemstack is out.
        if (source.getItem() != null && source.getItem().getAmount() <= 0) {
            return false;
        }

        Crate crate = source.getCrate();
        if (!settings.isForce() && !crate.hasPermission(player)) {
            Lang.ERROR_NO_PERMISSION.getMessage(plugin).send(player);
            return false;
        }

        if (!settings.isForce() && player.getInventory().firstEmpty() == -1) {
            Lang.CRATE_OPEN_ERROR_INVENTORY_SPACE.getMessage().send(player, replacer -> replacer.replace(crate.replacePlaceholders()));
            return false;
        }

        CrateKey key = null;
        CrateUser user = plugin.getUserManager().getOrFetch(player);
        UserCrateData crateData = user.getCrateData(crate);

        if (!settings.isForce() && crate.hasOpenCooldown() && crateData.hasCooldown()) {
            (crateData.isCooldownPermanent() ? Lang.CRATE_OPEN_ERROR_COOLDOWN_ONE_TIMED : Lang.CRATE_OPEN_ERROR_COOLDOWN_TEMPORARY).getMessage().send(player, replacer -> replacer
                .replace(Placeholders.GENERIC_TIME, TimeFormats.formatDuration(crateData.getOpenCooldown(), TimeFormatType.LITERAL))
                .replace(crate.replacePlaceholders())
            );
            return false;
        }

        if (!settings.isForce() && crate.isKeyRequired()) {
            key = this.plugin.getKeyManager().getOpenKey(player, crate);
            if (key == null) {
                boolean holdRequired = Config.isKeyHoldRequired() && !crate.isAllVirtualKeys();
                (holdRequired ? Lang.CRATE_OPEN_ERROR_NO_HOLD_KEY : Lang.CRATE_OPEN_ERROR_NO_KEY).getMessage().send(player, replacer -> replacer.replace(crate.replacePlaceholders()));
                return false;
            }
        }

        if (!settings.isForce() && !crate.canAffordOpen(player)) {
            Lang.CRATE_OPEN_ERROR_TOO_EXPENSIVE.getMessage().send(player, replacer -> replacer.replace(crate.replacePlaceholders()));
=======
        if (!this.plugin.getOpeningManager().isOpeningAvailable(player)) {
            Lang.CRATE_OPEN_ERROR_ALREADY.message().send(player);
            return false;
        }

        if (player.getInventory().firstEmpty() == -1) {
            Lang.CRATE_OPEN_ERROR_INVENTORY_SPACE.message().send(player);
>>>>>>> upstream/master
            return false;
        }

        if (crate.getRewards(player).isEmpty()) {
<<<<<<< HEAD
            Lang.CRATE_OPEN_ERROR_NO_REWARDS.getMessage().send(player, replacer -> replacer.replace(crate.replacePlaceholders()));
=======
            Lang.CRATE_OPEN_ERROR_NO_REWARDS.message().send(player, replacer -> replacer.replace(crate.replacePlaceholders()));
            return false;
        }

        return true;
    }

    public boolean openCrate(@NotNull Player player, @NotNull CrateSource source, @NotNull OpenOptions options, @Nullable Cost cost) {
        Crate crate = source.getCrate();
        CrateUser user = plugin.getUserManager().getOrFetch(player);
        UserCrateData userCrate = user.getCrateData(crate);
        Cost realCost = options.has(OpenOptions.Option.IGNORE_COST) ? null : cost;

        if (!this.testRestrictions(player, crate)) {
            this.pushback(player, source);
            return false;
        }

        // Ensure the inventory item used to open a crate does still exist.
        if (source.getItem() != null && source.getItem().getAmount() <= 0) {
            return false;
        }

        if (!options.has(OpenOptions.Option.IGNORE_PERMISSION) && !crate.hasPermission(player)) {
            CoreLang.ERROR_NO_PERMISSION.withPrefix(this.plugin).send(player);
            this.pushback(player, source);
            return false;
        }

        if (!options.has(OpenOptions.Option.IGNORE_COOLDOWN) && crate.isOpeningCooldownEnabled() && userCrate.isOnCooldown()) {
            int openLimit = crate.getOpeningLimitAmount();
            int openStreak = userCrate.queryOpeningStreak();
            int remaining = openLimit - openStreak;

            if (remaining <= 0) {
                (userCrate.isCooldownPermanent() ? Lang.CRATE_OPEN_ERROR_COOLDOWN_ONE_TIMED : Lang.CRATE_OPEN_ERROR_COOLDOWN_TEMPORARY).message().send(player, replacer -> replacer
                    .replace(Placeholders.GENERIC_TIME, TimeFormats.formatDuration(userCrate.getCooldownTimestamp(), TimeFormatType.LITERAL))
                    .replace(crate.replacePlaceholders())
                );
                this.pushback(player, source);
                return false;
            }
        }

        if (realCost != null && !realCost.canAfford(player)) {
            Lang.CRATE_OPEN_TOO_EXPENSIVE.message().send(player, replacer -> replacer
                .replace(crate.replacePlaceholders())
                .replace(Placeholders.GENERIC_COSTS, () -> realCost.formatInline(", ")) // TODO Delimiter lang
            );
            this.pushback(player, source);
>>>>>>> upstream/master
            return false;
        }

        CrateOpenEvent openEvent = new CrateOpenEvent(crate, player);
        plugin.getPluginManager().callEvent(openEvent);
<<<<<<< HEAD
        if (openEvent.isCancelled()) return false;

        player.closeInventory(); // Cheat clients must die

        Opening opening = this.plugin.getOpeningManager().createOpening(player, source, key);
        opening.setRefundable(!settings.isForce());

        this.plugin.getOpeningManager().startOpening(player, opening, settings.isSkipAnimation());

        if (!settings.isForce()) {
            // Take costs
            crate.payForOpen(player);

            // Take key
            if (crate.isKeyRequired() && key != null) {
                this.plugin.getKeyManager().takeKey(player, key, 1);
            }

            // Take crate item stack
            ItemStack item = source.getItem();
            if (item != null) {
                item.setAmount(item.getAmount() - 1);
            }
=======
        if (openEvent.isCancelled()) {
            this.pushback(player, source);
            return false;
        }

        player.closeInventory(); // Cheat clients must die

        Opening opening = this.plugin.getOpeningManager().createOpening(player, source, realCost);

        this.plugin.getOpeningManager().startOpening(player, opening, options.has(OpenOptions.Option.IGNORE_ANIMATION));

        if (realCost != null) {
            realCost.takeAll(player);
        }

        ItemStack item = source.getItem();
        if (item != null) {
            item.setAmount(item.getAmount() - 1);
>>>>>>> upstream/master
        }

        return true;
    }

<<<<<<< HEAD
=======
    private void pushback(@NotNull Player player, @NotNull CrateSource source) {
        if (source.hasBlock() && source.getCrate().isPushbackEnabled()) {
            player.setVelocity(player.getEyeLocation().getDirection().setY(Config.CRATE_PUSHBACK_Y.get()).multiply(Config.CRATE_PUSHBACK_MULTIPLY.get()));
        }
    }

>>>>>>> upstream/master
    public boolean triggerMilestones(@NotNull Player player, @NotNull Crate crate, int progress) {
        if (!crate.hasMilestones()) return false;

        int maxProgress = crate.getMaxMilestone();
        if (!crate.isMilestonesRepeatable() && progress > maxProgress) return false;

        Milestone milestone = crate.getMilestone(progress);
        if (milestone == null) return false;

        Reward reward = milestone.getReward();
        if (reward == null) return false;

        reward.giveContent(player);

<<<<<<< HEAD
        Lang.CRATE_OPEN_MILESTONE_COMPLETED.getMessage().send(player, replacer -> replacer
=======
        Lang.CRATE_OPEN_MILESTONE_COMPLETED.message().send(player, replacer -> replacer
>>>>>>> upstream/master
            .replace(crate.replacePlaceholders())
            .replace(Placeholders.MILESTONE_OPENINGS, NumberUtil.format(progress))
            .replace(reward.replacePlaceholders())
        );

        return true;
    }

    public void giveReward(@NotNull Player player, @NotNull Reward reward) {
        reward.giveContent(player);

        Crate crate = reward.getCrate();
        GlobalCrateData globalData = this.plugin.getDataManager().getCrateDataOrCreate(crate);

        globalData.setLatestReward(reward);
<<<<<<< HEAD
        globalData.setSaveRequired(true);

        Lang.CRATE_OPEN_REWARD_INFO.getMessage().send(player, replacer -> replacer
            .replace(crate.replacePlaceholders())
            .replace(reward.replacePlaceholders())
        );

        if (reward.isBroadcast()) {
            Lang.CRATE_OPEN_REWARD_BROADCAST.getMessage().broadcast(replacer -> replacer
=======
        globalData.setDirty(true);

        if (reward.isBroadcast()) {
            Lang.CRATE_OPEN_REWARD_BROADCAST.message().broadcast(replacer -> replacer
>>>>>>> upstream/master
                .replace(Placeholders.forPlayerWithPAPI(player))
                .replace(crate.replacePlaceholders())
                .replace(reward.replacePlaceholders())
            );
        }

        this.addRollCount(player, reward);
        this.plugin.getCrateLogger().logReward(player, reward);
<<<<<<< HEAD
    }

    public int getGlobalRollsLeft(@NotNull Reward reward) {
        if (!reward.hasGlobalLimit()) return -1;

        RewardLimit limit = this.plugin.getDataManager().getRewardLimit(reward, null);
        if (limit == null) return reward.getGlobalLimits().getAmount();

        limit.resetIfReady();

        return Math.max(0, reward.getGlobalLimits().getAmount() - limit.getAmount());
    }

    public int getPersonalRollsLeft(@NotNull Reward reward, @NotNull Player player) {
        if (!reward.hasPersonalLimit()) return -1;

        RewardLimit limit = this.plugin.getDataManager().getRewardLimit(reward, player);
        if (limit == null) return reward.getPlayerLimits().getAmount();

        limit.resetIfReady();

        return Math.max(0, reward.getPlayerLimits().getAmount() - limit.getAmount());
    }

    public int getAvailableRolls(@NotNull Player player, @NotNull Reward reward) {
        int globalLeft = this.getGlobalRollsLeft(reward);
        int playerLeft = this.getPersonalRollsLeft(reward, player);

        if (globalLeft < 0 || playerLeft < 0) {
            return Math.max(playerLeft, globalLeft);
        }

        return Math.min(playerLeft, globalLeft);
    }

    public void addRollCount(@NotNull Player player, @NotNull Reward reward) {
        if (player.hasPermission(Perms.BYPASS_REWARD_LIMIT)) return;

        if (reward.hasGlobalLimit()) {
            RewardLimit limit = this.plugin.getDataManager().getRewardLimitOrCreate(reward, null);
            limit.resetIfReady();

            limit.addRoll(1);
            limit.updateResetTime(reward.getGlobalLimits());
            limit.setSaveRequired(true);
        }

        if (reward.hasPersonalLimit()) {
            RewardLimit limit = this.plugin.getDataManager().getRewardLimitOrCreate(reward, player);
            limit.resetIfReady();

            limit.addRoll(1);
            limit.updateResetTime(reward.getPlayerLimits());
            limit.setSaveRequired(true);
=======

        CrateObtainRewardEvent event = new CrateObtainRewardEvent(reward, player);
        this.plugin.getPluginManager().callEvent(event);
    }

    public void addRollCount(@NotNull Player player, @NotNull Reward reward) {
        LimitValues limits = reward.getLimits();
        if (!limits.isEnabled()) return;

        if (limits.hasGlobalCooldown() || limits.isGlobalAmountLimited()) {
            RewardData globalData = this.plugin.getDataManager().getRewardLimitOrCreate(reward, null);
            if (limits.hasGlobalCooldown()) {
                globalData.setCooldownUntil(limits.generateGlobalCooldown());
            }
            if (limits.isGlobalAmountLimited()) {
                globalData.addRoll(1);
            }
            globalData.setSaveRequired(true);
        }

        if (limits.hasPlayerCooldown() || limits.isPlayerAmountLimited()) {
            RewardData playerData = this.plugin.getDataManager().getRewardLimitOrCreate(reward, player);
            if (limits.hasPlayerCooldown()) {
                playerData.setCooldownUntil(limits.generatePlayerCooldown());
            }
            if (limits.isPlayerAmountLimited()) {
                playerData.addRoll(1);
            }
            playerData.setSaveRequired(true);
>>>>>>> upstream/master
        }
    }

    public void setPreviewCooldown(@NotNull Player player) {
        long timestamp = System.currentTimeMillis() + Config.CRATE_PREVIEW_COOLDOWN.get();
        this.previewCooldown.put(player.getUniqueId(), timestamp);
    }

    public long getPreviewCooldown(@NotNull Player player) {
        long timestamp = this.previewCooldown.getOrDefault(player.getUniqueId(), 0L);
        if (System.currentTimeMillis() < timestamp) {
            return timestamp;
        }

        this.removePreviewCooldown(player);
        return 0L;
    }

    public boolean hasPreviewCooldown(@NotNull Player player) {
        return this.getPreviewCooldown(player) > 0L;
    }

    public void removePreviewCooldown(@NotNull Player player) {
        this.previewCooldown.remove(player.getUniqueId());
    }

    public void playCrateEffects() {
        this.getCrates().forEach(crate -> {
<<<<<<< HEAD
=======
            if (!crate.isEffectEnabled()) return;

>>>>>>> upstream/master
            CrateEffect effect = crate.getEffect();
            if (effect.isDummy()) return;

            UniParticle particle = crate.getEffectParticle();

            crate.getBlockPositions().forEach(worldPos -> {
                if (!worldPos.isChunkLoaded()) return;

                Location location = worldPos.toLocation();
                if (location == null) return;

                CrateUtils.getPlayersForEffects(location).forEach(player -> {
                    effect.playStep(location, particle, player);
                });
            });
        });

<<<<<<< HEAD
        EffectRegistry.getEffects().forEach(CrateEffect::addTickCount);
=======
        CratesRegistries.getEffects().forEach(CrateEffect::addTickCount);
>>>>>>> upstream/master
    }
}

package su.nightexpress.excellentcrates.key;

<<<<<<< HEAD
=======
import org.bukkit.Material;
>>>>>>> upstream/master
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.CratesPlugin;
import su.nightexpress.excellentcrates.Placeholders;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.api.item.ItemProvider;
import su.nightexpress.excellentcrates.config.Keys;
import su.nightexpress.excellentcrates.item.ItemTypes;
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.nightcore.manager.AbstractFileData;
import su.nightexpress.nightcore.util.ItemUtil;
import su.nightexpress.nightcore.util.PDCUtil;
import su.nightexpress.nightcore.util.bukkit.NightItem;
import su.nightexpress.nightcore.util.text.NightMessage;

import java.io.File;
import java.util.function.UnaryOperator;

public class CrateKey extends AbstractFileData<CratesPlugin> {

    private String       name;
    private boolean      virtual;
    private ItemProvider provider;
    private boolean itemStackable;

    public CrateKey(@NotNull CratesPlugin plugin, @NotNull File file) {
        super(plugin, file);
    }

    @Override
    protected boolean onLoad(@NotNull FileConfig config) {
=======
import su.nightexpress.excellentcrates.config.Keys;
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.excellentcrates.util.ItemHelper;
import su.nightexpress.nightcore.bridge.item.AdaptedItem;
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.nightcore.manager.ConfigBacked;
import su.nightexpress.nightcore.util.ItemUtil;
import su.nightexpress.nightcore.util.PDCUtil;
import su.nightexpress.nightcore.util.bukkit.NightItem;
import su.nightexpress.nightcore.util.problem.ProblemCollector;
import su.nightexpress.nightcore.util.problem.ProblemReporter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.UnaryOperator;

public class CrateKey implements ConfigBacked {

    private final Path path;
    private final String id;

    private String      name;
    private boolean     virtual;
    private AdaptedItem item;
    private boolean     itemStackable;

    private boolean dirty;

    public CrateKey(@NotNull CratesPlugin plugin, @NotNull Path path, @NotNull String id) {
        this.path = path;
        this.id = id;
    }

    public void load() throws IllegalStateException {
        if (!this.hasFile()) {
            // TODO Throw
            return;
        }

        this.loadConfig().edit(this::load);
    }

    private void load(@NotNull FileConfig config) throws IllegalStateException {
>>>>>>> upstream/master
        this.setName(config.getString("Name", this.getId()));
        this.setVirtual(config.getBoolean("Virtual"));

        if (config.contains("Item")) {
            NightItem item = config.getCosmeticItem("Item");
<<<<<<< HEAD
            ItemProvider provider = ItemTypes.vanilla(item.getItemStack());

            config.remove("Item");
            config.set("ItemData", provider);
        }

        this.setProvider(ItemTypes.read(config, "ItemData"));
        this.setItemStackable(config.getBoolean("ItemStackable", true));
        return true;
    }

    @Override
    protected void onSave(@NotNull FileConfig config) {
        config.set("Name", this.name);
        config.set("Virtual", this.virtual);
        config.set("ItemData", this.provider);
=======
            AdaptedItem adaptedItem = ItemHelper.vanilla(item.getItemStack());

            config.remove("Item");
            config.set("ItemData", adaptedItem);
        }

        this.setItem(ItemHelper.read(config, "ItemData").orElse(ItemHelper.vanilla(new ItemStack(Material.TRIAL_KEY))));
        this.setItemStackable(config.getBoolean("ItemStackable", true));
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
        config.set("Name", this.name);
        config.set("Virtual", this.virtual);
        config.set("ItemData", this.item);
>>>>>>> upstream/master
        config.set("ItemStackable", this.itemStackable);
    }

    @NotNull
    public UnaryOperator<String> replacePlaceholders() {
        return Placeholders.KEY.replacer(this);
    }

<<<<<<< HEAD
    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getNameTranslated() {
        return NightMessage.asLegacy(this.name);
=======
    public ProblemReporter collectProblems() {
        ProblemReporter reporter = new ProblemCollector(this.name, this.path.toString());

        if (!this.item.isValid()) reporter.report(Lang.INSPECTIONS_GENERIC_ITEM.get(false));

        return reporter;
    }

    public void markDirty() {
        this.dirty = true;
    }

    public boolean hasFile() {
        return Files.exists(this.path);
    }

    public boolean hasProblems() {
        return !this.collectProblems().isEmpty();
    }

    @Override
    @NotNull
    public Path getPath() {
        return this.path;
    }

    @NotNull
    public String getId() {
        return this.id;
    }

    @NotNull
    public String getName() {
        return this.name;
>>>>>>> upstream/master
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public boolean isVirtual() {
        return this.virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

<<<<<<< HEAD


    @NotNull
    public ItemStack getRawItem() {
        ItemStack itemStack = this.provider.getItemStack();
        ItemUtil.editMeta(itemStack, meta -> {
            meta.setDisplayName(this.getNameTranslated());
        });
        return itemStack;
    }

    @NotNull
    public ItemStack getItem() {
        ItemStack item = this.getRawItem();
        ItemUtil.editMeta(item, meta -> {
            if (!this.isItemStackable()) meta.setMaxStackSize(1);
            PDCUtil.set(meta, Keys.keyId, this.getId());
=======
    @NotNull
    public ItemStack getRawItem() {
        return this.getItemStack(false);
    }

    @NotNull
    public ItemStack getItemStack() {
        return this.getItemStack(true);
    }

    @NotNull
    public ItemStack getItemStack(boolean fullData) {
        ItemStack item = ItemHelper.toItemStack(this.item);
        ItemUtil.editMeta(item, meta -> {
            if (fullData) {
                meta.setMaxStackSize(this.itemStackable ? null : 1);
                PDCUtil.set(meta, Keys.keyId, this.getId());
            }
>>>>>>> upstream/master
        });
        return item;
    }

    public boolean isItemStackable() {
        return this.itemStackable;
    }

    public void setItemStackable(boolean itemStackable) {
        this.itemStackable = itemStackable;
    }

    @NotNull
<<<<<<< HEAD
    public ItemProvider getProvider() {
        return this.provider;
    }

    public void setProvider(@NotNull ItemProvider provider) {
        this.provider = provider;
=======
    public AdaptedItem getItem() {
        return this.item;
    }

    public void setItem(@NotNull AdaptedItem item) {
        this.item = item;
>>>>>>> upstream/master
    }
}

package su.nightexpress.excellentcrates.crate.reward.impl;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.CratesPlugin;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.Placeholders;
import su.nightexpress.excellentcrates.api.crate.RewardType;
import su.nightexpress.excellentcrates.api.item.ItemProvider;
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.crate.impl.Rarity;
import su.nightexpress.excellentcrates.crate.reward.AbstractReward;
import su.nightexpress.excellentcrates.item.ItemTypes;
import su.nightexpress.excellentcrates.util.CrateUtils;
=======
import su.nightexpress.excellentcrates.api.crate.RewardType;
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.crate.impl.Rarity;
import su.nightexpress.excellentcrates.crate.reward.AbstractReward;
import su.nightexpress.excellentcrates.util.CrateUtils;
import su.nightexpress.excellentcrates.util.ItemHelper;
import su.nightexpress.nightcore.bridge.item.AdaptedItem;
>>>>>>> upstream/master
import su.nightexpress.nightcore.config.ConfigValue;
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.nightcore.util.ItemNbt;
import su.nightexpress.nightcore.util.ItemUtil;
import su.nightexpress.nightcore.util.Players;
import su.nightexpress.nightcore.util.placeholder.Replacer;
<<<<<<< HEAD

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class ItemReward extends AbstractReward {

    private boolean customPreview;
    private List<ItemProvider> items;
=======
import su.nightexpress.nightcore.util.problem.ProblemReporter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ItemReward extends AbstractReward {

    private boolean           customPreview;
    private boolean           allowItemPlaceholders;
    private List<AdaptedItem> items;
>>>>>>> upstream/master

    public ItemReward(@NotNull CratesPlugin plugin, @NotNull Crate crate, @NotNull String id, @NotNull Rarity rarity) {
        super(plugin, crate, id, rarity);
        this.items = new ArrayList<>();
<<<<<<< HEAD
        this.setPreview(ItemTypes.DUMMY);
=======
>>>>>>> upstream/master
    }

    @Override
    protected void loadAdditional(@NotNull FileConfig config, @NotNull String path) {
        if (config.contains(path + ".Items")) {
            int count = 0;
            for (String encoded : config.getStringList(path + ".Items")) {
                ItemStack itemStack = ItemNbt.decompress(encoded);
                if (itemStack == null) return;

<<<<<<< HEAD
                ItemProvider provider = ItemTypes.vanilla(itemStack);
=======
                AdaptedItem provider = ItemHelper.vanilla(itemStack);
>>>>>>> upstream/master
                config.set(path + ".ItemsData." + count++, provider);
            }
            config.remove(path + ".Items");
        }

        this.setCustomPreview(ConfigValue.create(path + ".Custom_Preview", false).read(config));
<<<<<<< HEAD

        config.getSection(path + ".ItemsData").forEach(sId -> {
            ItemProvider provider = ItemTypes.read(config, path + ".ItemsData." + sId);
            this.items.add(provider);
=======
        this.setAllowItemPlaceholders(config.getBoolean(path + ".Placeholder_Apply"));

        config.getSection(path + ".ItemsData").forEach(sId -> {
            AdaptedItem item = ItemHelper.read(config, path + ".ItemsData." + sId).orElse(null);
            if (item == null) {
                this.plugin.error("Invalid/Unknown item data at '" + config.getPath() + "' -> '" + path + ".ItemsData." + sId + "'.");
                return;
            }

            this.items.add(item);
>>>>>>> upstream/master
        });
    }

    @Override
    protected void writeAdditional(@NotNull FileConfig config, @NotNull String path) {
        config.set(path + ".Custom_Preview", this.customPreview);
<<<<<<< HEAD
        config.remove(path + ".ItemsData");

        int count = 0;
        for (ItemProvider provider : this.items) {
            if (provider.isDummy()) continue;

=======
        config.set(path + ".Placeholder_Apply", this.allowItemPlaceholders);
        config.remove(path + ".ItemsData");

        int count = 0;
        for (AdaptedItem provider : this.items) {
>>>>>>> upstream/master
            config.set(path + ".ItemsData." + count++, provider);
        }
    }

    @Override
<<<<<<< HEAD
    @NotNull
    public UnaryOperator<String> replaceAllPlaceholders() {
        return Placeholders.ITEM_REWARD_EDITOR.replacer(this);
=======
    protected void collectAdditionalProblems(@NotNull ProblemReporter reporter) {
        if (!this.hasContent()) {
            reporter.report(Lang.INSPECTIONS_REWARD_NO_ITEMS.text());
        }
        else if (this.hasInvalidItems()) {
            reporter.report(Lang.INSPECTIONS_REWARD_ITEMS.get(false));
        }
        if (this.customPreview && !this.preview.isValid()) {
            reporter.report(Lang.INSPECTIONS_REWARD_PREVIEW.get(false));
        }
>>>>>>> upstream/master
    }

    @Override
    @NotNull
    public RewardType getType() {
        return RewardType.ITEM;
    }

    @Override
    public boolean hasContent() {
        return !this.items.isEmpty();
    }

    public boolean hasInvalidItems() {
<<<<<<< HEAD
        return this.items.stream().anyMatch(provider -> !provider.canProduceItem());
=======
        return this.items.stream().anyMatch(Predicate.not(AdaptedItem::isValid));
    }

    public int countItems() {
        return this.items.size();
>>>>>>> upstream/master
    }

    @Override
    public void giveContent(@NotNull Player player) {
        Replacer replacer = this.createContentReplacer(player);

        this.getItems().forEach(provider -> {
            ItemStack itemStack = provider.getItemStack();
<<<<<<< HEAD
            if (ItemTypes.isDummy(itemStack)) return;

            if (this.placeholderApply) {
                replacer.apply(itemStack);
=======
            if (itemStack == null) return;

            if (this.allowItemPlaceholders) {
                ItemUtil.editMeta(itemStack, meta -> {
                    if (meta.hasItemName()) {
                        meta.setItemName(replacer.apply(String.valueOf(ItemUtil.getItemNameSerialized(meta))));
                    }
                    if (meta.hasDisplayName()) {
                        meta.setDisplayName(replacer.apply(String.valueOf(ItemUtil.getCustomNameSerialized(meta))));
                    }
                    if (meta.hasLore()) {
                        meta.setLore(replacer.apply(ItemUtil.getLoreSerialized(meta)));
                    }
                });
>>>>>>> upstream/master
            }

            Players.addItem(player, itemStack);
        });
    }

    public boolean isCustomPreview() {
        return this.customPreview;
    }

    public void setCustomPreview(boolean customPreview) {
        this.customPreview = customPreview;
    }

<<<<<<< HEAD
=======
    public void setAllowItemPlaceholders(boolean allowItemPlaceholders) {
        this.allowItemPlaceholders = allowItemPlaceholders;
    }

    public boolean isAllowItemPlaceholders() {
        return this.allowItemPlaceholders;
    }

>>>>>>> upstream/master
    @NotNull
    public String getName() {
        return ItemUtil.getNameSerialized(this.getPreviewItem());
    }

    @Override
    @NotNull
    public List<String> getDescription() {
        return ItemUtil.getLoreSerialized(this.getPreviewItem());
    }

    @Override
    @NotNull
    public ItemStack getPreviewItem() {
<<<<<<< HEAD
        return this.getPreview().getItemStack();
    }

    @NotNull
    public ItemProvider getPreview() {
        if (this.customPreview && this.preview.isValid()) {
            return super.getPreview();
        }

        return this.items.isEmpty() ? ItemTypes.DUMMY : this.items.getFirst();
    }

    @NotNull
    public List<ItemProvider> getItems() {
        return this.items;
    }

    public void setItems(@NotNull List<ItemProvider> items) {
        this.items = new ArrayList<>(items.stream().filter(ItemProvider::isValid).limit(CrateUtils.REWARD_ITEMS_LIMIT).toList());
    }

    public void addItem(@NotNull ItemProvider provider) {
=======
        return ItemHelper.toItemStack(this.getPreview());
    }

    @NotNull
    public AdaptedItem getPreview() {
        if (this.customPreview || this.items.isEmpty()) {
            return super.getPreview();
        }

        return this.items.getFirst();
    }

    @NotNull
    public List<AdaptedItem> getItems() {
        return this.items;
    }

    public void setItems(@NotNull List<AdaptedItem> items) {
        this.items = new ArrayList<>(items.stream().filter(AdaptedItem::isValid).limit(CrateUtils.REWARD_ITEMS_LIMIT).toList());
    }

    public void addItem(@NotNull AdaptedItem provider) {
>>>>>>> upstream/master
        if (this.items.size() >= CrateUtils.REWARD_ITEMS_LIMIT) return;
        if (!provider.isValid()) return;

        this.items.add(provider);
    }
}

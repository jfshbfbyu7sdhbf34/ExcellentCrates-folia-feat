package su.nightexpress.excellentcrates.crate.reward.impl;

<<<<<<< HEAD
import org.bukkit.Material;
=======
>>>>>>> upstream/master
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.CratesPlugin;
import su.nightexpress.excellentcrates.Placeholders;
import su.nightexpress.excellentcrates.api.crate.RewardType;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.crate.impl.Rarity;
import su.nightexpress.excellentcrates.crate.reward.AbstractReward;
import su.nightexpress.excellentcrates.item.ItemTypes;
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.nightcore.util.ItemUtil;
import su.nightexpress.nightcore.util.Lists;
import su.nightexpress.nightcore.util.Players;
import su.nightexpress.nightcore.util.StringUtil;
import su.nightexpress.nightcore.util.placeholder.Replacer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class CommandReward extends AbstractReward {

    //private ItemProvider preview;
=======
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.crate.impl.Rarity;
import su.nightexpress.excellentcrates.crate.reward.AbstractReward;
import su.nightexpress.excellentcrates.util.CrateUtils;
import su.nightexpress.excellentcrates.util.ItemHelper;
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.nightcore.util.*;
import su.nightexpress.nightcore.util.placeholder.Replacer;
import su.nightexpress.nightcore.util.problem.ProblemReporter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CommandReward extends AbstractReward {

>>>>>>> upstream/master
    private String       name;
    private List<String> description;
    private List<String> commands;

    public CommandReward(@NotNull CratesPlugin plugin, @NotNull Crate crate, @NotNull String id, @NotNull Rarity rarity) {
        super(plugin, crate, id, rarity);
        this.setName(StringUtil.capitalizeUnderscored(id));
        this.setDescription(new ArrayList<>());
        this.setCommands(new ArrayList<>());
<<<<<<< HEAD
        this.setPreview(ItemTypes.vanilla(new ItemStack(Material.COMMAND_BLOCK)));
=======
>>>>>>> upstream/master
    }

    @Override
    protected void loadAdditional(@NotNull FileConfig config, @NotNull String path) {
        this.setName(config.getString(path + ".Name", StringUtil.capitalizeUnderscored(this.getId())));
        this.setDescription(config.getStringList(path + ".Description"));
<<<<<<< HEAD
//        this.setPreview(ItemTypes.read(config, path + ".PreviewData"));
=======
>>>>>>> upstream/master
        this.setCommands(config.getStringList(path + ".Commands"));
    }

    @Override
    protected void writeAdditional(@NotNull FileConfig config, @NotNull String path) {
        config.set(path + ".Name", this.name);
        config.set(path + ".Description", this.description);
<<<<<<< HEAD
//        config.set(path + ".PreviewData", this.preview);
=======
>>>>>>> upstream/master
        config.set(path + ".Commands", this.commands);
    }

    @Override
<<<<<<< HEAD
    @NotNull
    public UnaryOperator<String> replaceAllPlaceholders() {
        return Placeholders.COMMAND_REWARD_EDITOR.replacer(this);
=======
    protected void collectAdditionalProblems(@NotNull ProblemReporter reporter) {
        if (!this.preview.isValid()) {
            reporter.report(Lang.INSPECTIONS_REWARD_PREVIEW.get(false));
        }
        if (!this.hasContent()) {
            reporter.report(Lang.INSPECTIONS_REWARD_NO_COMMANDS.text());
        }
        else {
            this.commands.stream().filter(Predicate.not(CrateUtils::isValidCommand)).forEach(command -> {
                reporter.report("Command '" + command + "' does no exist.");
            });
        }
>>>>>>> upstream/master
    }

    @Override
    @NotNull
    public RewardType getType() {
        return RewardType.COMMAND;
    }

    @Override
    public boolean hasContent() {
        return !this.commands.isEmpty();
    }

<<<<<<< HEAD
    @Override
    public void giveContent(@NotNull Player player) {
        Replacer replacer = this.createContentReplacer(player);

        this.getCommands().forEach(command -> {
            if (this.placeholderApply) {
                command = replacer.apply(command);
            }

            Players.dispatchCommand(player, command);
=======
    public int countCommands() {
        return this.commands.size();
    }

    public boolean hasInvalidCommands() {
        return this.commands.stream().anyMatch(Predicate.not(CrateUtils::isValidCommand));
    }

    @Override
    public void giveContent(@NotNull Player player) {
        Replacer replacer = this.createContentReplacer(player).replace(Placeholders.forPlayerWithPAPI(player));

        this.getCommands().forEach(command -> {
            Players.dispatchCommand(player, replacer.apply(command));
>>>>>>> upstream/master
        });
    }

    @Override
    @NotNull
    public ItemStack getPreviewItem() {
<<<<<<< HEAD
        ItemStack itemStack = this.getPreview().getItemStack();
=======
        ItemStack itemStack = ItemHelper.toItemStack(this.preview);
>>>>>>> upstream/master
        ItemUtil.editMeta(itemStack, meta -> {
            ItemUtil.setCustomName(meta, this.name);
            ItemUtil.setLore(meta, this.description);
        });
        return itemStack;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    @Override
    public List<String> getDescription() {
        return this.description;
    }

    public void setDescription(@NotNull List<String> description) {
        this.description = description;
    }

<<<<<<< HEAD
//    @NotNull
//    public ItemProvider getPreview() {
//        return this.preview;
//    }
//
//    public void setPreview(@NotNull ItemProvider provider) {
//        this.preview = provider;
//    }

=======
>>>>>>> upstream/master
    @NotNull
    public List<String> getCommands() {
        return this.commands;
    }

    public void setCommands(@NotNull List<String> commands) {
        this.commands = Lists.modify(commands, str -> str
            // Legacy placeholder validation
            .replace("[CONSOLE]", "")
            .replace("%player%", Placeholders.PLAYER_NAME)
            .trim()
        );
        this.commands.removeIf(String::isBlank);
    }
}

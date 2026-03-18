package su.nightexpress.excellentcrates.editor.crate;

import org.bukkit.Material;
import org.bukkit.entity.Player;
<<<<<<< HEAD
=======
import org.bukkit.event.inventory.ClickType;
>>>>>>> upstream/master
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MenuType;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.CratesPlugin;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.Placeholders;
import su.nightexpress.excellentcrates.api.crate.Reward;
import su.nightexpress.excellentcrates.config.EditorLang;
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.crate.impl.Rarity;
import su.nightexpress.excellentcrates.crate.reward.impl.CommandReward;
import su.nightexpress.excellentcrates.crate.reward.impl.ItemReward;
import su.nightexpress.excellentcrates.item.ItemTypes;
import su.nightexpress.nightcore.ui.UIUtils;
import su.nightexpress.nightcore.ui.dialog.Dialog;
import su.nightexpress.nightcore.ui.menu.MenuViewer;
import su.nightexpress.nightcore.ui.menu.click.ClickResult;
import su.nightexpress.nightcore.ui.menu.confirmation.Confirmation;
import su.nightexpress.nightcore.ui.menu.item.ItemOptions;
import su.nightexpress.nightcore.ui.menu.item.MenuItem;
import su.nightexpress.nightcore.ui.menu.type.LinkedMenu;
import su.nightexpress.nightcore.util.ItemUtil;
import su.nightexpress.nightcore.util.Players;
import su.nightexpress.nightcore.util.bukkit.NightItem;

import java.util.ArrayList;

public class RewardOptionsMenu extends LinkedMenu<CratesPlugin, Reward> {

    private static final String TEXTURE_COMMAND      = "c2af9b072d19455809dc9d09d9da8bb32f63ad16b015ac772acd9a9f22c77098";
    private static final String TEXTURE_ITEMS        = "86bd920b402815ad89018df82977be9f7ea19e799ecf016f7f0da4ab47ca23c5";
    private static final String TEXTURE_PERMS_GREEN  = "fae119a2382eda864b244fa8c53ac3e544163103ee66795f0cd6c64f7abb8cf1";
    private static final String TEXTURE_PERMS_RED    = "b45e85edda1a81d224adb713b13b7038d5cc6becd98a716b8a3dec7e3a0f9817";
    private static final String TEXTURE_RARITY       = "c7db2aeca61b7616888b91fbe215501c70fc72ee8165aa971c0312381d41a795";
    private static final String TEXTURE_WEIGHT       = "e0a443e0eca7f5d30622dd937f1e5ea2cdf15d10c27a199c68a7ce09c39f6b69";
    private static final String TEXTURE_BROADCAST    = "1694928bd38f42dca585be02aeff1b293ee22f7a3b1444845ba456ef745b26b1";
    private static final String TEXTURE_PLACEHOLDERS = "c7e2aa79fc62fa4f5a8919f3dd0f12ab35e2d30f8e234bfea896c4ef31eee3db";
    private static final String TEXTURE_LIMIT_ON     = "a4efb34417d95faa94f25769a21676a022d263346c8553eb5525658b34269";
    private static final String TEXTURE_LIMIT_OFF    = "915f7c313bca9c2f958e68ab14ab393867d67503affff8f20cb13fbe917fd31";

    public RewardOptionsMenu(@NotNull CratesPlugin plugin) {
        super(plugin, MenuType.GENERIC_9X6, Lang.EDITOR_TITLE_REWARD_SETTINGS.getString());
=======
import su.nightexpress.excellentcrates.api.crate.Reward;
import su.nightexpress.excellentcrates.api.crate.RewardType;
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.crate.reward.impl.CommandReward;
import su.nightexpress.excellentcrates.crate.reward.impl.ItemReward;
import su.nightexpress.excellentcrates.dialog.DialogRegistry;
import su.nightexpress.excellentcrates.crate.reward.RewardDialogs;
import su.nightexpress.excellentcrates.dialog.reward.RewardPreviewDialog;
import su.nightexpress.excellentcrates.util.ItemHelper;
import su.nightexpress.nightcore.core.config.CoreLang;
import su.nightexpress.nightcore.locale.LangContainer;
import su.nightexpress.nightcore.locale.LangEntry;
import su.nightexpress.nightcore.locale.entry.IconLocale;
import su.nightexpress.nightcore.ui.menu.MenuViewer;
import su.nightexpress.nightcore.ui.menu.click.ClickResult;
import su.nightexpress.nightcore.ui.menu.item.MenuItem;
import su.nightexpress.nightcore.ui.menu.type.LinkedMenu;
import su.nightexpress.nightcore.util.Players;
import su.nightexpress.nightcore.util.bukkit.NightItem;
import su.nightexpress.nightcore.util.text.night.wrapper.TagWrappers;

import java.util.stream.IntStream;

import static su.nightexpress.excellentcrates.Placeholders.*;
import static su.nightexpress.nightcore.util.text.night.wrapper.TagWrappers.*;

public class RewardOptionsMenu extends LinkedMenu<CratesPlugin, Reward> implements LangContainer {

    private static final IconLocale LOCALE_ITEMS = LangEntry.iconBuilder("Editor.Button.Reward.Items").name("Items to Give")
        .appendCurrent("Status", GENERIC_INSPECTION)
        .appendCurrent("Items", GENERIC_AMOUNT).br()
        .appendInfo("Gives listed items when won.").br()
        .appendClick("Click to open")
        .build();

    private static final IconLocale LOCALE_COMMANDS = LangEntry.iconBuilder("Editor.Button.Reward.Commands").name("Commands to Run")
        .appendCurrent("Status", GENERIC_INSPECTION)
        .appendCurrent("Commands", GENERIC_AMOUNT).br()
        .appendInfo("Runs listed commands when won.").br()
        .appendClick("Click to edit")
        .build();

    private static final IconLocale LOCALE_PREVIEW_NORMAL = LangEntry.iconBuilder("Editor.Button.Reward.PreviewNormal")
        .name("Preview Item")
        .appendCurrent("Status", GENERIC_INSPECTION).br()
        .appendInfo("Drop an item on " + SOFT_YELLOW.wrap("this") + " button", "to replace the reward preview.")
        .build();

    private static final IconLocale LOCALE_PREVIEW_CUSTOM = LangEntry.iconBuilder("Editor.Button.Reward.PreviewCustom")
        .name("Preview Item")
        .appendCurrent("Status", GENERIC_INSPECTION)
        .appendCurrent("Use Custom", GENERIC_STATE).br()
        .appendInfo("Drop an item on " + SOFT_YELLOW.wrap("this") + " button", "to replace the reward preview.").br()
        .appendClick("Click to toggle custom usage")
        .build();

    public static final IconLocale LOCALE_RARIRY_WEIGHT = LangEntry.iconBuilder("Editor.Button.Reward.RarityWeight")
        .name("Rarity & Weight")
        .appendCurrent("Rarity", REWARD_RARITY_NAME + " → " + SOFT_GREEN.wrap(REWARD_RARITY_ROLL_CHANCE + "%"))
        .appendCurrent("Weight", REWARD_WEIGHT + " → " + SOFT_GREEN.wrap(REWARD_ROLL_CHANCE + "%")).br()
        .appendClick("Click to change")
        .build();

    public static final IconLocale LOCALE_NAME = LangEntry.iconBuilder("Editor.Button.Reward.Name")
        .name("Display Name")
        .appendCurrent("Current", REWARD_NAME).br()
        .appendClick("Click to change")
        .build();

    public static final IconLocale LOCALE_DESCRIPTION = LangEntry.iconBuilder("Editor.Button.Reward.Description")
        .name("Description")
        .rawLore(REWARD_DESCRIPTION, EMPTY_IF_ABOVE)
        .appendClick("Click to change")
        .build();

    public static final IconLocale LOCALE_BROADCAST = LangEntry.iconBuilder("Editor.Button.Reward.Broadcast")
        .name("Win Broadcast")
        .appendCurrent("State", GENERIC_STATE).br()
        .appendInfo("Restricts player access to the reward", "based on their permissions.").br()
        .appendClick("Click to toggle")
        .build();

    public static final IconLocale LOCALE_PERMISSIONS = LangEntry.iconBuilder("Editor.Button.Reward.Permissions")
        .name("Permissions")
        .appendCurrent("Total Permissions", GENERIC_AMOUNT).br()
        .appendInfo("Restrict reward access based on", "player's permissions.").br()
        .appendClick("Click to edit")
        .build();

    public static final IconLocale LOCALE_LIMITS = LangEntry.iconBuilder("Editor.Button.Reward.Limits")
        .name("Limits")
        .appendCurrent("State", GENERIC_STATE).br()
        .appendInfo("Controls how often and how many", "times this reward can be won.").br()
        .appendClick("Click to edit")
        .build();

    public static final IconLocale LOCALE_DELETE = LangEntry.iconBuilder("Editor.Button.Reward.Delete").accentColor(SOFT_RED)
        .name("Delete Reward")
        .appendInfo("Permanently deletes the reward.").br()
        .appendClick("Press " + TagWrappers.KEY.apply("key.drop") + " to delete")
        .build();

    private final DialogRegistry dialogs;

    public RewardOptionsMenu(@NotNull CratesPlugin plugin, @NotNull DialogRegistry dialogs) {
        super(plugin, MenuType.GENERIC_9X6, Lang.EDITOR_TITLE_REWARD_SETTINGS.text());
        this.dialogs = dialogs;
        this.plugin.injectLang(this);
>>>>>>> upstream/master

        this.addItem(MenuItem.buildReturn(this, 49, (viewer, event) -> {
            this.runNextTick(() -> plugin.getEditorManager().openRewardList(viewer.getPlayer(), this.getLink(viewer).getCrate()));
        }));

<<<<<<< HEAD
        this.addItem(ItemUtil.getCustomHead(Placeholders.SKULL_DELETE), EditorLang.REWARD_EDIT_DELETE, 8, (viewer, event, reward) -> {
            Player player = viewer.getPlayer();
            Crate crate = reward.getCrate();

            UIUtils.openConfirmation(player, Confirmation.builder()
                .onAccept((viewer1, event1) -> {
                    crate.removeReward(reward);
                    crate.saveRewards();
                    plugin.runTask(task -> plugin.getEditorManager().openRewardList(player, crate));
                })
                .onReturn((viewer1, event1) -> {
                    plugin.runTask(task -> plugin.getEditorManager().openRewardOptions(player, reward));
                })
                .build());
        });

        // ---------------------
        // Universal Options
        // ---------------------

        this.addItem(Material.ITEM_FRAME, EditorLang.REWARD_EDIT_ICON, 4, (viewer, event, reward) -> {
            if (event.isRightClick()) {
                Players.addItem(viewer.getPlayer(), reward.getPreviewItem());
                return;
            }

            ItemStack cursor = event.getCursor();
            if (cursor == null || cursor.getType().isAir()) return;

            ItemStack copy = new ItemStack(cursor);

            if (!ItemTypes.isCustom(copy)) {
                reward.setPreview(ItemTypes.vanilla(copy));
                this.saveAndFlush(viewer, reward);
            }
            else {
                this.runNextTick(() -> plugin.getEditorManager().openItemTypeMenu(viewer.getPlayer(), copy, provider -> {
                    reward.setPreview(provider);
                    reward.save();
                    this.runNextTick(() -> this.open(viewer.getPlayer(), reward));
                }));
            }

            event.getView().setCursor(null);

        }, ItemOptions.builder().setVisibilityPolicy(viewer -> {
                Reward reward = this.getLink(viewer);
                return reward instanceof CommandReward || (reward instanceof ItemReward itemReward && itemReward.isCustomPreview());
            }).build()
        );

        this.addItem(ItemUtil.getCustomHead(TEXTURE_RARITY), EditorLang.REWARD_EDIT_RARITY, 10, (viewer, event, reward) -> {
            this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_RARITY, wrapper -> {
                Rarity rarity = this.plugin.getCrateManager().getRarity(wrapper.getTextRaw());
                if (rarity == null) return true;

                reward.setRarity(rarity);
                reward.save();
                return true;
            }).setSuggestions(plugin.getCrateManager().getRarityIds(), true));
        });

        this.addItem(ItemUtil.getCustomHead(TEXTURE_WEIGHT), EditorLang.REWARD_EDIT_WEIGHT, 11, (viewer, event, reward) -> {
            if (event.isLeftClick()) {
                this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_WEIGHT, input -> {
                    reward.setWeight(input.asDouble(-1D));
                    reward.save();
                    return true;
                }));
            }
            if (event.isRightClick()) {
                reward.setWeight(-1D);
                this.saveAndFlush(viewer, reward);
            }
        });


        this.addItem(ItemUtil.getCustomHead(TEXTURE_PERMS_RED), EditorLang.REWARD_EDIT_IGNORED_PERMISSIONS, 16, (viewer, event, reward) -> {
            if (event.isRightClick()) {
                reward.getIgnoredPermissions().clear();
                this.saveAndFlush(viewer, reward);
                return;
            }
            this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_PERMISSION, input -> {
                reward.getIgnoredPermissions().add(input.getTextRaw());
                reward.save();
                return true;
            }));
        });

        this.addItem(ItemUtil.getCustomHead(TEXTURE_PERMS_GREEN), EditorLang.REWARD_EDIT_REQUIRED_PERMISSIONS, 15, (viewer, event, reward) -> {
            if (event.isRightClick()) {
                reward.getRequiredPermissions().clear();
                this.saveAndFlush(viewer, reward);
                return;
            }
            this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_PERMISSION, input -> {
                reward.getRequiredPermissions().add(input.getTextRaw());
                reward.save();
                return true;
            }));
        });


        this.addItem(ItemUtil.getCustomHead(TEXTURE_BROADCAST), EditorLang.REWARD_EDIT_BROADCAST, 28, (viewer, event, reward) -> {
            reward.setBroadcast(!reward.isBroadcast());
            this.saveAndFlush(viewer, reward);
        });


        this.addItem(ItemUtil.getCustomHead(TEXTURE_PLACEHOLDERS), EditorLang.REWARD_EDIT_PLACEHOLDERS, 30, (viewer, event, reward) -> {
            reward.setPlaceholderApply(!reward.isPlaceholderApply());
            this.saveAndFlush(viewer, reward);
        });


        this.addItem(ItemUtil.getCustomHead(TEXTURE_LIMIT_OFF), EditorLang.REWARD_EDIT_PLAYER_LIMIT, 32, (viewer, event, reward) -> {
            this.runNextTick(() -> plugin.getEditorManager().openRewardLimits(viewer.getPlayer(), reward, reward.getPlayerLimits()));
        }, ItemOptions.builder().setDisplayModifier((viewer, item) -> {
            if (this.getLink(viewer).getPlayerLimits().isEnabled()) item.setSkinURL(TEXTURE_LIMIT_ON);
        }).build());

        this.addItem(ItemUtil.getCustomHead(TEXTURE_LIMIT_OFF), EditorLang.REWARD_EDIT_GLOBAL_LIMIT, 34, (viewer, event, reward) -> {
            this.runNextTick(() -> plugin.getEditorManager().openRewardLimits(viewer.getPlayer(), reward, reward.getGlobalLimits()));
        }, ItemOptions.builder().setDisplayModifier((viewer, item) -> {
            if (this.getLink(viewer).getGlobalLimits().isEnabled()) item.setSkinURL(TEXTURE_LIMIT_ON);
        }).build());


        // ---------------------
        // Command Options
        // ---------------------

        this.addItem(Material.NAME_TAG, EditorLang.REWARD_EDIT_NAME, 2, (viewer, event, reward) -> {
            if (!(reward instanceof CommandReward commandReward)) return;

            this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_DISPLAY_NAME, input -> {
                commandReward.setName(input.getText());
                commandReward.save();
                return true;
            }));
        }, ItemOptions.builder().setVisibilityPolicy(viewer -> this.getLink(viewer) instanceof CommandReward).build());



        this.addItem(Material.WRITABLE_BOOK, EditorLang.REWARD_EDIT_DESCRIPTION, 6, (viewer, event, reward) -> {
            if (!(reward instanceof CommandReward commandReward)) return;

            if (event.isRightClick()) {
                commandReward.setDescription(new ArrayList<>());
                this.saveAndFlush(viewer, commandReward);
                return;
            }

            this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_TEXT, input -> {
                commandReward.getDescription().add(input.getText());
                commandReward.save();
                return true;
            }));
        }, ItemOptions.builder().setVisibilityPolicy(viewer -> this.getLink(viewer) instanceof CommandReward).build());


        this.addItem(ItemUtil.getCustomHead(TEXTURE_COMMAND), EditorLang.REWARD_EDIT_COMMANDS, 13, (viewer, event, reward) -> {
            if (!(reward instanceof CommandReward commandReward)) return;

            if (event.isRightClick()) {
                commandReward.getCommands().clear();
                this.saveAndFlush(viewer, commandReward);
                return;
            }
            this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_COMMAND, input -> {
                commandReward.getCommands().add(input.getText());
                commandReward.save();
                return true;
            }));
        }, ItemOptions.builder().setVisibilityPolicy(viewer -> this.getLink(viewer) instanceof CommandReward).build());


        // ---------------------
        // Item Options
        // ---------------------

        this.addItem(Material.GLOWSTONE_DUST, EditorLang.REWARD_EDIT_CUSTOM_ICON, 2, (viewer, event, reward) -> {
            if (!(reward instanceof ItemReward itemReward)) return;

            itemReward.setCustomPreview(!itemReward.isCustomPreview());
            this.saveAndFlush(viewer, reward);
        }, ItemOptions.builder().setVisibilityPolicy(viewer -> this.getLink(viewer) instanceof ItemReward).build());

        this.addItem(ItemUtil.getCustomHead(TEXTURE_ITEMS), EditorLang.REWARD_EDIT_ITEMS, 13, (viewer, event, reward) -> {
            if (!(reward instanceof ItemReward itemReward)) return;

            this.runNextTick(() -> plugin.getEditorManager().openRewardContent(viewer.getPlayer(), itemReward));
        }, ItemOptions.builder().setVisibilityPolicy(viewer -> this.getLink(viewer) instanceof ItemReward).build());
    }

    private void saveAndFlush(@NotNull MenuViewer viewer, @NotNull Reward reward) {
        reward.save();
        this.runNextTick(() -> this.flush(viewer));
    }

    @Override
    protected void onItemPrepare(@NotNull MenuViewer viewer, @NotNull MenuItem menuItem, @NotNull NightItem item) {
        super.onItemPrepare(viewer, menuItem, item);

        item.replacement(replacer -> replacer.replace(this.getLink(viewer).replaceAllPlaceholders()));
=======
        this.addItem(MenuItem.background(Material.GLASS_PANE, 19,20,21,22,23,24,25));
        this.addItem(MenuItem.background(Material.BLACK_STAINED_GLASS_PANE, IntStream.range(45, 54).toArray()));
>>>>>>> upstream/master
    }

    @Override
    protected void onPrepare(@NotNull MenuViewer viewer, @NotNull InventoryView view) {
<<<<<<< HEAD

=======
        Player player = viewer.getPlayer();
        Reward reward = this.getLink(player);
        Crate crate = reward.getCrate();
        Runnable flush = () -> this.flush(player);

        viewer.addItem(NightItem.fromItemStack(reward.getPreviewItem())
            .localized(reward.getType() == RewardType.ITEM ? LOCALE_PREVIEW_CUSTOM : LOCALE_PREVIEW_NORMAL)
            .replacement(replacer -> replacer
                .replace(GENERIC_INSPECTION, () -> Lang.inspection(Lang.INSPECTIONS_REWARD_PREVIEW, reward.getPreview().isValid()))
                .replace(GENERIC_STATE, () -> CoreLang.STATE_ENABLED_DISALBED.get(reward instanceof ItemReward itemReward && itemReward.isCustomPreview()))
            )
            .toMenuItem().setSlots(11).setHandler((viewer1, event) -> {
                ItemStack cursor = event.getCursor();
                if (cursor == null || cursor.getType().isAir()) {
                    if (reward instanceof ItemReward itemReward) {
                        itemReward.setCustomPreview(!itemReward.isCustomPreview());
                        crate.markDirty();
                        this.runNextTick(flush);
                    }
                    return;
                }

                ItemStack copy = new ItemStack(cursor);
                Players.addItem(player, copy);
                event.getView().setCursor(null);

                if (!ItemHelper.isCustom(copy)) {
                    reward.setPreview(ItemHelper.vanilla(copy));
                    crate.markDirty();
                    this.runNextTick(flush);
                }
                else {
                    this.dialogs.show(player, RewardDialogs.PREVIEW, new RewardPreviewDialog.Data(reward, copy), flush);
                }
            }).build()
        );

        if (reward instanceof ItemReward itemReward) {
            viewer.addItem(NightItem.fromType(Material.BUNDLE)
                .hideAllComponents()
                .localized(LOCALE_ITEMS)
                .replacement(replacer -> replacer
                    .replace(GENERIC_INSPECTION, () -> Lang.inspection(Lang.INSPECTIONS_REWARD_ITEMS, itemReward.hasContent() && !itemReward.hasInvalidItems()))
                    .replace(GENERIC_AMOUNT, () -> itemReward.hasContent() ? CoreLang.goodEntry(String.valueOf(itemReward.countItems())) : CoreLang.badEntry(Lang.INSPECTIONS_REWARD_NO_ITEMS.text()))
                )
                .toMenuItem().setSlots(10).setHandler((viewer1, event) -> {
                    this.runNextTick(() -> plugin.getEditorManager().openRewardContent(viewer.getPlayer(), itemReward));
                }).build()
            );
        }
        else if (reward instanceof CommandReward commandReward) {
            viewer.addItem(NightItem.fromType(Material.COMMAND_BLOCK)
                .hideAllComponents()
                .localized(LOCALE_COMMANDS)
                .replacement(replacer -> replacer
                    .replace(GENERIC_INSPECTION, () -> Lang.inspection(Lang.INSPECTIONS_GENERIC_COMMANDS, commandReward.hasContent() && !commandReward.hasInvalidCommands()))
                    .replace(GENERIC_AMOUNT, () -> commandReward.hasContent() ? CoreLang.goodEntry(String.valueOf(commandReward.countCommands())) : CoreLang.badEntry(Lang.INSPECTIONS_REWARD_NO_COMMANDS.text()))
                )
                .toMenuItem().setSlots(10).setHandler((viewer1, event) -> {
                    this.dialogs.show(player, RewardDialogs.COMMANDS, commandReward, flush);
                }).build()
            );

            viewer.addItem(NightItem.fromType(Material.NAME_TAG).localized(LOCALE_NAME)
                .replacement(replacer -> replacer.replace(reward.replacePlaceholders()))
                .toMenuItem().setSlots(30).setHandler((viewer1, event) -> {
                    this.dialogs.show(player, RewardDialogs.NAME, commandReward, flush);
                }).build()
            );

            viewer.addItem(NightItem.fromType(Material.WRITABLE_BOOK).localized(LOCALE_DESCRIPTION)
                .replacement(replacer -> replacer.replace(reward.replacePlaceholders()))
                .toMenuItem().setSlots(32).setHandler((viewer1, event) -> {
                    this.dialogs.show(player, RewardDialogs.DESCRIPTION, commandReward, flush);
                }).build()
            );
        }

        viewer.addItem(NightItem.fromType(Material.GLISTERING_MELON_SLICE).localized(LOCALE_RARIRY_WEIGHT)
            .replacement(replacer -> replacer.replace(reward.replacePlaceholders()))
            .toMenuItem().setSlots(12).setHandler((viewer1, event) -> {
                this.dialogs.show(player, RewardDialogs.WEIGHT, reward, flush);
            }).build()
        );

        viewer.addItem(NightItem.fromType(Material.ENDER_PEARL).localized(LOCALE_BROADCAST)
            .replacement(replacer -> replacer.replace(GENERIC_STATE, () -> CoreLang.STATE_ENABLED_DISALBED.get(reward.isBroadcast())))
            .toMenuItem().setSlots(13).setHandler((viewer1, event) -> {
                reward.setBroadcast(!reward.isBroadcast());
                crate.markDirty();
                this.runNextTick(flush);
            }).build()
        );

        viewer.addItem(NightItem.fromType(Material.REDSTONE).localized(LOCALE_PERMISSIONS)
            .replacement(replacer -> replacer.replace(GENERIC_AMOUNT, () -> String.valueOf(reward.getIgnoredPermissions().size() + reward.getRequiredPermissions().size())))
            .toMenuItem().setSlots(14).setHandler((viewer1, event) -> {
                this.dialogs.show(player, RewardDialogs.PERMISSIONS, reward, flush);
            }).build()
        );

        viewer.addItem(NightItem.fromType(Material.COMPARATOR).localized(LOCALE_LIMITS)
            .replacement(replacer -> replacer.replace(GENERIC_STATE, () -> CoreLang.STATE_ENABLED_DISALBED.get(reward.getLimits().isEnabled())))
            .toMenuItem().setSlots(15).setHandler((viewer1, event) -> {
                this.dialogs.show(player, RewardDialogs.LIMITS, reward, flush);
            }).build()
        );

        viewer.addItem(NightItem.fromType(Material.BARRIER).localized(LOCALE_DELETE)
            .toMenuItem().setSlots(53).setHandler((viewer1, event) -> {
                if (event.getClick() != ClickType.DROP) return;

                crate.removeReward(reward);
                crate.markDirty();
                this.runNextTick(() -> this.plugin.getEditorManager().openRewardList(player, crate));
            }).build()
        );
>>>>>>> upstream/master
    }

    @Override
    protected void onReady(@NotNull MenuViewer viewer, @NotNull Inventory inventory) {

    }

    @Override
    public void onClick(@NotNull MenuViewer viewer, @NotNull ClickResult result, @NotNull InventoryClickEvent event) {
        super.onClick(viewer, result, event);
        if (result.isInventory()) {
            event.setCancelled(false);
        }
    }
}

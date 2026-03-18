package su.nightexpress.excellentcrates.editor.crate;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MenuType;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.CratesPlugin;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.Placeholders;
import su.nightexpress.excellentcrates.config.Config;
import su.nightexpress.excellentcrates.config.EditorLang;
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.item.ItemTypes;
import su.nightexpress.excellentcrates.key.CrateKey;
import su.nightexpress.excellentcrates.util.CrateUtils;
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
import su.nightexpress.nightcore.util.Plugins;
import su.nightexpress.nightcore.util.bukkit.NightItem;

import java.util.ArrayList;
import java.util.HashSet;

public class CrateOptionsMenu extends LinkedMenu<CratesPlugin, Crate> {

    private static final String TEXTURE_KEYS       = "311790e8005c7f972c469b7b875eab218e0713afe5f2edfd468659910ed622e3";
    private static final String TEXTURE_REWARDS    = "663029cc8167897e6535a3c5734bbabaff188d0905f9d9353afac62a06dadf86";
    private static final String TEXTURE_PLACEMENT  = "181e124a2765c4b320d754f04e1807ad7b3c26ff95376d0b4263c4e1ae84e758";
    private static final String TEXTURE_MILESTONES = "d194a22345d9cdde75168299ad61873bc105e3ae73cd6c9ac02a285291ad0f1b";
    private static final String SKULL_STACK        = "e2e7ac70bf77ba3dd33f4cb78d88ac149ac6036cef2eac8e7a6fd3676fbaf1aa";

    public CrateOptionsMenu(@NotNull CratesPlugin plugin) {
        super(plugin, MenuType.GENERIC_9X6, Lang.EDITOR_TITLE_CRATE_SETTINGS.getString());

=======
import su.nightexpress.excellentcrates.api.crate.Reward;
import su.nightexpress.excellentcrates.config.Config;
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.crate.CrateDialogs;
import su.nightexpress.excellentcrates.dialog.DialogRegistry;
import su.nightexpress.excellentcrates.dialog.crate.CrateItemDialog;
import su.nightexpress.excellentcrates.util.CrateUtils;
import su.nightexpress.nightcore.core.config.CoreLang;
import su.nightexpress.nightcore.locale.LangContainer;
import su.nightexpress.nightcore.locale.LangEntry;
import su.nightexpress.nightcore.locale.entry.IconLocale;
import su.nightexpress.nightcore.ui.menu.MenuViewer;
import su.nightexpress.nightcore.ui.menu.click.ClickResult;
import su.nightexpress.nightcore.ui.menu.item.MenuItem;
import su.nightexpress.nightcore.ui.menu.type.LinkedMenu;
import su.nightexpress.nightcore.util.Players;
import su.nightexpress.nightcore.util.StringUtil;
import su.nightexpress.nightcore.util.bukkit.NightItem;
import su.nightexpress.nightcore.util.text.night.wrapper.TagWrappers;
import su.nightexpress.nightcore.util.time.TimeFormats;

import java.util.stream.IntStream;

import static su.nightexpress.excellentcrates.Placeholders.*;
import static su.nightexpress.nightcore.util.text.night.wrapper.TagWrappers.*;

public class CrateOptionsMenu extends LinkedMenu<CratesPlugin, Crate> implements LangContainer {

    private static final IconLocale LOCALE_DELETE = LangEntry.iconBuilder("Editor.Button.Crate.Delete").accentColor(RED).name("Delete Crate")
        .appendInfo("Permanently deletes the crate.").br()
        .appendClick("Press [" + TagWrappers.KEY.apply("key.drop") + "] to delete")
        .build();

    private static final IconLocale LOCALE_NAME = LangEntry.iconBuilder("Editor.Button.Crate.DisplayName").name("Name")
        .appendCurrent("Current", CRATE_NAME).br()
        .appendInfo("Sets crate display name.").br()
        .appendClick("Click to change")
        .build();

    private static final IconLocale LOCALE_DESCRIPTION = LangEntry.iconBuilder("Editor.Button.Crate.Description").name("Description")
        .rawLore(CRATE_DESCRIPTION, EMPTY_IF_ABOVE)
        .appendInfo("Sets crate description.").br()
        .appendClick("Click to edit")
        .build();

    private static final IconLocale LOCALE_ITEM = LangEntry.iconBuilder("Editor.Button.Crate.Item").name("Crate Item")
        .appendCurrent("Status", GENERIC_INSPECTION)
        .appendCurrent("Stackable", GENERIC_STATE).br()
        .appendInfo("Drop an item on " + SOFT_YELLOW.wrap("this") + " button", "to replace the crate's item.").br()
        .appendClick("Click to toggle stacking")
        .build();

    private static final IconLocale LOCALE_PREVIEW_SET = LangEntry.iconBuilder("Editor.Button.Crate.Preview.Set").name("Preview GUI")
        .appendCurrent("Status", GENERIC_INSPECTION)
        .appendCurrent("Preview ID", GENERIC_VALUE).br()
        .appendInfo("Sets preview GUI for the crate.").br()
        .appendClick("Click to change")
        .build();

    private static final IconLocale LOCALE_PREVIEW_UNSET = LangEntry.iconBuilder("Editor.Button.Crate.Preview.Unset").name("Preview GUI")
        .appendCurrent("Status", RED.wrap("Disabled")).br()
        .appendInfo("Sets preview GUI for this crate.").br()
        .appendClick("Click to change")
        .build();

    private static final IconLocale LOCALE_OPENING_SET = LangEntry.iconBuilder("Editor.Button.Crate.Opening.Set").name("Opening Animation")
        .appendCurrent("Status", GENERIC_INSPECTION)
        .appendCurrent("Preview ID", GENERIC_VALUE).br()
        .appendInfo("Sets opening animation for the crate.").br()
        .appendClick("Click to change")
        .build();

    private static final IconLocale LOCALE_OPENING_UNSET = LangEntry.iconBuilder("Editor.Button.Crate.Opening.Unset").name("Opening Animation")
        .appendCurrent("Status", RED.wrap("Disabled")).br()
        .appendInfo("Sets opening animation for the crate.").br()
        .appendClick("Click to change")
        .build();

    private static final IconLocale LOCALE_LINKED_BLOCKS = LangEntry.iconBuilder("Editor.Button.Crate.LinkedBlocks")
        .name("Linked Block")
        .rawLore(DARK_GRAY.wrap("Press " + GOLD.wrap("[" + TagWrappers.KEY.apply("key.drop") + "]") + " to unlink.")).br()
        .appendCurrent("Linked", GENERIC_STATE).br()
        .appendInfo("Link the crate to a block by", "using the link tool.").br()
        .appendInfo("Interacting with the linked block", "will preview and open the crate.").br()
        .appendClick("Click to get link tool")
        .build();

    private static final IconLocale LOCALE_BLOCK_PUSHBACK = LangEntry.iconBuilder("Editor.Button.Crate.BlockPushback")
        .name("Block Pushback")
        .appendCurrent("Status", GENERIC_STATE).br()
        .appendInfo("Pushes players back from the crate", "if they don't met the requirements.").br()
        .appendClick("Click to toggle")
        .build();

    private static final IconLocale LOCALE_COST_OPTIONS = LangEntry.iconBuilder("Editor.Button.Crate.CostOptions").name("Cost Options")
        .appendInfo("Here you can set the " + SOFT_YELLOW.wrap("'cost'"), "required to open the crate - ", "it can be " + SOFT_YELLOW.wrap("keys") + ", " + SOFT_YELLOW.wrap("currency") + ", or both.").br()
        .appendInfo("You can add multiple cost options,", "allowing players to choose how", "they want to open the crate.").br()
        .appendClick("Click to open")
        .build();

    private static final IconLocale LOCALE_PERMISSION_REQUIREMENT = LangEntry.iconBuilder("Editor.Button.Crate.Permission").name("Permission Requirement")
        .appendCurrent("Status", GENERIC_STATE)
        .appendCurrent("Permission", GENERIC_VALUE).br()
        .appendInfo("Controls whether permission is", "required to open the crate.").br()
        .appendClick("Click to toggle")
        .build();

    private static final IconLocale LOCALE_OPEN_LIMITS = LangEntry.iconBuilder("Editor.Button.Crate.OpeningCooldown").name("Open Limits")
        .appendCurrent("Status", GENERIC_STATE)
        .appendCurrent("Cooldown", GENERIC_VALUE)
        .appendCurrent("Limit Amount", GENERIC_AMOUNT).br()
        .appendInfo("Limits amount of crates", "can be opened per player", "for a time frame.").br()
        .appendClick("Click to edit")
        .build();

    private static final IconLocale LOCALE_EFFECT = LangEntry.iconBuilder("Editor.Button.Crate.Effect").name("Crate Effect")
        .appendCurrent("Model", GENERIC_TYPE)
        .appendCurrent("Particle", GENERIC_VALUE).br()
        .appendInfo("Sets effect for the crate block(s).").br()
        .appendClick("Click to edit")
        .build();

    public static final IconLocale LOCALE_HOLOGRAM = LangEntry.iconBuilder("Editor.Button.Crate.Hologram").name("Crate Hologram")
        .appendCurrent("Status", GENERIC_INSPECTION)
        .appendCurrent("State", GENERIC_STATE)
        .appendCurrent("Template", GENERIC_VALUE).br()
        .appendInfo("Auto-manageable hologram above", "the linked crate block.").br()
        .appendClick("Click to edit")
        .build();

    private static final IconLocale LOCALE_REWARDS = LangEntry.iconBuilder("Editor.Button.Crate.Rewards").name("Rewards")
        .appendCurrent("Status", GENERIC_INSPECTION)
        .appendCurrent("Rewards", GENERIC_AMOUNT).br()
        .appendInfo("Add and manage crate's rewards!").br()
        .appendClick("Click to open")
        .build();

    private static final IconLocale LOCALE_MILESTONES = LangEntry.iconBuilder("Editor.Button.Crate.Milestones").name("Milestones")
        .appendCurrent("Milestones", GENERIC_AMOUNT).br()
        .appendInfo("Create custom milestones with", "rewards for the crate!").br()
        .appendClick("Click to open")
        .build();

    private static final IconLocale LOCALE_POST_OPEN_COMMANDS = LangEntry.iconBuilder("Editor.Button.Crate.Post-Open-Commands").name("Post-Open Commands")
        .appendCurrent("Status", GENERIC_INSPECTION)
        .appendCurrent("Commands", GENERIC_AMOUNT).br()
        .appendInfo("Runs listed commands", "when the crate is opened.").br()
        .appendClick("Click to edit")
        .build();

    private final DialogRegistry dialogs;

    public CrateOptionsMenu(@NotNull CratesPlugin plugin, @NotNull DialogRegistry dialogs) {
        super(plugin, MenuType.GENERIC_9X6, Lang.EDITOR_TITLE_CRATE_SETTINGS.text());
        this.dialogs = dialogs;
        this.plugin.injectLang(this);
>>>>>>> upstream/master

        this.addItem(MenuItem.buildReturn(this, 49, (viewer, event) -> {
            this.runNextTick(() -> this.plugin.getEditorManager().openCrateList(viewer.getPlayer()));
        }));

<<<<<<< HEAD

        this.addItem(ItemUtil.getCustomHead(Placeholders.SKULL_DELETE), EditorLang.CRATE_EDIT_DELETE, 8, (viewer, event, crate) -> {
            Player player = viewer.getPlayer();

            UIUtils.openConfirmation(player, Confirmation.builder()
                .onAccept((viewer1, event1) -> {
                    plugin.getCrateManager().delete(crate);
                    plugin.runTask(task -> plugin.getEditorManager().openCrateList(player));
                })
                .onReturn((viewer1, event1) -> {
                    plugin.runTask(task -> plugin.getEditorManager().openOptionsMenu(player, crate));
                })
                .build());
        });


        this.addItem(Material.NAME_TAG, EditorLang.CRATE_EDIT_NAME, 2, (viewer, event, crate) -> {
            this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_DISPLAY_NAME, input -> {
                crate.setName(input.getText());
                crate.saveSettings();
                return true;
            }));
        });


        this.addItem(Material.WRITABLE_BOOK, EditorLang.CRATE_EDIT_DESCRIPTION, 11, (viewer, event, crate) -> {
            if (event.isRightClick()) {
                crate.setDescription(new ArrayList<>());
                this.saveAndFlush(viewer, crate);
                return;
            }

            this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_TEXT, input -> {
                crate.getDescription().add(input.getText());
                crate.saveSettings();
                return true;
            }));
        });


        this.addItem(Material.ITEM_FRAME, EditorLang.CRATE_EDIT_ITEM, 4, (viewer, event, crate) -> {
            ItemStack cursor = event.getCursor();
            if (cursor == null || cursor.getType().isAir()) {
                ItemStack itemStack = event.isLeftClick() ? crate.getItem() : crate.getRawItem();
                Players.addItem(viewer.getPlayer(), itemStack);
                return;
            }

            // Remove crate tags to avoid infinite recursion in ItemProvider.
            ItemStack clean = CrateUtils.removeCrateTags(new ItemStack(cursor));

            if (!ItemTypes.isCustom(clean)) {
                crate.setItemProvider(ItemTypes.vanilla(clean));
                crate.setName(ItemUtil.getNameSerialized(clean));
                crate.setDescription(ItemUtil.getLoreSerialized(clean));
                this.saveAndFlush(viewer, crate);
            }
            else {
                this.runNextTick(() -> plugin.getEditorManager().openItemTypeMenu(viewer.getPlayer(), clean, provider -> {
                    crate.setItemProvider(provider);
                    crate.setName(ItemUtil.getNameSerialized(clean));
                    crate.setDescription(ItemUtil.getLoreSerialized(clean));
                    crate.saveSettings();
                    this.runNextTick(() -> this.open(viewer.getPlayer(), crate));
                }));
            }

            event.getView().setCursor(null);

        });

        this.addItem(NightItem.asCustomHead(SKULL_STACK), Lang.EDITOR_BUTTON_CRATE_ITEM_STACKABLE, 0, (viewer, event, crate) -> {
            crate.setItemStackable(!crate.isItemStackable());
            this.saveAndFlush(viewer, crate);
        });

        this.addItem(Material.PAINTING, EditorLang.CRATE_EDIT_PREVIEW, 6, (viewer, event, crate) -> {
            if (event.isRightClick()) {
                crate.setPreviewEnabled(!crate.isPreviewEnabled());
                this.saveAndFlush(viewer, crate);
                return;
            }

            this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_PREVIEW_ID, input -> {
                crate.setPreviewId(input.getTextRaw());
                crate.saveSettings();
                return true;
            }).setSuggestions(plugin.getCrateManager().getPreviewNames(), true));
        });


        this.addItem(Material.GLOW_ITEM_FRAME, EditorLang.CRATE_EDIT_ANIMATION, 15, (viewer, event, crate) -> {
            if (event.isRightClick()) {
                crate.setAnimationEnabled(!crate.isAnimationEnabled());
                this.saveAndFlush(viewer, crate);
                return;
            }

            this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_ANIMATION_ID, input -> {
                crate.setAnimationId(input.getTextRaw());
                crate.saveSettings();
                return true;
            }).setSuggestions(plugin.getOpeningManager().getProviderIds(), true));
        });


        this.addItem(NightItem.asCustomHead(TEXTURE_KEYS), EditorLang.CRATE_KEY_REQUIREMENT, 19, (viewer, event, crate) -> {
            if (event.isLeftClick()) {
                this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_KEY_ID, input -> {
                    CrateKey key = this.plugin.getKeyManager().getKeyById(input.getTextRaw());
                    if (key != null) {
                        crate.addKeyId(key.getId());
                        crate.saveSettings();
                    }
                    return true;
                }).setSuggestions(plugin.getKeyManager().getKeyIds(), true));
            }
            else if (event.isRightClick()) {
                crate.setKeyIds(new HashSet<>());
                this.saveAndFlush(viewer, crate);
            }
            else if (event.getClick() == ClickType.DROP) {
                crate.setKeyRequired(!crate.isKeyRequired());
                this.saveAndFlush(viewer, crate);
            }
        });


        this.addItem(Material.REDSTONE, EditorLang.CRATE_EDIT_PERMISSION_REQUIREMENT, 21, (viewer, event, crate) -> {
            crate.setPermissionRequired(!crate.isPermissionRequired());
            this.saveAndFlush(viewer, crate);
        }, ItemOptions.builder().setDisplayModifier((viewer, item) -> {
            if (!this.getLink(viewer).isPermissionRequired()) item.setMaterial(Material.GUNPOWDER);
        }).build());


        this.addItem(Material.CLOCK, EditorLang.CRATE_EDIT_OPEN_COOLDOWN, 23, (viewer, event, crate) -> {
            if (event.getClick() == ClickType.DROP) {
                crate.setOpenCooldown(-1);
                this.saveAndFlush(viewer, crate);
                return;
            }
            if (event.isRightClick()) {
                crate.setOpenCooldown(0);
                this.saveAndFlush(viewer, crate);
                return;
            }
            this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_SECONDS, input -> {
                crate.setOpenCooldown(input.asInt(0));
                crate.saveSettings();
                return true;
            }));
        });


        this.addItem(Material.GOLD_INGOT, EditorLang.CRATE_EDIT_OPEN_COST, 25, (viewer, event, crate) -> {
            this.runNextTick(() -> plugin.getEditorManager().openCostsMenu(viewer.getPlayer(), crate));
        }, ItemOptions.builder().setVisibilityPolicy(viewer -> Plugins.hasEconomyBridge()).build());


        this.addItem(NightItem.asCustomHead(TEXTURE_PLACEMENT), EditorLang.CRATE_EDIT_PLACEMENT, 38, (viewer, event, crate) -> {
            this.runNextTick(() -> this.plugin.getEditorManager().openPlacementMenu(viewer.getPlayer(), crate));
        });


        this.addItem(NightItem.asCustomHead(TEXTURE_REWARDS), EditorLang.CRATE_EDIT_REWARDS, 40, (viewer, event, crate) -> {
            this.runNextTick(() -> this.plugin.getEditorManager().openRewardList(viewer.getPlayer(), crate));
        });


        this.addItem(NightItem.asCustomHead(TEXTURE_MILESTONES), EditorLang.CRATE_EDIT_MILESTONES, 42, (viewer, event, crate) -> {
            if (event.isRightClick()) {
                crate.setMilestonesRepeatable(!crate.isMilestonesRepeatable());
                crate.saveMilestones();
                this.runNextTick(() -> this.flush(viewer));
                return;
            }

            this.runNextTick(() -> this.plugin.getEditorManager().openMilestones(viewer.getPlayer(), crate));
        }, ItemOptions.builder().setVisibilityPolicy(viewer -> Config.isMilestonesEnabled()).build());
    }

    private void saveAndFlush(@NotNull MenuViewer viewer, @NotNull Crate crate) {
        crate.saveSettings();
        this.runNextTick(() -> this.flush(viewer));
    }

    @Override
    protected void onItemPrepare(@NotNull MenuViewer viewer, @NotNull MenuItem menuItem, @NotNull NightItem item) {
        super.onItemPrepare(viewer, menuItem, item);

        item.replacement(replacer -> replacer.replace(this.getLink(viewer).replaceAllPlaceholders()));
=======
        this.addItem(MenuItem.background(Material.BLACK_STAINED_GLASS_PANE, IntStream.range(45, 54).toArray()));
        this.addItem(MenuItem.background(Material.GLASS_PANE, IntStream.range(19, 26).toArray()));
>>>>>>> upstream/master
    }

    @Override
    protected void onPrepare(@NotNull MenuViewer viewer, @NotNull InventoryView view) {
<<<<<<< HEAD

=======
        Player player = viewer.getPlayer();
        Crate crate = this.getLink(player);
        Runnable flush = () -> this.flush(player);

        viewer.addItem(NightItem.fromType(Material.NAME_TAG)
            .localized(LOCALE_NAME)
            .replacement(replacer -> replacer.replace(crate.replacePlaceholders()))
            .toMenuItem().setSlots(10).setHandler((viewer1, event) -> {
                this.dialogs.show(player, CrateDialogs.CRATE_NAME, crate, flush);
            }).build()
        );

        viewer.addItem(NightItem.fromType(Material.WRITABLE_BOOK)
            .localized(LOCALE_DESCRIPTION)
            .replacement(replacer -> replacer.replace(crate.replacePlaceholders()))
            .toMenuItem().setSlots(11).setHandler((viewer1, event) -> {
                this.dialogs.show(player, CrateDialogs.CRATE_DESCRIPTION, crate, flush);
            }).build()
        );

        viewer.addItem(NightItem.fromItemStack(crate.getItemStack())
            .localized(LOCALE_ITEM)
            .replacement(replacer -> replacer
                .replace(GENERIC_INSPECTION, () -> Lang.inspection(Lang.INSPECTIONS_GENERIC_ITEM, crate.getItem().isValid()))
                .replace(GENERIC_STATE, () -> CoreLang.STATE_ENABLED_DISALBED.get(crate.isItemStackable()))
            )
            .toMenuItem().setSlots(12).setHandler((viewer1, event) -> {
                ItemStack cursor = event.getCursor();
                if (cursor == null || cursor.getType().isAir()) {
                    if (event.isLeftClick()) {
                        crate.setItemStackable(!crate.isItemStackable());
                        crate.markDirty();
                        this.runNextTick(flush);
                    }
                    return;
                }

                // Remove crate tags to avoid infinite recursion in ItemProvider.
                ItemStack clean = CrateUtils.removeCrateTags(new ItemStack(cursor));
                Players.addItem(player, cursor);
                event.getView().setCursor(null);
                this.dialogs.show(player, CrateDialogs.CRATE_ITEM, new CrateItemDialog.Data<>(crate, clean), flush);
            }).build()
        );

        viewer.addItem(NightItem.fromType(Material.PAINTING)
            .localized(crate.isPreviewEnabled() ? LOCALE_PREVIEW_SET : LOCALE_PREVIEW_UNSET)
            .replacement(replacer -> replacer
                .replace(GENERIC_INSPECTION, () -> Lang.inspection(Lang.INSPECTIONS_CRATE_PREVIEW, crate.isPreviewValid()))
                .replace(GENERIC_VALUE, crate::getPreviewId)
            )
            .toMenuItem().setSlots(13).setHandler((viewer1, event) -> {
                this.dialogs.show(player, CrateDialogs.CRATE_PREVIEW, crate, flush);
            }).build()
        );

        viewer.addItem(NightItem.fromType(Material.GLOW_ITEM_FRAME)
            .localized(crate.isOpeningEnabled() ? LOCALE_OPENING_SET : LOCALE_OPENING_UNSET)
            .replacement(replacer -> replacer
                .replace(GENERIC_INSPECTION, () -> Lang.inspection(Lang.INSPECTIONS_CRATE_OPENING, crate.isOpeningValid()))
                .replace(GENERIC_VALUE, crate::getOpeningId)
            )
            .toMenuItem().setSlots(14).setHandler((viewer1, event) -> {
                this.dialogs.show(player, CrateDialogs.CRATE_OPENING, crate, flush);
            }).build()
        );

        viewer.addItem(NightItem.fromType(Material.BEACON)
            .localized(LOCALE_LINKED_BLOCKS)
            .replacement(replacer -> replacer.replace(GENERIC_STATE, () -> CoreLang.STATE_YES_NO.get(!crate.getBlockPositions().isEmpty())))
            .toMenuItem().setSlots(15).setHandler((viewer1, event) -> {
                if (event.getClick() == ClickType.DROP) {
                    crate.removeHologram();
                    crate.clearBlockPositions();
                    crate.markDirty();
                    this.runNextTick(flush);
                    return;
                }

                this.plugin.getCrateManager().giveLinkTool(player, crate);
                this.runNextTick(player::closeInventory);
            }).build()
        );

        viewer.addItem(NightItem.fromType(Material.SLIME_BLOCK)
            .localized(LOCALE_BLOCK_PUSHBACK)
            .replacement(replacer -> replacer.replace(GENERIC_STATE, () -> CoreLang.STATE_ENABLED_DISALBED.get(crate.isPushbackEnabled())))
            .toMenuItem().setSlots(16).setHandler((viewer1, event) -> {
                crate.setPushbackEnabled(!crate.isPushbackEnabled());
                crate.markDirty();
                this.runNextTick(flush);
            }).build()
        );

        viewer.addItem(NightItem.fromType(Material.TRIAL_KEY)
            .localized(LOCALE_COST_OPTIONS)
            .toMenuItem().setSlots(28).setHandler((viewer1, event) -> {
                this.runNextTick(() -> plugin.getEditorManager().openCosts(viewer.getPlayer(), crate));
            }).build()
        );

        viewer.addItem(NightItem.fromType(crate.isPermissionRequired() ? Material.REDSTONE : Material.GUNPOWDER)
            .localized(LOCALE_PERMISSION_REQUIREMENT)
            .replacement(replacer -> replacer
                .replace(GENERIC_STATE, () -> CoreLang.STATE_ENABLED_DISALBED.get(crate.isPermissionRequired()))
                .replace(GENERIC_VALUE, crate::getPermission)
            )
            .toMenuItem().setSlots(29).setHandler((viewer1, event) -> {
                crate.setPermissionRequired(!crate.isPermissionRequired());
                crate.markDirty();
                this.runNextTick(flush);
            }).build()
        );

        viewer.addItem(NightItem.fromType(Material.CLOCK)
            .localized(LOCALE_OPEN_LIMITS)
            .replacement(replacer -> replacer
                .replace(GENERIC_STATE, () -> CoreLang.STATE_ENABLED_DISALBED.get(crate.isOpeningCooldownEnabled()))
                .replace(GENERIC_VALUE, () -> {
                    if (crate.getOpeningCooldownTime() < 0L) return CoreLang.OTHER_ONE_TIMED.text();

                    return TimeFormats.toLiteral(crate.getOpeningCooldownTime() * 1000L);
                })
                .replace(GENERIC_AMOUNT, () -> String.valueOf(crate.getOpeningLimitAmount()))
            )
            .toMenuItem().setSlots(30).setHandler((viewer1, event) -> {
                this.dialogs.show(player, CrateDialogs.CRATE_OPENING_LIMITS, crate, flush);
            }).build()
        );

        viewer.addItem(NightItem.fromType(Material.BLAZE_POWDER)
            .localized(LOCALE_EFFECT)
            .replacement(replacer -> replacer
                .replace(GENERIC_TYPE, () -> StringUtil.capitalizeUnderscored(crate.getEffectType()))
                .replace(GENERIC_VALUE, () -> Lang.PARTICLE.getLocalized(crate.getEffectParticle().getParticle())))
            .toMenuItem().setSlots(31).setHandler((viewer1, event) -> {
                this.dialogs.show(player, CrateDialogs.CRATE_EFFECT, crate, flush);
            }).build()
        );

        if (this.plugin.hasHolograms()) {
            viewer.addItem(NightItem.fromType(Material.ARMOR_STAND)
                .localized(LOCALE_HOLOGRAM)
                .replacement(replacer -> replacer
                    .replace(GENERIC_INSPECTION, () -> Lang.inspection(Lang.INSPECTIONS_CRATE_HOLOGRAM, crate.isHologramTemplateValid()))
                    .replace(GENERIC_STATE, () -> CoreLang.STATE_ENABLED_DISALBED.get(crate.isHologramEnabled()))
                    .replace(GENERIC_VALUE, crate::getHologramTemplateId)
                )
                .toMenuItem().setSlots(32).setHandler((viewer1, event) -> {
                    this.dialogs.show(player, CrateDialogs.CRATE_HOLOGRAM, crate, flush);
                }).build()
            );
        }

        viewer.addItem(NightItem.fromType(Material.VAULT)
            .localized(LOCALE_REWARDS)
            .replacement(replacer -> replacer
                .replace(GENERIC_INSPECTION, () -> Lang.inspection(Lang.INSPECTIONS_GENERIC_OVERVIEW, crate.getRewards().stream().noneMatch(Reward::hasProblems)))
                .replace(GENERIC_AMOUNT, () -> CoreLang.formatEntry(String.valueOf(crate.countRewards()), crate.countRewards() > 0))
            )
            .toMenuItem().setSlots(33).setHandler((viewer1, event) -> {
                this.runNextTick(() -> this.plugin.getEditorManager().openRewardList(viewer.getPlayer(), crate));
            }).build()
        );

        if (Config.isMilestonesEnabled()) {
            viewer.addItem(NightItem.fromType(Material.CAMPFIRE)
                .localized(LOCALE_MILESTONES)
                .replacement(replacer -> replacer
                    .replace(GENERIC_AMOUNT, () -> String.valueOf(crate.countMilestones()))
                )
                .toMenuItem().setSlots(34).setHandler((viewer1, event) -> {
                    // TODO crate.setMilestonesRepeatable(!crate.isMilestonesRepeatable());
                    this.runNextTick(() -> this.plugin.getEditorManager().openMilestones(viewer.getPlayer(), crate));
                }).build()
            );
        }

        viewer.addItem(NightItem.fromType(Material.BARRIER)
            .localized(LOCALE_DELETE)
            .toMenuItem().setSlots(53).setHandler((viewer1, event) -> {
                if (event.getClick() != ClickType.DROP) return;

                this.plugin.getCrateManager().delete(crate);
                this.runNextTick(() -> this.plugin.getEditorManager().openCrateList(player));
            }).build()
        );

        viewer.addItem(NightItem.fromType(Material.COMMAND_BLOCK)
            .localized(LOCALE_POST_OPEN_COMMANDS)
            .replacement(replacer -> replacer
                .replace(GENERIC_INSPECTION, () -> Lang.inspection(Lang.INSPECTIONS_GENERIC_COMMANDS, crate.getPostOpenCommands().stream().allMatch(CrateUtils::isValidCommand)))
                .replace(GENERIC_AMOUNT, () -> String.valueOf(crate.getPostOpenCommands().size()))
            )
            .toMenuItem().setSlots(40).setHandler((viewer1, event) -> {
                this.dialogs.show(player, CrateDialogs.CRATE_POST_OPEN_COMMANDS, crate, flush);
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
        if (result.isInventory() && !event.isShiftClick()) {
            event.setCancelled(false);
        }
    }
}

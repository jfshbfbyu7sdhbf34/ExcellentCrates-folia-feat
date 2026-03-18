package su.nightexpress.excellentcrates.editor.crate;

import org.bukkit.Material;
<<<<<<< HEAD
=======
import org.bukkit.entity.Player;
>>>>>>> upstream/master
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.MenuType;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.CratesPlugin;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.config.EditorLang;
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.excellentcrates.crate.CrateManager;
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.nightcore.ui.dialog.Dialog;
=======
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.excellentcrates.crate.CrateManager;
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.crate.CrateDialogs;
import su.nightexpress.excellentcrates.dialog.DialogRegistry;
import su.nightexpress.nightcore.locale.LangContainer;
import su.nightexpress.nightcore.locale.LangEntry;
import su.nightexpress.nightcore.locale.entry.IconLocale;
>>>>>>> upstream/master
import su.nightexpress.nightcore.ui.menu.MenuViewer;
import su.nightexpress.nightcore.ui.menu.data.Filled;
import su.nightexpress.nightcore.ui.menu.data.MenuFiller;
import su.nightexpress.nightcore.ui.menu.item.MenuItem;
import su.nightexpress.nightcore.ui.menu.type.LinkedMenu;
import su.nightexpress.nightcore.util.bukkit.NightItem;

import java.util.Comparator;
import java.util.stream.IntStream;

<<<<<<< HEAD
public class CrateListMenu extends LinkedMenu<CratesPlugin, CrateManager> implements Filled<Crate> {

    public CrateListMenu(@NotNull CratesPlugin plugin) {
        super(plugin, MenuType.GENERIC_9X5, Lang.EDITOR_TITLE_CRATE_LIST.getString());

        this.addItem(MenuItem.buildReturn(this, 39, (viewer, event) -> {
=======
import static su.nightexpress.excellentcrates.Placeholders.*;
import static su.nightexpress.nightcore.util.text.night.wrapper.TagWrappers.GREEN;

public class CrateListMenu extends LinkedMenu<CratesPlugin, CrateManager> implements Filled<Crate>, LangContainer {

    private static final IconLocale LOCALE_CRATE = LangEntry.iconBuilder("Editor.Button.Crates.Crate")
        .rawName(CRATE_NAME)
        .appendCurrent("Status", GENERIC_INSPECTION)
        .appendCurrent("ID", CRATE_ID).br()
        .appendClick("Click to open")
        .build();

    private static final IconLocale LOCALE_CREATION = LangEntry.iconBuilder("Editor.Button.Crates.Create")
        .accentColor(GREEN)
        .name("New Crate")
        .appendInfo("Use this button to create", "brand new crates!").br()
        .appendClick("Click to create")
        .build();

    private final DialogRegistry dialogs;

    public CrateListMenu(@NotNull CratesPlugin plugin, @NotNull DialogRegistry dialogs) {
        super(plugin, MenuType.GENERIC_9X5, Lang.EDITOR_TITLE_CRATE_LIST.text());
        this.dialogs = dialogs;
        this.plugin.injectLang(this);

        this.addItem(MenuItem.buildReturn(this, 40, (viewer, event) -> {
>>>>>>> upstream/master
            this.runNextTick(() -> this.plugin.getEditorManager().openEditor(viewer.getPlayer()));
        }));

        this.addItem(MenuItem.buildNextPage(this, 44));
        this.addItem(MenuItem.buildPreviousPage(this, 36));
<<<<<<< HEAD

        this.addItem(Material.ANVIL, EditorLang.CRATE_CREATE, 41, (viewer, event, manager) -> {
            this.handleInput(Dialog.builder(viewer, Lang.EDITOR_ENTER_CRATE_ID, input -> {
                if (!manager.create(input.getTextRaw())) {
                    Lang.CRATE_CREATE_ERROR_DUPLICATED.getMessage().send(viewer.getPlayer());
                    return false;
                }
                return true;
            }));
=======
        this.addItem(MenuItem.background(Material.BLACK_STAINED_GLASS_PANE, IntStream.range(36, 45).toArray()));
        this.addItem(MenuItem.background(Material.GRAY_STAINED_GLASS_PANE, IntStream.range(0, 36).toArray()));

        this.addItem(Material.ANVIL, LOCALE_CREATION, 42, (viewer, event, manager) -> {
            Player player = viewer.getPlayer();
            this.dialogs.show(player, CrateDialogs.CRATE_CREATION, manager, () -> this.flush(player));
>>>>>>> upstream/master
        });
    }

    @Override
    @NotNull
    public MenuFiller<Crate> createFiller(@NotNull MenuViewer viewer) {
        var autoFill = MenuFiller.builder(this);

        autoFill.setSlots(IntStream.range(0, 36).toArray());
        autoFill.setItems(this.getLink(viewer).getCrates().stream().sorted(Comparator.comparing(Crate::getId)).toList());
        autoFill.setItemCreator(crate -> {
<<<<<<< HEAD
            return NightItem.fromItemStack(crate.getRawItem())
                .localized(EditorLang.CRATE_OBJECT)
                .replacement(replacer -> replacer
                    .replace(crate.replaceAllPlaceholders())
=======
            return NightItem.fromItemStack(crate.getRawItemStack())
                .localized(LOCALE_CRATE)
                .replacement(replacer -> replacer
                    .replace(GENERIC_INSPECTION, () -> Lang.inspection(Lang.INSPECTIONS_GENERIC_OVERVIEW, !crate.hasProblems()))
                    .replace(crate.replacePlaceholders())
>>>>>>> upstream/master
                );
        });
        autoFill.setItemClick(crate -> (viewer1, event) -> {
            this.runNextTick(() -> this.plugin.getEditorManager().openOptionsMenu(viewer1.getPlayer(), crate));
        });

        return autoFill.build();
    }

    @Override
    protected void onPrepare(@NotNull MenuViewer viewer, @NotNull InventoryView view) {
        this.autoFill(viewer);
    }

    @Override
    protected void onReady(@NotNull MenuViewer viewer, @NotNull Inventory inventory) {

    }
}

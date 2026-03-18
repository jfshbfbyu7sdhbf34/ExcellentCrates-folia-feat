package su.nightexpress.excellentcrates.editor;

<<<<<<< HEAD
=======
import org.bukkit.Material;
>>>>>>> upstream/master
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.MenuType;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.CratesPlugin;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.config.EditorLang;
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.nightcore.ui.menu.MenuViewer;
import su.nightexpress.nightcore.ui.menu.type.NormalMenu;
import su.nightexpress.nightcore.util.bukkit.NightItem;

public class EditorMenu extends NormalMenu<CratesPlugin> {

    private static final String TEXTURE_CRATE = "322d4be1abcf3832c916191d24f9607bf194eff8dfbf3b9520bd97240e7c8";
    private static final String TEXTURE_KEYS = "311790e8005c7f972c469b7b875eab218e0713afe5f2edfd468659910ed622e3";

    public EditorMenu(@NotNull CratesPlugin plugin) {
        super(plugin, MenuType.GENERIC_9X3, Lang.EDITOR_TITLE_MAIN.getString());

        this.addItem(NightItem.asCustomHead(TEXTURE_CRATE).localized(EditorLang.CRATES_EDITOR).toMenuItem().setSlots(11).setHandler((viewer, event) -> {
            this.runNextTick(() -> plugin.getEditorManager().openCrateList(viewer.getPlayer()));
        }));

        this.addItem(NightItem.asCustomHead(TEXTURE_KEYS).localized(EditorLang.KEYS_EDITOR).toMenuItem().setSlots(15).setHandler((viewer, event) -> {
            this.runNextTick(() -> plugin.getEditorManager().openKeyList(viewer.getPlayer()));
        }));
=======
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.nightcore.locale.LangContainer;
import su.nightexpress.nightcore.locale.LangEntry;
import su.nightexpress.nightcore.locale.entry.IconLocale;
import su.nightexpress.nightcore.ui.menu.MenuViewer;
import su.nightexpress.nightcore.ui.menu.item.MenuItem;
import su.nightexpress.nightcore.ui.menu.type.NormalMenu;
import su.nightexpress.nightcore.util.bukkit.NightItem;

import static su.nightexpress.nightcore.util.text.night.wrapper.TagWrappers.*;
import static su.nightexpress.excellentcrates.Placeholders.*;

public class EditorMenu extends NormalMenu<CratesPlugin> implements LangContainer {

    private static final IconLocale CRATES_LOCALE = LangEntry.iconBuilder("Editor.Button.Main.Crates")
        .accentColor(GREEN)
        .name("Crates")
        .appendInfo("There are " + GREEN.wrap(GENERIC_AMOUNT) + " crates created.").br()
        .appendClick("Click to open").build();

    private static final IconLocale KEYS_LOCALE = LangEntry.iconBuilder("Editor.Button.Main.Keys")
        .accentColor(GOLD)
        .name("Keys")
        .appendInfo("There are " + GOLD.wrap(GENERIC_AMOUNT) + " keys created.").br()
        .appendClick("Click to open").build();

    public EditorMenu(@NotNull CratesPlugin plugin) {
        super(plugin, MenuType.GENERIC_9X3, Lang.EDITOR_TITLE_MAIN.text());
        this.plugin.injectLang(this);

        this.addItem(MenuItem.background(Material.BLACK_STAINED_GLASS_PANE, 0,1,7,8,9,17,18,19,25,26));
        this.addItem(MenuItem.background(Material.GRAY_STAINED_GLASS_PANE, 2,3,4,5,6,20,21,22,23,24));
        this.addItem(MenuItem.background(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 10,11,12,13,14,15,16));
>>>>>>> upstream/master
    }

    @Override
    protected void onPrepare(@NotNull MenuViewer viewer, @NotNull InventoryView view) {
<<<<<<< HEAD

=======
        viewer.addItem(NightItem.fromType(Material.VAULT)
            .localized(CRATES_LOCALE)
            .replacement(replacer -> replacer.replace(GENERIC_AMOUNT, () -> String.valueOf(this.plugin.getCrateManager().countCrates())))
            .toMenuItem()
            .setSlots(11)
            .setHandler((viewer1, event) -> {
                this.runNextTick(() -> plugin.getEditorManager().openCrateList(viewer.getPlayer()));
            })
            .build()
        );

        viewer.addItem(NightItem.fromType(Material.TRIAL_KEY)
            .localized(KEYS_LOCALE)
            .replacement(replacer -> replacer.replace(GENERIC_AMOUNT, () -> String.valueOf(this.plugin.getKeyManager().countKeys())))
            .toMenuItem()
            .setSlots(15)
            .setHandler((viewer1, event) -> {
                this.runNextTick(() -> plugin.getEditorManager().openKeyList(viewer.getPlayer()));
            })
            .build()
        );
>>>>>>> upstream/master
    }

    @Override
    protected void onReady(@NotNull MenuViewer viewer, @NotNull Inventory inventory) {

    }
}

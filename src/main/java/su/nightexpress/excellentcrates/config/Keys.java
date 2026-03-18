package su.nightexpress.excellentcrates.config;

import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.CratesPlugin;

public class Keys {

    public static NamespacedKey crateId;
    public static NamespacedKey keyId;
<<<<<<< HEAD
    public static NamespacedKey rewardId;
    public static NamespacedKey dummyItem;
=======
    public static NamespacedKey linkToolCrateId;
>>>>>>> upstream/master

    public static void load(@NotNull CratesPlugin plugin) {
        crateId = new NamespacedKey(plugin, "crate.id");
        keyId = new NamespacedKey(plugin, "crate_key.id");
<<<<<<< HEAD
        rewardId = new NamespacedKey(plugin, "reward.id");
        dummyItem = new NamespacedKey(plugin, "dummy_item");
=======
        linkToolCrateId = new NamespacedKey(plugin, "linktool.crate_id");
>>>>>>> upstream/master
    }

    public static void clear() {
        crateId = null;
        keyId = null;
<<<<<<< HEAD
        rewardId = null;
        dummyItem = null;
=======
        linkToolCrateId = null;
>>>>>>> upstream/master
    }
}

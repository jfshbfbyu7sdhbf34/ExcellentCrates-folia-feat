package su.nightexpress.excellentcrates.hooks.impl;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.excellentcrates.CratesPlugin;
import su.nightexpress.excellentcrates.api.crate.Reward;
import su.nightexpress.excellentcrates.config.Config;
import su.nightexpress.excellentcrates.config.Lang;
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.crate.impl.Milestone;
import su.nightexpress.excellentcrates.data.crate.UserCrateData;
import su.nightexpress.excellentcrates.user.CrateUser;
<<<<<<< HEAD
import su.nightexpress.nightcore.util.NumberUtil;
=======
import su.nightexpress.nightcore.bridge.wrap.NightProfile;
import su.nightexpress.nightcore.core.config.CoreLang;
import su.nightexpress.nightcore.util.NumberUtil;
import su.nightexpress.nightcore.util.profile.CachedProfile;
>>>>>>> upstream/master
import su.nightexpress.nightcore.util.time.TimeFormats;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class PlaceholderHook {

    private static Expansion expansion;

    public static void setup(@NotNull CratesPlugin plugin) {
        if (expansion == null) {
            expansion = new Expansion(plugin);
            expansion.register();
        }
    }

    public static void shutdown() {
        if (expansion != null) {
            expansion.unregister();
            expansion = null;
        }
    }

    private static class Expansion extends PlaceholderExpansion {

        private final CratesPlugin                                   plugin;
<<<<<<< HEAD
        private final Map<String, BiFunction<Player, Crate, String>> placeholders;

        public Expansion(@NotNull CratesPlugin plugin) {
            this.plugin = plugin;
            this.placeholders = new LinkedHashMap<>();

            this.placeholders.put("keys", (player, crate) -> {
                int keys = plugin.getKeyManager().getKeysAmount(player, crate);
                return NumberUtil.format(keys);
            });

            this.placeholders.put("openings_raw", (player, crate) -> {
=======
        private final Map<String, BiFunction<Player, Crate, String>> userPlaceholders;

        public Expansion(@NotNull CratesPlugin plugin) {
            this.plugin = plugin;
            this.userPlaceholders = new LinkedHashMap<>();

            this.userPlaceholders.put("keys", (player, crate) -> {
                if (player == null) return null;

                int amount = crate.countMaxOpenings(player);
                return amount < 0 ? CoreLang.OTHER_INFINITY.text() : String.valueOf(amount);
            });

            this.userPlaceholders.put("openings_available", (player, crate) -> {
                if (player == null) return null;

                int amount = crate.countMaxOpenings(player);
                return amount < 0 ? CoreLang.OTHER_INFINITY.text() : String.valueOf(amount);
            });

            this.userPlaceholders.put("openings_raw", (player, crate) -> {
                if (player == null) return null;

>>>>>>> upstream/master
                CrateUser user = plugin.getUserManager().getOrFetch(player);
                return String.valueOf(user.getCrateData(crate).getOpenings());
            });

<<<<<<< HEAD
            this.placeholders.put("openings", (player, crate) -> {
=======
            this.userPlaceholders.put("openings_remaining", (player, crate) -> {
                if (player == null) return null;
                if (!crate.isOpeningCooldownEnabled()) return CoreLang.OTHER_INFINITY.text();

                CrateUser user = plugin.getUserManager().getOrFetch(player);
                UserCrateData data = user.getCrateData(crate);

                int openLimit = crate.getOpeningLimitAmount();
                int openStreak = data.queryOpeningStreak();

                return String.valueOf(Math.max(0, openLimit - openStreak));
            });

            this.userPlaceholders.put("openings", (player, crate) -> {
                if (player == null) return null;

>>>>>>> upstream/master
                CrateUser user = plugin.getUserManager().getOrFetch(player);
                return NumberUtil.format(user.getCrateData(crate).getOpenings());
            });

<<<<<<< HEAD
            this.placeholders.put("cooldown", (player, crate) -> {
                CrateUser user = plugin.getUserManager().getOrFetch(player);
                UserCrateData data = user.getCrateData(crate);
                if (!data.hasCooldown()) return Lang.OTHER_COOLDOWN_READY.getString();

                return TimeFormats.formatDuration(data.getOpenCooldown(), Config.CRATE_COOLDOWN_FORMAT_TYPE.get());
            });

            this.placeholders.put("next_milestone_openings", (player, crate) -> {
                CrateUser user = plugin.getUserManager().getOrFetch(player);
                int milestones = user.getCrateData(crate).getMilestone();
                Milestone milestone = crate.getNextMilestone(milestones);
                if (milestone == null) return Lang.OTHER_NEXT_MILESTONE_EMPTY.getString();
=======
            this.userPlaceholders.put("cooldown", (player, crate) -> {
                if (player == null) return null;
                if (!crate.isOpeningCooldownEnabled()) return Lang.OTHER_COOLDOWN_READY.text();

                CrateUser user = plugin.getUserManager().getOrFetch(player);
                UserCrateData data = user.getCrateData(crate);

                if (!data.isOnCooldown()) return Lang.OTHER_COOLDOWN_READY.text();
                if (data.isCooldownPermanent()) return CoreLang.OTHER_NEVER.text();

                return TimeFormats.formatDuration(data.getCooldownTimestamp(), Config.CRATE_COOLDOWN_FORMAT_TYPE.get());
            });

            this.userPlaceholders.put("next_milestone_openings", (player, crate) -> {
                if (player == null) return null;

                CrateUser user = plugin.getUserManager().getOrFetch(player);
                int milestones = user.getCrateData(crate).getMilestone();
                Milestone milestone = crate.getNextMilestone(milestones);
                if (milestone == null) return Lang.OTHER_NEXT_MILESTONE_EMPTY.text();
>>>>>>> upstream/master

                return NumberUtil.format(milestone.getOpenings() - milestones);
            });

<<<<<<< HEAD
            this.placeholders.put("next_milestone_reward", (player, crate) -> {
=======
            this.userPlaceholders.put("next_milestone_reward", (player, crate) -> {
                if (player == null) return null;

>>>>>>> upstream/master
                CrateUser user = plugin.getUserManager().getOrFetch(player);
                int milestones = user.getCrateData(crate).getMilestone();
                Milestone milestone = crate.getNextMilestone(milestones);
                Reward reward = milestone == null ? null : milestone.getReward();
<<<<<<< HEAD
                if (reward == null) return Lang.OTHER_NEXT_MILESTONE_EMPTY.getString();
=======
                if (reward == null) return Lang.OTHER_NEXT_MILESTONE_EMPTY.text();
>>>>>>> upstream/master

                return reward.getName();
            });

<<<<<<< HEAD
            this.placeholders.put("latest_opener", (player, crate) -> crate.getLastOpenerName());
            this.placeholders.put("latest_rolled_reward", (player, crate) -> crate.getLastRewardName());
=======
            this.userPlaceholders.put("latest_opener", (player, crate) -> crate.getLastOpener().map(CachedProfile::query).map(NightProfile::getName).orElse(Lang.OTHER_LAST_OPENER_EMPTY.text()));
            this.userPlaceholders.put("latest_rolled_reward", (player, crate) -> crate.getLastRewardName());
>>>>>>> upstream/master
        }

        @Override
        @NotNull
        public String getIdentifier() {
            return this.plugin.getName().toLowerCase();
        }

        @Override
        @NotNull
        public String getAuthor() {
            return this.plugin.getDescription().getAuthors().getFirst();
        }

        @Override
        @NotNull
        public String getVersion() {
            return this.plugin.getDescription().getVersion();
        }

        @Override
        public boolean persist() {
            return true;
        }

        @Override
        public String onPlaceholderRequest(@Nullable Player player, @NotNull String params) {
<<<<<<< HEAD
            if (player == null) return null;

            for (var entry : this.placeholders.entrySet()) {
=======
            for (var entry : this.userPlaceholders.entrySet()) {
>>>>>>> upstream/master
                String prefix = entry.getKey() + "_";
                if (!params.startsWith(prefix)) continue;

                String id = params.substring(prefix.length());
                Crate crate = plugin.getCrateManager().getCrateById(id);
                if (crate == null) return null;

                return entry.getValue().apply(player, crate);
            }

            return null;
        }
    }
}

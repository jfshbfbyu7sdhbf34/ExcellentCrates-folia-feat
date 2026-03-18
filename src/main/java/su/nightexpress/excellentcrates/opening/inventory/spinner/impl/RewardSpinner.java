package su.nightexpress.excellentcrates.opening.inventory.spinner.impl;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.config.Keys;
=======
import su.nightexpress.excellentcrates.api.crate.Reward;
import su.nightexpress.excellentcrates.config.Config;
>>>>>>> upstream/master
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.crate.impl.Rarity;
import su.nightexpress.excellentcrates.opening.inventory.InventoryOpening;
import su.nightexpress.excellentcrates.opening.inventory.spinner.AbstractSpinner;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.opening.inventory.spinner.SpinnerData;
import su.nightexpress.excellentcrates.api.crate.Reward;
import su.nightexpress.excellentcrates.util.CrateUtils;
import su.nightexpress.nightcore.util.Lists;
import su.nightexpress.nightcore.util.PDCUtil;
import su.nightexpress.nightcore.util.random.Rnd;

import java.util.HashMap;
=======
import su.nightexpress.excellentcrates.opening.inventory.spinner.SpinMode;
import su.nightexpress.excellentcrates.opening.inventory.spinner.SpinnerData;
import su.nightexpress.nightcore.util.Lists;
import su.nightexpress.nightcore.util.random.Rnd;

import java.util.HashMap;
import java.util.List;
>>>>>>> upstream/master
import java.util.Map;
import java.util.Set;

public class RewardSpinner extends AbstractSpinner {

    private final Set<Rarity> rarities;

<<<<<<< HEAD
    public RewardSpinner(@NotNull SpinnerData data, @NotNull InventoryOpening opening, @NotNull Set<Rarity> rarities) {
        super(data, opening);
        this.rarities = rarities;
=======
    private int rewardIndex;

    public RewardSpinner(@NotNull SpinnerData data, @NotNull InventoryOpening opening, @NotNull Set<Rarity> rarities) {
        super(data, opening);
        this.rarities = rarities;
        this.rewardIndex = opening.getRewards().size(); // Start from latest index after previous reward spinners added their rewards.

        this.prepareRewards();
    }

    private boolean isWinSlot(int slot) {
        return Lists.contains(this.winSlots, slot);
    }

    private void prepareRewards() {
        for (int winSlot : this.winSlots) {
            if (Lists.contains(this.slots, winSlot)) {
                this.opening.addReward(this.rollReward(false));
            }
        }
    }

    @NotNull
    private Reward rollReward(boolean visual) {
        Crate crate = this.opening.getCrate();
        Player player = this.opening.getPlayer();

        if (!visual || Config.OPENINGS_GUI_SIMULATE_REAL_CHANCES.get()) {
            Map<Rarity, Double> rarityMap = new HashMap<>();
            this.rarities.forEach(rarity -> {
                if (crate.hasRewards(player, rarity)) {
                    rarityMap.put(rarity, rarity.getWeight());
                }
            });
            if (rarityMap.isEmpty()) throw new IllegalStateException("No rewards available!");

            Rarity rarity = Rnd.getByWeight(rarityMap);
            return crate.rollReward(this.opening.getPlayer(), rarity);
        }
        else {
            List<Reward> rewards = crate.getRewards(player);
            rewards.removeIf(reward -> !this.rarities.contains(reward.getRarity()));
            if (rewards.isEmpty()) throw new IllegalStateException("No rewards available!");

            return Rnd.get(rewards);
        }
>>>>>>> upstream/master
    }

    @Override
    @NotNull
<<<<<<< HEAD
    public ItemStack createItem() {
        Crate crate = this.opening.getCrate();
        Player player = this.opening.getPlayer();

        Map<Rarity, Double> rarityMap = new HashMap<>();
        this.rarities.forEach(rarity -> {
            if (crate.hasRewards(player, rarity)) {
                rarityMap.put(rarity, rarity.getWeight());
            }
        });
        if (rarityMap.isEmpty()) {
            return new ItemStack(Material.AIR);
        }

        Rarity rarity = Rnd.getByWeight(rarityMap);
        Reward reward = this.opening.getCrate().rollReward(this.opening.getPlayer(), rarity);

        ItemStack item = reward.getPreviewItem();
        PDCUtil.set(item, Keys.rewardId, reward.getId());

        return item;
=======
    public ItemStack createItem(int slot) {
        Reward reward = this.shouldUsePredictedReward(slot) ? this.opening.getRewards().get(this.rewardIndex++) : this.rollReward(true);
        if (reward == null) return new ItemStack(Material.AIR);

        return reward.getPreviewItem();
    }

    private boolean shouldUsePredictedReward(int slot) {
        if (this.rewardIndex >= this.opening.getRewards().size()) return false;

        int spinsLeft = Math.toIntExact(this.requiredSpins - this.spinCount);
        SpinMode mode = this.data.getMode();

        if (mode == SpinMode.SYNCRHONIZED) return spinsLeft == 1;
        if (mode == SpinMode.RANDOM || mode == SpinMode.INDEPENDENT) return spinsLeft == 1 && this.isWinSlot(slot);

        if (mode == SpinMode.SEQUENTAL) {
            for (int winSlot : this.winSlots) {
                int index = Lists.indexOf(this.slots, winSlot) + 1;
                if (index > 0 && spinsLeft == index) return true;
            }
        }

        return false;
    }

    @Override
    protected void spinRandom() {
        this.spinIndependent(); // Random mode makes no sense for reward spinners. Also it's not possible to predict reward for it.
>>>>>>> upstream/master
    }

    @Override
    protected void onStop() {
<<<<<<< HEAD
        if (this.isCompleted()) {
            this.checkRewards();
        }
    }

    private void checkRewards() {
        for (int slot : this.opening.getConfig().getWinSlots()) {
            if (!Lists.contains(this.slots, slot)) continue;

            ItemStack item = this.opening.getView().getItem(slot);
            if (item == null || item.getType().isAir()) continue;

            String rewardId = PDCUtil.getString(item, Keys.rewardId).orElse(null);
            if (rewardId == null) continue;

            Reward reward = this.opening.getCrate().getReward(rewardId);
            if (reward == null) continue;

            reward.give(this.opening.getPlayer());

            CrateUtils.callRewardObtainEvent(this.opening.getPlayer(), reward);

            PDCUtil.remove(item, Keys.rewardId);
        }
=======

>>>>>>> upstream/master
    }
}

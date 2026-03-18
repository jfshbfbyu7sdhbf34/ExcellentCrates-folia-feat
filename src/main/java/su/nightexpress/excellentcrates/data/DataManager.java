package su.nightexpress.excellentcrates.data;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.excellentcrates.CratesPlugin;
import su.nightexpress.excellentcrates.api.crate.Reward;
import su.nightexpress.excellentcrates.config.Config;
import su.nightexpress.excellentcrates.crate.impl.Crate;
import su.nightexpress.excellentcrates.data.crate.GlobalCrateData;
<<<<<<< HEAD
import su.nightexpress.excellentcrates.data.reward.RewardKey;
import su.nightexpress.excellentcrates.data.reward.RewardLimit;
=======
import su.nightexpress.excellentcrates.crate.reward.RewardKey;
import su.nightexpress.excellentcrates.data.reward.RewardData;
>>>>>>> upstream/master
import su.nightexpress.nightcore.manager.AbstractManager;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
<<<<<<< HEAD
=======
import java.util.stream.Collectors;
>>>>>>> upstream/master

public class DataManager extends AbstractManager<CratesPlugin> {

    private final Map<String, GlobalCrateData> crateDataMap;
<<<<<<< HEAD
    private final Map<RewardKey, RewardLimit>  rewardLimitMap;
=======
    private final Map<RewardKey, RewardData>   rewardLimitMap;
>>>>>>> upstream/master

    private boolean dataLoaded;

    public DataManager(@NotNull CratesPlugin plugin) {
        super(plugin);
        this.crateDataMap = new ConcurrentHashMap<>();
        this.rewardLimitMap = new ConcurrentHashMap<>();
    }

    @Override
    protected void onLoad() {
<<<<<<< HEAD
        this.plugin.runTaskAsync(() -> this.loadData());
=======
        this.plugin.runTaskAsync(task -> this.loadData());
>>>>>>> upstream/master

        this.addAsyncTask(this::saveCrateDatas, Config.DATA_CRATE_DATA_SAVE_INTERVAL.get());
        this.addAsyncTask(this::saveRewardLimits, Config.DATA_REWARD_LIMITS_SAVE_INTERVAL.get());
    }

    @Override
    protected void onShutdown() {
        this.saveData();
        this.crateDataMap.clear();
        this.rewardLimitMap.clear();
        this.dataLoaded = false;
    }

    public void saveData() {
        this.saveCrateDatas();
        this.saveRewardLimits();
    }

    public void saveCrateDatas() {
<<<<<<< HEAD
        Set<GlobalCrateData> dataSet = new HashSet<>();

        this.getCrateDatas().forEach(data -> {
            if (data.isSaveRequired()) {
                dataSet.add(data);
                data.setSaveRequired(false);
            }
        });
=======
        Set<GlobalCrateData> dataSet = this.getCrateDatas().stream()
            .filter(GlobalCrateData::isDirty)
            .peek(data -> data.setDirty(false))
            .collect(Collectors.toSet());
>>>>>>> upstream/master
        if (dataSet.isEmpty()) return;

        this.plugin.getDataHandler().updateCrateDatas(dataSet);
        //this.plugin.debug("Saved " + dataSet.size() + " crate datas.");
    }

    public void saveRewardLimits() {
<<<<<<< HEAD
        Set<RewardLimit> limits = new HashSet<>();

        this.getRewardLimits().forEach(limit -> {
            if (limit.isSaveRequired()) {
                limits.add(limit);
                limit.setSaveRequired(false);
            }
        });
=======
        Set<RewardData> limits = this.getRewardLimits().stream()
            .filter(RewardData::isSaveRequired)
            .peek(data -> data.setSaveRequired(false))
            .collect(Collectors.toSet());
>>>>>>> upstream/master
        if (limits.isEmpty()) return;

        this.plugin.getDataHandler().updateRewardLimits(limits);
        //this.plugin.debug("Saved " + limits.size() + " reward limits.");
    }

    public void loadData() {
        this.loadCrateDatas();
        this.loadRewardLimits();

        this.dataLoaded = true;
    }

    public void loadCrateDatas() {
        this.crateDataMap.clear();

        this.plugin.getDataHandler().loadCrateDatas().forEach(data -> {
            this.crateDataMap.put(data.getCrateId(), data);
        });

        //this.plugin.debug("Loaded " + this.crateDataMap.size() + " crate datas.");
    }

    public void loadRewardLimits() {
        this.rewardLimitMap.clear();

<<<<<<< HEAD
        this.plugin.getDataHandler().loadRewardLimits().forEach(limit -> {
            if (!this.removeExpired(limit)) {
                this.addRewardLimit(limit);
            }
        });
=======
        this.plugin.getDataHandler().loadRewardLimits().forEach(this::addRewardLimit);
>>>>>>> upstream/master

        //this.plugin.debug("Loaded " + this.rewardLimitMap.size() + " reward limit datas.");
    }



    public void handleSynchronization() {
        if (!this.isDataLoaded()) return;

        if (Config.isCrateDataSynchronized()) {
            this.loadCrateDatas();
        }
        if (Config.isRewardLimitsSynchronized()) {
            this.loadRewardLimits();
        }
    }

    public void handleCrateRemoval(@NotNull Crate crate) {
        if (Config.isCrateDataSynchronized()) {
            this.deleteCrateData(crate);
        }
        if (Config.isRewardLimitsSynchronized()) {
            this.deleteRewardLimits(crate);
        }
    }

    public void handleRewardRemoval(@NotNull Reward reward) {
        if (Config.isRewardLimitsSynchronized()) {
            this.deleteRewardLimits(reward);
        }
    }



    public boolean isDataLoaded() {
        return this.dataLoaded;
    }

    @NotNull
    public Set<GlobalCrateData> getCrateDatas() {
        return new HashSet<>(this.crateDataMap.values());
    }

    @Nullable
    public GlobalCrateData getCrateData(@NotNull String crateId) {
        return this.crateDataMap.get(crateId.toLowerCase());
    }

    @NotNull
    public GlobalCrateData getCrateDataOrCreate(@NotNull Crate crate) {
        GlobalCrateData data = this.getCrateData(crate.getId());
        if (data != null) return data;

        GlobalCrateData fresh = GlobalCrateData.create(crate);
<<<<<<< HEAD
        this.plugin.runTaskAsync(() -> this.plugin.getDataHandler().insertCrateData(fresh));
=======
        this.plugin.runTaskAsync(task -> this.plugin.getDataHandler().insertCrateData(fresh));
>>>>>>> upstream/master
        this.crateDataMap.put(fresh.getCrateId(), fresh);
        return fresh;
    }

    public void deleteCrateData(@NotNull Crate crate) {
<<<<<<< HEAD
        this.plugin.runTaskAsync(() -> this.plugin.getDataHandler().deleteCrateData(crate));
=======
        this.plugin.runTaskAsync(task -> this.plugin.getDataHandler().deleteCrateData(crate));
>>>>>>> upstream/master
        this.crateDataMap.remove(crate.getId());
    }



    @NotNull
<<<<<<< HEAD
    public RewardLimit getRewardLimitOrCreate(@NotNull Reward reward, @Nullable Player player) {
        RewardLimit limit = this.getRewardLimit(reward, player);
        if (limit != null && !this.removeExpired(limit)) return limit;

        RewardLimit fresh = RewardLimit.create(reward, player);
        this.plugin.runTaskAsync(() -> this.plugin.getDataHandler().insertRewardLimit(fresh));
=======
    public RewardData getRewardLimitOrCreate(@NotNull Reward reward, @Nullable Player player) {
        RewardData limit = this.getRewardLimit(reward, player);
        if (limit != null) return limit;

        RewardData fresh = RewardData.create(reward, player);
        this.plugin.runTaskAsync(task -> this.plugin.getDataHandler().insertRewardLimit(fresh));
>>>>>>> upstream/master
        this.addRewardLimit(fresh);
        return fresh;
    }

    @Nullable
<<<<<<< HEAD
    public RewardLimit getRewardLimit(@NotNull Reward reward, @Nullable Player player) {
=======
    public RewardData getRewardLimit(@NotNull Reward reward, @Nullable Player player) {
>>>>>>> upstream/master
        RewardKey key = getRewardKey(reward, player);
        return this.rewardLimitMap.get(key);
    }

    @NotNull
<<<<<<< HEAD
    public Set<RewardLimit> getRewardLimits() {
        return new HashSet<>(this.rewardLimitMap.values());
    }

    private void addRewardLimit(@NotNull RewardLimit limit) {
=======
    public Set<RewardData> getRewardLimits() {
        return new HashSet<>(this.rewardLimitMap.values());
    }

    private void addRewardLimit(@NotNull RewardData limit) {
>>>>>>> upstream/master
        RewardKey key = getRewardKey(limit);
        this.rewardLimitMap.put(key, limit);
    }

<<<<<<< HEAD
    private boolean removeExpired(@NotNull RewardLimit limit) {
        if (!limit.isResetTime()) return false;

        //this.plugin.debug("Expired reward limit removed: " + limit.getHolder() + " | " + limit.getCrateId() + " | " + limit.getRewardId());
        this.deleteRewardLimit(limit);
        return true;
    }

    public void deleteRewardLimit(@NotNull RewardLimit limit) {
        this.plugin.runTaskAsync(() -> this.plugin.getDataHandler().deleteRewardLimit(limit));
=======
    public void deleteRewardLimit(@NotNull RewardData limit) {
        this.plugin.runTaskAsync(task -> this.plugin.getDataHandler().deleteRewardLimit(limit));
>>>>>>> upstream/master
        this.rewardLimitMap.remove(getRewardKey(limit));
    }

    public void deleteRewardLimits(@NotNull Crate crate) {
        String crateId = crate.getId();

<<<<<<< HEAD
        this.plugin.runTaskAsync(() -> this.plugin.getDataHandler().deleteRewardLimits(crate));
        this.rewardLimitMap.keySet().removeIf(key -> key.getCrateId().equalsIgnoreCase(crateId));
=======
        this.plugin.runTaskAsync(task -> this.plugin.getDataHandler().deleteRewardLimits(crate));
        this.rewardLimitMap.keySet().removeIf(key -> key.crateId().equalsIgnoreCase(crateId));
>>>>>>> upstream/master
    }

    public void deleteRewardLimits(@NotNull Reward reward) {
        String crateId = reward.getCrate().getId();
        String rewardId = reward.getId();

<<<<<<< HEAD
        this.plugin.runTaskAsync(() -> this.plugin.getDataHandler().deleteRewardLimits(reward));
        this.rewardLimitMap.keySet().removeIf(key -> key.getCrateId().equalsIgnoreCase(crateId) && key.getRewardId().equalsIgnoreCase(rewardId));
=======
        this.plugin.runTaskAsync(task -> this.plugin.getDataHandler().deleteRewardLimits(reward));
        this.rewardLimitMap.keySet().removeIf(key -> key.crateId().equalsIgnoreCase(crateId) && key.rewardId().equalsIgnoreCase(rewardId));
>>>>>>> upstream/master
    }

    public void deleteRewardLimits(@NotNull UUID playerId) {
        String holder = playerId.toString();

<<<<<<< HEAD
        this.plugin.runTaskAsync(() -> this.plugin.getDataHandler().deleteRewardLimits(playerId));
        this.rewardLimitMap.keySet().removeIf(key -> key.getHolder().equalsIgnoreCase(holder));
=======
        this.plugin.runTaskAsync(task -> this.plugin.getDataHandler().deleteRewardLimits(playerId));
        this.rewardLimitMap.keySet().removeIf(key -> key.holder().equalsIgnoreCase(holder));
>>>>>>> upstream/master
    }



    @NotNull
    public static String getHolder(@NotNull Reward reward, @Nullable Player player) {
        return player == null ? reward.getCrate().getId() : player.getUniqueId().toString();
    }

    @NotNull
    public static RewardKey getRewardKey(@NotNull Reward reward, @Nullable Player player) {
        Crate crate = reward.getCrate();
        String holder = getHolder(reward, player);

        return new RewardKey(holder, crate.getId(), reward.getId());
    }

    @NotNull
<<<<<<< HEAD
    public static RewardKey getRewardKey(@NotNull RewardLimit limit) {
=======
    public static RewardKey getRewardKey(@NotNull RewardData limit) {
>>>>>>> upstream/master
        return new RewardKey(limit.getHolder(), limit.getCrateId(), limit.getRewardId());
    }
}

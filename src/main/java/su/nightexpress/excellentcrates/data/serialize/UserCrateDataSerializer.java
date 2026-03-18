package su.nightexpress.excellentcrates.data.serialize;

import com.google.gson.*;
import su.nightexpress.excellentcrates.data.crate.UserCrateData;

import java.lang.reflect.Type;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> upstream/master

public class UserCrateDataSerializer implements JsonSerializer<UserCrateData>, JsonDeserializer<UserCrateData> {

    @Override
    public UserCrateData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();

        long openCooldown = object.get("openCooldown").getAsLong();
<<<<<<< HEAD
        int openings = object.get("openings").getAsInt();
        int milestones = object.get("milestones").getAsInt();

        return new UserCrateData(openCooldown, openings, milestones);
    }

    @Override
    public JsonElement serialize(UserCrateData crateData, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();

        object.addProperty("openCooldown", crateData.getOpenCooldown());
        object.addProperty("openings", crateData.getOpenings());
        object.addProperty("milestones", crateData.getMilestone());
=======
        int openingStreak = Optional.ofNullable(object.get("openingStreak")).map(JsonElement::getAsInt).orElse(openCooldown != 0 ? 1 : 0);
        int openings = object.get("openings").getAsInt();
        int milestones = object.get("milestones").getAsInt();

        return new UserCrateData(openCooldown, openingStreak, openings, milestones);
    }

    @Override
    public JsonElement serialize(UserCrateData data, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();

        object.addProperty("openCooldown", data.getCooldownTimestamp());
        object.addProperty("openingStreak", data.getOpeningStreak());
        object.addProperty("openings", data.getOpenings());
        object.addProperty("milestones", data.getMilestone());
>>>>>>> upstream/master

        return object;
    }
}

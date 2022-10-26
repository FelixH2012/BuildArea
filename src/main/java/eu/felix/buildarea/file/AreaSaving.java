/**
 * Please no hatar for ugly code
 */

package eu.felix.buildarea.file;

import com.google.gson.*;
import eu.felix.buildarea.mapping.AreaData;
import eu.felix.buildarea.BuildArea;
import eu.felix.buildarea.mapping.AreaStorage;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.*;
import java.util.Map;

public class AreaSaving {

    private final File jsonFile;

    public AreaSaving(File file) {
        this.jsonFile = file;

        if (!jsonFile.exists()) {
            try {
                if (!jsonFile.createNewFile()) throw new IOException("Could not create new file");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void save() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(jsonFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gson.toJson(saveJson(), fileWriter);
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JsonObject saveJson() {
        final JsonObject jsonObject = new JsonObject();
        if (!AreaStorage.areas.isEmpty()) {
            AreaStorage.areas.forEach(storage -> {
                JsonObject nameJson = new JsonObject();
                nameJson.addProperty("AreaName", storage.getAreaName());
                final JsonObject areaData = new JsonObject();
                areaData.addProperty("X1", storage.getFirstLocation().getX());
                areaData.addProperty("X2", storage.getSecondLocation().getX());
                areaData.addProperty("Y1", storage.getFirstLocation().getY());
                areaData.addProperty("Y2", storage.getSecondLocation().getY());
                areaData.addProperty("Z1", storage.getFirstLocation().getZ());
                areaData.addProperty("Z2", storage.getSecondLocation().getZ());
                areaData.addProperty("ResetInterval", storage.getResetDelay());
                areaData.addProperty("allowRun", storage.isAllowToRun);
                nameJson.add("Data", areaData);
                jsonObject.add(storage.getAreaName(), nameJson);
            });
        }
        return jsonObject;
    }

    public void loadData(BuildArea buildArea) {

        if (jsonFile.exists()) {
            try {
                if (load(new JsonParser().parse(new FileReader(jsonFile)), buildArea)) {
                    System.out.println("Loaded area data!");
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }


    private boolean load(final JsonElement jsonElement, BuildArea buildArea) {
        try {
            if (jsonElement instanceof JsonNull)
                return false;


            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                final JsonObject jsonModule = (JsonObject) entry.getValue();
                if (jsonModule.has("Data")) {

                    final double x1 = jsonModule.get("Data").getAsJsonObject().get("X1").getAsDouble();
                    final double x2 = jsonModule.get("Data").getAsJsonObject().get("X2").getAsDouble();

                    final double y1 = jsonModule.get("Data").getAsJsonObject().get("Y1").getAsDouble();

                    final double y2 = jsonModule.get("Data").getAsJsonObject().get("Y2").getAsDouble();

                    final double z1 = jsonModule.get("Data").getAsJsonObject().get("Z1").getAsDouble();
                    final double z2 = jsonModule.get("Data").getAsJsonObject().get("Z2").getAsDouble();

                    final int resetInterval = jsonModule.get("Data").getAsJsonObject().get("ResetInterval").getAsInt();

                    final boolean allowToRun = jsonModule.get("Data").getAsJsonObject().get("allowRun").getAsBoolean();

                    final String areaName = entry.getKey();

                    final Location firstLocation = new Location(Bukkit.getWorld("world"), x1, y1, z1);

                    final Location secondLocation = new Location(Bukkit.getWorld("world"), x2, y2, z2);


                    final AreaData areaData = new AreaData(areaName, firstLocation, secondLocation, resetInterval);
                    areaData.isAllowToRun = allowToRun;
                    AreaStorage.areas.add(areaData);

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}

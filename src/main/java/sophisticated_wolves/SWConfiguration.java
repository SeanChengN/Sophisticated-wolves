package sophisticated_wolves;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Sophisticated Wolves
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SWConfiguration {

    private static SWConfiguration instance;
    private static Configuration config;


    public static boolean customWolfTextures = true;
    public static boolean respawningWolves = true;
    public static boolean customBreeding = true;
    public static boolean nameTagForAnyPets = true;
    public static boolean immuneToCacti = true;

    public static boolean attackAnimals = false;
    public static boolean attackSkeletons = true;

    public static int spawnProbability = 1;
    public static int spawnMinCount = 4;
    public static int spawnMaxCount = 4;

    private SWConfiguration(File configFile) {
        this.config = new Configuration(configFile);
        getConfigs();
    }

    public static SWConfiguration getInstance(File configFile) {
        if (instance == null) {
            return new SWConfiguration(configFile);
        } else {
            return instance;
        }
    }

    public final void getConfigs() {
        config.load();

        customWolfTextures = config.get(Configuration.CATEGORY_GENERAL, "CustomWolfTextures", true).getBoolean(true);
        respawningWolves = config.get(Configuration.CATEGORY_GENERAL, "RespawningWolves", true).getBoolean(true);
        customBreeding = config.get(Configuration.CATEGORY_GENERAL, "CustomBreeding", true).getBoolean(true);
        nameTagForAnyPets = config.get(Configuration.CATEGORY_GENERAL, "NameTagForAnyPets", true).getBoolean(true);
        immuneToCacti = config.get(Configuration.CATEGORY_GENERAL, "ImmuneToCacti", true).getBoolean(true);
        attackAnimals = config.get(Configuration.CATEGORY_GENERAL, "AttackAnimals", false).getBoolean(false);
        attackSkeletons = config.get(Configuration.CATEGORY_GENERAL, "AttackSkeletons", true).getBoolean(true);

        spawnProbability = config.get(Configuration.CATEGORY_GENERAL, "SpawnProbability", 1).getInt(1);
        spawnMinCount = config.get(Configuration.CATEGORY_GENERAL, "SpawnMinCount", 4).getInt(4);
        spawnMaxCount = config.get(Configuration.CATEGORY_GENERAL, "SpawnMaxCount", 4).getInt(4);
        if (spawnMinCount < 0) {
            spawnMinCount = 0;
        }
        if (spawnMaxCount < spawnMinCount) {
            spawnMaxCount = spawnMinCount;
        }

        config.save();
    }
}

package com.github.aabssmc.minehutapi.server;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.github.aabssmc.minehutapi.MinehutAPI.request;

/**
 * The Icon Class
 */
@SuppressWarnings("unused")
public enum Icon {
    /**
     * The Sunflower Icon.
     */
    SUNFLOWER("6172e1f9ba3e7c00755da4de"),
    /**
     * The Redstone Block Icon.
     */
    REDSTONE_BLOCK("5eb9c16826c96b1e13b1bc60"),
    /**
     * Flowering Azalea Icon.
     */
    FLOWERING_AZALEA("61bcba825ccece00ec3f54e5"),
    /**
     * Diamond Pickaxe Icon.
     */
    DIAMOND_PICKAXE("5eb9bf620a50651be22b5102"),
    /**
     * Bedrock Icon.
     */
    BEDROCK("615b78e7de00ed007bbbf108"),
    /**
     * Lava Bucket Icon.
     */
    LAVA_BUCKET("5e7471aa0c53f7005f9b783b"),
    /**
     * Candle Icon.
     */
    CANDLE("61bcb9debbc2f000b8f98feb"),
    /**
     * Redstone Dust Icon.
     */
    REDSTONE_DUST("5e8cb3b47a4f630097c215b4"),

    /**
     * Snowball Icon.
     */
    SNOWBALL("60075c351c78e40073b9e6c3"),

    /**
     * Crafting Table Icon.
     */
    CRAFTING_TABLE("5eb9c19e4128c21cae29c236"),

    /**
     * Enchanted Book Icon.
     */
    ENCHANTED_BOOK("5eb9c14d68edc21b3870bfff"),

    /**
     * Golden Hoe Icon.
     */
    GOLDEN_HOE("5eb9c08dadae1d1b8d6d309d"),

    /**
     * Golden Pickaxe Icon.
     */
    GOLDEN_PICKAXE("5e74715ead31770058c5f29e"),

    /**
     * Hay Block Icon.
     */
    HAY_BLOCK("6172e14622a0d100928170e9"),

    /**
     * Gold Ore Icon.
     */
    GOLD_ORE("5eb9c0a9eaf0a51c21da3c31"),

    /**
     * Gunpowder Icon.
     */
    GUNPOWDER("5eb9c0ec9467b81c8d17b0b7"),

    /**
     * Iron Shovel Icon.
     */
    IRON_SHOVEL("5eb9c0167f4d7c1c9e6b3832"),

    /**
     * Chain Icon.
     */
    CHAIN("6172e1239dfa5b007cdc0379"),

    /**
     * Emerald Icon.
     */
    EMERALD("5eb9c1c9a812e61b8dfe62d5"),

    /**
     * Iron Bars Icon.
     */
    IRON_BARS("5e8cb3cb8c84e800b918a732"),

    /**
     * Iron Block Icon.
     */
    IRON_BLOCK("5eb9c0470a50651be22b510a"),

    /**
     * Pufferfish Bucket Icon.
     */
    PUFFERFISH_BUCKET("5fdcf5733313a2baac1c9115"),

    /**
     * Wheat Icon.
     */
    WHEAT("5e8cb35710a5af0058e1f671"),

    /**
     * Scute Icon.
     */
    SCUTE("6172e1e1c8de35007573abd5"),

    /**
     * Cookie Icon.
     */
    COOKIE("5eb9c10708513d1b7c803025"),

    /**
     * Glow Ink Sac Icon.
     */
    GLOW_INK_SAC("61bcba425ccece00ec3f4afa"),

    /**
     * Bow Icon.
     */
    BOW("5eb9c1e69467b81c8d17b0c1"),

    /**
     * Iron Pickaxe Icon.
     */
    IRON_PICKAXE("5eb9c0080a50651be22b5107"),

    /**
     * Elytra Icon.
     */
    ELYTRA("5eb9c0dd3020ee1b493c6f7b"),

    /**
     * Gold Block Icon.
     */
    GOLD_BLOCK("5eb9c0b62662131e8a4703aa"),

    /**
     * Emerald Block Icon.
     */
    EMERALD_BLOCK("5fdcf5a47968deb9174b320f"),

    /**
     * TNT Icon.
     */
    TNT("5eb9c0c1ea3b021d25b511a9"),

    /**
     * Diamond Boots Icon.
     */
    DIAMOND_BOOTS("5eb9bfc31fd2221c6b9e4434"),

    /**
     * Red Candle Icon.
     */
    RED_CANDLE("61bcba5ca4747800c524a46f"),

    /**
     * Sponge Icon.
     */
    SPONGE("5eb9c0f9da3b691b27940623"),

    /**
     * Chest Icon.
     */
    CHEST("5eb9c1ab08513d1b7c80302b"),

    /**
     * Firework Rocket Icon.
     */
    FIREWORK_ROCKET("5eb9c20deaf0a51c21da3c3b"),

    /**
     * Diamond Hoe Icon.
     */
    DIAMOND_HOE("5eb9bfaa8b20fe1e572c6ed0"),

    /**
     * Totem of Undying Icon.
     */
    TOTEM_OF_UNDYING("6172e2276aa038008ee04dc2"),

    /**
     * Water Bucket Icon.
     */
    WATER_BUCKET("5e8cb39a0248de0098858ef4"),

    /**
     * Diamond Shovel Icon.
     */
    DIAMOND_SHOVEL("5eb9bf7cea3b021d25b511a0"),

    /**
     * Arrow Icon.
     */
    ARROW("5eb9c1f372541d1c7cf7fc89"),

    /**
     * Iron Hoe Icon.
     */
    IRON_HOE("5eb9c02972541d1c7cf7fc7c"),

    /**
     * White Candle Icon.
     */
    WHITE_CANDLE("61bcbb15a884ac00c5e38f6d"),

    /**
     * Cake Icon.
     */
    CAKE("5e74719738451e006888cb08"),

    /**
     * Potato Icon.
     */
    POTATO("5fdcf560fba655bbf0eccad8"),

    /**
     * Axolotl Bucket Icon.
     */
    AXOLOTL_BUCKET("61bcba1d88181b00c56fb3bf"),
    /**
     * Iron Sword Icon.
     */
    IRON_SWORD("5eb9bff1a812e61b8dfe62c8"),
    /**
     * Nether Star Icon.
     */
    NETHER_STAR("5fdcf54a39e080aabff441c2"),
    /**
     * Bucket Icon.
     */
    BUCKET("5eb9c1818b20fe1e572c6ee0"),
    /**
     * Red Mushroom Block Icon.
     */
    RED_MUSHROOM_BLOCK("6172e18865cb460075f169f0"),
    /**
     * Snow Block Icon.
     */
    SNOW_BLOCK("61bcb9b8098e6e00abe469ee"),
    /**
     * End Crystal Icon.
     */
    END_CRYSTAL("61bcbadedaa26600c58da35d"),
    /**
     * Bell Icon.
     */
    BELL("5fdcf5ac381170bce30589ef"),
    /**
     * Iron Boots Icon.
     */
    IRON_BOOTS("5eb9c03a099ea01cbfcfbfe5"),
    /**
     * Golden Shovel Icon.
     */
    GOLDEN_SHOVEL("5eb9c07e2662131e8a4703a6"),
    /**
     * Cactus Icon.
     */
    CACTUS("5fdcf583fc5814bb9d273507"),
    /**
     * Target Icon.
     */
    TARGET("6172e205ba3e7c00755da63b"),
    /**
     * Stonecutter Icon.
     */
    STONECUTTER("6172e1ee9dfa5b007cdc12a2"),
    /**
     * Sea Lantern Icon.
     */
    SEA_LANTERN("5eb9c12254b32e1c37b57763"),
    /**
     * Apple Icon.
     */
    APPLE("5fdcf5a47968deb9174b320e"),
    /**
     * Trident Icon.
     */
    TRIDENT("5fdcf5988d46cdbac8d123bd"),
    /**
     * Diamond Sword Icon.
     */
    DIAMOND_SWORD("5e7471850275560052b2ea01"),
    /**
     * Jack o' Lantern Icon.
     */
    JACK_O_LANTERN("6172e15d364f0200832b4f72"),
    /**
     * Blaze Rod Icon.
     */
    BLAZE_ROD("5fdcf58b7968deb9174b320e"),
    /**
     * Grass Block Icon.
     */
    GRASS_BLOCK("5e7471730275560052b2ea00"),
    /**
     * Dragon Egg Icon.
     */
    DRAGON_EGG("5fb5905b22006e0095e5a4f6"),
    /**
     * Diamond Ore Icon.
     */
    DIAMOND_ORE("5eb9bfd126c96b1e13b1bc52"),
    /**
     * Oak Boat Icon.
     */
    OAK_BOAT("5eb9c0ce13078b1c6b9d9768"),
    /**
     * Music Disc 11 Icon.
     */
    MUSIC_DISC_11("61bcbab6bbc2f000b8f9b256"),
    /**
     * Gold Ingot Icon.
     */
    GOLD_INGOT("5eb9c054d125f31b1651b017"),
    /**
     * Shield Icon.
     */
    SHIELD("5eb9c1d8f6c4d51cae77d80d"),
    /**
     * Creeper Spawn Egg Icon.
     */
    CREEPER_SPAWN_EGG("5fdcf55832a323abb90ce974"),
    /**
     * Golden Apple Icon.
     */
    GOLDEN_APPLE("5eb9c200a812e61b8dfe62d9"),
    /**
     * Glowstone Icon.
     */
    GLOWSTONE("61bcbaf3daa26600c58da69f"),
    /**
     * Redstone Ore Icon.
     */
    REDSTONE_ORE("5eb9c175b04a8c1b6b4a1fa4"),
    /**
     * Diamond Block Icon.
     */
    DIAMOND_BLOCK("5eb9bfe0f6c4d51cae77d7f2"),
    /**
     * Golden Boots Icon.
     */
    GOLDEN_BOOTS("5eb9c09c640dc21b16d4f9f0"),
    /**
     * Magma Block Icon.
     */
    MAGMA_BLOCK("6172e16dbca1f10085890e32"),
    /**
     * Enchanting Table Icon.
     */
    ENCHANTING_TABLE("5eb9c191da3b691b2794062a"),
    /**
     * Music Disc Wait Icon.
     */
    MUSIC_DISC_WAIT("61bcb9fceb6a4f00fa401fb2"),
    /**
     * Ender Chest Icon.
     */
    ENDER_CHEST("5eb9c1bab64b891b271ddab7"),
    /**
     * Music Disc Pigstep Icon.
     */
    MUSIC_DISC_PIGSTEP("61bcbb3174013b00d215408e"),
    /**
     * Ender Pearl Icon.
     */
    ENDER_PEARL("5eb9c13eea3b021d25b511ad"),
    /**
     * Beacon Icon.
     */
    BEACON("5eb9c1164128c21cae29c231"),
    /**
     * Ink Sac Icon.
     */
    INK_SAC("61bcb9ca88181b00c56faa62"),
    /**
     * Diamond Icon.
     */
    DIAMOND("5eb9bf982662131e8a47039b"),
    /**
     * Ender Eye Icon.
     */
    ENDER_EYE("5eb9c132e9e3a11b27eef3a5"),
    /**
     * Command Block Icon.
     */
    COMMAND_BLOCK("5eb9c15ad125f31b1651b01e"),
    /**
     * Golden Sword Icon.
     */
    GOLDEN_SWORD("5eb9c0617f4d7c1c9e6b3837"),
    /**
     * Iron Ore Icon.
     */
    IRON_ORE("5e8cb37153ba8700a85a7c64");



        private JSONObject icon;

        Icon(String id) {
            String req = request("https://api.minehut.com/", "servers/icons");
            JSONArray jsonArray = new JSONArray(req);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String objectId = jsonObject.getString("_id");
                if (objectId.equals(id)) {
                    icon = jsonObject;
                }
            }
            icon = null;
        }

    /**
     * @param id The id of the icon.
     * @return An icon.
     */
        // if anyone knows how to improve this please make a PR!
        public static Icon getIcon(String id){
            String req = request("https://api.minehut.com/", "servers/icons");
            JSONArray jsonArray = new JSONArray(req);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String objectId = jsonObject.getString("_id");
                if (objectId.equals(id)) {
                    return Icon.valueOf(jsonObject.getString("icon_name"));
                }
            }
            return null;
        }

    /**
     * @return Returns true if the icon can be purchased now.
     */
    public boolean isAvailable(){
        return icon.getBoolean("available");
    }

    /**
     * @return Returns the date the icon was created in unix timestamp.
     */
    public long getCreated(){
        return icon.getLong("created");
    }

    /**
     * @return Returns true if the icon is disabled.
     */
    public boolean isDisabled(){
        return icon.getBoolean("disabled");
    }

    /**
     * @return Returns the display name of the icon.
     */
    public String getDisplayName(){
        return icon.getString("display_name");
    }

    /**
     * @return Returns the icon name of the icon.
     */
    public String getIconName(){
        return icon.getString("icon_name");
    }

    /**
     * @return Returns the date the icon was last updated in unix timestamp.
     */
    public long getLastUpdated(){
        return icon.getLong("last_updated");
    }

    /**
     * @return Returns the price of the icon.
     */
    public int getPrice(){
        return icon.getInt("price");
    }

    /**
     * @return Returns rank of the icon.
     */
    public String getRank(){
        return icon.getString("rank");
    }

    /**
     * @return Returns the id of the icon.
     */
    public String getId(){
        return icon.getString("_id");
    }
}

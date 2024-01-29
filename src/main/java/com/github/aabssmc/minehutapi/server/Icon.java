package com.github.aabssmc.minehutapi.server;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.github.aabssmc.minehutapi.MinehutAPI.request;

public enum Icon {
    SUNFLOWER(0),
    REDSTONE_BLOCK(1),
    FLOWERING_AZALEA(2),
    DIAMOND_PICKAXE(3),
    BEDROCK(4),
    LAVA_BUCKET(5),
    CANDLE(6),
    REDSTONE_DUST(7),
    SNOWBALL(8),
    CRAFTING_TABLE(9),
    ENCHANTED_BOOK(10),
    GOLDEN_HOE(11),
    GOLDEN_PICKAXE(12),
    HAY_BLOCK(13),
    GOLD_ORE(14),
    GUNPOWDER(15),
    IRON_SHOVEL(16),
    CHAIN(17),
    EMERALD(18),
    IRON_BARS(19),
    IRON_BLOCK(20),
    PUFFERFISH_BUCKET(21),
    WHEAT(22),
    SCUTE(23),
    COOKIE(24),
    GLOW_INK_SAC(25),
    BOW(26),
    IRON_PICKAXE(27),
    ELYTRA(28),
    GOLD_BLOCK(29),
    EMERALD_BLOCK(30),
    TNT(31),
    DIAMOND_BOOTS(32),
    RED_CANDLE(33),
    SPONGE(34),
    CHEST(35),
    FIREWORK_ROCKET(36),
    DIAMOND_HOE(37),
    TOTEM_OF_UNDYING(38),
    WATER_BUCKET(39),
    DIAMOND_SHOVEL(40),
    ARROW(41),
    IRON_HOE(42),
    WHITE_CANDLE(43),
    CAKE(44),
    POTATO(45),
    AXOLOTL_BUCKET(46),
    IRON_SWORD(47),
    NETHER_STAR(48),
    BUCKET(49),
    RED_MUSHROOM_BLOCK(50),
    SNOW_BLOCK(51),
    END_CRYSTAL(52),
    BELL(53),
    IRON_BOOTS(54),
    GOLDEN_SHOVEL(55),
    CACTUS(56),
    TARGET(57),
    STONECUTTER(58),
    SEA_LANTERN(59),
    APPLE(60),
    TRIDENT(61),
    DIAMOND_SWORD(62),
    JACK_O_LANTERN(63),
    BLAZE_ROD(64),
    GRASS_BLOCK(65),
    DRAGON_EGG(66),
    DIAMOND_ORE(67),
    OAK_BOAT(68),
    MUSIC_DISC_11(69),
    GOLD_INGOT(70),
    SHIELD(71),
    CREEPER_SPAWN_EGG(72),
    GOLDEN_APPLE(73),
    GLOWSTONE(74),
    REDSTONE_ORE(75),
    DIAMOND_BLOCK(76),
    GOLDEN_BOOTS(77),
    MAGMA_BLOCK(78),
    ENCHANTING_TABLE(79),
    MUSIC_DISC_WAIT(80),
    ENDER_CHEST(81),
    MUSIC_DISC_PIGSTEP(82),
    ENDER_PEARL(83),
    BEACON(84),
    INK_SAC(85),
    DIAMOND(86),
    ENDER_EYE(87),
    COMMAND_BLOCK(88),
    GOLDEN_SWORD(89),
    IRON_ORE(90);

    private final JSONObject icon;

    Icon(Integer index) {
        String req = request("https://api.minehut.com/", "servers/icons");
        icon = new JSONArray(req).getJSONObject(index);
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
    public long getDisplayName(){
        return icon.getLong("display_name");
    }

    /**
     * @return Returns the icon name of the icon.
     */
    public long getIconName(){
        return icon.getLong("icon_name");
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

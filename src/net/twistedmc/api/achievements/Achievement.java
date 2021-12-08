package net.twistedmc.api.achievements;


import net.twistedmc.api.framework.SeasonalType;
import net.twistedmc.api.framework.ServerGameType;

public enum Achievement {

    // Special Achievements
    UNKNOWN(AchievementType.SECRET, ServerGameType.ENCHANTED,"???", AchievementDifficulty.NOVICE, "???", 5),

    // General Achievements
    TWISTED_SERVER(AchievementType.NORMAL,"Achievement Get! Twisted Server!", AchievementDifficulty.NOVICE, "Join the TwistedMC Network for the first time", 5),
    ACHIEVEMENTS(AchievementType.NORMAL,"Achievements!?!", AchievementDifficulty.NOVICE, "Click the Achievement Guide in the Main Lobby", 5),
    BABY_STEPS(AchievementType.NORMAL,"Baby Steps", AchievementDifficulty.NOVICE, "Play a minigame", 5),
    CREEPERBOOK(AchievementType.NORMAL,"Creeperbook", AchievementDifficulty.NOVICE, "Link your Minecraft account to your Discord account", 5),
    EEEEKK(AchievementType.NORMAL,"EEEEKK!", AchievementDifficulty.MEDIUM, "Be in the same lobby as a YouTuber", 10),
    FIRST_WORDS(AchievementType.NORMAL,"Let the world hear your voice!", AchievementDifficulty.NOVICE, "Use chat for the first time", 5),
    NOT_ALONE(AchievementType.NORMAL,"Not forever alone...", AchievementDifficulty.NOVICE, "Make a friend using the friend system", 5),
    ACTIVATE_BOOSTER(AchievementType.NORMAL,"Network Booster", AchievementDifficulty.MEDIUM, "Activate any type of booster", 10),
    PERSONAL_BANKER(AchievementType.NORMAL,"Personal Banker", AchievementDifficulty.HARD, "Have a total of 1,000,000 coins saved up", 15),
    VERY_IMPORTANT_PERSON(AchievementType.NORMAL,"Very Important Person", AchievementDifficulty.MEDIUM, "Become a VIP", 10),
    VERY_VERY_IMPORTANT_PERSON(AchievementType.NORMAL,"Very Very Important Person", AchievementDifficulty.HARD, "Become a VIP+", 15),

    TOTAL_COINS_I(AchievementType.TIERED,"Ultimate Banker I", AchievementDifficulty.NOVICE, "Earn a total of 1,000 coins", 5),
    TOTAL_COINS_II(AchievementType.TIERED,"Ultimate Banker II", AchievementDifficulty.EASY, "Earn a total of 30,000 coins", 10),
    TOTAL_COINS_III(AchievementType.TIERED,"Ultimate Banker III", AchievementDifficulty.MEDIUM, "Earn a total of 95,000 coins", 15),
    TOTAL_COINS_IV(AchievementType.TIERED,"Ultimate Banker IV", AchievementDifficulty.HARD, "Earn a total of 150,000 coins", 20),
    TOTAL_COINS_V(AchievementType.TIERED,"Ultimate Banker V", AchievementDifficulty.INSANE, "Earn a total of 350,000 coins", 25),

    WINNING_I(AchievementType.TIERED,"Winning I", AchievementDifficulty.NOVICE, "Win 15 minigames", 5),
    WINNING_II(AchievementType.TIERED,"Winning II", AchievementDifficulty.EASY, "Win 150 minigames", 10),
    WINNING_III(AchievementType.TIERED,"Winning III", AchievementDifficulty.MEDIUM, "Win 500 minigames", 15),
    WINNING_IV(AchievementType.TIERED,"Winning IV", AchievementDifficulty.HARD, "Win 1,500 minigames", 20),
    WINNING_V(AchievementType.TIERED,"Winning V", AchievementDifficulty.INSANE, "Win 2,500 minigames", 25),

    // Enchanted Achievements
    SHOPPING_SPREE_I(AchievementType.TIERED, ServerGameType.ENCHANTED,"Shoppin' Spree I", AchievementDifficulty.NOVICE, "Purchase a total of 1,000 items from any Shop Villager", 5),
    SHOPPING_SPREE_II(AchievementType.TIERED, ServerGameType.ENCHANTED,"Shoppin' Spree II", AchievementDifficulty.EASY, "Purchase a total of 25,000 items from any Shop Villager", 10),
    SHOPPING_SPREE_III(AchievementType.TIERED, ServerGameType.ENCHANTED,"Shoppin' Spree III", AchievementDifficulty.MEDIUM, "Purchase a total of 45,000 items from any Shop Villager", 15),
    SHOPPING_SPREE_IV(AchievementType.TIERED, ServerGameType.ENCHANTED,"Shoppin' Spree IV", AchievementDifficulty.HARD, "Purchase a total of 65,000 items from any Shop Villager", 20),
    SHOPPING_SPREE_V(AchievementType.TIERED, ServerGameType.ENCHANTED,"Shoppin' Spree V", AchievementDifficulty.INSANE, "Purchase a total of 95,000 items from any Shop Villager", 25),

    ADVENTURE_BEGINS(AchievementType.NORMAL, ServerGameType.ENCHANTED,"Your adventure begins..", AchievementDifficulty.NOVICE, "Travel to the wilderness from hub island", 5),
    HELL(AchievementType.NORMAL, ServerGameType.ENCHANTED,"Hell", AchievementDifficulty.MEDIUM, "Visit the nether", 15),
    THE_END(AchievementType.NORMAL, ServerGameType.ENCHANTED,"Beginning of the end..", AchievementDifficulty.HARD, "Visit the end", 20),

    // Seasonal Achievements

    // Christmas

    MERRY_CHRISTMAS_2021(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Merry Christmas! 2021", AchievementDifficulty.INSANE, "Open all Advent Calendar Windows (2021)", 25),

    DEC_25_2021(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"December 25th, 2021", AchievementDifficulty.INSANE, "Open December 25th Advent Calendar Window (2021)", 25),

    INCOMING(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Incoming Meteorites!!", AchievementDifficulty.NOVICE, "Login to Survival before December 1st, 2021", 5),

    A_VERY_MERRY_VISIT(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"A Very Merry Visit", AchievementDifficulty.NOVICE, "Login to Survival between December 1st, 2021 and December 25th, 2021", 5),

    SPIRIT_OF_GIVING(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Spirit of Giving", AchievementDifficulty.NOVICE, "Activate a booster during TwistedMC's Very Merriest Celebration", 5),

    WINTERY_DEVOTION(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Wintery Devotion", AchievementDifficulty.EASY, "Kill a Fox, Dolphin, Villager (Taiga/Snow), Polar Bear or Goat for it's Snowflakes.", 10),

    SO_THIS_IS_CHRISTMAS(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"So This is Christmas?", AchievementDifficulty.EASY, "Login to Survival during the first TwistedMC's Christmastime Fireworks", 10),

    FEELS_LIKE_CHRISTMAS(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Feels like Christmas!", AchievementDifficulty.EASY, "Enter a Snowy Biome", 10),

    FEELING_FROSTY(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Feeling Frostyyy", AchievementDifficulty.EASY, "Build a Snowman and then kill it.", 10),

    MY_SNOWFLAKE_COLLECTION(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"My Snowflake Collection", AchievementDifficulty.NOVICE, "Collect 1,000 Snowflakes", 15),

    REAL_SANTA(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Real Santa", AchievementDifficulty.INSANE, "Find all 41 Presents in the Main Lobby", 15),

    HAPPY_HOLIDAYS(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Happy Holidays!", AchievementDifficulty.NOVICE, "Speak to the Holidays Guide in the Main Lobby", 5),

    SNOWFLAKE_COLLECTOR_I(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Snowflake Collector I", AchievementDifficulty.NOVICE, "Collect 2,000 Snowflakes in Survival", 5),
    SNOWFLAKE_COLLECTOR_II(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Snowflake Collector II", AchievementDifficulty.EASY, "Collect 4,000 Snowflakes in Survival", 10),
    SNOWFLAKE_COLLECTOR_III(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Snowflake Collector III", AchievementDifficulty.MEDIUM, "Collect 5,000 Snowflakes in Survival", 15),
    SNOWFLAKE_COLLECTOR_IV(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Snowflake Collector IV", AchievementDifficulty.HARD, "Collect 8,000 Snowflakes in Survival", 20),
    SNOWFLAKE_COLLECTOR_V(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Snowflake Collector V", AchievementDifficulty.INSANE, "Collect 10,000 Snowflakes in Survival", 25),

    ADVENT_CALENDAR_I(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Advent Calendar I", AchievementDifficulty.NOVICE, "Claim 1 Days in the Advent Calendar", 5),
    ADVENT_CALENDAR_II(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Advent Calendar II", AchievementDifficulty.EASY, "Claim 3 Days in the Advent Calendar", 10),
    ADVENT_CALENDAR_III(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Advent Calendar III", AchievementDifficulty.MEDIUM, "Claim 7 Days in the Advent Calendar", 15),
    ADVENT_CALENDAR_IV(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Advent Calendar IV", AchievementDifficulty.HARD, "Claim 14 Days in the Advent Calendar", 20),
    ADVENT_CALENDAR_V(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.CHRISTMAS,"Advent Calendar V", AchievementDifficulty.INSANE, "Claim 21 Days in the Advent Calendar", 25),



    // Halloween

    BOO(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Boo!", AchievementDifficulty.NOVICE, "Speak to the Halloween Guide in the Main Lobby", 5),

    ALL_BASKETS(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"All Baskets", AchievementDifficulty.MEDIUM, "Find all Candy Baskets in the Main Lobby", 15),
    FIVE_BASKETS(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Five Baskets", AchievementDifficulty.NOVICE, "Find five Candy Baskets in the Main Lobby", 5),
    SUGAR_RUSH(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Sugar Rush", AchievementDifficulty.MEDIUM, "Collect 70 candy in Survival", 15),
    TRICK_OR_TREAT_TIME(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Trick or Treat Time!", AchievementDifficulty.NOVICE, "Give a player one of your candies", 5),
    PUMPKINATOR_RAMPAGE(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Pumpkinator Rampage", AchievementDifficulty.EASY, "Bring 15 pumpkins at once to a Shopkeeper in Bed Wars", 10),
    THE_LUCKY_PUMPKIN(AchievementType.NORMAL, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"The Lucky Pumpkin", AchievementDifficulty.NOVICE, "Bring one pumpkin to a Shopkeeper in Bed Wars", 5),

    CANDY_HOARDER_I(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Candy Hoarder I", AchievementDifficulty.NOVICE, "Collect 50 candy in Survival", 5),
    CANDY_HOARDER_II(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Candy Hoarder II", AchievementDifficulty.EASY, "Collect 250 candy in Survival", 10),
    CANDY_HOARDER_III(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Candy Hoarder III", AchievementDifficulty.MEDIUM, "Collect 750 candy in Survival", 15),
    CANDY_HOARDER_IV(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Candy Hoarder IV", AchievementDifficulty.HARD, "Collect 1500 candy in Survival", 20),
    CANDY_HOARDER_V(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Candy Hoarder V", AchievementDifficulty.INSANE, "Collect 3000 candy in Survival", 25),

    PUMPKINATOR_COLLECTOR_I(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Pumpkinator Collector I", AchievementDifficulty.NOVICE, "Collect 5 pumpkins in Bed Wars", 5),
    PUMPKINATOR_COLLECTOR_II(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Pumpkinator Collector II", AchievementDifficulty.EASY, "Collect 25 pumpkins in Bed Wars", 10),
    PUMPKINATOR_COLLECTOR_III(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Pumpkinator Collector III", AchievementDifficulty.MEDIUM, "Collect 100 pumpkins in Bed Wars", 15),
    PUMPKINATOR_COLLECTOR_IV(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Pumpkinator Collector IV", AchievementDifficulty.HARD, "Collect 250 pumpkins in Bed Wars", 20),
    PUMPKINATOR_COLLECTOR_V(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Pumpkinator Collector V", AchievementDifficulty.INSANE, "Collect 1,000 pumpkins in Bed Wars", 25),

    PUMPKIN_SMASHER_I(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Pumpkin Smasher I", AchievementDifficulty.NOVICE, "Smash 250 pumpkins in Bed Wars", 5),
    PUMPKIN_SMASHER_II(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Pumpkin Smasher II", AchievementDifficulty.EASY, "Smash 500 pumpkins in Bed Wars", 10),
    PUMPKIN_SMASHER_III(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Pumpkin Smasher III", AchievementDifficulty.MEDIUM, "Smash 750 pumpkins in Bed Wars", 15),
    PUMPKIN_SMASHER_IV(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Pumpkin Smasher IV", AchievementDifficulty.HARD, "Smash 1,000 pumpkins in Bed Wars", 20),
    PUMPKIN_SMASHER_V(AchievementType.TIERED, ServerGameType.SEASONAL, SeasonalType.HALLOWEEN,"Pumpkin Smasher V", AchievementDifficulty.INSANE, "Smash 3,333 pumpkins in Bed Wars", 25),

    // Bed Wars

    THATS_A_FIRST(AchievementType.NORMAL, ServerGameType.BEDWARS,"That's a First", AchievementDifficulty.EASY, "Win your first game of Bed Wars", 5),
    FIRST_BLOOD(AchievementType.NORMAL, ServerGameType.BEDWARS,"That's a First", AchievementDifficulty.EASY, "Get your first final kill in Bed Wars", 5),

    BED_REMOVAL_I(AchievementType.TIERED, ServerGameType.BEDWARS,"Bed Removal I", AchievementDifficulty.NOVICE, "Destroy 10 Beds", 5),
    BED_REMOVAL_II(AchievementType.TIERED, ServerGameType.BEDWARS,"Bed Removal II", AchievementDifficulty.EASY, "Destroy 25 Beds", 10),
    BED_REMOVAL_III(AchievementType.TIERED, ServerGameType.BEDWARS,"Bed Removal III", AchievementDifficulty.MEDIUM, "Destroy 100 Beds", 15),
    BED_REMOVAL_IV(AchievementType.TIERED, ServerGameType.BEDWARS,"Bed Removal IV", AchievementDifficulty.HARD, "Destroy 250 Beds", 20),
    BED_REMOVAL_V(AchievementType.TIERED, ServerGameType.BEDWARS,"Bed Removal V", AchievementDifficulty.INSANE, "Destroy 500 Beds", 25),

    BED_WARS_KILLER_I(AchievementType.TIERED, ServerGameType.BEDWARS,"Bed Wars Killer I", AchievementDifficulty.NOVICE, "Get 25 Final Kills", 5),
    BED_WARS_KILLER_II(AchievementType.TIERED, ServerGameType.BEDWARS,"Bed Wars Killer II", AchievementDifficulty.EASY, "Get 100 Final Kills", 10),
    BED_WARS_KILLER_III(AchievementType.TIERED, ServerGameType.BEDWARS,"Bed Wars Killer III", AchievementDifficulty.MEDIUM, "Get 250 Final Kills", 15),
    BED_WARS_KILLER_IV(AchievementType.TIERED, ServerGameType.BEDWARS,"Bed Wars Killer IV", AchievementDifficulty.HARD, "Get 500 Final Kills", 20),
    BED_WARS_KILLER_V(AchievementType.TIERED, ServerGameType.BEDWARS,"Bed Wars Killer V", AchievementDifficulty.INSANE, "Get 1,500 Final Kills", 25),

    VICTORY_DANCER_I(AchievementType.TIERED, ServerGameType.BEDWARS,"Victory Dancer I", AchievementDifficulty.NOVICE, "Win 25 games", 5),
    VICTORY_DANCER_II(AchievementType.TIERED, ServerGameType.BEDWARS,"Victory Dancer II", AchievementDifficulty.EASY, "Win 75 games", 10),
    VICTORY_DANCER_III(AchievementType.TIERED, ServerGameType.BEDWARS,"Victory Dancer III", AchievementDifficulty.MEDIUM, "Win 200 games", 15),
    VICTORY_DANCER_IV(AchievementType.TIERED, ServerGameType.BEDWARS,"Victory Dancer IV", AchievementDifficulty.HARD, "Win 500 games", 20),
    VICTORY_DANCER_V(AchievementType.TIERED, ServerGameType.BEDWARS,"Victory Dancer V", AchievementDifficulty.INSANE, "Win 1,000 games", 25),

    OG_BEDWARS(AchievementType.NORMAL, ServerGameType.BEDWARS,"OG Bed Wars Player", AchievementDifficulty.NOVICE, "Play a game of Bed Wars before November 1st, 2021", 5);


    private String display, description;
    private int amount = 1;
    private int points;

    private AchievementType achievementType;
    private ServerGameType serverGameType;
    private SeasonalType seasonalType;
    private AchievementDifficulty achievementDifficulty;

    // Used to create achievements for a specific game type.
    Achievement(AchievementType achievementType, ServerGameType serverGameType, String display, AchievementDifficulty achievementDifficulty, String description, int points) {
        this.achievementType = achievementType;
        this.serverGameType = serverGameType;
        this.display = display;
        this.achievementDifficulty = achievementDifficulty;
        this.description = description;
        this.points = points;
    }

    // Used to create achievements for a specific season.
    Achievement(AchievementType achievementType, ServerGameType serverGameType, SeasonalType seasonalType, String display, AchievementDifficulty achievementDifficulty, String description, int points) {
        this.achievementType = achievementType;
        this.serverGameType = serverGameType;
        this.seasonalType = seasonalType;
        this.display = display;
        this.achievementDifficulty = achievementDifficulty;
        this.description = description;
        this.points = points;
    }

    // Used to create achievements that can be unlocked on any server.
    Achievement(AchievementType achievementType, String display, AchievementDifficulty achievementDifficulty, String description, int points) {
        this(achievementType, ServerGameType.GENERAL, display, achievementDifficulty, description, points);
    }

    public ServerGameType getServerGameType() {
        return serverGameType;
    }

    public SeasonalType getSeason() {
        return seasonalType;
    }

    public AchievementType getAchievementType() {
        return achievementType;
    }

    public String getDisplay() {
        return display;
    }

    public AchievementDifficulty getAchievementDifficulty() {
        return achievementDifficulty;
    }

    public String getDescription() {
        return description;
    }

    public int getStatAmount() {
        return amount;
    }

    public int getPointsAmount() {
        return points;
    }
}
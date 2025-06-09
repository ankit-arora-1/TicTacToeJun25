package strategies.bot;

import models.BotDifficultyLevel;

public class BotPlayingFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        if(botDifficultyLevel == BotDifficultyLevel.EASY) {
            return new EasyBotPlayingStrategy();
        } else if(botDifficultyLevel == BotDifficultyLevel.MEDIUM) {
            return new MediumBotPlayingStrategy();
        } else if(botDifficultyLevel == BotDifficultyLevel.HARD) {
            return new HardBotPlayingStrategy();
        }

        return new EasyBotPlayingStrategy();
    }
}

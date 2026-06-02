package net.dupe;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DupeMod implements ModInitializer {
    public static final String MOD_ID = "dupe";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("DupeMod initialized!");
        DupeCommand.register();
    }
}
package be.alexandre01.eloriabot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.login.LoginException;
import java.util.Arrays;

public class Main {

    public static final Logger LOGGER = LogManager.getRootLogger();

    private static JDA jda;

    private static JDA buildJDA(final String token) throws LoginException, InterruptedException {
        final JDABuilder jdaBuilder = JDABuilder.create(Arrays.asList(GatewayIntent.values()));
        final JDA jda;

        jdaBuilder.setToken(token);
        jdaBuilder.setAutoReconnect(true);
        jdaBuilder.enableCache(Arrays.asList(CacheFlag.values()));
        LOGGER.info("Connecting to discord...");
        jda = jdaBuilder.build();
        jda.awaitReady();
        return jda;
    }

    public static void main(String[] args) {
        final String token = System.getenv("TOKEN");
        final JDABuilder jdaBuilder;

        if (token == null) {
            LOGGER.error("Missing discord token.");
            System.exit(22);
        }
        jdaBuilder = JDABuilder.create(Arrays.asList(GatewayIntent.values()));
        jdaBuilder.setToken(token);
        jdaBuilder.setAutoReconnect(true);
        jdaBuilder.enableCache(Arrays.asList(CacheFlag.values()));
        LOGGER.info("Connecting to discord...");
        try {
            jda = buildJDA(token);
        } catch (LoginException exception) {
            LOGGER.error("Error during login to discord.", exception);
            System.exit(111);
        } catch (InterruptedException exception) {
            LOGGER.error("Connection interrupted.", exception);
            System.exit(102);
        }
        LOGGER.info("Connected !");
        // TODO: init listeners.
    }

    public static JDA getJda() {
        return jda;
    }
}

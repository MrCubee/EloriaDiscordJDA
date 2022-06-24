package be.alexandre01.eloriabot;

import be.alexandre01.eloriabot.listeners.SuggestionListener;
import be.alexandre01.eloriabot.utils.Colors;
import be.alexandre01.eloriabot.utils.Tuple;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
@Getter
public class EloriaBot {
    private final JDA jda;
    private final String[] datas;
    public EloriaBot(String... datas){
        this.datas = datas;
        System.out.println(Colors.CYAN+"Starting EloriaBot...");
        System.out.println(Colors.BLUE+"Your Key: " + datas[0]);

        try {
            jda = JDABuilder.createLight(datas[0], GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS)
                    .addEventListeners(new SuggestionListener())
                    .setActivity(Activity.playing("play.eloriamc.net"))
                    .build();
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }

        try {
            jda.awaitReady();
            System.out.println(Colors.GREEN+"EloriaBot started!");
            onStart();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void onStart(){

    }

}

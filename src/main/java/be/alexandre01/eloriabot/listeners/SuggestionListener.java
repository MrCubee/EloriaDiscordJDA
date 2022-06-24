package be.alexandre01.eloriabot.listeners;

import be.alexandre01.eloriabot.EloriaBot;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class SuggestionListener extends ListenerAdapter {
    EloriaBot bot;

    public SuggestionListener(EloriaBot bot){
        this.bot = bot;
    }
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Message message = event.getMessage();
        if(message.getChannelType() == ChannelType.TEXT && message.getChannel().getId().equals(bot.getDatas()[1])){
            TextChannel textChannel = message.getTextChannel();
        }
    }
}

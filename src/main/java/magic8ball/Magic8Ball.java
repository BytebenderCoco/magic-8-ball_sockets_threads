package magic8ball;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Magic8Ball {

    private static final List<String> ANSWERS = List.of(
            "It is giving... certain",
            "Slay, the answer is yes",
            "No cap, it's a yes",
            "Main character energy — yes",
            "The vibes say yes",
            "Absolutely, bestie",
            "It's giving yes",
            "Certified banger",
            "Yes, and it's not even close",
            "The universe is literally aligning for this",
            "Ask again when the WiFi is better",
            "Plot twist - try again later",
            "It's giving... unclear",
            "Mercury is in retrograde, ask later",
            "The algorithm hasn't decided yet",
            "That's big a nono from me, babe",
            "Absolutely not, respectfully",
            "The odds are not in your favor",
            "Hard pass",
            "Touch some grass and reconsider"
            );

    public String getAnswer(){
        return ANSWERS.get(ThreadLocalRandom.current().nextInt(ANSWERS.size()));
    }
}


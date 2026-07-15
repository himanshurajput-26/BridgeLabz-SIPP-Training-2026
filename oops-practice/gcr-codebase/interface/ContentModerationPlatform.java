interface TextModeration {
    boolean checkOffensiveContent(String post);
    
    default void displayModerationPolicy() {
        System.out.println("Text Policy: Profanity, hate speech, and harassment are prohibited.");
    }
}

interface SpamDetection {
    boolean checkSpamContent(String post);
    
    default void displayModerationPolicy() {
        System.out.println("Spam Policy: Repetitive links, bots, and scam promotions are filtered.");
    }
}

class ContentModerator implements TextModeration, SpamDetection {
    // Shared static keyword list helper
    public static boolean containsRestrictedWords(String post) {
        String lower = post.toLowerCase();
        return lower.contains("offensive") || lower.contains("hate") || lower.contains("toxic");
    }

    @Override
    public void displayModerationPolicy() {
        System.out.println("=== Global Platform Moderation Guidelines ===");
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    @Override
    public boolean checkOffensiveContent(String post) {
        return containsRestrictedWords(post);
    }

    @Override
    public boolean checkSpamContent(String post) {
        String lower = post.toLowerCase();
        return lower.contains("buy now") || lower.contains("free money") || lower.contains("click here");
    }

    public void moderatePosts(String[] posts) {
        displayModerationPolicy();
        System.out.println("\n=== Analyzing Posts ===");
        for (String post : posts) {
            boolean isSpam = checkSpamContent(post);
            boolean isOffensive = checkOffensiveContent(post);
            
            System.out.print("Post: \"" + post + "\" -> Status: ");
            if (isSpam) {
                System.out.println("[SPAM POST - FLAGGED]");
            } else if (isOffensive) {
                System.out.println("[OFFENSIVE POST - BLOCKED]");
            } else {
                System.out.println("[VALID POST - APPROVED]");
            }
        }
    }
}
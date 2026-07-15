interface StreamingService {
    void playMovie(String movieName);
    
    default void showSubscriptionDetails() {
        System.out.println("Streaming Service: Premium Movie Plan Active ($9.99/mo).");
    }
}

interface GamingService {
    void playGame(String gameName);
    
    default void showSubscriptionDetails() {
        System.out.println("Gaming Service: Ultimate Arcade Pass Active ($14.99/mo).");
    }
}

class SmartTV implements StreamingService, GamingService {
    // Resolving default method signature conflict explicitly
    @Override
    public void showSubscriptionDetails() {
        System.out.println("--- Unified Smart TV Subscriptions ---");
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    @Override
    public void playMovie(String movieName) {
        System.out.println("Streaming Movie: " + movieName);
    }

    @Override
    public void playGame(String gameName) {
        System.out.println("Launching Game: " + gameName);
    }

    public void displayContent(String[] movies, String[] games) {
        System.out.println("\n=== Available Movies ===");
        for (String movie : movies) playMovie(movie);

        System.out.println("\n=== Available Games ===");
        for (String game : games) playGame(game);
    }
}
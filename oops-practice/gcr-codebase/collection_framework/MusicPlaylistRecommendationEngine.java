import java.util.LinkedList;

public class MusicPlaylistRecommendationEngine {
    private LinkedList<String> recentPlaylist;
    private final int MAX_LIMIT = 10; // [cite: 83]

    public MusicPlaylistRecommendationEngine() {
        this.recentPlaylist = new LinkedList<>(); // [cite: 86]
    }

    // Task 1, 2 & 3: Add songs to top and drop the oldest element if list > 10 [cite: 93, 97, 98]
    public void playSong(String songName) {
        // Move song to top if it's already there or remove it to re-insert as most recent
        recentPlaylist.remove(songName); 
        
        recentPlaylist.addFirst(songName); // [cite: 87, 93]
        System.out.println("Playing: " + songName);

        if (recentPlaylist.size() > MAX_LIMIT) { // [cite: 88, 97]
            String oldest = recentPlaylist.removeLast(); // [cite: 88, 98]
            System.out.println("History full. Removed oldest song: " + oldest);
        }
    }

    // Task 4: Search for a song in the history [cite: 99]
    public boolean searchSong(String songName) {
        return recentPlaylist.contains(songName); // [cite: 89]
    }

    // Task 5: Display the complete list of recently played songs in order [cite: 100]
    public void displayHistory() {
        System.out.println("\n--- Recently Played History ---");
        if (recentPlaylist.isEmpty()) {
            System.out.println("History is empty.");
        } else {
            for (int i = 0; i < recentPlaylist.size(); i++) { // [cite: 90]
                System.out.println((i + 1) + ". " + recentPlaylist.get(i));
            }
        }
    }

    public static void main(String[] args) {
        MusicPlaylistRecommendationEngine engine = new MusicPlaylistRecommendationEngine();
        for (int i = 1; i <= 11; i++) {
            engine.playSong("Song " + i);
        }
        engine.displayHistory(); // Should show Song 11 down to Song 2 (Song 1 dropped) [cite: 88]
    }
}
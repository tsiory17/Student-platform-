public class Documents {
    private static int documentNotifications = 10;

    public void downloadDocuments() {
        // Logic to download documents

        // Simulating decrease in document notifications when viewed
        if (documentNotifications > 0) {
            documentNotifications--;
        }
    }
}

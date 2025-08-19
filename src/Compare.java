public class Compare {
    public Compare() {
    }
public static Boolean compare(String text, String searchword) {
    String[] searchsplit = searchword.toLowerCase().trim().split("\\s+");
    String[] textsplit = text.toLowerCase().trim().split("\\s+");

    for (String s : searchsplit) {  // jedes Suchwort
        boolean matchFound = false;
        for (String str : textsplit) {  // jedes Wort im Text
            if (levenshtein(s, str) <= 2) { // Treffer, wenn Distanz <= 2
                matchFound = true;
                break;
            }
        }
        if (!matchFound) {
            return false; // sobald ein Suchwort nicht gefunden wird → false
        }
    }
    return true; // alle Suchwörter gefunden
}
    public static int levenshtein(String a, String b) {

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                            dp[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1)
                    );
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}

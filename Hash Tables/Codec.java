
/**
 * Problem: Design TinyURL (LeetCode 535)
 *
 * Goal:
 * Encode a long URL into a short URL and decode it back.
 *
 * Approach:
 * 1. Generate a random 6-character key using Base62 characters.
 * 2. Use two HashMaps:
 *    - shortToLong → for decoding
 *    - longToShort → to avoid duplicate entries
 * 3. Handle collisions by regenerating keys if already used.
 *
 * Time Complexity:
 * - encode: O(1) average
 * - decode: O(1)
 *
 * Space Complexity:
 * - O(n)
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {

    // Map for decoding (short → long)
    Map<String, String> shortToLong = new HashMap<>();

    // Map for avoiding duplicates (long → short)
    Map<String, String> longToShort = new HashMap<>();

    // Base62 characters (a-z, A-Z, 0-9)
    final String CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    // Prefix for short URL
    final String PREFIX = "http://tinyurl.com/";

    // Random generator
    Random random = new Random();

    /**
     * Generates a random 6-character key
     */
    public String generateKey() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(CHAR.length());
            str.append(CHAR.charAt(index));
        }

        return str.toString();
    }

    /**
     * Encodes a long URL into a short URL
     */
    public String encode(String longUrl) {

        // Return existing short URL if already present
        if (longToShort.containsKey(longUrl)) {
            return PREFIX + longToShort.get(longUrl);
        }

        // Generate unique key
        String key = generateKey();

        // Handle collision (ensure key is unique)
        while (shortToLong.containsKey(key)) {
            key = generateKey();
        }

        // Store mappings
        longToShort.put(longUrl, key);
        shortToLong.put(key, longUrl);

        return PREFIX + key;
    }

    /**
     * Decodes a short URL back to original URL
     */
    public String decode(String shortUrl) {
        String key = shortUrl.replace(PREFIX, "");
        return shortToLong.get(key);
    }
}
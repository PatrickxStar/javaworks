package org.example.CodingBat;

public int diff21(int n) {
    // Calculate the absolute difference between n and 21
    int difference = Math.abs(n - 21);

    // If n is greater than 21, return double the absolute difference
    if (n > 21) {
        return 2 * difference;
    } else {
        // Otherwise, return the absolute difference
        return difference;
    }
}

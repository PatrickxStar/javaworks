package org.example.CodingBat;

public boolean posNeg(int a, int b, boolean negative) {
    // If negative is true, return true only if both a and b are negative
    if (negative) {
        return (a < 0 && b < 0);
    } else {
        // Otherwise, return true if one is negative and the other is positive
        return ((a < 0 && b > 0) || (a > 0 && b < 0));
    }
}


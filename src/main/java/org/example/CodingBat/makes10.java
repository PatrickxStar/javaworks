package org.example.CodingBat;
public boolean makes10(int a, int b) {
    // Check if either a or b is 10, or if their sum is 10
    if (a == 10 || b == 10 || a + b == 10) {
        return true;  // Return true if any condition is met
    } else {
        return false; // Return false if none of the conditions are met
    }
}

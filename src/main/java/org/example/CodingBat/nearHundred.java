
public boolean nearHundred(int n) {
    // Calculate the absolute difference between n and 100
    int diff100 = Math.abs(n - 100);
    // Calculate the absolute difference between n and 200
    int diff200 = Math.abs(n - 200);

    // Check if either difference is less than or equal to 10
    if (diff100 <= 10 || diff200 <= 10) {
        return true;  // Return true if within 10 of 100 or 200
    } else {
        return false; // Return false otherwise
    }
}

public void main() {
}

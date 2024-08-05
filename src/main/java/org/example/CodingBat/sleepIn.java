

public boolean sleepIn(boolean weekday, boolean vacation) {
    // If it's not a weekday or if we're on vacation, we can sleep in
    if (!weekday || vacation) {
        return true;  // We can sleep in
    } else {
        return false; // We can't sleep in
    }
}

public void main() {
}


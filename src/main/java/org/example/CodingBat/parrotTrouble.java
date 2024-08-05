
public boolean parrotTrouble(boolean talking, int hour) {
    // Check if the parrot is talking and the hour is before 7 or after 20
    if (talking && (hour < 7 || hour > 20)) {
        return true;  // We are in trouble
    } else {
        return false; // We are not in trouble
    }
}

public void main() {
}


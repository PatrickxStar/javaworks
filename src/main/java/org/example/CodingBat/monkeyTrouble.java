package org.example.CodingBat;
public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
    // If both monkeys are smiling or neither of them is smiling, we're in trouble
    if (aSmile == bSmile) {
        return true;  // We are in trouble
    } else {
        return false; // We are not in trouble
    }
}


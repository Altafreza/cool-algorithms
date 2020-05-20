public class Logic_1 {
    // You are driving a little too fast, and a police officer stops you. Write code to compute the result,
    // encoded as an int value: 0=no ticket, 1=small ticket, 2=big ticket.
    // If speed is 60 or less, the result is 0.
    // If speed is between 61 and 80 inclusive, the result is 1. If speed is 81 or more, the result is 2.
    // Unless it is your birthday -- on that day, your speed can be 5 higher in all cases.
    public int caughtSpeeding(int speed, boolean isBirthday) {
        if (isBirthday) {
            speed -= 5;
        }
        if (speed <= 60) return 0;
        else if (speed <= 80) return 1;
        else return 2;
    }

    public int caughtSpeeding1(int speed, boolean isBirthday) {
        int ret = 0, n = 60, s = 80;
        if (isBirthday) {
            n += 5;
            s += 5;
        }
        if (speed > n && speed <= s) ret = 1;
        else if (speed > s) ret = 2;
        return ret;
    }

    public int caughtSpeeding3(int speed, boolean isBirthday) {
        int ret = 0, n = 60, s = 80;
        if (isBirthday) {
            n += 5;
            s += 5;
        }
        if (speed > s) ret = 2;
        else if (speed > n) ret = 1;
        return ret;
    }

    public int sortaSum(int a, int b) {
        int res = a + b;
        return res >= 10 && res <= 19 ? 20 : res;
    }

    // Given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating
    // if we are on vacation, return a string of the form "7:00" indicating when the alarm clock should ring.
    // Weekdays, the alarm should be "7:00" and on the weekend it should be "10:00". Unless we are on vacation
    // -- then on weekdays it should be "10:00" and weekends it should be "off".
    public String alarmClock(int day, boolean vacation) {
        if (vacation) {
            if (day == 0 || day == 6)
                return "off";
            return "10:00";
        } else {
            if (day == 0 || day == 6)
                return "10:00";
            return "7:00";
        }
    }

    // The number 6 is a truly great number. Given two int values, a and b, return true if either one is 6.
    // Or if their sum or difference is 6. Note: the function Math.abs(num) computes the absolute value of a number
    public boolean love6(int a, int b) {
        return a == 6 || b == 6 || a + b == 6 || Math.abs(a - b) == 6;
    }

    // Given a number n, return true if n is in the range 1..10, inclusive. Unless "outsideMode" is true,
    // in which case return true if the number is less or equal to 1, or greater or equal to 10.
    public boolean in1To10(int n, boolean outsideMode) {
        if (outsideMode)
            return (n <= 1 || n >= 10);
        return (n >= 1 && n <= 10);
    }

    // Return true if the given non-negative number is a multiple of 3 or 5, but not both.
    public boolean old35(int n) {
        return (n % 3 == 0) != (n % 5 == 0);
    }

    // Return true if the given non-negative number is 1 or 2 less than a multiple of 20.
    public boolean less20(int n) {
        return n % 20 == 19 || n % 20 == 18;
    }

    // Given a non-negative number "num", return true if num is within 2 of a multiple of 10.
    public boolean nearTen(int num) {
        return (num % 10 <= 2 || num % 10 >= 8);
    }

    // Given 2 ints, a and b, return their sum. However, "teen" values in the range 13..19 inclusive,
    // are extra lucky. So if either value is a teen, just return 19.
    public int teenSum(int a, int b) {
        if (a >= 13 && a <= 19 || b >= 13 && b <= 19) return 19;
        return a + b;
    }

    // Your cell phone rings. Return true if you should answer it.
    // Normally you answer, except in the morning you only answer if it is your mom calling.
    // In all cases, if you are asleep, you do not answer.
    public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
        return !isAsleep && !isMorning || !isAsleep && isMom;
    }

    // We are having a party with amounts of tea and candy. Return the int outcome of the party encoded
    // as 0=bad, 1=good, or 2=great. A party is good (1) if both tea and candy are at least 5.
    // However, if either tea or candy is at least double the amount of the other one, the party is great (2).
    // However, in all cases, if either tea or candy is less than 5, the party is always bad (0).
    public int teaParty(int tea, int candy) {
        if (tea >= 5 && candy >= 5) {
            if (tea >= 2 * candy || candy >= 2 * tea)
                return 2;
            return 1;
        }
        return 0;
    }
}

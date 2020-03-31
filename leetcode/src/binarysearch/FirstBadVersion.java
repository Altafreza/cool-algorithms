package binarysearch;
class VersionControl{
    public boolean isBadVersion(int x){
        return true;
    }
}
public class FirstBadVersion extends VersionControl {
    public int firstBadVersion5(int n) {
        int lo = 0, hi = n;

        while(hi - lo > 1){
            int mid = lo + (hi - lo) / 2;
            if(isBadVersion(mid)) hi = mid;
            else lo = mid;
        }
        // [0, lo] --> false/ not possible
        // [hi, n] --> true/ possible/ minimum
        return hi;
    }

    public int firstBadVersion1(int n) {
        int lo = 1, hi = n;

        while(lo < hi){
            // when they are equal,
            //that means low + 1 can be answer and high is answer or low was an answer and high is an answer
            // lo : 4 high:5
            // next transition
            // either low : 5 hi :5 // means low + 1 might be probable and high == 5 confirms it.
            //or low : 4, hi: 4
            int mid = lo + (hi - lo) / 2;
            if(isBadVersion(mid)) hi = mid; // one answer for sure
            else lo = mid + 1; // next estimate not sure
        }

        return hi;
    }

    public int firstBadVersion(int n) {
        int lo = 1, hi = n;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(isBadVersion(mid)) hi = mid - 1;
            else lo = mid + 1;
        }
        //[0, hi] is all false so hi + 1 is min ans
        return hi + 1;
    }
}

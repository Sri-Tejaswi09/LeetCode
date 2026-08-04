class Solution {
    public int dayOfYear(String date) {
         String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonths[i];
        }
        totalDays += day;
        if (isLeapYear(year) && month > 2) {
            totalDays += 1;
        }   
        return totalDays;
    }
    private boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}
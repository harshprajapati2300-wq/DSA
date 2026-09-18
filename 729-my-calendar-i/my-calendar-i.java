class MyCalendar {
    ArrayList<int[]> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (int[] event : list) {
            int s = event[0];
            int e = event[1];

            if (startTime < e && endTime > s) {
                return false;
            }
        }

        list.add(new int[]{startTime, endTime});
        return true;
    }
}
class DigitalWatch {
    public static void main(String[] args) {

        for (int hour = 0; hour < 24; hour++) {

            for (int minute = 0; minute < 60; minute++) {

                if (hour == 13 && minute == 0) {
                    System.out.println("Power Cut");
                    return;
                }

                System.out.println(hour + ":" + minute);
            }
        }
    }
}

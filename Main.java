import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //считываем начальное время
        String[] startTime = scanner.nextLine().split(" ");
        int startHour = Integer.parseInt(startTime[0]);
        int startMinute = Integer.parseInt(startTime[1]);

        //считываем конечное время
        String[] endTime = scanner.nextLine().split(" ");
        int endHour = Integer.parseInt(endTime[0]);
        int endMinute = Integer.parseInt(endTime[1]);

        int totalStrikes = calculateStrikes(startHour, startMinute, endHour, endMinute);
        System.out.println(totalStrikes);
        scanner.close();
    }

    private static int calculateStrikes(int startHour, int startMinute, int endHour, int endMinute) {
        int totalStrikes = 0;

        //преобразование времени в минуты
        int startTimeInMinutes = startHour * 60 + startMinute;
        int endTimeInMinutes = endHour * 60 + endMinute;

        if (endTimeInMinutes < startTimeInMinutes) {
            endTimeInMinutes += 24 * 60; //24 часа в минутах
        }

        for (int currentTime = startTimeInMinutes; currentTime < endTimeInMinutes; currentTime += 30) {
            int hour = (currentTime / 60) % 24; //текущий час
            int hour12Format = hour % 12; //перевод в 12-часовой формат

            // Удары в начале часа
            totalStrikes += (hour12Format == 0 ? 12 : hour12Format);

        }
        if(startMinute > 0) totalStrikes++;

        return totalStrikes;
    }
}

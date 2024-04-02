package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.util.logging.*;
import java.util.*;

public class YearlyBookingCalendar extends JFrame {
    private static final String BOOKINGS_FILE = "bookingHall.txt";
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final Map<String, Set<String>> bookedDatesPerHall = new HashMap<>();
    private final String currentHall;
    private final JLabel monthLabel = new JLabel("", SwingConstants.CENTER);
    private Calendar calendar = new GregorianCalendar(2024, Calendar.JANUARY, 1);
    private JPanel monthPanel;
    private static final Logger LOGGER = Logger.getLogger(YearlyBookingCalendar.class.getName());

    public YearlyBookingCalendar(String hallName) {
        this.currentHall = hallName;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        loadBookings();
        initUI();
    }

    private void initUI() {
        JPanel topPanel = new JPanel(new BorderLayout());
        JButton prevButton = new JButton("<");
        JButton nextButton = new JButton(">");
        monthLabel.setText(new SimpleDateFormat("MMMM yyyy").format(calendar.getTime()));
        topPanel.add(prevButton, BorderLayout.WEST);
        topPanel.add(monthLabel, BorderLayout.CENTER);
        topPanel.add(nextButton, BorderLayout.EAST);

        prevButton.addActionListener(e -> changeMonth(-1));
        nextButton.addActionListener(e -> changeMonth(1));

        add(topPanel, BorderLayout.NORTH);

        monthPanel = new JPanel();
        add(monthPanel, BorderLayout.CENTER);

        updateMonthView();

        setVisible(true);
    }

    private void changeMonth(int delta) {
        calendar.add(Calendar.MONTH, delta);
        monthLabel.setText(new SimpleDateFormat("MMMM yyyy").format(calendar.getTime()));
        updateMonthView();
    }

    private void updateMonthView() {
        monthPanel.removeAll();
        monthPanel.setLayout(new GridLayout(0, 7, 5, 5));

        Calendar monthStart = (Calendar) calendar.clone();
        monthStart.set(Calendar.DAY_OF_MONTH, 1);

        int firstDayOfWeek = monthStart.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = monthStart.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = Calendar.SUNDAY; i < firstDayOfWeek; i++) {
            monthPanel.add(new JLabel(""));
        }

        Set<String> bookedDates = bookedDatesPerHall.getOrDefault(currentHall, new HashSet<>());

        for (int day = 1; day <= daysInMonth; day++) {
            monthStart.set(Calendar.DAY_OF_MONTH, day);
            String dayString = dateFormat.format(monthStart.getTime());
            JButton dayButton = new JButton(Integer.toString(day));

            if (bookedDates.contains(dayString)) {
                dayButton.setEnabled(false);
                dayButton.setBackground(Color.RED);
            } else {
                dayButton.addActionListener(e -> bookDate(dayString));
            }

            monthPanel.add(dayButton);
        }

        monthPanel.revalidate();
        monthPanel.repaint();
    }

    public void bookDate(String date) {
        Set<String> dates = bookedDatesPerHall.computeIfAbsent(currentHall, k -> new HashSet<>());
        if (dates.add(date)) {
            saveBooking(currentHall + "," + date);
            JOptionPane.showMessageDialog(this, "Date booked successfully for " + currentHall + " on " + date);
            dispose(); // Close the window after booking
        } else {
            JOptionPane.showMessageDialog(this, "This date is already booked.");
        }
    }

    public boolean hasDuplicateDates(String hallName) {
        Set<String> dates = bookedDatesPerHall.get(hallName);
        return dates != null && !dates.isEmpty();
    }

    private void loadBookings() {
        Path path = Paths.get(BOOKINGS_FILE);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                bookedDatesPerHall.computeIfAbsent(parts[0], k -> new HashSet<>()).add(parts[1]);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load bookings from file: " + e.getMessage(), e);
        }
    }

    private void saveBooking(String bookingKey) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(BOOKINGS_FILE), StandardOpenOption.APPEND)) {
            writer.write(bookingKey);
            writer.newLine();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to save booking: " + e.getMessage(), e);
        }
    }

    public String getCurrentHall() {
        return currentHall;
    }
}

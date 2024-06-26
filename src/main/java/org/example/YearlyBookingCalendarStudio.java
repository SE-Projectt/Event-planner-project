package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.util.logging.*;
import java.util.*;

public class YearlyBookingCalendarStudio extends JFrame {
    private static final String BOOKINGS_FILE = "bookingStudio.txt";
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final Logger logger = Logger.getLogger(YearlyBookingCalendarStudio.class.getName());

    private final Map<String, Set<String>> bookedDatesPerHall = new HashMap<>();
    private final String currentHall;
    private final JLabel monthLabel = new JLabel("", SwingConstants.CENTER);
    private Calendar calendar = new GregorianCalendar(2024, Calendar.JANUARY, 1);
    private JPanel monthPanel;

    public YearlyBookingCalendarStudio(String hallName) {
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
            String dayString = DATE_FORMAT.format(monthStart.getTime());
            JButton dayButton = new JButton(Integer.toString(day));
            if (bookedDates.contains(dayString)) {
                dayButton.setEnabled(false);
                dayButton.setBackground(Color.RED);
            } else {
                dayButton.addActionListener(e -> bookDate(dayString));
            }
            monthPanel.add(dayButton);
            monthStart.add(Calendar.DAY_OF_MONTH, 1);
        }
        monthPanel.revalidate();
        monthPanel.repaint();
    }

    private void bookDate(String date) {
        String bookingKey = currentHall + "," + date;
        if (!bookedDatesPerHall.computeIfAbsent(currentHall, k -> new HashSet<>()).add(date)) return;
        saveBooking(bookingKey);
        JOptionPane.showMessageDialog(this, "Date booked successfully for " + currentHall + " on " + date);
        dispose(); // Close the window after booking
    }

    private void loadBookings() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(BOOKINGS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                bookedDatesPerHall.computeIfAbsent(parts[0], k -> new HashSet<>()).add(parts[1]);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to load bookings from file: ", e);
        }
    }

    private void saveBooking(String bookingKey) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKINGS_FILE, true))) {
            writer.write(bookingKey);
            writer.newLine();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to save booking: ", e);
        }
    }
}

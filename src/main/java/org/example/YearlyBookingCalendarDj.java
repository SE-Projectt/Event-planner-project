package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.util.*;

public class YearlyBookingCalendarDj extends JFrame {
    private static final String BOOKINGS_FILE = "BookingDj.txt";
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final Map<String, Set<String>> bookedDatesPerHall = new HashMap<>();
    private final String  currentDj;
    private final JLabel monthLabel = new JLabel("", SwingConstants.CENTER);
    private Calendar calendar = new GregorianCalendar(2024, Calendar.JANUARY, 1);
    private JPanel monthPanel;
    String DjName;
    public YearlyBookingCalendarDj( String DjName) {
        this.currentDj = DjName;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        Set<String> bookedDates = bookedDatesPerHall.getOrDefault(currentDj, new HashSet<>());
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
        String bookingKey = currentDj + "," + date;
        if (!bookedDatesPerHall.computeIfAbsent(currentDj, k -> new HashSet<>()).add(date)) return;
        saveBooking(bookingKey);
        JOptionPane.showMessageDialog(this, "Date booked successfully for " + currentDj + " on " + date);
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
            System.err.println("Failed to load bookings from file: " + e.getMessage());
        }
    }

    private void saveBooking(String bookingKey) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKINGS_FILE, true))) {
            writer.write(bookingKey);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Failed to save booking: " + e.getMessage());
        }
    }


    public String getDjName() {
        return DjName;
    }

    public String getCurrentDj() {
        return currentDj;
    }
}
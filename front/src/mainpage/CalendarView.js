import React from "react";
import { useState } from "react";
import { format } from "date-fns";
import { StyleSheet, View } from "react-native";
import { LocaleConfig, Calendar } from "react-native-calendars";

LocaleConfig.locales["kr"] = {
  monthNames: [
    "1월",
    "2월",
    "3월",
    "4월",
    "5월",
    "6월",
    "7월",
    "8월",
    "9월",
    "10월",
    "11월",
    "12월",
  ],
  monthNamesShort: [
    "1월",
    "2월",
    "3월",
    "4월",
    "5월",
    "6월",
    "7월",
    "8월",
    "9월",
    "10월",
    "11월",
    "12월",
  ],
  dayNames: [
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
  ],
  dayNamesShort: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
  today: "오늘",
};
LocaleConfig.defaultLocale = "kr";

export default function CalendarView() {
  const [selectedDate, setSelectedDate] = useState(
    format(new Date(), "yyyy-MM-dd")
  );
  const markedSelectedDates = {
    [selectedDate]: {
      selected: true,
    },
  };

  return (
    <View>
      <Calendar
        style={styles.calendar}
        markedDates={markedSelectedDates}
        theme={{
          selectedDayBackgroundColor: "#2B4036",
          arrowColor: "#2B4036",
          dotColor: "#1B4B66",
          todayTextColor: "#2B4036",
        }}
        onDayPress={(day) => {
          setSelectedDate(day.dateString);
        }}
        enableSwipeMonths={true}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  calendar: {
    borderBottomWidth: 1,
    borderBottomColor: "#e0e0e0",
  },
});

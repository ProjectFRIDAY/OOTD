import { View } from "react-native";
import CalendarView from "./CalendarView";

export default function MainPage() {
  return (
    <View style={{ width: "100%", height: "100%", backgroundColor: "#E6EBE9" }}>
      <CalendarView />
    </View>
  );
}

import { View } from "react-native";
import CalendarView from "./CalendarView";
import Ranking from "./Ranking";

export default function MainPage({ navigation }) {
  return (
    <View
      style={{
        width: "100%",
        height: "100%",
        backgroundColor: "#EFF1F0",
        paddingBottom: 90,
      }}
    >
      <CalendarView />
      <Ranking navigation={navigation} />
    </View>
  );
}

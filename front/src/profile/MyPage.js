import { View } from "react-native";
import ProfileView from "./ProfileView";

export default function MyPage({ navigation }) {
  return (
    <View>
      <ProfileView navigation={navigation} />
    </View>
  );
}

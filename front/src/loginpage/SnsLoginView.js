import { View, StyleSheet } from "react-native";
import SnsLoginBtn from "../button/loginpage/SnsLoginBtn";

export default function SnsLoginView() {
  return (
    <View style={styles.outView}>
      <View style={styles.innerView}>
        <SnsLoginBtn SNS={"kakao"} />
        <SnsLoginBtn SNS={"naver"} />
        <SnsLoginBtn SNS={"email"} />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  outView: {
    position: "absolute",
    left: 0,
    right: 0,
    bottom: 100,
    alignItems: "center",
  },
  innerView: {
    width: "60%",
    flexDirection: "row",
    justifyContent: "space-between",
  },
});

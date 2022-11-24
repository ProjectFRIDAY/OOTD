import { StyleSheet, Text, View, Image } from "react-native";
import ForgotPassword from "../button/loginpage/ForgotPasswordBtn";
import Btn from "../button/Btn";
import SnsLoginView from "./SnsLoginView";
import LoginInputView from "./LoginInputView";
import JoinMembership from "../button/loginpage/JoinMembershipBtn";

export default function LoginPage({ navigation }) {
  return (
    <View style={styles.container}>
      <View style={styles.loginPageTopBackground}>
        <View style={styles.textOotdLocation}>
          <Text style={styles.textOotd}>OOTD?</Text>
          <Image
            style={{ marginTop: "3%" }}
            source={require("../../assets/images/ootdLogoInLoginPage.png")}
          ></Image>
        </View>
      </View>
      <LoginInputView />
      <Btn text={"로그인하기"} navigation={navigation} />
      <JoinMembership navigation={navigation} />
      <ForgotPassword />
      <SnsLoginView />
      <Text style={styles.copyrightText}>
        &#9426; FRIDAY, All rights reserved.
      </Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#E6EBE9",
  },
  loginPageTopBackground: {
    height: 310,
    backgroundColor: "#3B5448",
  },
  textOotdLocation: {
    top: 225,
    alignItems: "center",
  },
  textOotd: {
    fontSize: 18,
    color: "white",
    fontWeight: "400",
  },
  copyrightText: {
    position: "absolute",
    left: 0,
    right: 0,
    bottom: 20,
    color: "#97B4AB",
    textAlign: "center",
    fontSize: 12,
  },
});

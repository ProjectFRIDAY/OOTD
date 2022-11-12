import { StyleSheet, Text, View, Image } from "react-native";
import ForgotPassword from "../button/loginpage/ForgotPassword";
import LoginBtn from "../button/loginpage/LoginBtn";
import SnsLoginView from "./SnsLoginView";
import LoginInputView from "./LoginInputView";
import JoinMembership from "../button/loginpage/JoinMembership";

export default function LoginPage() {
  return (
    <>
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
      <LoginBtn />
      <ForgotPassword />
      <JoinMembership />
      <SnsLoginView />
      <Text style={styles.copyrightText}>
        &#9426; FRIDAY, All rights reserved.
      </Text>
    </>
  );
}

const styles = StyleSheet.create({
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

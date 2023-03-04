import { StyleSheet, Text, View, Image } from "react-native";
import ForgotPassword from "../button/loginpage/ForgotPasswordBtn";
import Btn from "../button/Btn";
import LoginInputView from "./LoginInputView";
import JoinMembership from "../button/loginpage/JoinMembershipBtn";
import { useState } from "react";

export default function LoginPage({ navigation }) {
  const [changeIdText, setChangeIdText] = useState("");
  const handleIdChange = (text) => {
    setChangeIdText(text);
  };

  const [changePasswordText, setChangePasswordText] = useState("");
  const handlePasswordChange = (text) => {
    setChangePasswordText(text);
  };
  return (
    <View style={styles.container}>
      <View style={styles.loginPageTopBackground} />
      <View style={styles.textOotdLocation}>
        <Text style={styles.textOotd}>OOTD?</Text>
        <Image
          style={{ marginTop: "3%" }}
          source={require("../../assets/images/ootdLogoInLoginPage.png")}
        ></Image>
        <LoginInputView
          handleIdChange={handleIdChange}
          handlePasswordChange={handlePasswordChange}
        />
        <Btn
          text={"로그인하기"}
          navigation={navigation}
          changeIdText={changeIdText}
          changePasswordText={changePasswordText}
        />
        <JoinMembership navigation={navigation} />
        <ForgotPassword navigation={navigation} />
      </View>
      {/* <SnsLoginView /> */}
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
    height: "30%",
    backgroundColor: "#3B5448",
  },
  textOotdLocation: {
    bottom: 87,
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

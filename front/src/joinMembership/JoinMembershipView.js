import { useState, useEffect } from "react";
import {
  Text,
  View,
  StyleSheet,
  ScrollView,
  Platform,
  KeyboardAvoidingView,
  NativeModules,
} from "react-native";
import Btn from "../button/Btn";
import InfoInput from "./InfoInput";
import UploadImageBtn from "./UploadImageBtn";

const { StatusBarManager } = NativeModules;

export default function JoinMembershipView({ navigation }) {
  const [checkEssentialFill, setCheckEssentialFill] = useState(false);
  const handleCheckEssentialFill = (isFill) => {
    isFill ? setCheckEssentialFill(true) : setCheckEssentialFill(false);
  };

  useEffect(() => {
    Platform.OS == "ios"
      ? StatusBarManager.getHeight((statusBarFrameData) => {
          setStatusBarHeight(statusBarFrameData.height);
        })
      : null;
  }, []);

  const [statusBarHeight, setStatusBarHeight] = useState(0);

  const [accountChange, setAccountChange] = useState("");
  const handleAccountChange = (text) => {
    setAccountChange(text);
  };

  const [nickNameChange, setNickNameChange] = useState("");
  const handleNickNameChange = (text) => {
    setNickNameChange(text);
  };

  const [emailChange, setEmailChange] = useState("");
  const handleEmailChange = (text) => {
    setEmailChange(text);
  };

  const [passwordChange, setPasswordChange] = useState("");
  const handlePasswordChange = (text) => {
    setPasswordChange(text);
  };

  const [birthChange, setBirthChange] = useState("");
  const handleBirthChange = (text) => {
    setBirthChange(text);
  };

  return (
    <KeyboardAvoidingView
      style={styles.keyboard}
      keyboardVerticalOffset={statusBarHeight + 44}
      behavior={"padding"}
    >
      <ScrollView style={{ height: "100%", backgroundColor: "#E6EBE9" }}>
        <View style={styles.background}>
          <View style={{ marginTop: 108, marginBottom: 30 }}>
            <UploadImageBtn />
          </View>
          <InfoInput
            handleCheckEssentialFill={handleCheckEssentialFill}
            handleAccountChange={handleAccountChange}
            handleNickNameChange={handleNickNameChange}
            handleEmailChange={handleEmailChange}
            handlePasswordChange={handlePasswordChange}
            handleBirthChange={handleBirthChange}
            emailChange={emailChange}
            accountChange={accountChange}
            nickNameChange={nickNameChange}
            passwordChange={passwordChange}
          />
          <Btn
            text={"회원가입하기"}
            isFill={checkEssentialFill}
            navigation={navigation}
            emailChange={emailChange}
            accountChange={accountChange}
            nickNameChange={nickNameChange}
            changePasswordText={passwordChange}
          />
          <Text style={styles.agreeText}>
            인증을 완료하면 서비스 이용약관과 개인정보처리방침에 동의한 것으로
            간주합니다
          </Text>
        </View>
      </ScrollView>
    </KeyboardAvoidingView>
  );
}

const styles = StyleSheet.create({
  background: {
    flex: 1,
    // backgroundColor: "#E6EBE9",
    width: "100%",
    height: "100%",
    alignItems: "center",
  },
  agreeText: {
    fontSize: 10,
    color: "#598471",
    margin: 10,
    marginBottom: 30,
  },
});

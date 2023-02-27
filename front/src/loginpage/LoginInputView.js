import { useState } from "react";
import { View, StyleSheet } from "react-native";
import InputText from "../input/LoginInput";

export default function LoginInputView({
  handleIdChange,
  handlePasswordChange,
}) {
  // const [changeIdText, setChangeIdText] = useState("");
  // const handleIdChange = (text) => {
  //   setChangeIdText(text);
  // };
  // const [changePasswordText, setChangePasswordText] = useState("");
  // const handlePasswordChange = (text) => {
  //   setChangePasswordText(text);
  // };
  return (
    <View style={styles.inputView}>
      <InputText
        placeHoldText={"이메일을 입력해주세요."}
        keyboardType={"email-address"}
        textType={false}
        handleChange={handleIdChange}
      />
      <InputText
        placeHoldText={"비밀번호를 입력해주세요."}
        keyboardType={"password"}
        textType={true}
        handleChange={handlePasswordChange}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  inputView: {
    alignItems: "center",
    marginTop: 50,
  },
});

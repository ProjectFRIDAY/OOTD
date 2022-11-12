import { useState } from "react";
import { View, Text, StyleSheet } from "react-native";
import InputText from "../input/LoginInput";

export default function InfoInput() {
  const [idChange, setIdChange] = useState("");
  const handleIdChange = (text) => {
    setIdChange(text);
  };
  return (
    <View>
      <View>
        <Text style={styles.titleText}>UserID</Text>
        <InputText
          placeHoldText={"@사용자 이름을 입력해주세요."}
          keyboardType={"email-address"}
          textType="false"
          handleChange={handleIdChange}
        />
      </View>
      <View>
        <Text style={styles.titleText}>Password</Text>
        <InputText
          placeHoldText={"비밀번호를 입력해주세요."}
          keyboardType={"email-address"}
          textType="true"
          handleChange={handleIdChange}
        />
      </View>
      <View>
        <Text style={styles.titleText}>Password Confirmation</Text>
        <InputText
          placeHoldText={"비밀번호를 다시 입력해주세요."}
          keyboardType={"email-address"}
          textType="true"
          handleChange={handleIdChange}
        />
      </View>
      <View>
        <Text style={styles.titleText}>EmailAddress</Text>
        <InputText
          placeHoldText={"이메일을 입력해주세요."}
          keyboardType={"email-address"}
          textType="false"
          handleChange={handleIdChange}
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  titleText: {
    color: "#456A5A",
    fontSize: 13,
    fontWeight: "400",
  },
});

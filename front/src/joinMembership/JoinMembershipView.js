import { useState } from "react";
import { Text, View, StyleSheet, ScrollView } from "react-native";
import Btn from "../button/Btn";
import InfoInput from "./InfoInput";
import UploadImageBtn from "./UploadImageBtn";

export default function JoinMembershipView({ navigation }) {
  const [checkEssentialFill, setCheckEssentialFill] = useState(false);
  const handleCheckEssentialFill = (isFill) => {
    isFill ? setCheckEssentialFill(true) : setCheckEssentialFill(false);
  };
  return (
    <ScrollView style={{ height: "100%", backgroundColor: "#E6EBE9" }}>
      <View style={styles.background}>
        <View style={{ marginTop: 108, marginBottom: 30 }}>
          <UploadImageBtn />
        </View>
        <InfoInput handleCheckEssentialFill={handleCheckEssentialFill} />
        <Btn
          text={"회원가입하기"}
          isFill={checkEssentialFill}
          navigation={navigation}
        />
        <Text style={styles.agreeText}>
          인증을 완료하면 서비스 이용약관과 개인정보처리방침에 동의한 것으로
          간주합니다
        </Text>
      </View>
    </ScrollView>
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

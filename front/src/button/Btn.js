import { TouchableOpacity, StyleSheet, Text, View } from "react-native";
import { joinMembership, login } from "../api/api";

export default function Btn({
  text,
  navigation,
  isFill,
  changeIdText,
  changePasswordText,
  accountChange,
  nickNameChange,
  emailChange,
  userBirthChange,
}) {
  const handlePress = () => {
    if (text === "로그인하기") {
      login(changeIdText, changePasswordText, navigation);
      // navigation.navigate("MainPage");
    } else {
      if (isFill) {
        joinMembership(
          emailChange,
          accountChange,
          nickNameChange,
          changePasswordText,
          userBirthChange,
          navigation
        );
        // alert("회원가입이 완료되었습니다. 로그인해주세요.");
        // navigation.navigate("Login");
      } else {
        alert("필수 정보를 입력해주세요");
      }
    }
  };
  return (
    <View style={styles.buttonView}>
      <TouchableOpacity style={styles.button} onPress={handlePress}>
        <Text style={styles.text}>{text}</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  button: {
    backgroundColor: "#3B5448",
    width: 285,
    height: 50,
    borderRadius: 25,
    padding: 10,
    margin: 10,
    justifyContent: "center",
  },
  text: {
    color: "#fff",
    textAlign: "center",
    fontSize: 15,
  },
  buttonView: {
    alignItems: "center",
  },
});

import { Text, StyleSheet, View } from "react-native";

export default function ForgotPassword() {
  const handleClick = () => {
    alert("잊었니?");
  };
  return (
    <View style={styles.textForgotPasswordView}>
      <Text style={styles.textForgotPassword} onPress={handleClick}>
        비밀번호를 잊어버리셨나요?
      </Text>
    </View>
  );
}

const styles = StyleSheet.create({
  textForgotPassword: {
    marginTop: 10,
    fontSize: 13,
    color: "#598471",
  },
  textForgotPasswordView: {
    alignItems: "center",
  },
});

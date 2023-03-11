import { Text, StyleSheet, View, Alert} from "react-native";

export default function ForgotPassword() {
  const handleClick = () => {
    Alert.alert('비밀번호를 잊으셨나요?'
    ,'비밀번호 재설정을 위해 관리자에게 메일 부탁드립니다. 관리자 메일 : ddd.@ddd.com');
  };

  return (
    <View style={styles.textForgotPasswordView}>
      <Text
      style={styles.textForgotPassword}
      onPress={handleClick}>
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

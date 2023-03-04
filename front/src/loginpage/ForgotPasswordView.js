import { StyleSheet, Text, View,} from 'react-native';

export default function ForgotPasswordView() {

  return (
    <View style={styles.container}>
      <View style={styles.ViewStyle}>
        <View style={{alignItems: "flex-start"}}>
          <Text style={styles.TextStyle}>비밀번호를 잊으셨나요?</Text>
          <Text style={styles.TextStyle}>아래 정보를 입력해주세요.</Text>
        </View>
      </View>
    </View>
  );
}



const styles = StyleSheet.create({
  container: {
    backgroundColor: "#E6EBE9",
    width: "100%",
    height: "100%",
    alignItems: "center",
    flexDirection: 'row',
  },
  ViewStyle: {
    alignItems: "center",
  },
  TextStyle: {
    color: "#456A5A",
    fontSize: 17,
    fontWeight: "400",
    fontWeight: "bold",
    letterSpacing: 0.1,
  },
});

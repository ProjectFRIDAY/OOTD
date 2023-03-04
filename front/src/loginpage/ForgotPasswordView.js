import { StyleSheet, Text, View, TextInput, KeyboardAvoidingView} from 'react-native';


export default function ForgotPasswordView({
  keyboardType,
  textType,
  maxLength,}) {

  return (
    <View style={styles.container}>
      <View style={{marginTop: 170}}>
        <View style={{alignItems: "flex-start"}}>
          <Text style={styles.TextStyle}>비밀번호를 잊으셨나요?</Text>
          <Text style={styles.TextStyle}>아래 정보를 입력해주세요.</Text>
        </View>
        <View style={{marginTop: 40}}>
          <Text style={styles.titleText}>E-mail</Text>
          <TextInput
          style={styles.input}
          placeholder={"e메일을 입력해 주세요"}
          placeholderTextColor={"#BECCC8"}
          keyboardType={keyboardType}
          secureTextEntry={textType}
          returnKeyType="done"
          maxLength={maxLength}
          editablex
          />
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
  },
  TextStyle: {
    color: "#456A5A",
    fontSize: 13.5,
    fontWeight: "700",
    marginLeft: 7,
    letterSpacing: 0.1,
  },
  titleText: {
    color: "#456A5A",
    fontSize: 13,
    fontWeight: "400",
    marginLeft: 10,
    fontWeight: "bold"
  },
  input: {
    backgroundColor: "#FFFFFF",
    width: 285,
    height: 50,
    borderRadius: 25,
    padding: 10,
    margin: 10,
    fontSize: 13,
  },
});

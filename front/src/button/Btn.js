import { TouchableOpacity, StyleSheet, Text, View } from "react-native";

export default function Btn({ text, navigation }) {
  const handlePress = () => {
    text === "로그인하기" ? navigation.navigate("MainPage") : alert("인증");
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

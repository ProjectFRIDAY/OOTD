import { TouchableOpacity, StyleSheet, Text, View } from "react-native";

export default function LoginBtn() {
  const handlePress = () => {
    alert("click");
  };
  return (
    <View style={styles.buttonView}>
      <TouchableOpacity style={styles.button} onPress={handlePress}>
        <Text style={styles.text}>로그인하기</Text>
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

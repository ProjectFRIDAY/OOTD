import { TouchableOpacity, StyleSheet, Text, View } from "react-native";

export default function Btn({ text }) {
  const handlePress = () => {
    alert(text);
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

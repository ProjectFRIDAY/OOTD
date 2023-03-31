import { useEffect, useState } from "react";
import { TextInput, StyleSheet, Platform} from "react-native";

export default function InputText({
  placeHoldText,
  handleChange,
  keyboardType,
  textType,
  maxLength,
}) {
  const [changeText, setChangeText] = useState("");
  useEffect(() => {
    handleChange(changeText);
  });
  return (
    <TextInput
      style={styles.input}
      placeholder={placeHoldText}
      placeholderTextColor={"#BECCC8"}
      keyboardType={keyboardType}
      onChangeText={(text) => setChangeText(text)}
      secureTextEntry={textType}
      returnKeyType="done"
      maxLength={maxLength}
      editablex
    />
  );
}

const styles = StyleSheet.create({
  input: {
    backgroundColor: "#FFFFFF",
    width: 285,
    height: 50,
    borderRadius: 25,
    padding: 10,
    margin: 10,
    fontSize: 13,
    ...Platform.select({
      ios: {
        elevation : 5,
      },
      android: {
        elevation : 5,
      }
    })
  },
});

import { StyleSheet, TextInput, TouchableOpacity, View } from "react-native";
import { MaterialCommunityIcons } from "@expo/vector-icons";

export default function ClosetSearchBar() {
  return (
    <View style={styles.searchbar}>
      <TouchableOpacity style={{ marginLeft: 5 }}>
        <MaterialCommunityIcons name={"magnify"} size={30} color="#3B5448" />
      </TouchableOpacity>
      <TextInput
        style={styles.input}
        placeholder={"해시태그, 의상 이름"}
        placeholderTextColor={"#BECCC8"}
        returnKeyType="search"
        editablex
      ></TextInput>
    </View>
  );
}

const styles = StyleSheet.create({
  searchbar: {
    flexDirection: "row",
    alignItems: "center",
    borderBottomWidth: 1,
    borderBottomColor: "#879B91",
  },
  input: {
    width: "90%",
    height: 40,
    padding: 10,
    fontSize: 16,
  },
});

import { Text, StyleSheet, TouchableOpacity, View } from "react-native";

export default function JoinMembership({ navigation }) {
  return (
    <View style={{ alignItems: "center" }}>
      <TouchableOpacity
        style={styles.textJoinMembershipView}
        onPress={() => navigation.navigate("JoinMembershipView")}
      >
        <Text style={styles.textJoinMembership}>회원가입하기</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  textJoinMembership: {
    fontSize: 13,
    color: "#598471",
  },
  textJoinMembershipView: {
    alignItems: "center",
    justifyContent: "center",
    borderColor: "#598471",
    borderWidth: 2,
    // marginTop: 10,
    width: 285,
    height: 50,
    borderRadius: 25,
    margin: 10,
  },
});

import { View, Text, StyleSheet } from "react-native";

export default function JoinMembership({ navigation }) {
  return (
    <View style={styles.textJoinMembershipView}>
      <Text
        style={styles.textJoinMembership}
        onPress={() => navigation.navigate("JoinMembershipView")}
      >
        회원가입
      </Text>
    </View>
  );
}

const styles = StyleSheet.create({
  textJoinMembership: {
    marginTop: 10,
    fontSize: 13,
    color: "#598471",
  },
  textJoinMembershipView: {
    alignItems: "center",
    marginTop: 10,
  },
});

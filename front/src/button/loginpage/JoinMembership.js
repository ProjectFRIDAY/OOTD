import { View, Text, StyleSheet } from "react-native";

export default function JoinMembership() {
  const handleClick = () => {
    alert("가입");
  };
  return (
    <View style={styles.textJoinMembershipView}>
      <Text style={styles.textJoinMembership} onPress={handleClick}>
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

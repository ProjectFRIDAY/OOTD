import { useEffect, useState } from "react";
import { View, TouchableOpacity, Image } from "react-native";

export default function TabMiddleBtn({ navigation, isClick }) {
  return (
    <View
      style={
        isClick
          ? {
              // width: 85,
              // height: 85,
              // justifyContent: "center",
              // alignItems: "center",
              // backgroundColor: "#E6EBE9",
              // borderRadius: 100,
              marginBottom: 35,
            }
          : {}
      }
    >
      <TouchableOpacity
        onPress={() => {
          navigation.navigate(" ");
        }}
      >
        <View
          style={{
            width: 70,
            height: 70,
            backgroundColor: "#2B4036",
            borderRadius: 100,
            justifyContent: "center",
            alignItems: "center",
            // marginBottom: Platform.OS == "android" ? 20 : 10,
          }}
        >
          <Image
            source={require("../../assets/images/logotitle.png")}
            style={{
              width: 25,
              height: 25,
              tintColor: "white",
            }}
          ></Image>
        </View>
      </TouchableOpacity>
    </View>
  );
}

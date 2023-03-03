import { useEffect, useState } from "react";
import { ImageBackground } from "react-native";
import AsyncStorage from "@react-native-async-storage/async-storage";

export default function Splash({ navigation }) {
  useEffect(() => {
    setTimeout(() => {
      AsyncStorage.getItem("auth").then((value) => {
        console.log(value);
        if (value != null) {
          navigation.replace("MainPage");
        } else {
          navigation.replace("Login");
          console.log(value);
        }
      });
    }, 3000);
  }, []);
  return (
    <ImageBackground
      source={require("../assets/images/Splash.png")}
      style={{ width: "100%", height: "100%" }}
    />
  );
}

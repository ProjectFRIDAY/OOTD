import AsyncStorage from "@react-native-async-storage/async-storage";
import axios from "axios";
import { useState } from "react";

const api = axios.create({
  baseURL: "https://ootd-friday-api.shop/",
});

export const checkName = async (name, handleClickDuplicate) => {
  // const [isCheck, setIsCheck] = useState(false);
  try {
    await api
      .post("api/auth/checkname", {
        name: name,
      })
      .then((res) => {
        if (res.data === "사용 가능한 닉네임입니다.")
          handleClickDuplicate(false);
        else handleClickDuplicate(true);
        // return res.data;
        // return res.data;
      })
      .catch((e) => {
        console.log(e);
      });
  } catch (e) {
    console.log(e);
  }
};

export const login = async (email, password, navigation) => {
  try {
    await api
      .post("api/auth/login", {
        email: email,
        password: password,
      })
      .then(async (res) => {
        await AsyncStorage.setItem("auth", res.data.data.userAuthenticationId);
        navigation.navigate("MainPage");
      });
  } catch (e) {
    alert("문제가 발생하였습니다.");
    console.log(e);
  }
};

export const joinMembership = async (
  email,
  accountName,
  nickName,
  password,
  userBirth,
  navigation
) => {
  try {
    await api
      .post("api/auth/create", {
        email: email,
        accountName: accountName,
        nickName: nickName,
        password: password,
        userBirth: userBirth,
      })
      .then((res) => {
        alert("회원가입이 완료되었습니다.");
        navigation.navigate("Login");
      })
      .catch((e) => {
        alert("필수 정보를 입력하세요.");
        console.log(e);
      });
  } catch (e) {
    console.log(e);
  }
};

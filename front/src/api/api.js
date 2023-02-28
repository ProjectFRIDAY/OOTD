import AsyncStorage from "@react-native-async-storage/async-storage";
import axios from "axios";
import { useState } from "react";

const api = axios.create({
  baseURL: "https://ootd-friday-api.shop/",
});

export const checkName = (name, handleClickDuplicate) => {
  // const [isCheck, setIsCheck] = useState(false);
  api
    .post("api/auth/checkname", {
      name: name,
    })
    .then((res) => {
      console.log(res.data);
      handleClickDuplicate(false);
      // return res.data;
      // return res.data;
    })
    .catch((e) => {
      handleClickDuplicate(true);
      console.log(e);
    });
};

export const login = (email, password, navigation) => {
  api
    .post("api/auth/login", {
      email: email,
      password: password,
    })
    .then(async (res) => {
      await AsyncStorage.setItem("auth", res.data.data.userAuthenticationId);
      navigation.replace("MainPage");
    })
    .catch((e) => {
      alert("이메일 또는 비밀번호가 일치하지 않습니다.");
      console.log(e);
      // console.log("err");
    });
};

export const joinMembership = (
  email,
  accountName,
  nickName,
  password,
  userBirth,
  navigation
) => {
  api
    .post("api/auth/create", {
      email: email,
      accountName: accountName,
      nickName: nickName,
      password: password,
      userBirth: "2023-02-27",
    })
    .then((res) => {
      alert("회원가입이 완료되었습니다.");
      navigation.navigate("Login");
    })
    .catch((e) => {
      alert("필수 정보를 입력하세요.");
      console.log(e);
    });
};

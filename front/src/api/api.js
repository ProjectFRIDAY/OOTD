import axios from "axios";
import { useState } from "react";

const api = axios.create({
  baseURL: "https://ootd-friday-api.shop/",
});

export const checkName = async (name, handleClickDuplicate) => {
  // const [isCheck, setIsCheck] = useState(false);
  try {
    await api
      .post("api/auth/checkname/", {
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

import AsyncStorage from "@react-native-async-storage/async-storage";
import axios from "axios";
import { useEffect, useState } from "react";

const api = axios.create({
  baseURL: "https://ootd-friday-api.shop/",
});
const apiAuth = axios.create({
  baseURL: "https://ootd-friday-api.shop/",
  withCredentials: true,
  crossDomain: true,
  credentials: "include",
});

apiAuth.interceptors.request.use(
  async (config) => {
    const accessToken = await AsyncStorage.getItem("accessToken");
    const refreshToken = await AsyncStorage.getItem("refreshToken");
    config.headers["Authorization"] = `Bearer ${accessToken}`;
    config.headers["RefreshToken"] = refreshToken;
    console.log(config);
    return config;
  },
  async (err) => {
    // console.log(err.response);
    // if (err.response?.status === 401) {
    //   const data = err.response.data;
    //   apiAuth
    //     .get("api/auth/token/reissuance")
    //     .then(async (res) => {
    //       // await AsyncStorage.setItem("accessToken", res.)
    //       console.log(res);
    //     })
    //     .catch((e) => {
    //       console.log(e);
    //     });
    //   // err.config.headers = {
    //   //   Authorization: `Bearer ${accessToken}`,
    //   //   RefreshToken:
    //   // };
    //   const originalResponse = await axios.request(err.config);
    //   return originalResponse.data.data;
    // } else {
    //   alert("문제가 발생하였습니다. 다시 시도하세요.");
    //   return Promise.reject(err);
    // }
  }
);

// apiAuth.interceptors.response.use(
//   async (res) => {
//     console.log(res);
//     return res;
//   },
//   async (err) => {
//     if (err.response?.status === 401) {
//       const data = err.response.data;
//       apiAuth
//         .get("api/auth/token/reissuance")
//         .then(async (res) => {
//           await AsyncStorage.setItem("accessToken", res.data.data.accessToken);
//           await AsyncStorage.setItem(
//             "refreshToken",
//             res.data.data.refreshToken
//           );
//           console.log(res.data);
//         })
//         .catch((e) => {
//           console.log("get err");
//           console.log(e);
//         });
//       // err.config.headers = {
//       //   Authorization: `Bearer ${accessToken}`,
//       //   RefreshToken:
//       // };
//       const originalResponse = await axios.request(err.config);
//       return originalResponse.data.data;
//     } else {
//       alert("문제가 발생하였습니다. 다시 시도하세요.");
//       return Promise.reject(err);
//     }
//   }
// );

// //-----------------------------------------------------------------
// // 로그인 부분

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
      console.log(res.data.data);
      await AsyncStorage.setItem("accessToken", res.data.data.accessToken);
      await AsyncStorage.setItem("refreshToken", res.data.data.refreshToken);
      await AsyncStorage.setItem("userId", res.data.data.memberId.toString());
      navigation.replace("MainPage");
    })
    .catch((e) => {
      if (e.response?.status === 500) {
        alert("이메일 또는 비밀번호가 일치하지 않습니다.");
      } else {
        alert("문제가 발생했습니다.");
      }
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
      navigation.goBack();
    })
    .catch((e) => {
      alert("필수 정보를 입력하세요.");
      console.log(e);
    });
};

export const logout = (navigation) => {
  apiAuth
    .post("api/auth/logout")
    .then(async (res) => {
      console.log(res);
      await AsyncStorage.removeItem("accessToken");
      await AsyncStorage.removeItem("refreshToken");
      await AsyncStorage.removeItem("userId");
      navigation.replace("Login");
    })
    .catch((e) => {
      console.log(e);
    });
};

export const membershipWithdrawal = async (navigation) => {
  const userId = await AsyncStorage.getItem("userId");
  // getMyData(navigation, handleUserId);
  apiAuth
    .delete(`api/user/${userId}`)
    .then(async (res) => {
      console.log(res);
      await AsyncStorage.removeItem("accessToken");
      await AsyncStorage.removeItem("refreshToken");
      await AsyncStorage.removeItem("userId");
      navigation.navigate("Login");
    })
    .catch((e) => {
      console.log("membership");
      console.log(e);
    });
};

//------------------------------------------------------------
// 게시글 부분

export const getFeed = (isExistFollowerDiary, lastId) => {
  apiAuth
    .get(
      `api/diary?isExistFollowerDiary=${isExistFollowerDiary}&lastId=${lastId}`
    )
    .then((res) => {
      console.log(res.data);
    })
    .catch((e) => {
      console.log(e);
    });
};

export const writeFeed = async ({
  title,
  content,
  scope,
  files,
  formData,
  navigation,
}) => {
  apiAuth
    .post(
      "api/diary",
      {
        data: {
          dto: {
            title: title,
            content: content,
            scope: scope,
          },
          files: formData,
        },
      },
      {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      }
    )
    .then((res) => {
      console.log(res.data);
      navigation.goBack();
    })
    .catch((e) => {
      console.log(e);
      if (e.response?.status === 401) {
        alert("다시 로그인해주세요");
        navigation.replace("Login");
      }
    });
  // apiAuth
  //   .post("api/diary", {
  //     dto: {
  //       title: title,
  //       content: content,
  //       scope: scope,
  //     },
  //     files: [files],
  //   })
  //   .then((res) => {
  //     console.log(res);
  //     navigation.goBack();
  //   })
  //   .catch(async (e) => {
  //     console.log("errrrr");
  //     console.log(e);
  //   });
};

// -----------------------------------------------------------
// 옷장 부분

export const addDress = (
  dressName,
  dressType,
  hashTag,
  file,
  formData,
  navigation
) => {
  apiAuth
    .post("api/dress/file", formData)
    .then((res) => {
      console.log(res.data);
      apiAuth
        .post(`api/dress/req/${res.data.data}`, {
          dressName: dressName,
          dressType: dressType,
          hashTag: hashTag,
        })
        .then((res) => {
          console.log(res.data);
          navigation.goBack();
        })
        .catch((e) => {
          console.log(e);
        });
    })
    .catch((e) => {
      console.log(e);
      if (e.response?.status === 401) {
        alert("다시 로그인해주세요");
        navigation.navigate("Login");
      } else if (e.response?.status === 400) {
        alert("사진을 첨부해주세요");
      } else {
        alert("문제 발생");
      }
    });
};

export const getDressList = (
  navigation,
  handleOuterFlatListData,
  handleTopFlatListData,
  handleBottomsFlatListData,
  handleShoesFlatListData
) => {
  apiAuth
    .get("api/dress")
    .then((res) => {
      for (let i = 0; i < res.data.data.length; i++) {
        if (res.data.data[i].dressType === "OUTER") {
          handleOuterFlatListData(res.data.data[i]);
        } else if (res.data.data[i].dressType === "TOP") {
          handleTopFlatListData(res.data.data[i]);
        } else if (res.data.data[i].dressType === "BOTTOMS") {
          handleBottomsFlatListData(res.data.data[i]);
        } else {
          handleShoesFlatListData(res.data.data[i]);
        }
      }
    })
    .catch((e) => {
      console.log(e);
      if (e.response?.status === 401) {
        alert("다시 로그인해주세요");
        navigation.replace("Login");
      }
    });
};

export const deleteDress = (navigation, id) => {
  apiAuth
    .delete(`api/dress/${id}`)
    .then((res) => {
      console.log(res);
      navigation.goBack();
    })
    .catch((e) => {
      console.log(e);
    });
};

// ---------------------------------------------------------
// 본인 프로필

export const getMyData = (navigation, handleSetMyProfileData) => {
  apiAuth
    .get("api/profile")
    .then((res) => {
      console.log(res.data.data.userId);
      handleSetMyProfileData(res.data.data);
      return res.data.data;
    })
    .catch((e) => {
      console.log(e);
      if (e.response?.status === 401) {
        alert("다시 로그인해주세요");
        navigation.replace("Login");
      } else {
        alert("문제가 발생하였습니다. 다시 시도해주세요");
        navigation.replace("Login");
      }
    });
};

// -----------------------------------------------------
// 회원 정보 관련

const searchUser = (id) => {
  apiAuth
    .get(`api/user/${id}`)
    .then((res) => {
      console.log(res.data);
    })
    .catch((e) => {
      console.log(e);
    });
};

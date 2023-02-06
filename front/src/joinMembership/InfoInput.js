import { useEffect, useState } from "react";
import { View, Text, StyleSheet, TouchableOpacity } from "react-native";
import { checkName } from "../api/api";
import InputText from "../input/LoginInput";

export default function InfoInput({ handleCheckEssentialFill }) {
  const [accountChange, setAccountChange] = useState("");
  const handleAccountChange = (text) => {
    setAccountChange(text);
  };

  const [nickNameChange, setNickNameChange] = useState("");
  const handleNickNameChange = (text) => {
    setNickNameChange(text);
  };

  const [emailChange, setEmailChange] = useState("");
  const handleEmailChange = (text) => {
    setEmailChange(text);
  };

  const [clickSend, setClickSend] = useState(false);

  const [checkAuthenticate, setCheckAuthenticate] = useState(false);

  const handleAuthenticate = () => {
    console.log("데이터 전송");
    console.log("데이터 받기");
    if (true) {
      setClickSend(false);
      setCheckAuthenticate(true);
    }
  };

  const [passwordChange, setPasswordChange] = useState("");
  const handlePasswordChange = (text) => {
    setPasswordChange(text);
  };

  const [passwordConfirmationChange, setPasswordConfirmationChange] =
    useState("");
  const handlepasswordConfirmationChange = (text) => {
    setPasswordConfirmationChange(text);
  };

  const [birthChange, setBirthChange] = useState("");
  const handleBirthChange = (text) => {
    setBirthChange(text);
  };

  const [clickDuplicate, setClickDuplicate] = useState(false);
  const handleClickDuplicate = (bool) => {
    setClickDuplicate(bool);
  };

  const handleDuplicate = () => {
    checkName(accountChange, handleClickDuplicate);
  };

  const [checkPasswordFormText, setCheckPasswordFormText] = useState("");

  const checkPasswordForm = () => {
    if (0 < passwordChange.length) {
      if (passwordChange.length < 8) {
        setCheckPasswordFormText("* 8자리 이상으로 입력해주세요");
      } else if (passwordChange.search(/\s/) != -1) {
        setCheckPasswordFormText("* 비밀번호는 공백 없이 입력해주세요");
      } else if (passwordChange.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi) < 0) {
        setCheckPasswordFormText("* 특수문자를 혼합하여 입력해주세요");
      } else {
        setCheckPasswordFormText("");
      }
    }
  };
  useEffect(() => {
    checkPasswordForm();
  }, [passwordChange]);

  const [checkPassword, setCheckPassword] = useState(false);

  const handleCheckPassword = () => {
    if (0 < passwordConfirmationChange.length)
      if (passwordChange === passwordConfirmationChange) {
        setCheckPassword(true);
      } else {
        setCheckPassword(false);
      }
  };

  useEffect(() => {
    handleCheckPassword();
  }, [passwordConfirmationChange]);

  const [checkEssentialFill, setCheckEssentialFill] = useState(false);
  useEffect(() => {
    if (
      !clickDuplicate &&
      nickNameChange !== "" &&
      checkAuthenticate &&
      checkPassword
    ) {
      setCheckEssentialFill(true);
    } else {
      setCheckEssentialFill(false);
    }
  });

  useEffect(() => {
    handleCheckEssentialFill(checkEssentialFill);
  });

  return (
    <View>
      <View>
        <View style={styles.titleView}>
          <Text style={styles.titleText}>Account Name *</Text>
          {clickDuplicate && 0 < accountChange.length ? (
            <Text style={styles.warningMessage}>
              * 이미 존재하는 닉네임입니다.
            </Text>
          ) : 0 < accountChange.length ? (
            <Text style={[styles.warningMessage, { color: "blue" }]}>
              * 사용 가능한 닉네임입니다.
            </Text>
          ) : null}
        </View>
        <InputText
          placeHoldText={"@Account_Name을 입력해주세요."}
          keyboardType={"email-address"}
          textType="false"
          handleChange={handleAccountChange}
        />
        <TouchableOpacity style={styles.inputBtn} onPress={handleDuplicate}>
          <Text style={{ color: "#456A5A" }}>중복확인</Text>
        </TouchableOpacity>
      </View>
      <View>
        <Text style={styles.titleText}>NickName *</Text>
        <InputText
          placeHoldText={"닉네임을 입력해주세요."}
          keyboardType={"email-address"}
          textType="false"
          handleChange={handleNickNameChange}
        />
      </View>
      <View>
        <Text style={styles.titleText}>E-mail *</Text>
        <InputText
          placeHoldText={"이메일을 입력해주세요."}
          keyboardType={"email-address"}
          textType="false"
          handleChange={handleEmailChange}
        />
        <TouchableOpacity
          style={styles.inputBtn}
          onPress={() => {
            setClickSend(true);
          }}
        >
          <Text style={{ color: "#456A5A" }}>인증코드 전송</Text>
        </TouchableOpacity>
      </View>
      {clickSend && (
        <View>
          <InputText
            placeHoldText={"인증번호를 입력하세요."}
            keyboardType={"email-address"}
            textType="false"
            handleChange={handleEmailChange}
          />
          <TouchableOpacity
            style={styles.checkBtn}
            onPress={handleAuthenticate}
          >
            <Text style={{ textAlign: "center", color: "#E6EBE9" }}>확인</Text>
          </TouchableOpacity>
        </View>
      )}
      <View>
        <View style={styles.titleView}>
          <Text style={styles.titleText}>Password *</Text>
          <Text style={styles.warningMessage}>{checkPasswordFormText}</Text>
        </View>
        <InputText
          placeHoldText={"비밀번호(8~15자 특수문자 포함)를 입력해주세요."}
          keyboardType={"email-address"}
          textType="true"
          handleChange={handlePasswordChange}
          maxLength="15"
        />
      </View>
      <View>
        <View style={styles.titleView}>
          <Text style={styles.titleText}>Password Confirmation *</Text>
          {!checkPassword && 0 < passwordConfirmationChange.length && (
            <Text style={styles.warningMessage}>
              * 비밀번호가 일치하지 않습니다.
            </Text>
          )}
          {checkPassword && 0 < passwordConfirmationChange.length && (
            <Text style={[styles.warningMessage, { color: "blue" }]}>
              * 비밀번호가 일치합니다.
            </Text>
          )}
        </View>
        <InputText
          placeHoldText={"비밀번호를 다시 입력해주세요."}
          keyboardType={"email-address"}
          textType="true"
          handleChange={handlepasswordConfirmationChange}
        />
      </View>
      <View>
        <Text style={styles.titleText}>Date of Birth</Text>
        <InputText
          placeHoldText={"YY-MM-DD"}
          keyboardType={"email-address"}
          textType="true"
          handleChange={handleBirthChange}
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  titleView: {
    flexDirection: "row",
    alignItems: "baseline",
    justifyContent: "space-between",
    width: 290,
  },
  titleText: {
    color: "#456A5A",
    fontSize: 13,
    fontWeight: "400",
    marginLeft: 10,
  },
  inputBtn: {
    position: "absolute",
    right: 20,
    top: 43,
  },
  warningMessage: {
    fontSize: 10,
    color: "red",
  },
  checkBtn: {
    backgroundColor: "#456A5A",
    position: "absolute",
    right: 20,
    top: 23,
    width: 40,
    height: 25,
    borderRadius: 20,
    justifyContent: "center",
  },
});

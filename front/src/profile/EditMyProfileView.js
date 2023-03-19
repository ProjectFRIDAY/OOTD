import { 
  Text, 
  StyleSheet, 
  View, 
  Alert, 
  FlatList, 
  Image, 
  Pressable, 
  NativeModules,} from "react-native";
import { useState, useEffect } from "react";
import CameraImg from "../../assets/images/circlecamera.png";
import InfoInput from "../joinMembership/InfoInput";
import Btn from "../button/Btn";

const { StatusBarManager } = NativeModules;

export default function EditMyProfileView ({navigation}) {
  const ImgClick = () => {
    Alert.alert('이미지 추가 버튼','이미지 추가 버튼임');
  };


  const [checkEssentialFill, setCheckEssentialFill] = useState(false);
  const handleCheckEssentialFill = (isFill) => {
    isFill ? setCheckEssentialFill(true) : setCheckEssentialFill(false);
  };

  useEffect(() => {
    Platform.OS == "ios"
      ? StatusBarManager.getHeight((statusBarFrameData) => {
          setStatusBarHeight(statusBarFrameData.height);
        })
      : null;
  }, []);

  const [statusBarHeight, setStatusBarHeight] = useState(0);

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

  const [passwordChange, setPasswordChange] = useState("");
  const handlePasswordChange = (text) => {
    setPasswordChange(text);
  };

  const [birthChange, setBirthChange] = useState("");
  const handleBirthChange = (text) => {
    setBirthChange(text);
  };

	return (
		<View style={styles.container}>
      <FlatList
        ListHeaderComponent={
          <View>
            <View style={styles.backgroundImage}/>
            <View style={styles.profileImage}>
              <Text
                style={{
                  fontSize: 50,
                  color: "white",
                  alignSelf: "center",
                }}
              >
                S
              </Text>
            </View>
            <Pressable onPress={ImgClick} style={styles.CameraImage}>
              <Image source={CameraImg} style={{width: 45,height: 45,}}/>        
            </Pressable>
            <View style = {{marginTop: 50, padding: 44}}>
              <InfoInput
                handleCheckEssentialFill={handleCheckEssentialFill}
                handleAccountChange={handleAccountChange}
                handleNickNameChange={handleNickNameChange}
                handleEmailChange={handleEmailChange}
                handlePasswordChange={handlePasswordChange}
                handleBirthChange={handleBirthChange}
                accountChange={accountChange}
                nickNameChange={nickNameChange}
                passwordChange={passwordChange}
              />
              <Btn
                text={"변경확인"}
                isFill={checkEssentialFill}
                navigation={navigation}
                emailChange={emailChange}
                accountChange={accountChange}
                nickNameChange={nickNameChange}
                changePasswordText={passwordChange}
              />
            </View>
          </View>
        }
      />
    </View>
	);
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: "white",
    height: "100%",
  },
  backgroundImage: {
    backgroundColor: "#EFF1F0",
    height: 230,
    zIndex: 0,
    shadowColor: "#000",
    shadowOpacity: 0.2,
    shadowOffset: {
      width: 1,
      height: 1,
    },
  },
  profileImage: {
    position: "absolute",
    top: 175,
    width: 90,
    height: 90,
    backgroundColor: "#2B4036",
    borderRadius: 50,
    alignSelf: "center",
    justifyContent: "center",
  },
  CameraImage: {
    position: "absolute",
    alignSelf: "center",
    top: 224,
    left: 205,
    width: 45,
    height: 45,
  },
})
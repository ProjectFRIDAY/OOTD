import { 
  StyleSheet, 
  View, 
  FlatList, 
  Image, 
  Pressable, 
  NativeModules,
  Platform,} from "react-native";
import { useState, useEffect } from "react";
import CameraImg from "../../assets/images/circlecamera.png";
import InfoInput from "../joinMembership/InfoInput";
import Btn from "../button/Btn";
import * as ImagePicker from "expo-image-picker";

const { StatusBarManager } = NativeModules;

export default function EditMyProfileView ({navigation}) {

  const [status, requestPermission] = ImagePicker.useMediaLibraryPermissions();
  const [imageUrl, setImageUrl] = useState("");

  const uploadImage = async () => {
    if (Platform.OS !== 'web') {
      const {
        status,
      } = await ImagePicker.requestCameraPermissionsAsync();
      if (status !== "granted") {
        alert('이미지를 업로드하려면 사진첩 권한이 필요합니다.');
        return false
      }
      return true
      
    }
  }; //사진권한

  const loadImage = async () => {
    if (!status?.granted) {
      const permission = await requestPermission();
      if (!permission.granted) {
        return null;
      }
    }
    const result = await ImagePicker.launchImageLibraryAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
      allowsEditing: true,
      quality: 1,
      aspect: [1, 1],
    });
    if (result.canceled) {
      return null;
    }
    // console.log(result.assets[0].uri);
    setImageUrl(result.assets[0].uri);
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
              {imageUrl ? (
                <Image source={{ uri: imageUrl }} style={styles.imageBox} />
              ) : (
                <Image
                  source={require("../../assets/images/defaultImage.png")}
                  style={[styles.imageBox]}
                />
              )}
            </View>
            <Pressable onPress={() => {uploadImage(); loadImage();}} style={styles.CameraImage}>
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
  imageBox: {
    width: 90,
    height: 90,
    borderRadius: 50,
    backgroundColor: "white",
  },
})
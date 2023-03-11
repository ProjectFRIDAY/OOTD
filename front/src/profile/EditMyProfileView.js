import { Text, StyleSheet, View, Alert, FlatList, Image, Pressable,} from "react-native";
import CameraImg from "../../assets/images/circlecamera.png";

export default function EditMyProfileView (handleEmailChange) {
  const ImgClick = () => {
    Alert.alert('이미지 추가 버튼','이미지 추가 버튼임');
  };

	return (
		<View style={styles.container}>
      <FlatList
        ListHeaderComponent={
          <View>
            <View style={styles.backgroundImage}></View>
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
            <View style={{ marginTop: 40 }}/>
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
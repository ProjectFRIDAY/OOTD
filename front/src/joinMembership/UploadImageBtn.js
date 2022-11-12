import { TouchableOpacity, Image, StyleSheet, View } from "react-native";
import * as ImagePicker from "expo-image-picker";
import { useState } from "react";

export default function UploadImageBtn() {
  const [status, requestPermission] = ImagePicker.useMediaLibraryPermissions();
  const [imageUrl, setImageUrl] = useState("");

  const uploadImage = async () => {
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
  return (
    <View>
      <View style={styles.imageBox}>
        {imageUrl ? (
          <Image source={{ uri: imageUrl }} style={styles.imageBox} />
        ) : (
          <Image
            source={require("../../assets/images/defaultImage.png")}
            style={[styles.imageBox]}
          />
        )}
      </View>
      <TouchableOpacity style={styles.uploadImage} onPress={uploadImage}>
        <Image source={require("../../assets/images/circlecamera.png")} />
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  uploadImage: {
    position: "absolute",
    top: 125,
    left: 125,
  },
  imageBox: {
    width: 173,
    height: 173,
    borderRadius: 100,
    backgroundColor: "white",
  },
});

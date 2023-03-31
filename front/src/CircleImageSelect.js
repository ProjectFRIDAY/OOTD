import { useEffect, useState } from "react";
import { View, StyleSheet, Image, TouchableOpacity } from "react-native";
import * as ImagePicker from "expo-image-picker";

export default function CircleImageSelect({
  handleImageUrl,
  imageUrl,
  formData,
}) {
  const [status, requestPermission] = ImagePicker.useMediaLibraryPermissions();

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
    handleImageUrl(result.assets[0].uri);
    const imageUri = result.uri;
    const filename = imageUri.split("/").pop();
    const match = /\.(\w+)$/.exec(filename ?? "");
    const type = match ? `image/${match[1]}` : `image`;
    // const formData = new FormData();
    formData.append("image", { uri: imageUri, name: filename, type });
  };

  return (
    <View style={{ alignItems: "center" }}>
      <View>
        <View style={styles.imageBox}>
          {imageUrl ? (
            <Image source={{ uri: imageUrl }} style={styles.imageBox} />
          ) : (
            <View
              style={[styles.imageBox, { backgroundColor: "white" }]}
            ></View>
          )}
        </View>
        <TouchableOpacity style={styles.uploadImage} onPress={uploadImage}>
          <Image source={require("../assets/images/circlecamera.png")} />
        </TouchableOpacity>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  imageBox: {
    width: 173,
    height: 173,
    borderRadius: 100,
    backgroundColor: "white",
  },
  uploadImage: {
    position: "absolute",
    top: 125,
    left: 125,
  },
});
